# Java Concrete Challenge Proposal
Este proyecto consiste en la propuesta realizada para el reclutamiento de Backend. La implementación se encuentra en el Branch **challenge**. Existe una rama llamada **challenge-jenkins-flutter**, el cual es un intento de levantar un ambiente Jenkins con Flutter, pero debido a que se encontró que se requiere de 4GB para la instalación, es que se dejó de lado.

# Scenario Analysis
El primer análisis tiene que ver con el espectro de clientes que desea abarcar la aplicación. Por lo que se indica, el cliente requiere una aplicación dirigida a dispositivos de **bajo rendimiento** hasta dispositivos con **gran poder de procesamiento**. Según la documentación entregada por  [Google](https://developer.android.com/about/dashboards) recientemente, aprox. el 99% de los equipos con Android utilizan la versión de JellyBean (API 16) o superiores. Y según la documentación, ([Flutter](https://flutter.io/faq/#what-devices-and-os-versions-does-flutter-run-on) tiene compatibilidad desde esa versión en adelante.
El segundo punto a analizar, tiene que ver con el backend propuesto por el cliente. Si bien cuenta con todo lo necesario para operar con la herramienta, tiene las siguientes desventajas:

- El backend depende de tecnologías legadas, las cuales pueden ser inestables. Esto se puede apreciar con la API de Coupons, la cual tiene un tiempo de respuesta por sobre los 5 segundos (~10 seg). Según [un estudio](https://www.nngroup.com/articles/response-times-3-important-limits/), los tiempos de respuesta de navegación deberían estar por el segundo para que el usuario no pierda el interés.

![Tiempo de respuesta de Coupons](https://lh3.googleusercontent.com/L8qBuy3xLSy3BbNVjphnGnqQXx1-FvDza4PpEvPZZHPbrCQtlZynpIrtKYI_TLcMWXpTT5s8tsj1=s800 "Tiempo de respuesta de Coupons")

- La estructura de algunos de los backends se encuentra con un modelo complejo de manejar. En este caso, el modelo de Categories se encuentra con 4 niveles de Subcategories, cada cual cuenta con atributos muy similares entre si, pero con algunas de ellas diferentes.

![Atributos diferenciadores para cada categoría](https://lh3.googleusercontent.com/tz81ljD3lgjJ3stG8kvk9jW-XIUm1vgswH4sV4oTFX3bCm1bZyEracdY9X4ai-t-D60KkL-QX9Oi=s800 "Atributos diferenciadores para cada categoría")

# Proposal

Tomando en cuenta el análisis realizado, la propuesta es trabajar de la siguiente forma: 

## Application & Patterns

Basado en el análisis, la mejor opción es abordar la solicitud de los requerimientos mediante ***Caching***. Sin embargo, esto puede causar problemas de memoria si se implementa para cada llamado. Debido a lo anterior, es que se abordó el respaldo mediante ***Memoización***. Este método se abordo tanto para los resultado entregados por *Coupons* como también para *Categories*.

## Model

El modelo propuesto tendrá algunas mejoras con respecto a las Categories. Se implementarán todos los atributos, incluído las que sean diferentes para los demás, y para desplegar la data se revisará previamente si tiene data o no. En resumen, el proyecto quedará de la siguiente forma:

![Server Model](https://lh3.googleusercontent.com/xAe1dyla8MyW1oKDJs8rkYIQnNh8W4EJlEflYoacrOFHKQ1Vb9szaPs3iOfYwrGCpUt5GkMRJUmf=s800 "Server Model")

## UI

Para el Servidor API, se encuentra una interfaz desarrollada en Swagger para la documentación. Para el mobile, se generó una pantalla de carga inicial y una pantalla principal con los elementos solicitados.

## Tools

- Flutter y Android Studio (última versión) para Mobile
	> Tomando en cuenta los equipos de bajo rendimiento, se ocupó un emulador con la versión de **Jelly Bean (API 16)** para efectos de testing.
- Java 8 con Spring Boot y Gradle para Servidor de API. Documentación con Swagger.
	> Se desarrollaron pruebas unitarias en JUnit.
- Docker, Docker-Compose, Jenkins y Tomcat
	> Docker se ocupa para levantar los ambientes de desarrollo. Jenkins se encuentra configurado para automatizar los procesos de compilación, pruebas unitarias y levantamiento del servidor de pruebas. Para ello, se creó un Dockerfile que ajusta Jenkins a lo necesario y un Docker-Compose que levanta Tomcat y Jenkins.

# Installation Rules

Dentro de cada proyecto se encuentran las reglas para levantar el ambiente.

1) [Server API (Desarrollo)](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/java/challenge/)
2) [Mobile (Desarrollo)](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/flutter/challenge)
3) [Docker](https://github.com/pperez-accenture/java-recruiting-hsa/tree/challenge/docker)

# Special

Para efectos de pruebas, se encuentra levantado un ambiente con Jenkins y Tomcat para que puedan revisar y probar el Servidor API sin necesidad de levantar un ambiente de desarrollo. Este ambiente es temporal, y puede no estar disponible al momento de leer esta documentación. Las credenciales se encuentran en el siguiente enlace (Requiere cuenta de Organización): [Credentials](https://myoffice.accenture.com/:w:/g/personal/p_perez_bustos_accenture_com/ERSCKifF2IRCn622gsSo0D8BQMuYZLiNkrl8D4CPSnZI2A?e=3lr4Vp).