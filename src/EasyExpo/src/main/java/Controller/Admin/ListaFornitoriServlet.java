package Controller.Admin;

import Controller.HttpServlet;
import Model.DAO.FornitoreDAO;
import Model.POJO.Fornitore;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> ListaFornitoriServlet e' una Servlet che permette all'Admin di
 * visionare la lista dei fornitori iscritti al sito</p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ListaFornitoriServlet")
public class ListaFornitoriServlet extends HttpServlet {

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doPost(request, response);
  }

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    List<Fornitore> fornitori = fornitoreDAO.doRetrievebyStato(1);
    request.setAttribute("fornitori", fornitori);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneFornitori.jsp");
    requestDispatcher.forward(request, response);

  }
}
