package Controller;

import javax.servlet.ServletException;

/**
 * Classe dell'eccezione MyServletException.
 */
public class MyServletException extends ServletException {

  public MyServletException() {
  }

  /**
   * Metodo che prende il messaggio dell'eccezione.
   *
   * @param message - oggetto di tipo String
   */
  public MyServletException(String message) {
    super(message);
  }

}