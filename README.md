<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Propuesta al desafio tecnico Java Concrete.

# Servicio
- **URI-Local:** http://localhost:8080 
- **Base-Path:** /api/bff/mobile-team

# Requisitos
- JDK 17
- Docker
- Docker-Compose
- Git

# Tecnologias
- Java 17
- Spring WebMvc
- Rest-Template
- Docker
- Docker-Compose
- Gradle
- Junit 5 (spring integrated)
- Postman
- Swagger
- Git

# Testing

Para ejecutar las pruebas solo debes hacer uso del comando correspondiente a tu S.O:
- windows: `./gradlew.bat test`
- linux: `./gradlew test`
- mac: `./gradlew test`

Tambien puedes usar tu IDE favorito para ejecutarlas.

# Construir el servicio

Para utilizar el servicio tienes tres opciones, las dejaremos a continuacion de la forma mas rapida a la mas lenta, recuerda solo escoger una de las siguientes 3 opciones.:
- utiliza docker-compose, para ello dirigete a la seccion `Docker Compose`
- utiliza docker, para ello dirigete a la seccion de `Docker`, 
- la opcion que tienes es utilizar el gradle wrapper que viene en el servicio, de igual forma debes tener instalado java 17 en tu equipo, por que debes compilar por tu cuenta el servicio, para ello utilizaras el comando build desde el wrapper correspondiente a tu equipo:
-- windows: `./gradlew.bat build`
-- linux: `./gradlew build`
-- mac: `./gradlew build`

si construiste con gradle favor continua con la seccion `Construir el servicio`, de otra forma continua a la seccion Pruebas.

# Levantar el servicio

una vez construido el servicio, solo en el caso de haber compilado mediante Gradle, si usaste la opcion docker o docker-compose salta hasta la seccion `Pruebas`, se generaran dos Jar's esto es para eficientar el uso posterior de docker, para ello solo debes correr el siguiente comando y asi ejecutaras el servicio
- `java -jar /ruta/hacia/el/proyecto/build/libs/Concrete-0.3.1.jar`

si todo va bien deberias ver los logs levantarse en tu consola, ya ahora puedes continuar con las pruebas.

# Pruebas

para utilizar postman debes simplemente importar el archivo que se encuentra dentro de la carpeta postman y correr la colleccion, esto ejecutara las pruebas que viene dentro de cada request, si todo ha salido bien todas deberian estar en verde.

**Importante:** al ser un producto dependiente de un tercero existe un riesgo de que se produscan errores causados por algun cambio en las terceras dependencias, para ello refierete a los test y que deberian realizar para que comienzes a debugear cual podria ser el posible error.

# Swagger UI

el proyecto cuenta con [Swagger-UI](http://localhost:8080/api/bff/mobile-team/swagger-ui/index.html), ademas contiene una carpeta con un [archivo json](https://github.com/zcamles/java-recruiting-hsa/blob/master/postman/concrete.postman_collection.json) listo para cargar en [postman](https://www.postman.com/) y ejecutar las pruebas de postman.

# Docker 

Para utilizar la imagen de docker recomendamos utilizar el archivo de docker local, este funciona en dos etapas, la primera se encargara de realizar las pruebas y luego construir el proyecto, finalmente generara la etapa en la cual se ejecutara nuestro servicio.

para ello debes tener instalado docker en tu equipo
- [docker-windows](https://docs.docker.com/desktop/install/windows-install/)
- [docker-linux](https://docs.docker.com/desktop/install/mac-install/)
- [docker-mac](https://docs.docker.com/desktop/install/linux-install/)

si ya cumples con lo anterior, a continuacion esta la lista de comandos que debes utilizar:

**Construir la imagen**

para construir la imagen en base a nuestro archivo recomendado debes usar el siguiente comando:
- `docker build --rm -t concrete-image --progress plain --file docker/local/Dockerfile.local .`

**Ejecutar la imagen**

una vez construida la imagen, debemos ejecutarla, para ello usaremos el siguiente comando
- `docker run -it --rm -p 8080:8080 concrete-image`


ya realizados los pasos anteriores podras visualizar en tu consola los logs del aplicativo funcionando.

si quieres tomar control de la imagen generada puedes sobrescribir la entrada, de la siguiente forma:
- `docker run -it --rm -p 8080:8080 --entrypoint "/bin/sh" concrete-image`

**RECOMENDACION: utilizar docker-compose**

# Docker Compose
Nuestra recomendacion es utilizar docker-compose de esta forma se levanta junto al servicio todas sus dependencias externas, como por ejemplo base de datos entre otras.

Para ello necesitaremos hacer uso de dos comandos:
- `docker-compose build --progress plain --no-cache`
- `docker-compose up`

con el siguiente comando puedes eliminar lo generado con docker-compose:
- `docker-compose down`