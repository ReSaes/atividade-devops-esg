FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

COPY .mvn .mvn/
COPY mvnw .
COPY mvnw.cmd .

COPY pom.xml .
COPY src /app/src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine

EXPOSE 8080

ARG JAR_FILE=target/*.jar

COPY --from=builder /app/${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]