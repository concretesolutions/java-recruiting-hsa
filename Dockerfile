FROM openjdk:8
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/bff-mobile-0.0.1.jar /app/bff-mobile-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app/bff-mobile-0.0.1.jar"]