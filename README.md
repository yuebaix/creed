## creed

[![Build Status](https://www.travis-ci.org/geercode/creed.svg?branch=master)](https://www.travis-ci.org/geercode/creed)
[![Coverage Status](https://coveralls.io/repos/github/geercode/creed/badge.svg?branch=master)](https://coveralls.io/github/geercode/creed?branch=master)
![release](https://img.shields.io/github/release/geercode/creed.svg)
![license](https://img.shields.io/badge/license-Apache--2.0-blue.svg)
![language](https://img.shields.io/badge/language-java-blue.svg)

springboot springcloud ci docker financial architect archetype sample

more information can be found (这里能找到更多信息) [here](docs/instruction/index.md)

### maven plugin list
> * flatten-maven-plugin
> * maven-enforcer-plugin
> * lombok-maven-plugin
> * duplicate-finder-maven-plugin
> * maven-checkstyle-plugin
> * maven-pmd-plugin(p3c-pmd)
> * findbugs-maven-plugin
> * dockerfile-maven-plugin
> * maven-project-info-reports-plugin
> * maven-jxr-plugin
> * maven-surefire-report-plugin
> * taglist-maven-plugin
> * jdepend-maven-plugin
> * javancss-maven-plugin
> * cobertura-maven-plugin
> * coveralls-maven-plugin
> * jmeter-maven-plugin

### project design

* build-neat

`make child builds clean except for dependencyManagement & pluginManagement`

* dependencies

`manage dependencies for all child projects`

* creed-projects

`mainten the codes with the aim of business website, simple use & general satisfying`

name|description|brief introduction
---|---|---
creed-bom|bom of creed framework|
creed-parent|parent of creed framework|
creed-codecheck|plugin dependency to check java codes|
creed-core|core codes from bottom up|
creed-tools|common tools to build framework|
creed-archetypes|archetypes to make create project faster|
creed-autoconfigure|autoconfigure creed framework for springboot application|
creed-starters|enhance prefer traits of springboot application|

* spring-supports

`utils to enchance spring eco`

name|description|brief introduction
---|---|---
spring-supports-bom|bom of spring-supports|
spring-supports-parent|parent of spring-supports|
spring-supports-utils|utils to enhance spring framework|
spring-supports-test|test support for springboot application|

* samples

`all sample projects to explain how to use these codes`

name|description|brief introduction
---|---|---
springcloud-center|service registry center|
springcloud-config|config center|
springcloud-mcenter|combination fo service registry center & config center|
springcloud-uaa|user account & authentication based on oauth2 protocol & user/role/authority model|
springcloud-gate|service gateway|
sc-service|role service application|
sc-facade|stub codes to use service more easily|
sc-aggregater|role aggregater application|
sc-app|role app application|
sc-client|role client application|