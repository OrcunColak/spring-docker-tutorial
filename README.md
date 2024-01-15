# DOCKERFILE
The original idea is from  
https://levelup.gitconnected.com/how-to-containerize-your-java-application-updated-2023-851520ec4bdd

Build
```
mvn clean install
docker build . -t spring-docker-tutorial:1.0
```
Run
```
# --rm flag tells Docker to remove the container when it stops.
docker run -it --rm --name spring-docker-tutorial -p8080:8080 spring-docker-tutorial:1.0
```

