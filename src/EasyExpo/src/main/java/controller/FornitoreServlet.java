package controller;

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

@WebServlet("/FornitoreServlet")
public class FornitoreServlet extends HttpServlet {
  private final FornitoreDAO fornitoreDAO = new FornitoreDAO();

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

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


    RequestDispatcher requestDispatcher = request.getRequestDispatcher("specificheFornitore.jsp");
    requestDispatcher.forward(request, response);
  }

}
