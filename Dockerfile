# Use a base image with Java 11 installed
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory of your Spring Boot project to the container's working directory
COPY target/BookManagementAPI.jar /app/BookManagementAPI.jar

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "BookManagementAPI.jar"]
