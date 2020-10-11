FROM openjdk:8-alpine
ADD target/my-fat.jar /usr/share/app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/app.jar"]
