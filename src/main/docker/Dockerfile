# Google Cloud Platform openjdk 8 Docker Image
FROM gcr.io/google-appengine/openjdk:8

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Default copy (Gradle)
COPY build/libs/*.jar /api/app.jar

# Default workspace dir
RUN ls /api
WORKDIR /api

ENTRYPOINT exec java -jar app.jar
