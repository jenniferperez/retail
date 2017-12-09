package udea.monolito.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import udea.monolito.modelo.Cliente;
import udea.monolito.modelo.Devolucion;
import udea.monolito.modelo.Venta;

@Api(value = "Cliente/Servidor",
     description = "API consumida por las aplicaciones Cliente/Servidor, las cuales son las encargadas de enviar las transacciones a Retail")
public interface MonolitoApi {

  @ApiOperation(
    value = "Ingresa una nueva venta",
    notes = "Envía un mensaje con la información de la venta ingresada. El mensaje es enviado al exchange udea.ventaingresada.",
    tags = {"developers"} )
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "venta ingresada"),
    @ApiResponse(code = 400, message = "entrada inválida") })
  @RequestMapping(value = "/monolito/venta/ingresar",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.POST)
  ResponseEntity<Void> ingresarVenta(@ApiParam(value = "Venta a ingresar") @RequestBody Venta venta);

  @ApiOperation(
    value = "Ingresa un nuevo cliente",
    notes = "Envía un mensaje con la información del cliente ingresado. El mensaje es enviado al exchange udea.clienteingresado.",
    tags = {"developers"} )
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "cliente ingresado"),
    @ApiResponse(code = 400, message = "entrada inválida") })
  @RequestMapping(value = "/monolito/cliente/ingresar",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.POST)
  ResponseEntity<Void> ingresarCliente(@ApiParam(value = "Cliente a ingresar") @RequestBody Cliente cliente);

  @ApiOperation(
    value = "Ingresa una nueva devolución",
    notes = "Envía un mensaje con la información de la devolución ingresada. El mensaje es enviado al exchange udea.devolucioningresada.",
    tags = {"developers"} )
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "devolución ingresada"),
    @ApiResponse(code = 400, message = "entrada inválida") })
  @RequestMapping(value = "/monolito/devolucion/ingresar",
    produces = { "application/json" },
    consumes = { "application/json" },
    method = RequestMethod.POST)
  ResponseEntity<Void> ingresarDevolucion(@ApiParam(value = "Devolución a ingresar") @RequestBody Devolucion devolucion);

}
