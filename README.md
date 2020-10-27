<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

###Realizado con:
- Java 11.
- Springboot.
- Gradle.

###Swagger:
> http://localhost:8091/java-recruiting-hsa/v1/swagger-ui.html

###Métodos de consulta:
getCategoriesTopFive: 
> http://localhost:8091/java-recruiting-hsa/v1/categories/topFive
getRestOfCategories: 
> http://localhost:8091/java-recruiting-hsa/v1/categories/rest
getNotExpiredCoupons:
> http://localhost:8091/java-recruiting-hsa/v1/coupons

###Ejecución:
Abrir consola de comandos y ejecutar en el siguiente orden para generar el .jar:
>gradle bootRun
>build gradle

###Ejecutar siguiente comando con docker:
>docker build -t java-recruiting-hsa-0.0.1.jar .

###Validar si se encuentra generada imagen en docker con el siguiente comando:
>docker images

###Iniciar el contenedor docker:
>docker run java-recruiting-hsa