<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

---
# Solución

###Desarrollado con
    - Java 8
    - Springboot
    - Lombok
    - Gradle
    - Junit
    - Swagger
    - Jmeter

###Consideraciones
    - Para el tema del API de cupones que aveces se demora en responder y no esta especificado la frecuencia en la
      que estos datos son actualizados genere una llave parametrizada en el application.yml api.coupons.cache.maxMinutes
      en la que se deben especificar en minutos cuanto sera la validez de los datos guardados en cache antes de consultar
      el api nuevamente.
      
    - Cree un plan de pruebas de carga con la herramienta Jmeter el cual realiza prueba de todos los endpoints del servicio.

### Levantar servicio
#### Levantar servicio vía jar compilado:
    Debes abrir una terminal/cmd en el root del proyecto y ejecutar los siguientes comandos:
        
        Para compilar el proyecto:
        > gradlew build
        
        Moverse a la carpeta de build/libs donde se encuentra el .jar compilado
        > cd build/libs
        
        Ejecutar jar compilado
        > java -jar desafio-0.0.1-SNAPSHOT.jar

#### Levantar servicio vía docker:
    Debes abrir una terminal/cmd en el root del proyecto y ejecutar los siguientes comandos:
        
        Para compilar el proyecto:
        > gradlew build
        
        Generar imagen docker con el nombre "img_docker_desafio_accenture"
        > docker build -t img_docker_desafio_accenture .
        
        Desplegar imagen antes creada en un nuevo contenedor docker con el nombre container_desafio_accenture       
        > docker run -p 8080:8080 --name container_desafio_accenture img_docker_desafio_accenture


En ambos casos se desplegara el servicio escuchando en el puerto 8080 y se expondran los siguientes endpoints:

    Method: GET  |  Descripción: Obtener todas las categorias
        > curl -X GET "http://localhost:8080/categories" -H "accept: application/json"
        
    Method: GET  |  Descripción: Obtener las categorias top ordenas de la mejor a la peor valorada
        > curl -X GET "http://localhost:8080/categories/top" -H "accept: application/json"
            
    Method: GET  |  Descripción: Obtener las categorias que no estan dentro del top
        > curl -X GET "http://localhost:8080/categories/no-top" -H "accept: application/json"
        
    Method: GET  |  Descripción: Obtener los cupones, este endpoint recibe un paramtero que permite 
                                 filtrar solo los no expirados o mostrar todos
        > curl -X GET "http://localhost:8080/coupons?onlyNotExpired=true" -H "accept: application/json"

Para temas de documentación del servicio mediante swagger se disponibiliza los siguientes endpoints:
    
    Descripción: Ver documentación de API mediante Swagger UI
            http://localhost:8080/swagger-ui.html
            
    Descripción: Obtener endpoints codificados en JSON para poder importar a herramientas como postman
           http://localhost:8080/v2/api-docs
         