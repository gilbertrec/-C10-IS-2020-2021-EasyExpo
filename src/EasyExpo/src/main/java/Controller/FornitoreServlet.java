package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> FornitoreServlet e' una Servlet che permette al
 * cliente di visionare le specifiche di un fornitore</p>.
 *
 * @author KATIA MONACO DE SIMONE
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/FornitoreServlet")
public class FornitoreServlet extends HttpServlet {
  private final FornitoreDAO fornitoreDAO = new FornitoreDAO();

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, NumberFormatException {

    String partitaIva;
    try {
      partitaIva = request.getParameter("partitaIva");

    } catch (NumberFormatException e) {
      throw new MyServletException("partita Iva non valida.");
    }

    Fornitore fornitore = fornitoreDAO.doRetrieveByPIVA(partitaIva);
    request.setAttribute("fornitore", fornitore);


    if (fornitore == null) {
      throw new MyServletException("Fornitore non trovato.");
    }

    ProdottoDAO prodottoDAO = new ProdottoDAO();
    List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(fornitore.getPartitaIva());
    request.setAttribute("prodotti", prodotti);


    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/specificheFornitore.jsp");
    requestDispatcher.forward(request, response);
  }

}
