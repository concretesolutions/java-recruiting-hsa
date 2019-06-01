FROM openjdk:8-jdk-alpine

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Default copy (Gradle)
COPY build/libs/challenge-1.0.0.jar app.jar

ENV JAVA_OPTS="-Dspring.profiles.active=prod -Djava.security.egd=file:/dev/./urandom "

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]