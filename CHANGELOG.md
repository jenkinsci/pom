Changelog
=====

### 1.51

Release date: 2018-12-30

* [PR-36](https://github.com/jenkinsci/pom/pull/36): Update to extra-enforcer-rules with JDK 11 support
* [PR-37](https://github.com/jenkinsci/pom/pull/37): Update various plugins
* [PR-38](https://github.com/jenkinsci/pom/pull/38): Update to Maven JAR Plugin 3.1.1 to pick up the fix of [MJAR-241](https://issues.apache.org/jira/browse/MJAR-241)

### 1.50

Release date: 2018-11-08

* Work around Surefire bug to enable tests to be run on some Java versions, such as the current updates for Debian/Ubuntu.

### 1.49

Release date: Sep 27, 2018

Updates Maven plugins towards JDK 11 support:

* Maven Compiler 3.8.0: support of multi-release JARs
* Animal Sniffer 1.17: Support of Java 10+ formats and multi-release JARs
* Javadoc Plugin 3.0.1: Better support of Java 9+ constructs + stability fixes
* Dependency Plugin 3.0.2: Java 9+ compatibility

### 1.48

Release date: Jul 31, 2018

* Ensure the `incrementals` plugin prefix is available.

### 1.47

Release date: Jul 24, 2018

* JENKINS-51658: automatically reincrementalify during Maven releases.
* JENKINS-51869: require a newer `git-changelist-maven-extension` to effectively drop `--first-parent` from the rev count.
* Support `mvn incrementals:incrementalify`.
* Remove MNG-6405 workaround by assuming Maven 3.5.4+ for builds when using Incrementals.

### 1.46

Release date: May 15, 2018

* Do not use the `source:jar` mojo during releases; use `source:jar-no-fork`.

### 1.45

Release date: May 11, 2018

* The `incrementals` plugin is now preconfigured, so you can run `mvn incrementals:update` and more.
* For Incrementals, `flatten-maven-plugin` now places the generated POM inside `target`.

### 1.44

Release date: May 07, 2018

* [PR #22](https://github.com/jenkinsci/pom/pull/22) Update versions-maven-plugin.version=2.5 so versions:set-property is available
* Some precisions in the [docs for Incrementals](https://github.com/jenkinsci/pom/blob/master/incrementals.md)

### 1.43

Release date: Apr 27, 2018

* [PR #20](https://github.com/jenkinsci/pom/pull/20): support for JEP-305 “Incrementals”.

### 1.42

Release date: Apr 27, 2018

* [PR #21](https://github.com/jenkinsci/pom/pull/21): Update `maven-site-plugin` from version `3.6` to `3.7`.


### 1.41

Release date: Apr 05, 2018

* Add `junit:junit` dependency to the dependency management section

### 1.40

Release date: Feb 28, 2018

* [PR #18](https://github.com/jenkinsci/pom/pull/18) -
Enable FindBugs by default for downstream components
  * Previously components used to declare FindBugs on their own

### 1.39

Release date: Sep 06, 2017

* Update to animal-sniffer 1.16
* Update Maven plugins to latest to get upstream fixes to be able to build with JDK9

### 1.38

Release date: Aug 21, 2017

* Update Maven requirement to 3.3.9
* Enable new rules in Maven Enforcer by default: Upper Bounds, Bytecode, release deps
* Enable Animal Sniffer by default
* Update Maven Javadoc and Mavern Surefire plugins to recent versions

### Previous releases

* See the commit history
