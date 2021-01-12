package guru.springframework.mrhpetclcinic.exception.handling;

public class ExceptionReason extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ExceptionReason(String msg) {
    super(msg);
  }
}