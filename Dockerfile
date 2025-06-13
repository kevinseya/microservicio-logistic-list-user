FROM maven:3.8.3-openjdk-17 AS builder
ADD . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=builder /app/target/list-user-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
