FROM openjdk:17-jdk-alpine

EXPOSE 8080

RUN set -ex; mkdir spring-docker-tutorial

WORKDIR /spring-docker-tutorial
COPY ./target/spring-docker-tutorial-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]