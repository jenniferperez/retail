package udea.clientesAPI.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ErrorMessage {

  private String error;
  private String errorDescription;
  @JsonIgnore
  private HttpStatus httpStatus;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }
  
  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public boolean hasError() {
    return httpStatus != null && !HttpStatus.OK.equals(httpStatus);
  }
}
