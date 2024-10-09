# RECIPE-AND-RATING-MANAGENT
System for recording chefs' recipes and diners' ratings

# LEVANTAR PROYECTO CON DOCKER...
* Requisitos:
  - Docker instalado.
  - Clonar el repositorio, rama main.

* Comandos:
  (Ejecutar los comandos en la raíz del proyecto)
  - docker build -f DockerFile -t springboot-app .
  - docker run -d -p 8080:8080 --name springboot-container springboot-app
 
# LEVANTAR PROYECTO DE FORMA LOCAL
* Requisitos:
  - Intalar Java versión 23
  - Intalar Maven versión 3.9.9
  - Clonar el repositorio, rama main.
  - ingresar al proyecto, en el archivo application.properties comentar las líneas "Remoto con Docker" y descomentar las líneas "Remoto"
 
* Comandos:
  (Ejecutar los comandos en la raíz del proyecto)
  - mvn clean install
  - mvn spring-boot:run

# DESICIONES TÉCNICAS INTERESANTES DURANTE EL DESARROLLO
  - Usar técnologias más actualizadas, Java versión 23 y dependencias.
  - Usar anotaciones para realizar validaciones para los distintos datos.
  - Usar Swagger para mantener la documentación del proyecto Back-end.
  - Usar Docker para levantar el proyecto.
