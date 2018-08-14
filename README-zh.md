## creed

[![Build Status](https://www.travis-ci.org/geercode/creed.svg?branch=master)](https://www.travis-ci.org/geercode/creed)
[![Coverage Status](https://coveralls.io/repos/github/geercode/creed/badge.svg?branch=master)](https://coveralls.io/github/geercode/creed?branch=master)
![release](https://img.shields.io/github/release/geercode/creed.svg)
![license](https://img.shields.io/badge/license-Apache--2.0-blue.svg)
![language](https://img.shields.io/badge/language-java-blue.svg)

springboot springcloud ci docker financial architect archetype sample

### maven plugin list
> * flatten-maven-plugin
> * maven-enforcer-plugin
> * duplicate-finder-maven-plugin
> * maven-checkstyle-plugin
> * maven-pmd-plugin(p3c-pmd)
> * findbugs-maven-plugin
> * maven-project-info-reports-plugin
> * maven-jxr-pluginn
> * maven-surefire-report-plugin
> * taglist-maven-plugin
> * jdepend-maven-plugin
> * cobertura-maven-plugin
> * coveralls-maven-plugin

### project design

* build-neat

`make child builds clean except for dependencyManagement & pluginManagement`

* dependencies

`manage dependencies for all child projects`

* creed-projects

`mainten the codes with the aim of business website, simple use & general satisfying`

name|description|brief introduction
---|---|---
creed-bom      ||
creed-parent   ||
creed-codecheck||
creed-core     ||
creed-starters ||

* spring-supports

`utils to enchance spring eco`

name|description|brief introduction
---|---|---
spring-supports-bom   ||
spring-supports-parent||
spring-supports-utils ||

* samples

`all sample projects to explain how to use these codes`