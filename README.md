
# Backend de Conneto

Este es el backend de Conneto, un proyecto desarrollado con **Spring Boot** para gestionar la lógica de negocio y las operaciones de la plataforma. El backend se conecta a una base de datos MySQL para almacenar y gestionar la información.

## Requisitos

Antes de comenzar, asegúrate de tener los siguientes requisitos:

1. **Java 17**: Verifica que tienes Java 17 instalado y configurado en tu máquina. Puedes hacerlo ejecutando el siguiente comando en tu terminal:
 
   java -version
   Asegúrate de que la versión mostrada sea la 17.

2. **MySQL**: Necesitarás tener MySQL instalado y una base de datos creada. Crea una base de datos con el nombre adecuado que se utilizará para la conexión.

3. **Credenciales de la base de datos**: Verifica que tienes las credenciales correctas (usuario, contraseña y nombre de la base de datos) para conectarte a MySQL.

## Instalación

Para comenzar a trabajar con el backend de Conneto, sigue estos pasos:

1. Clona el repositorio en tu máquina local utilizando el siguiente comando:
 
   `git clone `
 
2. Dirígete al directorio del proyecto:
 
   `cd Conneto-backend`
 
3. Verifica las credenciales de la base de datos en el archivo `application.properties`, ubicado en:

   ```bash
   conneto/conneto/src/main/resources/application.properties
     ```

   Aquí deberás verificar que las siguientes configuraciones estén correctas:
   - **usuario**: el nombre de usuario de tu base de datos MySQL.
   - **contraseña**: la contraseña del usuario.
   - **url de la base de datos**: la URL de la base de datos a la que se conectará.

   Un ejemplo de configuración podría ser:

      ```bash
      spring.application.name=connetodb
      spring.datasource.url=jdbc:mysql://localhost:3306/connetodb
      spring.datasource.username=root
      spring.datasource.password=123


5. Dirígete al archivo principal `Application.java`, ubicado en:
   ```bash
     conneto/conneto/src/main/java/com/uvg/conneto/ConnetoApplication.java

6. Una vez que hayas revisado todo, puedes iniciar la aplicación ejecutando el archivo `Application.java` desde tu IDE 
o con alguna extensión (en Visual es recomendable instalar Spring Boot Extension Pack) también se puede escribir el comando:
   ./mvnw spring-boot:run
   (no es recomendable utilizar el comando ya que aveces no funciona correctamente)

La aplicación debería iniciarse en el puerto predeterminado `8080`. Puedes verificar su funcionamiento accediendo a `http://localhost:8080` desde tu navegador.

## Notas

- Asegúrate de tener **Java 17** correctamente instalado y configurado para que el proyecto se ejecute sin problemas.
- Si necesitas configurar otros parámetros de la base de datos o cambiar la URL de conexión, puedes hacerlo directamente en el archivo `application.properties`.
