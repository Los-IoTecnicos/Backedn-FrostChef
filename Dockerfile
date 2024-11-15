# Dockerfile
FROM amazoncorretto:17-alpine-jdk
LABEL authors="Yordi Gonzales"

# Copia el código fuente al contenedor
COPY . /app

# Ve al directorio de la aplicación
WORKDIR /app

# Ejecuta Maven para compilar el proyecto y crear el JAR
RUN ./mvnw clean package -DskipTests

# Copia el JAR generado al contenedor
RUN ls target # Verificar si el JAR se generó correctamente
COPY target/FrostChef-backend-0.0.1-SNAPSHOT.jar.original /app.jar

# Define el entrypoint para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
