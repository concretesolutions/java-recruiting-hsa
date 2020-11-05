FROM openjdk:8
COPY "build/libs/test-0.0.1-SNAPSHOT.jar" "test.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "test.jar"]