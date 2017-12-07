package udea.ventasAPI.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import udea.ventasAPI.modelo.Venta;

import java.util.concurrent.CompletableFuture;

/**
 * Created by pabliny193@gmail.com on 06/12/2017.
 */
@Service
@PropertySource(value="classpath:application.properties")
@ConfigurationProperties(prefix = "rabbit.exchange")
public class Publicador {

  private String nombreExchange;
  private String routingKey;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public Publicador(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publicarMensajeAsnc(Venta venta){
    CompletableFuture.runAsync(()-> rabbitTemplate.convertAndSend(getNombreExchange(), getRoutingKey(), venta));
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
