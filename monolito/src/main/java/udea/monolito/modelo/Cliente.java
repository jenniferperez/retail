package udea.monolito.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Objects;

public class Cliente extends ResourceSupport {

  @JsonProperty("idCliente")
  private String idCliente;
  @JsonProperty("nombre")
  private String nombre;
  @JsonProperty("telefono")
  private String telefono;

  @ApiModelProperty(example = "123456789", required = true)
  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String id) {
    this.idCliente = id;
  }

  @ApiModelProperty(example = "Rammstein", required = true)
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @ApiModelProperty(example = "3214567789", required = true)
  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Cliente cliente = (Cliente) obj;
    return Objects.equals(this.idCliente, cliente.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente);
  }

}
