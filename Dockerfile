FROM openjdk:11-stretch

WORKDIR /app


ADD ./build/libs/*.jar /app.jar

RUN sh -c 'touch /app.jar'

EXPOSE 8080


ENTRYPOINT ["java","-jar","/app.jar"]