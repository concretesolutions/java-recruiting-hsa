<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Consideraciones

- Se pide que aplicación tenga un buen rendimiento a pesar de que los webservices originales tienen problemas en este aspecto. Por lo tanto, el rendimiento es primordial.
- Todos los datos pueden ser vistos por cualquier usuario de la aplicación mobile.
- El volumen de información es controlado.
- El webservice de Categorías tiene una estructura de datos compleja.

# Diseño de la solución

Con lo anterior, es posible realizar Caching de datos dentro de la API. Esto significa que periódicamente se realizaran solicitudes hacia los webservices legados refrescando y almacenando las listas para que las consultas a la API se hagan desde los datos en Caching. Se aplicó esta solución para los dos webservices ya que se optó por mejorar el rendimiento en ambos servicios.

La estructura de datos del webservice de Categorías es de tipo Recursiva. Para simplificar el modelo, se creó una lista lineal en donde cada elemento contiene los mismos atributos (no mandatorios) que el resto. La implementación actual solo considera un tag nuevo que hace referencia a la Categoría padre. Esta estructura puede ser robustecida si se agregan referencias para Categorías hijas (subcategorías).

Se creó una API que interactúa como middleware entre la aplicación Mobile (también creada para este proyecto) y los webservices RESTful del E-Commerce.

**Tecnología API**
- Java 1.8
- Maven 3.6.1
- Tomcat 9.0.21
- Spring Boot 2.1.6
- OpenFeign 2.1.2
- Swagger 2.6.1
- JMeter 5.1.1
- Eclipse

**Tecnología Mobile**
- Visual Studio Code 1.35.1
- Flutter 3.1.0
- Dart 3.1.0
- Android Studio (Emulación Android 9.0 Pie)

# Ambiente

Para ejecutar la API es necesario descargar imágenes Docker creadas para este propósito.
- Contenedor 1: Apache Tomcat 9.0.21<br/>
  $ docker pull riosoft/tomcat90<br/>
  $ docker run -it -d -p 8080:8080 --name tomcat-desafio riosoft/tomcat90<br/>
- Contenedor 2: Jenkins<br/>
  $ docker pull riosoft/jenins-desafio<br/>
  $ git clone https://github.com/ricardobranco777/docker-volumes.sh.git<br/>
  $ cd docker-volumes.sh<br/>
  $ # Colocar volumen de Jenkins acá<br/>
  $ chmod +x docker-volumes.sh<br/>
  $ docker run -it -d -p 8081:8080 --name jenkins-desafio riosoft/jenkins-desafio<br/>
  $ docker stop jenkins-desafio<br/>
  $ /docker-volumes.sh jenkins-desafio load jenkins-desafio-volumes.tar.gz<br/>
  $ docker start jenkins-desafio<br/>

Ya que estos contenedores son ambientes aislados de la máquina host, **la comunicación entre ellos se deberá hacer a través de la IP del host que esté ejecutando los contenedores**.

Una vez iniciados estos contenedores, se puede proceder al levantamiento del Ambiente para la API. Esto se hace a través de 3 Jobs:
- **ecommerce-api-compile**: Compila el proyecto que se encuentra en GitHub.
- **ecommerce-api-deployment**: Deploya el WAR generado en el contenedor Tomcat. **Se debe ingresar la IP del host para que el contenedor lo pueda reconocer**.
- **ecommerce-api-test**: Ejecuta una prueba de stress de los endpoints a través de la aplicación JMeter. Dura 1 minuto simulando 1000 conexiones. **Se debe ingresar la IP del host para que el contenedor lo pueda reconocer**.

# Testing

Debido a que el principal foco del proyecto es el rendimiento, es que solo se creó un Job en Jenkins que realiza durante un minuto un test exhaustivo sobre los endpoints a través de la herramienta JMeter de Apache. Es posible realizar pruebas unitarias pero no me enfoqué en este aspecto favoreciendo el desarrollo a la parte de rendimiento.

Ingresando a Jenkins, se pueden observar gráficas de rendimiento a medida que se hacen pruebas. Los rangos de comparación se pueden extender o disminuir de acuerdo a las preferencias de medición.

# Rutas

Suponiendo que los servicios correrán en la máquina host del evaluador, el nombre "localhost" será el adecuado para acceder a los proyectos desde el browser.

**Spring Boot WebApp**

- http://localhost:8080/ecommerce

**URLs RESTful**

- http://localhost:8080/ecommerce/categories
- http://localhost:8080/ecommerce/coupons
- http://localhost:8080/ecommerce/coupons/currents

**Documentación API**

- http://localhost:8080/ecommerce/swagger-ui.html (vía Swagger)

# Docker machines

**Apache Tomcat**
- http://localhost:8080
- User: admin
- Password: password

**Jenkins**
- http://localhost:8081
- User: admin
- Password: password

# Aplicación Mobile

Se conecta a la API, falta desplegar los datos en los componentes de Flutter.
---
