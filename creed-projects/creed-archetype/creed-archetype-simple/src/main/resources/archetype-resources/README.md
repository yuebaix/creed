#### 代码规范尝鲜版

* 添加仓库

```
    <repositories>
        <repository>
            <id>nexus</id>
            <name>jufan-group-public</name>
            <url>http://svn.jufandev.com:8087/nexus/content/groups/public</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
                <checksumPolicy>warn</checksumPolicy>
            </snapshots>
        </repository>
    </repositories>
    <pluginRepositories>
        <pluginRepository>
            <id>nexus</id>
            <name>jufan-group-public</name>
            <url>http://svn.jufandev.com:8087/nexus/content/groups/public</url>
        </pluginRepository>
    </pluginRepositories>
```

* 添加版本属性

```
    <properties>
        <!--java版本-->
        <java.version>1.8</java.version>
        <!--编码-->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <!--creed版本-->
        <creed.version>0.1-SNAPSHOT</creed.version>
        <!--pmd插件-->
        <maven-pmd-plugin.version>3.8</maven-pmd-plugin.version>
        <!--alibaba第三版规范插件-->
        <p3c-pmd.version>1.3.5</p3c-pmd.version>
        <!--控制是否检测-->
        <disable.checks>false</disable.checks>
    </properties>
```

* 添加依赖管理

