<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Accenture

### APIs
Se requiere consumir los siguientes servicios:
- **Categorias**: [https://cs-hsa-api-categories.herokuapp.com/docs](https://cs-hsa-api-categories.herokuapp.com/docs)
- **Cupones**: [https://cs-hsa-api-coupons.herokuapp.com/docs](https://cs-hsa-api-coupons.herokuapp.com/docs)

### Features
El equipo Mobile necesita construir una pantalla de inicio que debe mostrar:

- Carrusel con **Top 5** categorias.
- Carrusel con cupones que no han expirado.
- Tabla (Grid) con las categorias **restantes**.
- Mobile **no** necesita de todas las imagenes del modelo de subcategorías, solamente la **imagen más pequeña**. Tu podrías tener que filtrar la respuesta, si tu quieres.

### Documentación Proyecto Java

A continuación se decriben los requerimientos y procedimientos necesarios para ejecutar el proyecto:

### Requerimientos:

Se debe tener instalado en el equipo las siguientes herramientas:

- JDK 15
- Docker

### Procedimiento para Iniciar Proyecto:

Para iniciar el proyecto, ejecutar:
 
1- Primero, se debe compilar el proyecto para obtener el archivo JAR con el siguiente comando:
 ```bash
 gradlew build
 ```
2- Luego se debe construir la imagen del proyecto en docker con el siguiente comando:
 ```bash
 docker build -t java-recruiting .
 ```
3- Finalmente, se levanta el contenedor con la ejecucion del JAR con el siguiente comando:
 ```bash
 docker run -p 8080:8080 java-recruiting
 ```
En este momento, la API esta lista para ser consumida en http://localhost:8080/

### Procedimiento para Detener Proyecto:

Para detener el proyecto, ejecutar:

1- Primero se debe tener el nombre del contenedor para idenfiticarlo mediante el siguiente comando:
 ```bash
 docker ps
 ```
2- Luego se ejecuta el siguiente comando ingresando el nombre del contenedor identificado anteriormente:
 ```bash
 docker stop <NAME>
 ```
### Procedimiento para realizar Pruebas Unitárias del Proyecto:

Para realizar pruebas del proyecto, ejecutar:
 ```bash
 gradlew test
 ```

### Documentación API Endpoints:
Para ver la documentación de la API y sus end-points, visitar la siguiente URL:

 ```bash
 http://localhost:8080/swagger-ui/index.html
 ```
A continuación, se tiene una tabla resumen con los endpoints disponibles:

| HTTP Method | URL | Feature |
| --- | --- | --- |
| GET | http://localhost:8080/categories/top5 | Carrusel con **Top 5** categorias |
| GET | http://localhost:8080/categories/others | Tabla (Grid) con las categorias **restantes**. |
| GET | http://localhost:8080/coupons/valid | Carrusel con cupones que no han expirado. |


### Consideraciones para optimización del proyecto
- La API de Cupones es **inestable** y a veces demora en responder. ¿Qué podemos hacer para que este problema no se replique en otras capas? ¿Habrá algún patrón que nos ayude?

> De acuerdo a lo anterior, una buena estrategia para solucionar este problema seria realizar un cambio de arquitectura de microservicios bloqueantes a implementar una arquitectura con programación reactiva.

> La programación reactiva es un paradigma enfocado en el trabajo con flujos de datos asíncronos (streams), finitos o infinitos, permitiendo que estos datos se propaguen generando cambios en una aplicación al "reaccionar" ante cambios asíncronos, lo cual podría ayudar a mejorar el consumo de una API lenta y bloqueante.

> La programación reactiva está relacionada con el patrón de diseño Observer, en este patrón hay un sujeto que es el productor de la información (stream) y por otro lado hay uno o varios consumidores de esta información, este sujeto sería el observable y el consumidor el observer.

> Cuando hay un cambio de estado en un observable, los observers son notificados y actualizados. Por lo tanto, en lugar de sondear eventos para los cambios, los eventos se realizan de forma asíncrona para que los observer puedan procesarlos. Un observer accede al último evento asincrónico que le interesa sin preocuparse por el estado o la terminación de una API en curso.

> Una herramienta útil para realizar este cambio de arquitectura es ReactiveX, una API que facilita el manejo de flujos de datos y eventos, a partir de una combinación del patrón Observer, el patrón Iterator y características de la Programación Funcional.

> Para más información, visitar el sitio http://reactivex.io/


- La API de Categorias responde un modelo complejo de manejar. ¿Qué podríamos hacer para simplificar este modelo y que las integraciones con su aplicación sean más sencillas?

> Una solución sería implementar un middleware entre la API de Categorías y las futuras integraciones utilizando el patrón de diseño Adapter. Este patrón nos permitiría realizar una envoltura de la API Categorías, la cual es compleja de manejar, para transformarla y simplificar su modelo, lo cual facilitaría su consumo.

> El patrón Adapter transforma una interfaz en otra, lo cual permite desacoplar nuestro código de los cambios de servicios de terceros para facilitar las futuras integraciones con este nuevo servicio.

---


