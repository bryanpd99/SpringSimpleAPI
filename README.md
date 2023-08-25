# Servicio REST Clientes 
Proyecto sencillo(API REST) hecha con  Springboot
**Tecnologías usadas**
* Java
* Springboot
* PostgreSQL


## Primeros Pasos

```
git clone https://github.com/bryanpd99/SpringSimpleAPI.git
cd music-app
```

### Importa el proyecto en tu IDE (Eclipse)

Update your Project with right click on your Project > Maven > Update Project :

Make sure your java library installed with check it in lists of Maven Dependency

Your also can update your project with terminal : 
```
mvn clean install
```
al descargar tus dependencias...tendrás un resultado en consola: BUILD SUCCESS

### Ejecuta la aplicación Springboot
El proyecto en sí mismo se ejecuta en el servidor embebido de Tomcat ( Listening en elPuerto 8080 por defecto).

Para la persistencia de los datos,el proyecto se vincula a una base de datos PostgreSQL, por lo que se debe comprobar los parámetros de acceso a la base de datos (username,password,puerto,etc...)
**Nota:** Los valores de la conexión a la base se especifican en el `aplication.properties` que consta de los siguientes valores para el actual proyecto
```
spring.jpa.database=POSTGRESQL
spring.sql.init.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create-drop
```
Nótese que la url a la base de datos toma el nombre de la base de datos que se destine a la aplicación.
Las tres  ultimas líneas definen la creación de las relaciones por lo que una vez creadas(Al correr el programa por primera vez, se recomienda comentar las instrucciones para evitar que los datos almacenados se pierdan por el auto drop)
Pon en marcha el proyecto con  Run as Spring boot application en tu  IDE. 



## API Documentación

Según la especificación del documento
El servicio dispone una API para operaciones CRUD de Clientes y su relación con direcciones asociadas al mismo.
A continuación se presentan los endpoints con su método de acceso respectivo:
Endpoint base:api/v1
Endpoint para la manipulacion de datos de entidades:
Cabe destacar que los parametros entre llaves{} o atributo? se pasan en la URL
los body content para pasar los valores de las entidades deben estar en JSON.
_A continuación se muestra un ejemplo del body content en JSON para crear un cliente con una direccion_
```
{
	"tipoIdentificacion":"CI",
	"numId":"0600000000",
	"nombres":"Bryan",
	"apellidos":"Dav",
	"correo":"bryan@correo.com",
	"numeroCelular":"0988888888",
	"direccionCliente":		[
		{
	"provincia":"Chimborazo",
	"ciudad":"Riobamba",
	"direccion":"av X y calle z"
		
		}
	]
}
```
**Nota:** El campo direccionCliente es una lista en el json debido a que el cliente puede tener más de una dirección(Veáse el instructivo en la parte inicial) y el tipo de dato listta será adecuado para la lógica correspondiente
Obtener listado de clientes(GET):
```
*api/v1/clientes
```
Obtener datos de cliente por su numero de identificacion(GET):
```
* api/v1/cliente/{numId}
```
Obtener datos de cliente por su nombre(GET):
```
* api/v1/cliente/nombre?nombre=
```
Editar datos del cliente(PUT):
```
*api/v1/cliente
```
Eliminar entidad cliente dado su numero de identificacion(PUT):
```
*api/v1/cliente/{numId}
```
Ingresar datos de un cliente incluyendo una direccion(Considerada matriz)(POST):
```
* api/v1/cliente
```
Obtener listado de Direcciones asociadas a un cliente(GET):
```
*api/v1/cliente/{numId}/direccion
```
Ingresar nueva direccion asociada a un cliente(POST):
```
*api/v1/cliente/{numId}/direccion
```

## correr los tests

Los test se puede ejecutar automáticamente como  JUnit 5
**Nota:** Verificar que las dependencias se encuentren correctamente incluidas en el proyecto para que los mocks y los test puean correr con normalidad.

## Autor

* @bryanpd99
