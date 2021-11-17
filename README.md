#Descripcion
Implementa metodos Get categoriasTop5, categoriasNoTop5, cuponesVigentes
Respuesta de Api externa guardada en cache (configurable en properties)


#Stack 
Aplicación Spring Boot

Maven 3.6.3
java 8
Junit 5
Swagger 2
Mockito
caffeine cache


#Compilacion

- Compilar con maven con comando : mvn install
- ejecutar: java -jar target/mobile-api-1.0.jar


- Importar imagen docker :docker save dockermobileapi > mobile-api.tar
- ejecutar imagen docker :docker run -it -p 8080:8080 dockermobileapi

#Documentación
http://localhost:8080/swagger-ui.html

#Endpoint GET implementados
http://localhost:8080/mobile-api/categoriasTop5
http://localhost:8080/mobile-api/categoriasNoTop5
http://localhost:8080/mobile-api/cuponesVigentes