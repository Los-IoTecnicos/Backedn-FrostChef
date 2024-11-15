FROM ubuntu:latest AS build
LABEL authors="Yordi Gonzales"
RUN apt-get update && apt-get install openjdk-21-jdk -y && apt-get install -y wget unzip

# Establecer el directorio de trabajo
WORKDIR /app

COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:21-jdk-slim
EXPOSE 8080
#COPY target/FrostChefBackendApplication-0.0.1-SNAPSHOT.jar app.jar
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]