<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Test Accenture

Proyecto cuya finalidad es consumir 2 APIRest de los siguientes endpoint:

- https://cs-hsa-api-categories.herokuapp.com (**categories**)
- https://cs-hsa-api-coupons.herokuapp.com (**coupons**)


## Tecnologías ocupadas en el desarrollo:

* Spring Framework 
* OpenFeign (**client**)
* Swagger
* Spring WEB
* Lombok
* Gradle
* Java 8
* JUnit with Mockito (**Jupiter**)


## APIs expuestas por el microservicios 

| Type Method   | Method        | URL  |
| ------------- | ------------- | ---- |
| GET           | getCouponsNotExpired()| localhost:8080/coupons/getCouponsNotExpired|
| GET           | getTopFive()  | localhost:8080/categories/getTopFive  |
| GET           | getRemainingCategories()  | localhost:8080/categories/getRemainingCategories|

## Compilacion y despliegue del microservicio

* Para compilar el proyecto de debe escribir el siguiente comando gradle `grandlew clean build` , el compilado se genera en la ruta `{base_proyect}/build/libs/test-0.0.1-SNAPSHOT.jar`

* Para correr el proyecto ya **compilado** escribir el siguiente comando `gradle bootRun`

* Para construir una imagen docker escribir el siguiente comando `docker build -t test-docker .`

* Para levantar o correr el contenedor con la imagen creada `docker run --name test-docker -p 8080:8080 test-docker:latest`


## Swagger

* Para poder ver la documentacion de las Apis Rest ver el siguiente enlace `http://localhost:8080/swagger-ui.html`


**Autor**
***Felipe Galaz***




