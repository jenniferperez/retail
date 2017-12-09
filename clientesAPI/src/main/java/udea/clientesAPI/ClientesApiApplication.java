package udea.clientesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class ClientesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApiApplication.class, args);
	}
}
