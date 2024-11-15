# Etapa de construcción: usamos Maven y Java 21
FROM maven:3.8.8-eclipse-temurin-21 AS build
LABEL authors="Yordi Gonzales"

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo de configuración Maven para aprovechar la caché de dependencias
COPY pom.xml .

# Descargar todas las dependencias del proyecto
RUN mvn dependency:go-offline

# Copiamos todo el proyecto y lo construimos
COPY . .

# Compilamos el proyecto y generamos el .jar
RUN mvn clean package -DskipTests

# Etapa final: Usamos una imagen más liviana para ejecutar el JAR
FROM openjdk:21-jdk-slim
LABEL authors="Yordi Gonzales"

# Exponemos el puerto en el que la aplicación corre
EXPOSE 8080

# Copiamos el JAR generado en la fase de construcción
COPY --from=build /app/target/FrostChefBackendApplication-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
