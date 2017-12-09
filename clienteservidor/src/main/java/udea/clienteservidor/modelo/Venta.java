package udea.clienteservidor.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Objects;

public class Venta extends ResourceSupport {

  @JsonProperty("idVenta")
  private String idVenta;
  @JsonProperty("idCliente")
  private String idCliente;
  @JsonProperty("detalle")
  private String detalle;
  @JsonProperty("valor")
  private String valor;

  @ApiModelProperty(example = "123456789", required = true)
  public String getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(String id) {
    this.idVenta = id;
  }

  @ApiModelProperty(example = "123456789", required = true)
  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  @ApiModelProperty(example = "Moto BMW 1200 GS", required = true)
  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  @ApiModelProperty(example = "100.000.000", required = true)
  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Venta venta = (Venta) obj;
    return Objects.equals(this.idVenta, venta.idVenta) && Objects.equals(this.idCliente, venta.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idVenta, idCliente);
  }

}
