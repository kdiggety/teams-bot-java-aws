FROM openjdk:22-jdk
WORKDIR /app
COPY . /app
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/*.jar"]
