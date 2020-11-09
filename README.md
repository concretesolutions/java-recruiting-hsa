

<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete - Matías Gómez Arancibia

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

## Pre-requisitos
Se deben tener ciertas condiciones para que el proyecto funcione.

#### Tener instalado:
- JDK 8.


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
- Correr la aplicación (Cuidado, podría quedar el proceso corriendo por siempre hasta matarlo manualmente).
```bash
./gradlew bootRun
```

### Endpoints para probar la aplicación

Solo como resumen y ayuda, ya que de igual forma de integra Swagger en el proyecto.
- Endpoint para la obtención de cupones no expirados:
```
http-method: GET
endpoint: http://127.0.0.1:8081/coupons/not-expired
```
- Endpoint para la obtención de las top 5 categorías:
```
http-method: GET
endpoint: http://127.0.0.1:8081/categories/top-relevance/5
```

## ¿Cómo ejecutar los test del proyecto?
Para ejecutar los test realizados, en la raíz del proyecto abrir una terminal/consola y ejecutar:
```bash
./gradlew cleanTest test -i
```
Luego de esto, es posible ver los resultados en el archivo:
```
java-recruiting-hsa-master/build/reports/tests/test/index.html
```

## Documentación Swagger

Para acceder a la documentación con Swagger, se debe correr la aplicación y acceder a la url:
```
http://127.0.0.1:8081/swagger-ui.html
```

## Consideraciones
Se han establecido ciertas consideraciones respecto los requerimientos dados.

- Para la establecer un criterio que permita comparar las categorías y saber cual pertenece al **top**, se ha decidido compararlas según el campo `relevance` y, entre mayor es este número, más relevancia tiene y por ende más "top" se considera. Para las categorías que no tienen el campo `relevance` o este no posea un valor, se deja en el final del stack de categorías (baja importancia).
- Para realizar los siguientes requerimientos:
-- Carrusel con **Top 5** categorias.
-- Tabla (Grid) con las categorias  **restantes**.
Se ha decidido utilizar un solo endpoint, ya que son requerimientos complementarios.
- Se ha realizado una solución en donde, al fallar la llamada de servicio final, se vuelve a intentar hacer el llamado del servicio REST.
-- Se han configurado tiempos bajos de timeout para ver su funcionamiento.
- Solo se han desarrollado pruebas unitarias críticas según mi criterio.
- Para solventar la inestabilidad de la API de cupones, se utiliza retryer de feign.
## Pendiente

Han quedado pendiente los fallback para las llamadas a las api finales, ya que mi idea era arrojar una excepción de servicio no disponible, pero hystrix no lo permite.

---
