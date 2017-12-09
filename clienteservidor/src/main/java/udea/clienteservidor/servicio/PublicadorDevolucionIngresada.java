package udea.clienteservidor.servicio;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import udea.clienteservidor.modelo.Devolucion;

import java.util.concurrent.CompletableFuture;

@Service
@ConfigurationProperties(prefix = "rabbit.exchange.devoluciones")
public class PublicadorDevolucionIngresada {

  private final RabbitTemplate rabbitTemplate;

  private String exchange;
  private String routingKey;

  @Autowired
  public PublicadorDevolucionIngresada(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public String getRoutingKey() {
    return routingKey;
  }

  public void setRoutingKey(String routingKey) {
    this.routingKey = routingKey;
  }

  public void publicarMensajeAync(Devolucion devolucion) {
    CompletableFuture.runAsync(() -> rabbitTemplate.convertAndSend(getExchange(), getRoutingKey(), devolucion));
  }

}
