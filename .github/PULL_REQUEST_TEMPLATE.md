# Información del Canditado
**Nombre**: RENE MENDOZA MUÑOZ

# Checklist del Desafío
Has una verificación final de esta lista para asegurar que no estes olvidando nada :)  
No tiene problemas si necesitas hacer algún arreglo y atualizar este **Pull Request** después de enviarlo.

## Checklist
Coloque una ```x``` en las cajas que aplican.
- [x] El código compila
- [x] Todas las pruebas se ejecutan exitosamente
- [x] Su proyecto está bien documentado (cómo ejecutar, pruebas ...)

## Comentarios
*Coloque aquí cualquier comentário o sugerencia que tenga*

Para ejecutar este proyecto es necesario contar con:

SpringTools Suite*
Librerias Lombok
Java8*
Gradle 6.6.1*

Paso 1:
Descargar las fuentes en tu local:
git clone https://github.com/rmendomi/test.git

luego de clonar las fuentes es necesario compilar la aplicación, para eso, nos dirigimos por CMD a la raiz del proyecto y ejecutamos:

gradlew build

Esto nos creara una carpeta llamada "build", dentro de ésta nos dirigimos a la carpeta "libs" y por CMD ejecutamos:

java -jar concrete-0.0.1-SNAPSHOT.jar

La aplicación se ejecutara y estará exponiendo por la siguiente URL:

http://localhost:8090/accenture/topCategory
http://localhost:8090/accenture/otherCategory
http://localhost:8090/accenture/getCouponsNoExp



VER SERVICIOS SWAGGER:
http://localhost:8090/swagger-ui.html


 Se ha agregado un documento word aparte con extras agregados al proyecto y mas detalle de sus tecnologias.
 https://drive.google.com/file/d/1ZLyTOiPB7FZPZrYbTHop11YfRy8whEa1/view?usp=sharing