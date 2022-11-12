FROM amazoncorretto:11
EXPOSE 8080
COPY build/libs/java-recruiting-hsa-0.0.1-SNAPSHOT.jar java-recruiting-hsa-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-recruiting-hsa-0.0.1-SNAPSHOT.jar"]