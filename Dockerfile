# Stage 1: Build the application using a Maven image 
FROM maven:3.9.6-openjdk-17 AS build 
WORKDIR /app 
COPY pom.xml . 
COPY src ./src 
# Build the application, skipping tests for faster image build (tests 
run in Jenkins pipeline) 
RUN mvn clean package -DskipTests 
 
# Stage 2: Create the final lightweight runtime image 
FROM openjdk:17-jdk-slim 
WORKDIR /app 
# Copy the built JAR from the 'build' stage 
COPY --from=build /app/target/*.jar app.jar 
# Expose the port your Spring Boot app runs on 
EXPOSE 8080 
# Define the command to run your application 
ENTRYPOINT ["java", "-jar", "app.jar"] 
