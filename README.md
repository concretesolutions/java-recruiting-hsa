# Desafio Java Concrete

Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**.

# API

Para consultar los servicios REST disponible: 
http://127.0.0.1:8094/swagger-ui.html#/

# Arquitectura del proyecto

El proyecto esta hecho con SpringBoot y Gradle.

# Puntos que se consideraron
Cómo la api de cupones es inestable, decidí utilizar cache del SpringBoot. Nos permiten almacenar en memoria datos devueltos por un método concreto estableciendo un limite de tiempo y de datos.

Cómo el modelo de categoria es complejo, decidi brindar mas servicios para que los usuarios mobile puedan hacer consultas
mas especificas sin tener que navegar con un modelo de datos muy extenso: Por ejemeplo:

Si quiero solo la subcategoria de nivel 4, pero tengo todos los identificadores de los padres. El servicio retorna solo el modelo solicitado de la subcategoria.

