package udea.clientesAPI.service;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import udea.clientesAPI.modelo.Cliente;

import java.util.concurrent.CompletableFuture;

/**
 * Created by pabliny193@gmail.com on 05/12/2017.
 */
@Service
@PropertySource(value="classpath:application.properties")
@ConfigurationProperties(prefix = "rabbit.exchange")
public class PublicadorClienteCreado {

  private static final Logger LOGGER = Logger.getLogger(PublicadorClienteCreado.class);

  private String nombreExchange;
  private String routingKey;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public PublicadorClienteCreado(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publicarMensajeAsnc(Cliente cliente){
    CompletableFuture.runAsync(()-> rabbitTemplate.convertAndSend(getNombreExchange(), getRoutingKey(), cliente));
    LOGGER.info("Cliente publicado: " + cliente.toString());
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