```
    <dependencyManagement>
        <dependencies>
            <dependency>
                <artifactId>dependencies</artifactId>
                <groupId>com.geercode.creed</groupId>
                <version>${creed.version}</version>
                <scope>import</scope>
                <type>pom</type>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

* 添加构建配置

```
    <build>
        <plugins>
            <!--check code style-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-checkstyle-plugin</artifactId>
                <executions>
                    <execution>
                        <id>checkstyle-verify</id>
                        <phase>verify</phase>
                        <configuration>
                            <skip>${disable.checks}</skip>
                            <consoleOutput>true</consoleOutput>
                            <failOnViolation>true</failOnViolation>
                            <violationSeverity>warning</violationSeverity>
                            <includeTestSourceDirectory>true</includeTestSourceDirectory>
                            <configLocation>com/geercode/creed/codecheck/checkstyle.xml</configLocation>
                            <headerLocation>${basedir}/checkstyle-header.txt</headerLocation>
                            <suppressionsLocation>
                                com/geercode/creed/codecheck/checkstyle-suppressions.xml
                            </suppressionsLocation>
                            <!--配置包控制文件路径-->
                            <propertyExpansion>
                                com.geercode.importcontrol.file=${basedir}/import-control.xml
                            </propertyExpansion>
                        </configuration>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>com.puppycrawl.tools</groupId>
                        <artifactId>checkstyle</artifactId>
                        <version>8.11</version>
                    </dependency>
                    <dependency>
                        <groupId>com.geercode.creed</groupId>
                        <artifactId>creed-codecheck</artifactId>
                        <version>${creed.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
            <!--阿里编码规约-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>${maven-pmd-plugin.version}</version>
                <configuration>
                    <skip>${disable.checks}</skip>
                    <includeTests>false</includeTests>
                    <sourceEncoding>${project.build.sourceEncoding}</sourceEncoding>
                    <targetJdk>${java.version}</targetJdk>
                    <printFailingErrors>true</printFailingErrors>
                    <failOnViolation>true</failOnViolation>
                    <!-- 代码检查规则 -->
                    <rulesets>
                        <ruleset>rulesets/java/ali-comment.xml</ruleset>
                        <ruleset>rulesets/java/ali-concurrent.xml</ruleset>
                        <ruleset>rulesets/java/ali-constant.xml</ruleset>
                        <ruleset>rulesets/java/ali-exception.xml</ruleset>
                        <ruleset>rulesets/java/ali-flowcontrol.xml</ruleset>
                        <ruleset>rulesets/java/ali-naming.xml</ruleset>
                        <ruleset>rulesets/java/ali-oop.xml</ruleset>
                        <ruleset>rulesets/java/ali-orm.xml</ruleset>
                        <ruleset>rulesets/java/ali-other.xml</ruleset>
                        <ruleset>rulesets/java/ali-set.xml</ruleset>
                    </rulesets>
                </configuration>
                <executions>
                    <!-- 绑定pmd:check到verify生命周期 -->
                    <execution>
                        <id>pmd-check-verify</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                    <!-- 绑定pmd:pmd到site生命周期 -->
                    <execution>
                        <id>pmd-pmd-site</id>
                        <phase>site</phase>
                        <goals>
                            <goal>pmd</goal>
                        </goals>
                    </execution>
                </executions>
                <!-- p3c依赖 -->
                <dependencies>
                    <dependency>
                        <groupId>com.alibaba.p3c</groupId>
                        <artifactId>p3c-pmd</artifactId>
                        <version>${p3c-pmd.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
            <!--findbugs-->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>findbugs-maven-plugin</artifactId>
                <configuration>
                    <skip>${disable.checks}</skip>
                    <failOnError>true</failOnError>
                    <includeTests>false</includeTests>
                    <!-- 设置分析工作的等级，可以为Min、Default和Max -->
                    <effort>Max</effort>
                    <!-- Low、Medium和High (Low最严格) -->
                    <threshold>Low</threshold>
                    <!--findbugs需要检测的错误的配置文件-->
                    <includeFilterFile>com/geercode/creed/codecheck/findbugs-include.xml</includeFilterFile>
                    <!--findbugs需要忽略的错误的配置文件-->
                    <excludeFilterFile>com/geercode/creed/codecheck/findbugs-exclude.xml</excludeFilterFile>
                </configuration>
                <executions>
                    <execution>
                        <id>findbugs-verify</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>com.geercode.creed</groupId>
                        <artifactId>creed-codecheck</artifactId>
                        <version>${creed.version}</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>
```

* 添加import-control.xml包管理配置文件

```
<?xml version="1.0"?>
<!DOCTYPE import-control PUBLIC "-//Checkstyle//DTD ImportControl Configuration 1.4//EN"
        "https://checkstyle.org/dtds/import_control_1_4.dtd">
<!--要控制的包-->
<import-control pkg="com.yimei.architect.samples">
    <!--base check-->
    <allow pkg=".*" regex="true"/>
    <!--子包dao-->
    <subpackage name="dao">
        <!--禁止import的包-->
        <disallow pkg="com.yimei.architect.samples.dao"/>
        <disallow pkg="com.yimei.architect.samples.domain"/>
        <disallow pkg="com.yimei.architect.samples.service"/>
        <disallow pkg="com.yimei.architect.samples.controller"/>
    </subpackage>
    <!--子包domain-->
    <subpackage name="domain">
        <!--禁止import的包-->
        <disallow pkg="com.yimei.architect.samples.domain"/>
        <disallow pkg="com.yimei.architect.samples.service"/>
        <disallow pkg="com.yimei.architect.samples.controller"/>
    </subpackage>
    <!--子包service-->
    <subpackage name="service">
        <!--禁止import的包-->
        <disallow pkg="com.yimei.architect.samples.service"/>
        <disallow pkg="com.yimei.architect.samples.controller"/>
    </subpackage>
    <!--子包controller-->
    <subpackage name="controller">
        <!--禁止import的包-->
        <disallow pkg="com.yimei.architect.samples.controller"/>
    </subpackage>
</import-control>
```

* 添加checkstyle-header.txt文件头正则

```
^\Q/*\E$
^\Q * Copyright \E20\d\d-20\d\d\Q the original author or authors.\E$
^\Q * Powered by Yimei Corp.\E$
^\Q * All Rights Reserved.\E$
^\Q */\E$
^$
^.*$
```

* 执行mvn verify