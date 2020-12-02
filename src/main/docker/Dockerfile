FROM openjdk:8-alpine
ARG JAR_FILE=build/libs/java-recruiting-hsa-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8081:8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

MAINTAINER Alvaro Montilla <alvaromontilla@gmail.com>