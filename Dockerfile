# Etapa 1: Construcción
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copia todos los archivos del proyecto
COPY . .

# Da permisos de ejecución al script mvnw
RUN chmod +x mvnw

# Construye el proyecto y empaqueta el JAR (sin ejecutar los tests)
RUN ./mvnw clean package -DskipTests

# Etapa 2: Creación del contenedor final
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

# Copia el JAR generado desde la etapa de construcción
COPY --from=build /app/target/FrostChef-backend-0.0.1-SNAPSHOT.jar app.jar

# Define el entrypoint para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
