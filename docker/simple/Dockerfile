# FROM openjdk:17-jdk-alpine
FROM openjdk:21-slim

EXPOSE 8080

RUN set -ex; mkdir spring-docker-tutorial

WORKDIR /spring-docker-tutorial
COPY ../../target/spring-docker-tutorial-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]