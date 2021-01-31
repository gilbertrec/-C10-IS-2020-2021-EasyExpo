package Controller.Admin;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> EliminaProdottoAdminServlet e' una Servlet che permette di
 * eliminare un prodotto da parte dell'admin </p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/EliminaProdottoAdminServlet")
public class EliminaProdottoAdminServlet extends HttpServlet {

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
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    prodottoDAO.deleteProdotto(Integer.parseInt(request.getParameter("id")),
        request.getParameter("partitaIva"));
    List<Prodotto> prodotti =
        prodottoDAO.doRetrieveByPartitaIva(request.getParameter("partitaIva"));
    request.setAttribute("prodotti", prodotti);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gestioneProdotti.jsp");
    requestDispatcher.forward(request, response);
  }
}