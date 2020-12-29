package Controller;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
  private final ProdottoDAO prodottoDAO = new ProdottoDAO();

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, NumberFormatException {

    int id;
    String partitaIva;
    try {
      id = Integer.parseInt(request.getParameter("id"));
      partitaIva = request.getParameter("partitaIva");
      System.out.println("id: " + id + "partita iva: " + partitaIva);

    } catch (NumberFormatException e) {
      throw new MyServletException("Id prodotto non valido.");
    }

    Prodotto prodotto = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(id, partitaIva);
    request.setAttribute("prodotti", prodotto);

    if (prodotto == null) {
      throw new MyServletException("Prodotto non trovato.");
    }

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("specificheProdotto.jsp");
    requestDispatcher.forward(request, response);
  }


}
