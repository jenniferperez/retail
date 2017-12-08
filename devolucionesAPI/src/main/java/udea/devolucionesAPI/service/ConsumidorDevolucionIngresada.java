package udea.devolucionesAPI.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.devolucionesAPI.modelo.Devolucion;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 */
@Service
public class ConsumidorDevolucionIngresada {

  public static final String NOMBRE_COLA_CONSUMIDOR = "udea.retail.devolucioningresada";

  private String colaPublicador;
  private String routingKey;

  @Autowired
  private PublicadorDevolucionCreada publicador;

  @RabbitListener(queues = NOMBRE_COLA_CONSUMIDOR)
  public void recibirMensaje(final Devolucion devolucion) {

    System.out.println("Mensaje recibido: " + devolucion.toString());

    publicador.publicarMensajeAsnc(devolucion);
  }
}
