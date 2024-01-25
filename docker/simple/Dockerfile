# JDK images are big. JRE images are smaller

# Some JDK images
# FROM openjdk:17-jdk-alpine
# FROM openjdk:17-jdk-slim

# Some JRE images
#eclipse-temurin:17.0.5_8-jre-focal

FROM openjdk:21-slim
LABEL version="1.0"
LABEL description="My Spring Boot application"

# Example to pass an environment variable
# ENV SPRING_PROFILES_ACTIVE=production

EXPOSE 8080

RUN set -ex; mkdir spring-docker-tutorial

WORKDIR /spring-docker-tutorial
COPY ../../target/spring-docker-tutorial-1.0.0.jar app.jar

HEALTHCHECK --interval=5s \
            --timeout=3s \
            CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar","app.jar"]