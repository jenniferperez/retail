package udea.clientesAPI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import udea.clientesAPI.util.BadRequestException;
import udea.clientesAPI.util.ErrorMessage;

/**
 * Created by pabliny193@gmail.com on 08/12/2017.
 * <p>
 * Clase encargada de manejar las excepciones que ocurran dentro del microservicio.
 */
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public final ResponseEntity<ErrorMessage> throwBadRequestException(BadRequestException e) {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
    errorMessage.setErrorDescription(e.getMessage());
    errorMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
  }
}
