package udea.clienteservidor.configuracion;


import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbit.configuracion")
public class RabbitConf {

  private String hostname;
  private String username;
  private String password;
  private String virtualHost;
  private long timeout;
  private int heartBeat;

  @Bean
  public ConnectionFactory connectionFactory() {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory(getHostname());
    connectionFactory.setUsername(getUsername());
    connectionFactory.setPassword(getPassword());
    connectionFactory.setVirtualHost(getVirtualHost());
    connectionFactory.setChannelCheckoutTimeout(getTimeout());
    connectionFactory.setRequestedHeartBeat(getHeartBeat());
    return connectionFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate() {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
    rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getVirtualHost() {
    return virtualHost;
  }

  public void setVirtualHost(String virtualHost) {
    this.virtualHost = virtualHost;
  }

  public long getTimeout() {
    return timeout;
  }

  public void setTimeout(long timeout) {
    this.timeout = timeout;
  }

  public int getHeartBeat() {
    return heartBeat;
  }

  public void setHeartBeat(int heartBeat) {
    this.heartBeat = heartBeat;
  }
}
