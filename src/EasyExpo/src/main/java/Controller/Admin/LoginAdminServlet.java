package Controller.Admin;

import Controller.HttpServlet;
import Model.DAO.AdminDAO;
import Model.POJO.Admin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> LoginAdminServlet e' una Servlet che permette all'Admin di
 * accedere al sito</p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AdminDAO adminDAO = new AdminDAO();
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Admin admin = null;
    if (email != null && password != null) {
      admin = adminDAO.doRetrieveByEmailandPassword(email, password);
    }
    if (admin == null) {
      request.getSession().setAttribute("Errore", 1);
      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/adminLoginSegreto.jsp");
      requestDispatcher.forward(request, response);
    } else {
      request.getSession().setAttribute("LeaderSupremo", admin);
      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/adminHome.jsp");
      requestDispatcher.forward(request, response);
    }
  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
