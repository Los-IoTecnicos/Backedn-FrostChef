FROM amazoncorretto:17-alpine-jdk
LABEL authors="Yordi Gonzales"

RUN mvn clean package

COPY target/FrostChefBackendApplication-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]