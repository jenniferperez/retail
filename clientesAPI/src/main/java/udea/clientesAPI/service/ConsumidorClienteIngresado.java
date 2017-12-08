package udea.clientesAPI.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.clientesAPI.modelo.Cliente;

/**
 * Created by pabliny193@gmail.com on 05/12/2017.
 */
@Service
public class ConsumidorClienteIngresado {

  public static final String COLA_CONSUMIDOR = "udea.crm.clienteingresado";

  @Autowired
  private PublicadorClienteCreado publicador;

  @RabbitListener(queues = COLA_CONSUMIDOR)
  public void recibirMensaje(final Cliente cliente) {

    System.out.println("Mensaje recibido: " + cliente.toString());

    publicador.publicarMensajeAsnc(cliente);
  }
}
