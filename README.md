<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

## Contenido
- [El Desafio](#el-desafio)
    - [Escenario](#escenario)
    - [APIs](#apis)
    - [Features](#features)
    - [Puntos a Considerar](#puntos-a-considerar)
- [¿Qué nos Gustaría Ver?](#qué-nos-gustaría-ver)
    - [Deseables](#deseables)
    - [Stack/Pool de Tecnologías](#stackpool-de-tecnologías)
- [Forma de Entrega](#forma-de-entrega)
- [Importante](#importante)

## El Desafio

### Escenario
Recientemente te has unido a un equipo que esta desarrollando una aplicación mobile para una gran compañía de e-commerce.  
Esta aplicación esta dirigida a dispositivos de **bajo rendimiento** hasta dispositivos con **gran poder de procesamiento**.  
El cliente ya cuenta con un backend establecido que contiene todas las reglas e información de negocio, pero algunos sistemas dependen de **tecnologías legadas** que pueden ser **inestables**.    
**Tu** eres responsable de construir la **API** que integrará con estos servicios y proveerá todas las informaciones que Mobile necesita.  
Para las próximas iteraciones, el equipo va a trabajar en la **Pantalla de Início** y tu debes construir todo(s) los **endpoint(s)** que se requieran para integrar con los servicios y proveer la información para la pantalla.

### APIs
Necesitarás consumir los siguientes servicios:
- **Categorias**: [https://cs-hsa-api-categories.herokuapp.com/docs](https://cs-hsa-api-categories.herokuapp.com/docs)
- **Cupones**: [https://cs-hsa-api-coupons.herokuapp.com/docs](https://cs-hsa-api-coupons.herokuapp.com/docs)

### Features
El equipo Mobile necesita construir una pantalla de inicio que debe mostrar:

- Carrusel con **Top 5** categorias.
- Carrusel con cupones que no han expirado.
- Tabla (Grid) con las categorias **restantes**.
- Mobile **no** necesita de todas las imagenes del modelo de categorías, pero solamente el **icono** y la **imagen más pequeña**. Tu podrías tener que filtrar la respuesta, si tu quieres.

### Puntos a Considerar
- La API de Cupones es **inestable** y a veces demora en responder.
- La API de Categorias responde un modelo complejo de manejar.

## ¿Qué nos Gustaría Ver? 
Eres libre para implementar la solución de la forma que consideres mejor, 
pero debes considerar el escenario, objetivo, implicaciones de performance y stack/pool de tecnología propuesta abajo.
- Nos enfocamos mucho en la **calidad** de nuestros proyectos y nos gustaría ver alguna estrategia aplicada. Puedes usar, por ejemplo, **Pruebas Unitárias**;
- No queremos que la experiencia de usuario se vea afectada por el rendimiento de los servicios;
- **Usted tiene 1 semana para completar el desafio**. Si necesitas mas tiempo, no hay problema, puede hablar con nosotros y veremos que podemos hacer :)

### Deseables
- Podría ser bueno una documentación de API. Sugerencia: [Swagger](https://swagger.io/).
- Ejecutando con [Docker](https://www.docker.com/).

### Stack/Pool de Tecnologías
- **Java 8** o **superiores**.
- Cualquier Framework Web. Sugerencia: [Spring Boot](https://spring.io/projects/spring-boot).
- Cualquier API Client. Sugerencia: [Feign](https://github.com/OpenFeign/feign).
- De preferencia [Gradle](https://gradle.org/) como sistema de compilación.
- Tu eres libre para escoger librerias y frameworks de pruebas que mas te guste. Nuestra sugerencia es: [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org/).

---

## Forma de Entrega
Siga los pasos para implementar y enviar este desafio:
- Haga un **Fork** a este repositorio. Mira esta guía para mayores informaciones: [How to Fork a repository](https://help.github.com/en/articles/fork-a-repo).
- Implemente el desafio.
- Después de completar el desafio, realise un **Pull Request** a este repositorio, utilisando la interface de **Github**. [Check this guide for more details](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork).
- Si es posible, deja tu repositorio publico para hacer la revision de codigo mas sencilla.

## Importante
**No** intente hacer un PUSH directo a ESTE repositorio!

## Compilar y generar el ensamblado
    Gradle : ./gradlew build
    Test   : java -jar build/libs/challenge-1.0.0.jar
    Swagger: http://localhost:8080/swagger-ui.html

# Crear imagen Docker
En la raíz del proyecto, ejecutar los siguientes comandos:

## Build de la imagen
    docker build -f src/main/docker/Dockerfile -t challenge:1.0.0 .

## Test de la imagen:
    docker run --name challenge --rm -p 8080:8080 challenge:1.0.0

## URL:
    Swagger: http://localhost:8080/swagger-ui.html
    Categories: http://localhost:8080/categories/top/5
    Categories After: http://localhost:8080/categories/after/5
    Categories Mobile: http://localhost:8080/mobile/categories/top/5
    Categories After Mobile: http://localhost:8080/mobile/categories/after/5
    Coupons Active: http://localhost:8080/coupons/active

## Push de la imagen
    docker tag challenge:1.0.0 REGISTRY_USER/challenge:1.0.0
    docker push REGISTRY_USER/challenge:1.0.0


---
