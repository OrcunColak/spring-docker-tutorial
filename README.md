# Swagger

http://localhost:8080/swagger-ui/index.html

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

# Multistage Dockerfile

The original idea is from  
https://medium.com/@rohitloke/spring-boot-docker-best-practices-4bf4fdec158

Build

```
mvn clean install
docker build -f .\docker\multistage\Dockerfile . -t spring-docker-tutorial:1.0
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

