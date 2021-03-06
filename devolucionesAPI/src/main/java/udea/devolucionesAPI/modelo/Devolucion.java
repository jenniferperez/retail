package udea.devolucionesAPI.modelo;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 */
public class Devolucion {

  private String idDevolucion;
  private String idCliente;
  private String tipo;
  private String detalle;

  public Devolucion() {
  }

  public Devolucion(String id, String idCliente, String tipo, String detalle) {
    this.idDevolucion = id;
    this.idCliente = idCliente;
    this.tipo = tipo;
    this.detalle = detalle;
  }

  public String getIdDevolucion() {
    return idDevolucion;
  }

  public void setIdDevolucion(String id) {
    this.idDevolucion = id;
  }

  public String getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(String idCliente) {
    this.idCliente = idCliente;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  @Override
  public String toString() {
    return "Devolucion{" +
            "idDevolucion='" + idDevolucion + '\'' +
            ", idCliente='" + idCliente + '\'' +
            ", tipo='" + tipo + '\'' +
            ", detalle='" + detalle + '\'' +
            '}';
  }
}
