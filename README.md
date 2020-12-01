

# Instalación 

a) Crear una base de datos en un servidor de mysql (al inicial se crean las tablas correspondientes)
b) Levantar un servicio que entregue los json 

cd  json-datos/
python -m SimpleHTTPServer 8081
#Windows
python -m http.server 8081

c) Iniciar el servicio :

mvn spring-boot:run


d) pruebas

d.1) http://localhost:8080/proyecto/api/top5-categorias.json

d.2) http://localhost:8080/proyecto/api/categorias-restantes.json

d.3) http://localhost:8080/proyecto/api/cupones-vigentes.json


e) Para probar que a pesar que este abajo el servicio de json, se puede bajar el http iniciado en el punto b

