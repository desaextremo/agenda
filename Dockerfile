# Usa una imagen base de Eclipse Temurin (Java 17)
FROM eclipse-temurin:17-alpine

LABEL authors="desaextremo"

# Copia el archivo JAR de la aplicación Spring Boot al contenedor
COPY target/agenda-0.0.1-SNAPSHOT.jar app.jar


# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]