<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Manual de Instalación y ejecución

El siguiente manual corresponde al desarrollo realizado para la postulación a Accenture, Por Felipe Villarroel Olivares

## El Desafio

## Stack/Pool de Tecnologías
En funcion de lo solicitado para la realización del desafio es que las tecnologias utilizadas son:
- Java 8
- Framework Web: Spring Boot
- API Client: Feign.
- Gradle como sistema de compilación.
- libreria y framework de pruebas: JUnit.
- Ademas el proyecto fue ambientado en IntelliJ IDEA 2020.2.3 para su desarrollo.

### Para Instalar el Proyecto

Debe tener instalado IntelliJ IDEA 2020.2.3 y el JDK 1.8
Debe tener instalado algun cliente API (En mi caso utilice ADvanced Rest Client)
Se debe clonar desde el siguiente enlace:

## Consideraciones en el Desarrollo

### Categorias
Categorias corresponde a un modelo complejo, por lo que  para permitir flexibilidad en los datos que se ingresan a través de API es que "Category" contiene una lista de si misma y todos los campos correspondientes a las subcategorias, lo que nos permite tener cuantas subcategorias se deseen, y simplifica el desarrollo en el caso de que se desee añadir mas información a la integración.

Ademas Considerando el punto de que no son necesarias todas las imagenes del modelo de subcategorías, es que se agregó un campo extra al output de Categorias llamado "imagen", de manera que este nuevo campo contiene la imagen mas pequeña posible de todas las ingresadas en una sub-categoria.

### Cupones
Cupones es mas inestable, por lo que una configuración de TIMEOUT o de prueba de la conexión (ping) por integración podria ser una metodologia Optima para la resolución de este punto, en funcion de obtener el problema en la capa presente. Por otra parte una opción es utilizar la configuración de Mock que permite realizar solicitudes de manera segura al enlace de integración.

## Para Reproducir el proyecto
Puede abrir el proyecto a través de Spring Boot ejecutando el "ServicioApiApplicationTests"(Esto se debe configurar luego de armar el proyecto con Gradle para poder ejecutar) y luego ya puede dirigirse a los siguientes enlaces a traves de algun Cliente de solicitudes API (puede ser Advanced Rest Client o el que prefiera que contenga método GET)
Debe configurar la solicitud con un el Content-Type: application/json, y finalmente puede ejecutar uno de los siguientes enlaces:
### ENDPOINT
- **Top 5** categorias: http://localhost:8080/top5
- Categorias **restantes**: http://localhost:8080/lastlist
- Cupones que no han expirado: http://localhost:8080/nonexpired
