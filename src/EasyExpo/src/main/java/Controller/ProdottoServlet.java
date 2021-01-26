package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.TagDAO;
import Model.DAO.TagProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.Tag;
import Model.POJO.TagProdotto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProdottoServlet")
public class ProdottoServlet extends HttpServlet {
  private final ProdottoDAO prodottoDAO = new ProdottoDAO();
  private final FornitoreDAO fornitoreDAO = new FornitoreDAO();

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
      //System.out.println("id: " + id + "partita iva: " + partitaIva);

    } catch (NumberFormatException e) {
      throw new MyServletException("Id prodotto non valido.");
    }

    Prodotto prodotto = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(id, partitaIva);
    request.setAttribute("prodotti", prodotto);

    Fornitore fornitore = fornitoreDAO.doRetrieveByPIVA(partitaIva);
    request.setAttribute("fornitore", fornitore);

    if (prodotto == null) {
      throw new MyServletException("Prodotto non trovato.");
    }

    TagProdottoDAO tagProdottoDAO= new TagProdottoDAO();
    TagDAO tagDAO = new TagDAO();
    ArrayList<TagProdotto> tagProdotti =  tagProdottoDAO.doRetrieveByIdProdottoPartitaIva(prodotto.getIdProdotto(), fornitore.getPartitaIva());
    ArrayList<Tag> tags = new ArrayList<>();
    for(TagProdotto t : tagProdotti){
      Tag tag = tagDAO.doRetrieveByIdTag(t.getIdTag());
      tags.add(tag);
    }


    request.setAttribute("tags", tags);

    RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/specificheProdotto.jsp");
    requestDispatcher.forward(request, response);
  }


}
