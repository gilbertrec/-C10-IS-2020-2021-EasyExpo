package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.ProdottoRichiestaDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Cliente;
import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> CompilaPreventivoServlet e' una Servlet che permette al fornitore di
 * compilare un preventivo i risposta alla richiesta di un cliente</p>.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/CompilaPreventivoServlet")
public class CompilaPreventivoServlet extends HttpServlet {

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }


  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idRichiesta = request.getParameter("idRichiesta");

    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    RichiestaPreventivo richiesta =
        richiestaPreventivoDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));

    ProdottoRichiestaDAO prodottoRichiestaDAO = new ProdottoRichiestaDAO();
    List<ProdottoRichiesta> prichiesta =
        prodottoRichiestaDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));

    ArrayList<Prodotto> prodotto = new ArrayList<>();
    ProdottoDAO prodottoDAO = new ProdottoDAO();

    for (ProdottoRichiesta a : prichiesta) {
      int idProdotto = a.getIdProdotto();
      String partitaIva = a.getPartitaIva();
      Prodotto p = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(idProdotto, partitaIva);
      prodotto.add(p);
    }

    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cliente = clienteDAO.doRetrieveByCF(richiesta.getCodiceFiscale());


    request.getSession().setAttribute("richiesta", richiesta);
    request.getSession().setAttribute("prichiesta", prichiesta);
    request.getSession().setAttribute("prodotto", prodotto);
    request.getSession().setAttribute("clifor", cliente);
    request.getSession().setAttribute("cliente_specifica", cliente);

    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/preventivo.jsp");
    requestDispatcher.forward(request, response);
  }
}
