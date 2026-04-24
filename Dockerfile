# Builda a aplicação dentro da imagem para não depender de Maven no host.
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /build

COPY app_spring/portalweb/pom.xml pom.xml
COPY app_spring/portalweb/src src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/target/portalweb-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
