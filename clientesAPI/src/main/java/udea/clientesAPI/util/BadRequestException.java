package udea.clientesAPI.util;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 * <p>
 * Clase para crear una excepcion en el caso de que ocurra un error 400.
 */
public class BadRequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private String message;

  public BadRequestException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
