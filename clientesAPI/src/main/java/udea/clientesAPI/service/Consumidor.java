package udea.clientesAPI.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import udea.clientesAPI.modelo.Cliente;

/**
 * Created by pabliny193@gmail.com on 05/12/2017.
 */
@Service
@PropertySource(value="classpath:application.properties")
@ConfigurationProperties(prefix = "rabbit.queue")
public class Consumidor{

  public static final String QUEUE_CONSUMIDOR = "udea.crm.nuevocliente";

  private String colaPublicador;
  private String routingKey;

  @Autowired
  private Publicador publicador;

  @RabbitListener(queues = QUEUE_CONSUMIDOR)
  public void receiveMessage(final Cliente cliente) {

    System.out.println("Received message: " + cliente.toString());

    publicador.publicarMensajeAsnc(getColaPublicador(), getRoutingKey(), cliente);
  }

  public String getColaPublicador() {
    return colaPublicador;
  }

  public void setColaPublicador(String colaPublicador) {
    this.colaPublicador = colaPublicador;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public void setRoutingKey(String routingKey) {
    this.routingKey = routingKey;
  }
}
