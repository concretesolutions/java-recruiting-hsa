# bff-mobile

 API Rest realizada con la herramienta Spring Boot
 
 Para iniciar la aplicación.
 
 ```
 gradle bootRun
 ```
 
 Para contruir un ejecutable.
 
 ```
 gradle build
 ```
 
 Para construir una imagen Docker
 
 ```
docker build -t bff-mobile-0.0.1.jar .
 ```
 
 Para levantar contenedor de imagen Docker creada
 
 ```
docker run -p 9090:8081 bff-mobile-0.0.1.jar
 ```
 
 