FROM openjdk:17-alpine

WORKDIR /api

# jar que contiene todas las dependencias del codigo
COPY ./build/libs/concrete-[0-9].[0-9].[0-9].jar /api/application.jar

# jar que contendra el codigo que creamos.
COPY ./build/libs/concrete-[0-9].[0-9].[0-9]-plain.jar /api/application-core.jar

EXPOSE 8080

ENTRYPOINT [ "java", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-Doracle.jdbc.timezoneAsRegion=false", \
    "-XX:+UnlockExperimentalVMOptions", \
    "-XX:+UseContainerSupport", \
    "-XX:MaxRAMPercentage=60.0", \
    "-XX:+UseSerialGC", \
    "-jar", \
     "/api/application.jar" \
]