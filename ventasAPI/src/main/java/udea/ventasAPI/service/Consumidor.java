package udea.ventasAPI.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.ventasAPI.modelo.Venta;

/**
 * Created by pabliny193@gmail.com on 06/12/2017.
 */
@Service
public class Consumidor{

  public static final String QUEUE_CONSUMIDOR = "udea.retail.nuevaventa";

  private String colaPublicador;
  private String routingKey;

  @Autowired
  private Publicador publicador;

  @RabbitListener(queues = QUEUE_CONSUMIDOR)
  public void receiveMessage(final Venta venta) {

    System.out.println("Received message: " + venta.toString());

    publicador.publicarMensajeAsnc(venta);
  }
}
