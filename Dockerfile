FROM openjdk:8
COPY ./ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","ServicioApiApplicationTests"]