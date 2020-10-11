FROM openjdk:8-jdk-alpine
ENV LANG C.UTF-8
COPY ./build/libs/*.jar /api/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
