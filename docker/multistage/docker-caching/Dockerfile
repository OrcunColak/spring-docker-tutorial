FROM maven:3.9.3-eclipse-temurin-17-alpine AS builder
LABEL version="1.0"
LABEL description="My Spring Boot application"

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

# Stage 2
# Copy only the jar file generated from builder container into the image for the 2nd stage.
FROM openjdk:17-slim
COPY --from=builder /app/target/spring-docker-tutorial-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]