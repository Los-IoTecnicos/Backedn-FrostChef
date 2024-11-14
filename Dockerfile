FROM ubuntu:latest
LABEL authors="Yordi Gonzales"

COPY target/FrostChefBackendApplication-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]