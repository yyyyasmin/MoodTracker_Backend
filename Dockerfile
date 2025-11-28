# 1. Build-Stage: Java-App mit Gradle bauen
FROM gradle:8.7-jdk17 AS builder
WORKDIR /app

# Nur die Gradle-Konfiguration zuerst kopieren, um Caching zu nutzen
COPY build.gradle settings.gradle gradlew gradlew.bat ./
COPY gradle ./gradle

# Ausführungsrechte für gradlew setzen (wichtig!)
RUN chmod +x gradlew

# Dummy-Build zum Cachen der Dependencies
RUN ./gradlew dependencies || true

# Jetzt den Rest des Projekts kopieren
COPY . .

# App bauen (ohne Tests, damit der Build schneller/robuster ist)
RUN ./gradlew clean bootJar -x test

# 2. Runtime-Stage: schlankes JDK-Image
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# JAR aus der Build-Stage kopieren
COPY --from=builder /app/build/libs/*.jar app.jar

# Render setzt die PORT-Umgebungsvariable
ENV PORT=8080
EXPOSE 8080

# Spring Boot starten
ENTRYPOINT ["java","-jar","app.jar"]