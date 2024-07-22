FROM maven:3.8.1-jdk-11-slim AS build
WORKDIR /build
COPY . /build
RUN mvn clean package -Dsnyk.skip

FROM openjdk:17-ea-22-jdk-oracle AS app
WORKDIR /app
COPY --from=build /build/target/demo-0.0.4-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-0.0.4-SNAPSHOT.jar"]
