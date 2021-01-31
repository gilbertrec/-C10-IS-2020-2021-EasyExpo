package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> LogoutServlet e' una Servlet che permette al Cliente e
 * al Fornitore di uscire dal sito</p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().removeAttribute("cliente");
    request.getSession().removeAttribute("fornitore");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(request, response);

  }

}