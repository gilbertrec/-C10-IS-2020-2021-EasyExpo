package Controller;

import javax.servlet.ServletException;

public class MyServletException extends ServletException {
  public MyServletException() {
  }

  public MyServletException(String message) {
    super(message);
  }

}
