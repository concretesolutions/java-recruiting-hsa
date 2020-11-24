FROM openjdk:8-alpine
ADD ./build/libs/prueba-0.0.1-SNAPSHOT.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]