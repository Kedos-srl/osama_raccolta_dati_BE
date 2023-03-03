FROM maven:3-eclipse-temurin-11 AS build
WORKDIR /build-folder
COPY .. /build-folder/.
RUN pwd
RUN ls -la
RUN mvn clean package -P docker
FROM tomcat:9-jdk11
COPY --from=build /build-folder/osamard-api/target/*.war /usr/local/tomcat/webapps/.
