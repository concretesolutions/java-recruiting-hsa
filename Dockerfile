FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/java-recruiting-hsa-0.0.1.jar /app/java-recruiting-hsa-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app/java-recruiting-hsa-0.0.1.jar"]
