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
 * <p> ListaFornitoriSospesiServlet e' una Servlet che permette all'Admin di
 * visionare la lista dei fornitori sospesi iscritti al sito</p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ListaFornitoriSospesiServlet")
public class ListaFornitoriSospesiServlet extends HttpServlet {

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
    List<Fornitore> fornitori = fornitoreDAO.doRetrievebyStato(2);
    request.setAttribute("fornitori", fornitori);

    RequestDispatcher requestDispatcher =
        request.getRequestDispatcher("gestioneFornitoriSospesi.jsp");
    requestDispatcher.forward(request, response);
  }
}