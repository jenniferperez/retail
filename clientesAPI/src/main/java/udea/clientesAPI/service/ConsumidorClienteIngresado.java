package udea.clientesAPI.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.clientesAPI.modelo.Cliente;
import udea.clientesAPI.util.BadRequestException;
import udea.clientesAPI.util.ClienteUtil;

import javax.ws.rs.WebApplicationException;

/**
 * Created by pabliny193@gmail.com on 05/12/2017.
 */
@Service
public class ConsumidorClienteIngresado {

  private static final Logger LOGGER = Logger.getLogger(ConsumidorClienteIngresado.class);
  public static final String COLA_CONSUMIDOR = "udea.crm.clienteingresado";

  @Autowired
  private PublicadorClienteCreado publicador;

  private Cliente cliente;

  @RabbitListener(queues = COLA_CONSUMIDOR)
  public void recibirMensaje(final Cliente cliente) {

    LOGGER.info("Cliente recibido: " + cliente.toString());
    ClienteUtil.setCliente(cliente);
    publicador.publicarMensajeAsnc(cliente);
  }

  public Cliente getCliente(String idCliente) throws WebApplicationException {
    Cliente cliente = ClienteUtil.getCliente(idCliente);
    if(cliente == null || cliente.getNombre() == null){
      throw new BadRequestException("Cliente ingresado no existe");
    }
    return cliente;
  }
}
