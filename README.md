# api-mobile

Microservicio consume las apis de cupones y categorias

#### Control de versiones 
| Version | Etapa      | Fecha      |
| ------- | ---------- | ---------- |
| 1.0     | Desarrollo | 02-11-2020 |

### Aspectos Tecnicos

Diseñado con las siguientes tecnologías:

* [Spring Boot] Microservicio REST

### Configuracion de aplicacion

El servicio necesita configuraciones propias de la aplicación. Por lo cual, se definen las siguientes variables de entorno.

##### Configuracion de Ambiente

| Variable                                  | Descripcion                                                                                               | Por Defecto        							|
| ----------------------------------------- | --------------------------------------------------------------------------------------------------------- | --------------------------------------------- |  
| URL_COUPONS                               | 							 																				| https://cs-hsa-api-coupons.herokuapp.com		|
| NAME_COUPONS                         		| 							                                         										| COUPONS										|
| NAME_CATEGORIES                      		| 										                                         							| CATEGORIES          	  						|
| URL_CATEGORY								|																											| https://cs-hsa-api-categories.herokuapp.com 	|

La configuracion se encuentra en el archivo "application.properties"

Compilacion
Ejecutar el siguiente comando:

grandlew clean build
La compilacion se genera en la carpeta "{base_proyect}/build/libs/api-mobile-0.0.1-SNAPSHOT.jar"

Ejecucion del aplicativo
Ejecutar el siguiente comando en la ruta del archivo jar.

java -jar api-mobile-0.0.1-SNAPSHOT.jar
Metodos disponibles
** Para realizar consultas de prueba se recomienda utilizar Postman.

El microservicio posee 3 metodos:

getCarruselCategories -> Path: "/api/mobile/categories/carrusel" -> METHOD: GET
getRemainingCategories -> Path: "/api/mobile/categories/remaining" -> METHOD: GET
getCouponsNotExpired -> Path: "/api/mobile/coupons/not_expired" -> METHOD: GET
** No poseen parametros de entrada

swagger
La documentacion swagger se encuentra en la ruta "${servidor}/swagger-ui.html"