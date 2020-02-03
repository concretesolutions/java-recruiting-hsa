# java-concrete-api


### Aspectos Tecnicos

Diseñado con las siguientes tecnologías:

* [Spring Boot] Microservicio REST

### Configuracion de aplicacion

El servicio necesita configuraciones en variables de ambiente, para permitir una correcta comunicacion con las APIs definidas.

##### Configuracion de Ambiente

| Variable | Descripcion | Por Defecto |
| --------------------------------------- | ---------------------------------------------------------------------------------------------------------------- | ------------------ |  
| HYSTRIX_ENABLED | Habilita hystrix en el aplicativo (feign) | false |
| CUPONS_URL | URL donde se encuentra la api de cupones | https://cs-hsa-api-coupons.herokuapp.com |
| CUPONS_NAME | nombre del cliente para api de cupones | COUPONS |
| CATEGORIES_URL | URL donde se encuentra la api de categorias | https://cs-hsa-api-categories.herokuapp.com |
| CATEGORIES_NAME | nombre del cliente para api de categorias | CATEGORIES |
| CLIENT_COUPONS_CONNECT_TIMEOUT | tiempo de espera para realizar la conexion con la api de cupones (milisegundos) | 5000 |
| CLIENT_COUPONS_READ_TIMEOUT | tiempo de espera para obtener los datos desde la api de cupones (milisegundos) | 300000 |

La configuracion se encuentra en el archivo "application.properties"

### Compilacion

Ejecutar el siguiente comando:
- grandlew clean build

La compilacion se genera en la carpeta "{base_proyect}/build/libs/java-concrete-api-1.0.jar"

### Ejecucion del aplicativo

Ejecutar el siguiente comando en la ruta del archivo jar.
- java -jar java-concrete-api-1.0.jar

### Metodos disponibles

** Para realizar consultas de prueba se recomienda utilizar Postman.

El microservicio posee 3 metodos:
- getTopFiveCategories  -> Path: "/backend/api/categories/top5"  -> METHOD: GET
- getValidsCoupons  -> Path: "/backend/api/coupons"  -> METHOD: GET
- getRemainingCategories  -> Path: "/backend/api/categories/remaining"  -> METHOD: GET

** No poseen parametros de entrada