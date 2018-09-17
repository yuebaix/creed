FROM openjdk:8-jdk-alpine as builder
MAINTAINER jerryniu <huifumanlove@hotmail.com>
VOLUME /tmp
ARG JAR_NAME
ARG JAR_DIR
ARG CONFIG_LABEL
ARG CONFIG_PROFILE
WORKDIR /root/creed
COPY ${JAR_DIR}/${JAR_NAME} ${JAR_NAME}
ENV ENV_JAR_NAME=${JAR_NAME}
ENV ENV_CONFIG_LABEL=${CONFIG_LABEL}
ENV ENV_CONFIG_PROFILE=${CONFIG_PROFILE}
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom \
                              -jar ${ENV_JAR_NAME} \
                              --spring.cloud.config.label=${ENV_CONFIG_LABEL} \
                              --spring.profiles.active=${ENV_CONFIG_PROFILE}"]