## Build stage
#
FROM maven:3.9.3 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:19-jdk-slim-buster
COPY --from=build /target/ELibrary-0.0.1-SNAPSHOT.jar ELibrary.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","ELibrary.jar"]