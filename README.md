Acenture - mfuenzalida - java-recruiting-hsa 
==============================

[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://git.thebarrens.nu/wolvie/short/blob/master/LICENSE)

Example microservice for accenture appliment

Init:
---------

 - unix
 - java 8
 - gradle 6.3
 - docker

Deploy:
---------

1 - compile

```shell
gradle build
```

2 - build

```shell
docker build --build-arg JAR_FILE=build/libs/*.jar -t accenture/mfuenzalida .
```

3 - run

```shell
docker run -p 8080:8080 accenture/mfuenzalida
```

4 - swagger in 
http://localhost:8080/swagger-ui