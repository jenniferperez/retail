# retail-udea
¡Bienvenido a Retail App!

Una aplicación que se encarga de registrar ventas y clientes utilizando mensajería para administrar la comunicación entre otras aplicaciones interntas. Este mecanismo de mensajera está desarrollado con RabbitMQ.

Para probar la aplicación, debe clonarse este repositorio inicialmente y ejecutar los siguientes proyectos:
1. clienteservidor: Aplicación que representa el banckend del cliente/servidor del enunciado. Este monolito envía mensajes para la creacin de ventas, clientes y devoluciones a sus respectivos exchanges. En pocas palabras, es un publicador de mensajes.
2. eurekaServer: Aplicación para el registro y descubrimiento de servicios.
3. ventasAPI: Microservicio suscrito a la cola udea.retail.ventaingresada. Esta cola es la que tiene los mensajes enviados por medio del exchange udea.ventaingresada, este exchange es uno de los que reciben los mensajes de parte de la aplicación cliente/servidor.
4. clientesAPI: Microservicio similar al anterior, suscrito a la cola udea.retail.clienteingresado.
5. devolucionesAPI: Microservicio similar a los anteriores, suscrito a la cola udea.retail.devolucioningresada.
6. Finalmente, con POSTMAN o alguna otra herramienta, se pueden ejecutar peticiones a cliente/servidor el cual es el punto de entrada de toda la aplicación. Una vez se ejecute este proyecto, se puede acceder a la documentación Swagger en http://localhost:8080/ para saber cuáles son los parámetros requeridos.

Para agilidad, sólo se implementan los anteriores microservicios ya que éstos también juegan el papel de publicadores. Cuando ellos reciben los mensajes, deben persistir la información y procesarla según su contexto de negocio. Posterior a esto, deben publicar el mensaje con la información procesada por medio de otros exchange que envían los mensajes a las colas que serán leídas por las aplicaciones PROVEEDORES, CRM, CARTERA.

Los microservicios implementados anteriormente, hacen parte de las aplicaciones del enunciado (CRM, CARTERA, PROVEEDORES) ya que en nuestra propuesta de solución, éstos son sistemas compuestos con muchos más microservicios. Nosotros sólo estamos interviniendo los microservicios que necesitamos para el procesamiento y uso de mensajes.

Se obvia la implementación de la aplicación Retail ya que su función es persistir la información que recibe y asociar ventas/devoluciones con clientes.

Se distribuye la carga de consulta de mensajes utilizando las demás colas integradas con los microservicios.

Autores:
- Jennifer Pérez Bedoya
- Juan Pablo Herrera
- Oscar Andrés Úsuga
