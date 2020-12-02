<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete Manuel Jimenez Navarrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

## requisitos
Se deben tener ciertas condiciones para que el proyecto funcione.
* JDK 8.

## Desarrollado con

- Java 8
- Springboot
- Lombok
- Gradle
- Junit
- Swagger
- CircuitBraker

## ¿Cómo ejecutar el proyecto?

- Abrir un terminal en la carpeta raíz del proyecto "java-recruiting-hsa".
- Limpiar cualquier otro build anterior.
```bash
./gradlew clean
```
- Construir la aplicación.
 ```bash
 ./gradlew build
 ```
- Correr la aplicación.
```bash
./gradlew bootRun
```

## Consideraciones
Se han establecido ciertas consideraciones respecto los requerimientos dados.

- Para la establecer las categorias **top**, se ha decidido compararlas según el campo `relevance` y, entre mayor es este número, más relevancia tiene y por ende más "top" se considera. Para las categorías que no tienen el campo `relevance` se consideran como baja relevancia.
- Para realizar los siguientes requerimientos:
-- Carrusel con **Top 5** categorias.
-- Tabla (Grid) con las categorias  **restantes**.
- Se ha realizado una solución en donde, al fallar la llamada de servicio final, se vuelve a intentar hacer el llamado del servicio REST.
- Solo se han desarrollado pruebas unitarias.
- Para solventar la inestabilidad de la API de cupones, se utiliza patron de arquitectura circuitBraker.

## Pendiente

Dado que el tiempo indicado fue de 3 dias y estar dentro de horario laboral a quedado pendiente la siguientes cosas.

- Han quedado pendiente finalizar 1 junit se CategoryServiceTest.
- no se alcanzo a implementar Docker

## Endpoints para probar la aplicación

Solo como resumen y ayuda, ya que de igual forma de integra Swagger en el proyecto.
- Endpoint para la obtención de cupones no expirados:
```
GET
endpoint: http://127.0.0.1:8081/accenture/test/rest/catalog/coupon/no-expired
```
- Endpoint para la obtención de las top 5 categorías:
```
GET
endpoint: http://127.0.0.1:8081/accenture/test/rest/catalog/category
```

## Documentación Swagger

Para acceder a la documentación con Swagger, se debe correr la aplicación y acceder a la url:
```
http://127.0.0.1:8081/accenture/test/rest/catalog/swagger-ui.html#/
```
Descripción: Obtener endpoints codificados en JSON para poder importar a herramientas como postman
```
http://127.0.0.1:8081/accenture/test/rest/catalog/v2/api-docs
```