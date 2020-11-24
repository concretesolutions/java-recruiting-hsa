FROM openjdk:15-jdk-alpine
WORKDIR /usr/local/app
ADD build/libs/java-recruiting-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]