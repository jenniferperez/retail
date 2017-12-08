package udea.devolucionesAPI.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import udea.devolucionesAPI.modelo.Devolucion;

import java.util.concurrent.CompletableFuture;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 */
@Service
@PropertySource(value="classpath:application.properties")
@ConfigurationProperties(prefix = "rabbit.exchange")
public class PublicadorDevolucionCreada {

  private String nombreExchange;
  private String routingKey;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public PublicadorDevolucionCreada(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publicarMensajeAsnc(Devolucion devolucion){
    CompletableFuture.runAsync(()-> rabbitTemplate.convertAndSend(getNombreExchange(), getRoutingKey(), devolucion));
  }

  public String getNombreExchange() {
    return nombreExchange;
  }

  public void setNombreExchange(String nombreExchange) {
    this.nombreExchange = nombreExchange;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public void setRoutingKey(String routingKey) {
    this.routingKey = routingKey;
  }
}
