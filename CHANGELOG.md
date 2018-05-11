Changelog
=====

### 1.45

Release date: May 11, 201*

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
