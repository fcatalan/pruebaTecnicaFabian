<!-- GETTING STARTED -->
## Getting Started

API Back, desarrollado en spring boot 3.1.2, con una arquitectura limpia basada en DDD

1. Clonar repositorio
2. Instalar Java 17
3. Crear la Base de datos en postgreSql y darle un nombre, para este caso se creo como pruebaTecnica
4. Abrir un script de SQL y ejecutar la siguiente sentencia o al iniciar la solución creara la tabla correspondiente

```SQL
  CREATE TABLE public.task
  (
      id int primary key generated always as identity,
      description        varchar(1000) NOT NULL,
      created_at  timestamp NOT NULL,
      is_actived boolean not null
  );

 ```  
6. Modificar el archivo application.properties para agregar la configuración de la base de datos, ejemplo:
```SQL
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.datasource.url=jdbc:postgresql://localhost/pruebaTecnica
    spring.datasource.username=postgres
    spring.datasource.password=
 ```
7. Puede ejecutar el proyecto para probar de las siguientes maneras
   1. Abrir el proyecto con un IDE como IntelliJ IDEA, eclipse, VS Code, etc y ejecutarlo desde ahí
   2. Abrir una terminal, abrir la carpeta raíz del proyecto y ejecutar el comando de maven: `mvn spring-boot:run`
   3. Crear una imagen docker
8. Una vez ejecutado el proyecto abrir el Swagger con su documentación de la siguiente ruta: `http://localhost:8080/swagger-ui/index.html`