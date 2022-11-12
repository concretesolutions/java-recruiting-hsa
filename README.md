<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete - Javier Vergara

Api Rest para backend aplicación ecommerce

### Tecnologías utilizadas

- Java 11
- Spring Boot
- Swagger
- Feign
- Lombok
- Docker

### Instrucciones

- Se requiere Java 11+.

- Ingresar a ruta base del proyecto y ejecutar lo siguiente por terminal, en el mismo orden en que aparecen:

```sh

./gradlew clean

./gradlew build

./gradlew bootRun
```
- Una vez ejecutada la instrucción anterior la API ya estará inicializada.

- Se incluye documentación gráfica por medio de Swagger en la ruta:

```
http://localhost:8080/swagger-ecommerce-app.html

```

- Para listar cupones no expirados (fecha de expiración mayor a la actual) realizar llamada GET a endpoint:

```
http://localhost:8080/coupons
```

- Para listar Top 5 categorías según su relevancia realizar llamada GET a endpoint: 

```
http://localhost:8080/categories/top
```

- Para listar las categorías no Top 5 según su relevancia realizar llamada GET a endpoint:

```
http://localhost:8080/categories/notop
```

### Ejecutar test del proyecto

- Ingresar a ruta base del proyecto y ejecutar lo siguiente por terminal

```bash
./gradlew cleanTest test -i
```
Luego revisar el siguiente archivo para ver los resultados :

- java-recruiting-hsa/build/reports/tests/test/index.html

### Instrucciones Docker

 Para construir la imagen Docker
 
 ```
docker build -t "ecommerce_backend" .
 ```
 
 Para levantar contenedor de imagen Docker creada
 
 ```
docker run -p 9090:8080 --name ecommerce_backend ecommerce_backend:latest
 ```

 - Se incluye documentación gráfica por medio de Swagger en la ruta:

```
http://localhost:9090/swagger-ecommerce-app.html

```