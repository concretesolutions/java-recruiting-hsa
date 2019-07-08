# Docker
## Requirements

 - Docker
 - Docker-Compose
 - Jenkins & Tomcat requires, at least, 2Gb to work properly.

## Instructions
Una vez descargado el proyecto, ir a la raíz del proyecto y seguir las siguientes instrucciones (Linux) / Once donwloaded, go to the root folder of the project and input the following (Linux).

    cd docker
    chmod +x docker-challenge-install.sh
    ./docker-challenge-install.sh

Una vez instalado, los contenedores se verán de la siguiente forma / Once installed, the containers will be like this:

![Docker Status](https://lh3.googleusercontent.com/5Ysi6k3XdENzsYNRoMRtv4Se_HkW3gEr7zGHpj7RAJe2ThAMGZKeWYDnnct3aE3M-b587SbD2ig_=s1000 "Docker Status")

En el navegador, abre la url http://<YOUR_IP>:82 y accede con las credenciales / Open http://<YOUR_IP>:82 and use the credentials:

    admin:admin

Tomcat estará disponible en el puerto 8080 / Tomcat will be available in the port 8080.

## Screens

### Tasks
Press in the task watch to run the Job.
![Available Tasks](https://lh3.googleusercontent.com/0MZmpfxf3fAmg3ixnkZkGbx5WSSpoRkIoQK6zQ1xbnpNVaAAYcbkyweIMDRayj9C6YRkQzb5M4O2=s1000 "Available Tasks")

### api_compile
Escoge la rama a compilar. Por defecto, el campo está fijado en ***master***, pero se puede modificar. El proyecto se encuentra en la rama ***challenge***. / Choose the **branch** to compile. As default, the field is set at ***master***. The project is mounted in the ***challenge*** branch.
![enter image description here](https://lh3.googleusercontent.com/yWFh-MLrRDow6LPk3bKJBNVA20wvQU1XrWZLb6uQKjIleaNEH7-w1TPK5nP_bN95Mlk8mAEIUNkZ=s800 "Choose the Branch to Compile")

![Run Status](https://lh3.googleusercontent.com/xUKxe98hzGns7KELr_LslcA6MZlzKQuCWhbOcUjrZ4zrIcqAZa6L1zWZfX4TQIAZwCRhI9rLXtzw=s1000 "Run Status")
![compile_api General Display](https://lh3.googleusercontent.com/3trHpriAMViCuir-qhU1MG6ub6-BG8rKHG5CPenMaVM-phN1G06DeaDLpP_vVoRsSU9IMWJicH0R=s1000 "compile_api General Display")
![Compilation Results](https://lh3.googleusercontent.com/iZwrXkOF7KBIKuT_xLgoLCiBUyjZ2OQBrCHZDiPagqFQ4N6XWyF37KCVqMu18fHR5j7gi5dO0Fve=s1000 "Compilation Results")

### deploy_api_tomcat
Esta tarea solo deployea el resultado del compilado en el servidor local (Docker) de Tomcat. This task only deploys to local (Docker) Tomcat Server.
![Compilation Results](https://lh3.googleusercontent.com/gOrIEMzrUj1i9pPSA6sHT-J_twjoXhbytSfb_5ETeQMZKsNYo2XovK51Sbsypad_bA-a7jKaqQol=s1000 "Compilation Results")