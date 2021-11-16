FROM frolvlad/alpine-java:jdk8-slim
COPY .mvn .mvn                                               
COPY mvnw .                                                  
COPY pom.xml .                                               
COPY src src
RUN chmod +x mvnw 
RUN ./mvnw clean package  
COPY target/*.jar /java-recruiting-hsa/lib/app.jar
WORKDIR /java-recruiting-hsa
ENTRYPOINT ["java","-jar","lib/app.jar"]
EXPOSE 8081
