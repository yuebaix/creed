FROM openjdk:8-jdk-alpine
MAINTAINER jerryniu <huifumanlove@hotmail.com>
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} creedapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/creedapp.jar"]