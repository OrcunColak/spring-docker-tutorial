FROM maven:3.9.9-eclipse-temurin-23-alpine AS builder
LABEL version="1.0"
LABEL description="My Spring Boot application"

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

# Stage 2
# Copy only the jar file generated from builder container into the image for the 2nd stage.
FROM openjdk:23-slim
COPY --from=builder /app/target/spring-docker-tutorial-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]