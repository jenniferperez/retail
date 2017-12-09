package udea.monolito.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import udea.monolito.modelo.Cliente;
import udea.monolito.modelo.Devolucion;
import udea.monolito.modelo.Venta;

@Controller
public class MonolitoApiController implements MonolitoApi {

  @Override
  public ResponseEntity<Void> ingresarVenta(Venta venta) {
    return null;
  }

  @Override
  public ResponseEntity<Void> ingresarCliente(Cliente cliente) {
    return null;
  }

  @Override
  public ResponseEntity<Void> ingresarDevolucion(Devolucion devolucion) {
    return null;
  }
}
