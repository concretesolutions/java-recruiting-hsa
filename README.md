# ¿Cómo ocupar esta api?
Para poder ejecutar esta api debe realizar los siguientes pasos:

### Pre-Requisitos
- Docker instalado en máquina
- Gradle instalado para compilar y generar Jar

### Paso 1 : Gradle Buid
En primer lugar debes construir el archivo jar utilizando gradle:

`
./gradlew build
`

#### Paso 2 : Crear imagen docker
En segundo lugar ya creado el jar debes crear la imagen docker utilizando el siguiente comando:

`
docker build -t challenge .
`


#### Paso 3 : Crear contenedor y ejecutar
Finalmente para ejecutar el contenedor debes utilizar el siguiente comando:

`
docker run -p 8090:8090 -e "JAVA_OPTS=-Ddebug -Xmx128m" challenge &
`

Ahora ya puedes probar directamente la api en la siguiente dirección:


http://localhost:8090/swagger-ui/



