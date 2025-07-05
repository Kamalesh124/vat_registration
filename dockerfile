# Use an official JDK 17 image as base
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven build jar to the container
COPY target/registration-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (same as server.port in application.properties)
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
