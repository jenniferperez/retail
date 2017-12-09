package udea.monolito.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Objects;

public class Devolucion extends ResourceSupport {

  @JsonProperty("idDevolucion")
  private String idDevolucion;
  @JsonProperty("idCliente")
  private String idCliente;
  @JsonProperty("tipo")
  private String tipo;
  @JsonProperty("detalle")
  private String detalle;

  @ApiModelProperty(example = "123456789", required = true)
  public String getIdDevolucion() {
    return idDevolucion;
  }

  public void setIdDevolucion(String id) {
    this.idDevolucion = id;
  }

  @ApiModelProperty(example = "123456789", required = true)
  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  @ApiModelProperty(example = "Defectuosa", required = true)
  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  @ApiModelProperty(example = "Devolver moto BMW 1200 GS", required = true)
  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Devolucion devolucion = (Devolucion) obj;
    return Objects.equals(this.idDevolucion, devolucion.idDevolucion) && Objects.equals(this.idCliente, devolucion.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idDevolucion, idCliente);
  }

}
