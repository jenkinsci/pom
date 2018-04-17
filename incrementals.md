# Incrementals

See [JEP-305](https://github.com/jenkinsci/jep/blob/master/jep/305/README.adoc) for context.

## Usage in plugin POMs

Since most Jenkins repositories host plugins, this use case will be documented first.

### Enabling consumption of incrementals

If your plugin has (or may have) dependencies on incremental versions, run:

```bash
mkdir -p .mvn
echo -Pconsume-incrementals >> .mvn/maven.config
git add .mvn
```

(See [this guide](https://maven.apache.org/docs/3.3.1/release-notes.html#JVM_and_Command_Line_Options) for details on the `.mvn` directory.)

This profile merely activates access to the [Incrementals repository](https://repo.jenkins-ci.org/incrementals/).

### Enabling production of incrementals

To produce incremental artifacts _from_ your plugin, first edit your `pom.xml`.
If your plugin declares

```xml
<version>1.23-SNAPSHOT</version>
```

then replace that with

```xml
<version>${revision}${changelist}</version>
```

and then in the `<properties>` section add

```xml
<revision>1.23</revision>
<changelist>-SNAPSHOT</changelist>
```

If you have a multimodule reactor build, the new `properties` need be defined only in the root POM,
but every child POM should use the edited `version` to refer to its `parent`.
(It should _not_ override the `version`.)
Intermodule `dependency`es may use `${project.version}` to refer to the `version` of the sibling.

Also change

```xml
<scm>
  <!-- … -->
  <tag>HEAD</tag>
</scm>
```

to


```xml
<scm>
  <!-- … -->
  <tag>${scmTag}</tag>
</scm>
```

Now run

```bash
mkdir -p .mvn
echo -Pmight-produce-incrementals >> .mvn/maven.config
echo .flattened-pom.xml >> .gitignore
git add .mvn .gitignore
```

Finally, configure [git-changelist-maven-extension](https://github.com/jglick/git-changelist-maven-extension) in `.mvn/extensions.xml`:

```xml
<extensions xmlns="http://maven.apache.org/EXTENSIONS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/EXTENSIONS/1.0.0 http://maven.apache.org/xsd/core-extensions-1.0.0.xsd">
  <extension>
    <groupId>io.jenkins.tools</groupId>
    <artifactId>git-changelist-maven-extension</artifactId>
    <version>1.0-alpha-1</version>
  </extension>
</extensions>
```

Now if you are authorized to deploy to the Incrementals repository you could run:

```bash
mvn -Dset.changelist clean deploy
```

To produce equivalent artifacts in your local repository while working offline:

```bash
mvn -Dset.changelist -DskipTests clean install
```

If you do not select the `-Dset.changelist` option, you will create a regular `*-SNAPSHOT` artifact.
(And that is what you _must_ do if you have any local modifications or untracked files.)

### Running Maven releases

You may still use the Maven release plugin (MRP) when `might-produce-incrementals` is activated:

```bash
mvn -B release:{prepare,perform}
```

The released artifacts should have sensible metadata.
(You may notice that they deploy a “flattened” POM file, but this should not break anything.)
However, after performing a traditional release, to resume being able to produce incrementals you must run:

```bash
mvn help:evaluate -Dexpression=project.version -Doutput=version && \
mvn versions:set -Ddollar='$' -DnewVersion='${dollar}{revision}${dollar}{changelist}' -DgenerateBackupPoms=false && \
mvn versions:set-property -Dproperty=revision -DnewVersion=`sed -e 's/-SNAPSHOT$//' < version` -DgenerateBackupPoms=false && \
rm version
```

<!--- TODO JENKINS-50693 publish this as a packaged script somewhere --->

and commit and push the resulting `pom.xml` edits.

## Offline testing

If you wish to test usage offline, run

```bash
docker run --rm --name nexus -p 8081:8081 -v nexus-data:/nexus-data sonatype/nexus3
```

add to your `~/.m2/settings.xml`:

```xml
<servers>
  <server>
    <id>incrementals</id>
    <username>admin</username>
    <password>admin123</password>
  </server>
</servers>
```

and then add to command lines consuming or producing incremental versions:

```
-Dincrementals.url=http://localhost:8081/repository/maven-releases/
```

or define an equivalent profile in local settings.
