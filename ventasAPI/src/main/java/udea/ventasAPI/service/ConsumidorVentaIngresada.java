package udea.ventasAPI.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.ventasAPI.modelo.Venta;

/**
 * Created by pabliny193@gmail.com on 06/12/2017.
 */
@Service
public class ConsumidorVentaIngresada {

  public static final String COLA_CONSUMIDOR = "udea.retail.ventaingresada";

  private String colaPublicador;
  private String routingKey;

  @Autowired
  private PublicadorVentaCreada publicador;

  @RabbitListener(queues = COLA_CONSUMIDOR)
  public void recibirMensaje(final Venta venta) {

    System.out.println("Mensaje recibido: " + venta.toString());

    publicador.publicarMensajeAsnc(venta);
  }
}
