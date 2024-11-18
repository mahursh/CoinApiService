FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
RUN mvn dependency:resolve
COPY src ./src


RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-jre
WORKDIR /app
EXPOSE 80
ENTRYPOINT ["java", "-jar", "app.jar"]