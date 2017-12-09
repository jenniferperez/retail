package udea.clientesAPI.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-11-04T14:39:56.794Z")

@Configuration
public class SwaggerDocumentationConfig {

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Administración de clientes para CRM")
            .description("Este es un microservicio encargado de consumir mensajes de la cola 'udea.crm.clienteingresado'" +
                    " configurada en Rabbit para luego validarlos y almacenarlos en su respectiva base de datos. Cuando" +
                    " la aplicación está segura que se guardó con éxito, publica este mismo cliente al exchange" +
                    " udea.crm.clientecreado para que la cola a la que se suscribe CRM pueda tomarlo y procesarlo.")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "oscarandresu@gmail.com"))
            .build();
  }

  @Bean
  public Docket customImplementation(){
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("udea.clientesAPI"))
            .build()
            .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
            .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
            .apiInfo(apiInfo());
  }

}
