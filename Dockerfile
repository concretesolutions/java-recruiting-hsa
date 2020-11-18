FROM gcr.io/google-appengine/openjdk:8

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Default copy (Gradle)
COPY ./build/libs/concrete-0.0.1-SNAPSHOT.jar /api/app.jar

# Default workspace dir
RUN ls /api
WORKDIR /api

# no root execution
USER www-data

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Doracle.jdbc.timezoneAsRegion=false", "-jar", "/api/app.jar"]