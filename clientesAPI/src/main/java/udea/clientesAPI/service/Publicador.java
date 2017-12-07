package udea.clientesAPI.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.clientesAPI.modelo.Cliente;

import java.util.concurrent.CompletableFuture;

/**
 * Created by pabliny193@gmail.com on 05/12/2017.
 */
@Service
public class Publicador {

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public Publicador(final RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void publicarMensajeAsnc(String exchange, String routingK, Cliente cliente){
    CompletableFuture.runAsync(()-> rabbitTemplate.convertAndSend(exchange, routingK, cliente));
  }
}
