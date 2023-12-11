<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

## Categories & Coupons API

Este proyecto es una API de Spring Boot para manejar categorías y cupones. Utiliza Spring Boot 3 con Gradle, integración con clientes Feign para servicios externos, manejo de errores con Spring Retry, y documentación de API con Swagger.

## Comenzando

Instrucciones para obtener una copia del proyecto funcionando en tu máquina local para desarrollo y pruebas.

### Prerrequisitos

- JDK 17
- Gradle

### Instalación

Clona el repositorio y navega al directorio del proyecto:

```bash
git clone https://github.com/BorisRand/java-recruiting-hsa.git
cd .\java-recruiting-hsa\bff-categories-coupons\
```

### Configuración

Configura las propiedades necesarias en `src/main/resources/application.properties`.

### Swagger API Docs
La documentación de la API está disponible en Swagger UI, que se puede acceder en:

```bash
http://localhost:8080/swagger-ui/index.html
```

### Spring Retry
El proyecto utiliza Spring Retry para manejar reintentos en las llamadas a servicios externos de manera eficiente.

## Construido con

- [Spring Boot](https://spring.io/projects/spring-boot) - El framework web utilizado.
- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign) - Cliente Feign para llamadas a servicios externos.
- [SpringDoc OpenAPI](https://springdoc.org/) - Para la documentación Swagger.
- [Spring Retry](https://docs.spring.io/spring-batch/docs/current/reference/html/retry.html) - Para el manejo de reintentos.

## IDE utilizado

- IntelliJ IDEA 2022.3.2 (Ultimate Edition)

## Autores

- **Boris Molina Igor** - Desarrollador - [BorisRand](https://github.com/BorisRand)

### APIs
Necesitarás consumir los siguientes servicios:
- **Categorias**: [https://cs-hsa-api-categories-rest.herokuapp.com/docs](https://cs-hsa-api-categories-rest.herokuapp.com/docs)
- **Cupones**: [https://cs-hsa-api-coupons-rest.herokuapp.com/docs](https://cs-hsa-api-coupons-rest.herokuapp.com/docs)

---
