FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]