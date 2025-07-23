# ===== Stage 1: Build JAR using Maven =====
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy everything (pom.xml + src) into container
COPY . .

# Build the Spring Boot app
RUN mvn clean package -DskipTests

# ===== Stage 2: Run the app using JDK 17 =====
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]