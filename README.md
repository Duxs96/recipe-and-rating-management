# recipe-and-rating-management
System for recording chefs' recipes and diners' ratings

# LEVANTAR PROYECTO CON DOCKER...
* Requisitos:
  - Docker instalado.
  - Clonar el repositorio, rama main.
 

* Comandos:
  (Ejecutar los comandos en la raíz del proyecto)
  - docker build -f DockerFile -t springboot-app .
  - docker run -d -p 8080:8080 --name springboot-container springboot-app

