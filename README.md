Ejecutar APP con Docker
=======================
1) Compilar app, ejecutar:

		$ ./gradlew.bat build
		
2) Crear imagen local Docker:

		$ docker build -t accenture-challenge-app .
		
3) Validar existencia de la imagen Docker con el comando:

		$ docker images -a		

4) Ejecutar imagen local:

		$ docker run -d -p 8080:8080 accenture-challenge-app

5) Revisar la documentación de la API ejecutando la siguiente URL en el navegador:

		http://localhost:8080/swagger-ui.html
