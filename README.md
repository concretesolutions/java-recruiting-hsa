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

| Variable                                  | Descripcion                           | Por Defecto        							|
| ----------------------------------------- | ------------------------------------- | --------------------------------------------- |  
| URL_COUPONS                               | url de la api cupones		 			| https://cs-hsa-api-coupons.herokuapp.com		|
| NAME_COUPONS                         		| nombre de api cupones		            | COUPONS										|
| URL_CATEGORY								| url de la api categoria				| https://cs-hsa-api-categories.herokuapp.com 	|
																				  
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

| Metodo                  | Path                              | METHOD	|
| ----------------------- |---------------------------------  |-------- |  
| getCarruselCategories   | /api/mobile/categories/carrusel   | GET     |
| getRemainingCategories  | /api/mobile/categories/remaining  | GET     |
| getCouponsNotExpired    | /api/mobile/coupons/not_expired   | GET     |

** No poseen parametros de entrada

swagger
La documentacion swagger se encuentra en la ruta "${servidor}/swagger-ui.html"