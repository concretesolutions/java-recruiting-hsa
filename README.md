<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

---

## APIs

Para obtener los cupones que no han vencido se invoca a servicio inestable "coupons", se disponibilizan 2 APis (GET) para obtener los datos, ambas Apis invocan al mismo endpoint y entregan la misma información, manejan circuit breaker con hystrix, para la resiliencia y con un timeout de 1.5 segundos, esto dado que esta enfocada en aplicaciones mobile. En caso que el servicio no entregue información o supere el timeout retornara un JSON vacio.  
La diferencia de APIs a continuación:

1. **API Cupones cache**: http://localhost:8083/cupones/v1/activos, utilización de ehcache para que en caso de obtener informaciòn se guarde en memoria durante 100 segundos, toda la configuración esta en el archivo ehcache.xml [aqui](/src/main/resources/ehcache.xml).

2. **API Cupones sin cache**: http://localhost:8083/cupones/v2/activos, no utiliza cache y va siempre a consultar al endpoint.
---

## Stack/Pool de Tecnologías
- Java 8. 
- Framework: Spring Boot. 
- API Client: Feign.
- Sistema de compilación: Gradle.
- frameworks de pruebas: JUnit y Mockito.
- ehcache (Cache) y hystrix (Circuit Breaker).
---
