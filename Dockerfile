FROM openjdk:11
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/java-recruiting-hsa-0.0.1.jar /app/java-recruiting-hsa-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app/java-recruiting-hsa-0.0.1.jar"]