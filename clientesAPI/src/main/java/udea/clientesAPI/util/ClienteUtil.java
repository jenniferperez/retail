package udea.clientesAPI.util;

import org.apache.commons.lang.StringUtils;
import udea.clientesAPI.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 *
 * Clase encargada de simular la persistencia de los clientes dentro del MS.
 */
public class ClienteUtil {

  private static List<Cliente> clienteLista = new ArrayList<>();

  public static void setCliente(Cliente cliente) {
    clienteLista.add(cliente);
  }

  public static Cliente getCliente(String idCliente) {
    Cliente clienteARetornar = new Cliente();
    for (Cliente cliente : clienteLista) {
      if (StringUtils.isNotEmpty(idCliente) && cliente.getId().equals(idCliente)) {
        clienteARetornar = cliente;
      }
    }
    return clienteARetornar;
  }
}
