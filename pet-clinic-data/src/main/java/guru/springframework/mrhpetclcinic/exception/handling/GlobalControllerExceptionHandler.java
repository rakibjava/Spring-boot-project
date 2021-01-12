package guru.springframework.mrhpetclcinic.exception.handling;


import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  @ExceptionHandler(ExceptionReason.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorDetails resourceNotFoundException(ExceptionReason ex, WebRequest request) {
    ErrorDetails message = new ErrorDetails(HttpStatus.NOT_FOUND.value(), new Date(),  ex.getMessage(),
            request.getDescription(false));
    
    return message;
  }


  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorDetails globalExceptionHandler(Exception ex, WebRequest request) {
    ErrorDetails message = new ErrorDetails(
        HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(),
            request.getDescription(false));
    
    return message;
  }
}