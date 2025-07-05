# ========================
# Stage 1: Build with Maven
# ========================
FROM maven:3.9.6-eclipse-temurin-17 as builder

WORKDIR /app

# Copy all source files
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# ========================
# Stage 2: Run with JDK
# ========================
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/target/registration-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8081

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
