#FROM openjdk:8-jre
#EXPOSE 8080

#ADD target/proyectoUno-0.0.1-SNAPSHOT.jar /app/proyectoUnojar

# Fix zona horaria de Chile
#RUN apt-get update && apt-get install -y tzdata

#WORKDIR /app
#CMD java -Djava.security.egd=file:/dev/./urandom ${JAVA_OPTS} -jar app.jar
FROM openjdk:11

ADD target/proyectoUno-0.0.1-SNAPSHOT.jar /app/proyectoUno.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "proyectoUno.jar"]