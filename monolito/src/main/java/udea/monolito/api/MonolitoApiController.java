package udea.monolito.api;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import udea.monolito.modelo.Cliente;
import udea.monolito.modelo.Devolucion;
import udea.monolito.modelo.Venta;
import udea.monolito.servicio.PublicadorClienteIngresado;
import udea.monolito.servicio.PublicadorDevolucionIngresada;
import udea.monolito.servicio.PublicadorVentaIngresada;

@Controller
public class MonolitoApiController implements MonolitoApi {

  @Autowired
  private PublicadorVentaIngresada publicadorVentaIngresada;

  @Autowired
  private PublicadorClienteIngresado publicadorClienteIngresado;

  @Autowired
  private PublicadorDevolucionIngresada publicadorDevolucionIngresada;

  @Override
  public ResponseEntity<Void> ingresarVenta(@ApiParam(value = "Venta a ingresar") @RequestBody Venta venta) {

    publicadorVentaIngresada.publicarMensajeAync(venta);

    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> ingresarCliente(@ApiParam(value = "Cliente a ingresar") @RequestBody Cliente cliente) {

    publicadorClienteIngresado.publicarMensajeAync(cliente);

    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> ingresarDevolucion(@ApiParam(value = "Devolución a ingresar") @RequestBody Devolucion devolucion) {

    publicadorDevolucionIngresada.publicarMensajeAync(devolucion);

    return new ResponseEntity<Void>(HttpStatus.OK);
  }

}
