package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> SospendiUtenteServlet e' una Servlet che permette all'Admin di
 * sospendere un fornitore o un cliente iscritto al sito</p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/SospendiUtenteServlet")
public class SospendiUtenteServlet extends HttpServlet {
  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if (request.getParameter("flag") == null || request.getParameter("id") == null) {
      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/adminHome.jsp");
      requestDispatcher.forward(request, response);
    }
    if (request.getParameter("flag").equals("1")) {
      FornitoreDAO fornitoreDAO = new FornitoreDAO();
      fornitoreDAO.updateStato(2, request.getParameter("id"));
      request.getSession().setAttribute("fornitori", null);
      response.sendRedirect("gestioneFornitori.jsp");
    }
    if (request.getParameter("flag").equals("2")) {
      ClienteDAO clienteDAO = new ClienteDAO();
      clienteDAO.updateStato(2, request.getParameter("id"));
      request.getSession().setAttribute("clienti", null);
      response.sendRedirect("gestioneClienti.jsp");
    }
  }

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doGet(request, response);
  }
}
