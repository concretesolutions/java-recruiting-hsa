FROM openjdk:8
EXPOSE 8080
ADD build/libs/concretechallenge-0.0.1-snapshot.jar concretechallenge-0.0.1-snapshot.jar
ENTRYPOINT ["java","-jar","/concretechallenge-0.0.1-snapshot.jar"]