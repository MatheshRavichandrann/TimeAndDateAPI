FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests


FROM amazoncorretto:21
WORKDIR /app
COPY --from=build /target/your-app.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
