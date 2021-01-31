package Controller.Admin;

import Controller.HttpServlet;
import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> ListaProdottiServlet e' una Servlet che permette all'Admin di
 * visionare la lista dei prodotti di un determinato fornitore</p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ListaProdottiServlet")
public class ListaProdottiServlet extends HttpServlet {

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String partitaIva = request.getParameter("id");
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(partitaIva);
    request.setAttribute("prodotti", prodotti);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneProdotti.jsp");
    requestDispatcher.forward(request, response);
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

