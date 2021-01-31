package Controller;

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
 * <p> ELiminaProdottoServlet e' una Servlet che permette al fornitore di
 * eliminare un prodotto dal proprio catalogo </p>.
 *
 * @author SABATINO STRUMOLO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ELiminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
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
    String partitaIva = request.getParameter("partitaIva");
    int id = Integer.parseInt(request.getParameter("id"));

    ProdottoDAO prodottoDAO = new ProdottoDAO();
    prodottoDAO.deleteProdotto(id, partitaIva);
    List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(partitaIva);
    request.getSession().setAttribute("prodotti", prodotti);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
  }
}