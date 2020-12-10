<a href="https://concrete.com.br/"><img src=".github/concrete_symbol.png" width="180px" align="right" /></a>

# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

## Contenido
- [El Desafio](#el-desafio)
    - [Escenario](#escenario)
    - [APIs](#apis)
    - [Features](#features)
    - [Puntos a Considerar](#puntos-a-considerar)
- [¿Qué nos Gustaría Ver?](#qué-nos-gustaría-ver)
    - [Deseables](#deseables)
    - [Stack/Pool de Tecnologías](#stackpool-de-tecnologías)
- [Forma de Entrega](#forma-de-entrega)
- [Importante](#importante)

## El Desafio

### Escenario
Recientemente te has unido a un equipo que esta desarrollando una aplicación mobile para una gran compañía de e-commerce.  
Esta aplicación esta dirigida a dispositivos de **bajo rendimiento** hasta dispositivos con **gran poder de procesamiento**.  
El cliente ya cuenta con un backend establecido que contiene todas las reglas e información de negocio, pero algunos sistemas dependen de **tecnologías legadas** que pueden ser **inestables**.    
**Tu** eres responsable de construir la **API** que integrará con estos servicios y proveerá todas las informaciones que Mobile necesita.  
Para las próximas iteraciones, el equipo va a trabajar en la **Pantalla de Início** y **Valoración de Cupones**, para ello tu debes construir todo(s) los **endpoint(s)** que se requieran para integrar con los servicios y proveer la información para la pantalla.

### APIs
Necesitarás consumir los siguientes servicios:
- **Categorias**: [https://cs-hsa-api-categories.herokuapp.com/docs](https://cs-hsa-api-categories.herokuapp.com/docs)
- **Cupones**: [https://cs-hsa-api-coupons.herokuapp.com/docs](https://cs-hsa-api-coupons.herokuapp.com/docs)

### Features
El equipo Mobile necesita construir una pantalla de inicio que debe mostrar:

- Carrusel con **Top 5** categorias.
- Carrusel con cupones que no han expirado.
- Tabla (Grid) con las categorias **restantes**.
- Mobile **no** necesita de todas las imagenes del modelo de subcategorías, solamente la **imagen más pequeña**. Tu podrías tener que filtrar la respuesta, si tu quieres.

Adicionalmente, se requiere empezar a crear el sistema de valoración de cupones. Para ello Mobile requiere:

- Un endpoint que les permita enviar el cupón seleccionado junto con una valoración del 1 al 5.

### Puntos a Considerar
- La API de Cupones es **inestable** y a veces demora en responder. ¿Qué podemos hacer para que este problema no se replique en otras capas? ¿Habrá algún patrón que nos ayude?
- La API de Categorias responde un modelo complejo de manejar. ¿Qué podríamos hacer para simplificar este modelo y que las integraciones con su aplicación sean más sencillas?
- Negocio nos ha comentado que se espera que la funcionalidad de valoración de cupones sea altamente utilizada, por lo cual se requiere que estas valoraciones sean enviadas a una cola, y que posteriormente sean procesadas y almacenadas en base de datos. Para esto puedes utilizar una cola local y una base de datos en memoria como H2.

## ¿Qué nos Gustaría Ver? 
Eres libre para implementar la solución de la forma que consideres mejor, 
pero debes considerar el escenario, objetivo, implicaciones de performance y stack/pool de tecnología propuesta abajo.
- Nos enfocamos mucho en la **calidad** de nuestros proyectos y nos gustaría ver alguna estrategia aplicada. Puedes usar, por ejemplo, **Pruebas Unitarias**.
- No queremos que la experiencia de usuario se vea afectada por el rendimiento de los servicios;
- **Usted tiene 1 semana para completar el desafio**. Si necesitas mas tiempo, no hay problema, puede hablar con nosotros y veremos que podemos hacer :)
- Documentación de como configurar y ejecutar el proyecto. Puede sobrescribir el **README.md** para eso.

### Deseables
- Podría ser bueno una documentación de API. Sugerencia: [Swagger](https://swagger.io/).
- Ejecutando con [Docker](https://www.docker.com/).

### Stack/Pool de Tecnologías
- **Java 8** o **superiores**.
- Base de Datos **H2**. [Spring Boot + H2](https://www.baeldung.com/spring-boot-h2-database) 
- **JMS**. [Spring Boot + JMS](https://www.baeldung.com/spring-jms)
- Cualquier Framework Web. Sugerencia: [Spring Boot](https://spring.io/projects/spring-boot).
- Cualquier API Client. Sugerencia: [Feign](https://github.com/OpenFeign/feign).
- De preferencia [Gradle](https://gradle.org/) como sistema de compilación.
- Tu eres libre para escoger librerias y frameworks de pruebas que mas te guste. Nuestra sugerencia es: [JUnit](https://junit.org/junit5/), [Mockito](https://site.mockito.org/).

---

## Forma de Entrega
Siga los siguientes pasos para implementar y enviar este desafío:
- Haga un **Fork** a este repositorio. Puedes mirar esta guía para mayores informaciones: [Como hacer fork de un repositorio](https://help.github.com/en/articles/fork-a-repo).
- Implemente el desafío.
- Después de completar el desafío, realice un **Pull Request** a este repositorio, utilizando la interface de **Github**. [Creando un Pull Request](https://help.github.com/en/articles/creating-a-pull-request-from-a-fork).
- Si es posible, deja tu repositorio publico para hacer la revisión de código más sencilla.

## Importante
**No** intente hacer un PUSH directo a ESTE repositorio!

---
