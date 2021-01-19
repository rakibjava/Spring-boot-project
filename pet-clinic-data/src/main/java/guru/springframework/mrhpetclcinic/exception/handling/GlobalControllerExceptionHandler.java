package guru.springframework.mrhpetclcinic.exception.handling;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                       HttpHeaders headers,
                                                                       HttpStatus status,
                                                                       WebRequest request) {
    System.out.println(request.getHeaderNames());
    ErrorDetails message = new ErrorDetails(
            HttpStatus.METHOD_NOT_ALLOWED.value(),
            new Date(),
            ex.getLocalizedMessage() +"Supported methods are:"+ex.getSupportedHttpMethods(),
            request.getDescription(false));
    return new ResponseEntity(message,
            new HttpHeaders(),
            HttpStatus.METHOD_NOT_ALLOWED);
  }
  @ExceptionHandler(ResponseStatusException.class)
  public ErrorDetails globalExceptionHandler(Exception ex, WebRequest request, HttpServletResponse response, HttpServletRequest req) {

    ResponseStatusException responseStatusException = (ResponseStatusException) ex;
    System.out.println(responseStatusException.getResponseHeaders());
    response.setStatus(responseStatusException.getStatus().value());
    System.out.println(req.getRequestURL() +" ==" +req.getRequestURI());
    System.out.println(((ServletWebRequest)request).getRequest().getRequestURI());
    System.out.println(((ServletWebRequest)request).getRequest().getRequestURL().toString());
    ErrorDetails message = new ErrorDetails(
            responseStatusException.getStatus().value(),
            new Date(),
            responseStatusException.getReason(),
            request.getDescription(false));
    
    return message;
  }


  @ExceptionHandler(ExceptionReason.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorDetails resourceNotFoundException(ExceptionReason ex, WebRequest request) {
    ErrorDetails message = new ErrorDetails(HttpStatus.NOT_FOUND.value(), new Date(),  ex.getMessage(),
            request.getDescription(false));

    return message;
  }

  /*@Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                HttpHeaders headers,
                                                                HttpStatus status,
                                                                WebRequest request) {
    List<String> details = new ArrayList<>();
    details.add(ex.getMethod());
    details.add(" method is not supported for this request. Supported methods are "+ex.getSupportedHttpMethods());
    //ex.getSupportedHttpMethods().forEach(t -> details.add(t + " "));

    ErrorResponse error = new ErrorResponse("Validation Failed", details);
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }*/

  /*@Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                       HttpHeaders headers,
                                                                       HttpStatus status,
                                                                       WebRequest request) {
    StringBuilder builder = new StringBuilder();
    builder.append(ex.getMethod());
    builder.append(
            " method is not supported for this request. Supported methods are ");
    ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

    ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED,ex.getLocalizedMessage(), builder.toString());
    return new ResponseEntity(apiError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
  }*/




}