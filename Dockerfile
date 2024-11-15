FROM amazoncorretto:17-alpine-jdk
LABEL authors="Yordi Gonzales"

# Copia el código fuente al contenedor
COPY . /app

# Cambia el directorio de trabajo a /app
WORKDIR /app

# Ejecuta Maven para compilar el proyecto y crear el JAR
RUN ./mvnw clean package -DskipTests

# Copia el JAR generado al contenedor (usa comodín para encontrar el JAR)
RUN mv target/*.jar /app.jar

# Define el entrypoint para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
