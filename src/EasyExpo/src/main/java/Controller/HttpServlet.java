package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> HttpServlet e' la Servlet di avvio </p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet(name = "HttpServlet", urlPatterns = "", loadOnStartup = 1)
public class HttpServlet extends javax.servlet.http.HttpServlet {

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
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(request, response);
  }
}