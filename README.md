# Swagger

http://localhost:8080/swagger-ui/index.html

# Build-pack.io

The original idea is from  
https://medium.com/@kiarash.shamaii/dockerizing-spring-boot-best-practices-for-efficient-containerization-f60ed3980dc7

Run

```
mvn spring-boot:build-image
docker run -p 8080:8080 -t spring-docker-tutorial:1.0.0
```

# Simple Dockerfile

The original idea is from  
https://levelup.gitconnected.com/how-to-containerize-your-java-application-updated-2023-851520ec4bdd

Build

```
mvn clean install
docker build -f .\docker\simple\Dockerfile . -t spring-docker-tutorial:1.0
```

Run

```
# --rm flag tells Docker to remove the container when it stops.
docker run -it --rm --name spring-docker-tutorial -p8080:8080 spring-docker-tutorial:1.0
```

# Multistage Caching Dockerfile

The original idea is from  
https://medium.com/@kiarash.shamaii/dockerizing-spring-boot-best-practices-for-efficient-containerization-f60ed3980dc7

# Multistage Layered Dockerfile

The original idea is from  
https://medium.com/@rohitloke/spring-boot-docker-best-practices-4bf4fdec158

Build

```
mvn clean install
docker build -f .\docker\multistage\layered\Dockerfile . -t spring-docker-tutorial:1.0
```

Run

```
# --rm flag tells Docker to remove the container when it stops.
docker run -it --rm --name spring-docker-tutorial -p8080:8080 spring-docker-tutorial:1.0
```

# DOCKER COMPOSE

The original idea is from  
https://medium.com/@satanjim/how-we-reduced-the-memory-consumption-of-spring-boot-application-over-40-for-the-development-c8a5813fac23

# Kubernetes

The original idea is from  
https://medium.com/@mustafaguc/how-to-build-and-deploy-a-spring-boot-microservice-on-a-kubernetes-cluster-using-github-actions-1d9f78d6f8a4  
and  
https://dzone.com/articles/spring-boot-with-kubernetes

# Actuator

http://localhost:8080/actuator/health
http://localhost:8080/actuator/env

# Kubernetes Custom Health Indicator

The original idea is from  
https://medium.com/cloud-native-daily/ensuring-kubernetes-readiness-with-custom-health-checks-in-spring-boot-services-47a4a0131108

# Helm

One example is here

https://ashishnoob.medium.com/dockerizing-and-deploying-a-spring-boot-application-in-kubernetes-15486b4af26c