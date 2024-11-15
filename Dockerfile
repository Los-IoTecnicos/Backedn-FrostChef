FROM amazoncorretto:17-alpine-jdk AS build
LABEL authors="Yordi Gonzales"

# Copiamos el wrapper de Maven y el archivo de configuración
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Descargar dependencias sin construir aún
RUN ./mvnw dependency:go-offline

# Copiamos el código fuente y construimos el JAR
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Imagen final con solo el JAR
FROM amazoncorretto:17-alpine-jdk
LABEL authors="Yordi Gonzales"

COPY --from=build target/FrostChefBackendApplication-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
