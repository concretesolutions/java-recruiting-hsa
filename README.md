# Desafio Java Concrete

Desafio técnico desarrollado por **José Miguel Lizárraga**. <br />
joselizarraga.m@gmail.com

# Consideraciones

Por defecto el puerto utilizado es el 8080.Si desea cambiarlo puede usar el siguiente comando en el archivo application.properties <br />
server.port=8999
<br />
Los endpoints para llamar a las apis se encuentran en este archivo también.

## Probar la aplicación con Swagger

**Top 5 categorias**
http://localhost:8080/swagger-ui.html#/categoria-controller/getCarruselUsingGET
<br />

**Cupones que no han expirado**
http://localhost:8080/swagger-ui.html#/cupon-controller/getCarruselUsingGET_1

## Endpoints utilizados

http://localhost:8080/api/categoria/mobile/getCarrusel
<br />
http://localhost:8080/api/cupon/mobile/getCarrusel

## Pruebas unitarias

Click derecho sobre la clase de pruebas -> run as -> junit test

## Tecnologías

Maven, Spring Boot, Jersey, Swagger, JUnit, Jackson


## Patrones de diseño utilizados

Patrón Singleton en el servicio de cupones para una carga inicial durante el arranque del proyecto
