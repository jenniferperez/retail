package udea.monolito.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Cliente/Servidor UdeA API")
      .description("API que se expone a las aplicaciones Cliente/Servidor las cuales envían las transacciones para creación de ventas, clientes y devoluciones.")
      .version("1.0.0")
      .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
                .apis(RequestHandlerSelectors.basePackage("udea.monolito.api"))
                .build()
            .apiInfo(apiInfo());
  }

}
