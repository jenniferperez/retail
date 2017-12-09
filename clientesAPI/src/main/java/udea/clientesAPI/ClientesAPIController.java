package udea.clientesAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import udea.clientesAPI.modelo.Cliente;
import udea.clientesAPI.service.ConsumidorClienteIngresado;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 */
@RestController
public class ClientesAPIController {

  @Autowired
  private ConsumidorClienteIngresado consumidor;

  @ResponseBody
  @RequestMapping(method = RequestMethod.GET, value = "/cliente/consulta")
  public Cliente crearCliente(@RequestParam String idCliente) {

    return consumidor.getCliente(idCliente);
  }
}
