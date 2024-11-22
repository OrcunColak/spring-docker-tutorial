# Stage 1
# Build application within the Docker container.
# Use maven image. In case of gradle you could use gradle:8.2-jdk17-alpine
FROM maven:3.9.9-eclipse-temurin-23-alpine AS builder
WORKDIR build

# Old way
#COPY . .
#RUN mvn clean install -DskipTests

# Docker caching allows you to reuse previously built layers of your Docker image, avoiding the need to rebuild those
# layers each time you build a new image.
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ ./src/
RUN mvn package -DskipTests

# Stage 2
# Copy only the jar file generated from builder container into the image for the 2nd stage.
FROM eclipse-temurin:17.0.6_10-jre-alpine AS layers
WORKDIR layer
COPY --from=builder /build/target/spring-docker-tutorial-1.0.0.jar app.jar

# Extract these layers out of the jar file
# RUN java -Djarmode=layertools -jar app.jar extract
RUN java -Djarmode=tools -jar app.jar extract

# Stage 3
# /opt/java/openjdk/bin/java
FROM eclipse-temurin:23-jre-alpine
LABEL version="1.0"
LABEL description="My Spring Boot application"

WORKDIR /opt/app
RUN addgroup --system appuser && adduser -S -s /usr/sbin/nologin -G appuser appuser

#The following layers are present by default:
# 1. dependencies (for regular released dependencies)
# 2. spring-boot-loader (for everything under org/springframework/boot/loader)
# 3. snapshot-dependencies (for snapshot dependencies)
# 4. application (for application classes and resources)

COPY --from=layers /layer/dependencies/ ./
COPY --from=layers /layer/spring-boot-loader/ ./
COPY --from=layers /layer/snapshot-dependencies/ ./
COPY --from=layers /layer/application/ ./
RUN chown -R appuser:appuser /opt/app
USER appuser
HEALTHCHECK --interval=30s --timeout=3s --retries=1 CMD wget -qO- http://localhost:8080/actuator/health/ | grep UP || exit 1
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
