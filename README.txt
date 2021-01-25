Requisitos de la aplicacion
1-Java JDK  11   https://docs.aws.amazon.com/es_es/corretto/latest/corretto-11-ug/what-is-corretto-11.html
2-Maven 3.3.9    https://maven.apache.org/index.html
3-PostgreSQL
4-IntelliJ IDE   https://www.jetbrains.com/idea/
5-PostMan        https://www.getpostman.com/

Instrucciones
1-Agregar proyecto a IntelliJ:
Import pom.xml
2-Crear build con maven
Maven project -> northwind -> Lifecycle -> install
3-Ejecutar aplicación
Project -> northwind->src->main->java->northwind->Application.java click derecho Run

Descripcion de carpetas:
northwind
  |
  |
  |--src    (contenido de el proyecto)
  |   |
  |   |--main
  |   |     |--java
  |   |           |
  |   |           |--northwind
  |   |           |     |
  |   |           |     |--config (configuraion para conectar a la base de datos)
  |   |           |     |--model  (Clases para mapear los datos de la base de datos, tablas y columnas)
  |   |           |     |--repository (Clases para acceder a la base de datos)
  |   |           |     |--web (Clases para crear los End Points que se van a exponer en el servicio)
  |   |           |     |--Application.java (Clase principal de la aplicacion)
  |   |           |
  |   |           |--resources
  |   |                 |
  |   |                 |--application.properties (propiedades para realizar la conexión a la base de datos)
  |   |                 |--application.queries.properties (queries para ejecutar a la base de datos)
  |   |
  |   |--test (pruebas unitarias del proyecto, investigar JUnit para saber que son las pruebas unitarias)
  |
  |--pom.xml (definición de biliotecas que ocupará el proyecto)

Se agrega spring-data como alternativa para persistir los datos.
