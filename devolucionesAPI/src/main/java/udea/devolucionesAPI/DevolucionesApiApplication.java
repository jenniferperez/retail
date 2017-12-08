package udea.devolucionesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DevolucionesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevolucionesApiApplication.class, args);
	}
}
