package udea.clientesAPI;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import udea.clientesAPI.modelo.Cliente;
import udea.clientesAPI.service.ConsumidorClienteIngresado;
import udea.clientesAPI.util.ErrorMessage;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 */
@RestController
public class ClientesAPIController {

  @Autowired
  private ConsumidorClienteIngresado consumidor;

  @ApiOperation(value = "Consulta de clientes", notes = "Consulta un cliente apartir de su identificación o id",
          response = Void.class, tags = {"Administradores", "Desarrolladores",})
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "Cliente obtenido con éxito", response = Cliente.class),
          @ApiResponse(code = 400, message = "Cliente ingresado no existe", response = ErrorMessage.class)})
  @RequestMapping(method = RequestMethod.GET, value = "/cliente/consulta")
  @ResponseBody
  public Cliente crearCliente(@RequestParam String idCliente) {

    return consumidor.getCliente(idCliente);
  }
}
