FROM openjdk:22-jdk
COPY target/teams-bot-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
