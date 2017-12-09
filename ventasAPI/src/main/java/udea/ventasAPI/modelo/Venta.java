package udea.ventasAPI.modelo;

/**
 * Created by pabliny193@gmail.com on 06/12/2017.
 */
public class Venta {

  private String idVenta;
  private String idCliente;
  private String detalle;
  private String valor;

  public Venta() {
  }

  public Venta(String id, String idCliente, String detalle, String valor) {
    this.idVenta = id;
    this.idCliente = idCliente;
    this.detalle = detalle;
    this.valor = valor;
  }

  public String getId() {
    return idVenta;
  }

  public void setId(String id) {
    this.idVenta = id;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Venta{" +
            "id='" + idVenta + '\'' +
            ", idCliente='" + idCliente + '\'' +
            ", detalle='" + detalle + '\'' +
            ", valor='" + valor + '\'' +
            '}';
  }
}
