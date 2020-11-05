FROM openjdk:8-jdk-alpine
COPY build/libs/test-0.0.1-SNAPSHOT.jar test.jar
ENTRYPOINT ["java", "-jar", "/test.jar"]