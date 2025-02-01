# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Copy the pom.xml and fetch dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code and build the app
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:21
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /target/HuffmanCoder-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the correct port based on logs (8080 in this case)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]

# Health check (optional but recommended)
HEALTHCHECK CMD curl --fail http://localhost:8080/actuator/health || exit 1
