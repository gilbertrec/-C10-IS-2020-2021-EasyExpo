package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Cliente;
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
 * <p> RichiesteServlet e' una Servlet che permette di visionare
 * tutti le richieste di un Cliente o di un Fornitore</p>.
 *
 * @author GAETANO IULIANO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/RichiesteServlet")
public class RichiesteServlet extends HttpServlet {
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
    String codiceFiscale = request.getParameter("codiceFiscale");

    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();

    if (partitaIva != null && codiceFiscale == null) {
      List<RichiestaPreventivo> richiesteComplessive =
          richiestaPreventivoDAO.doRetrieveByPartitaIva(partitaIva);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<RichiestaPreventivo>();
      ArrayList<Cliente> clienti = new ArrayList<Cliente>();
      ClienteDAO clienteDAO = new ClienteDAO();
      for (RichiestaPreventivo rp : richiesteComplessive) {
        if (!rp.getStato().toString().equals("RIFIUTATO")) {
          richieste.add(rp);
          Cliente c = clienteDAO.doRetrieveByCF(rp.getCodiceFiscale());
          clienti.add(c);
        }

      }
      request.getSession().setAttribute("clienti", clienti);
      request.getSession().setAttribute("richieste", richieste);
    } else if (partitaIva == null && codiceFiscale != null) {
      List<RichiestaPreventivo> richieste =
          richiestaPreventivoDAO.doRetrieveByCodiceFiscale(codiceFiscale);
      ArrayList<Cliente> clienti = new ArrayList<Cliente>();
      ClienteDAO clienteDAO = new ClienteDAO();
      for (RichiestaPreventivo rp : richieste) {
        Cliente c = clienteDAO.doRetrieveByCF(rp.getCodiceFiscale());
        clienti.add(c);
      }
      request.getSession().setAttribute("clienti", clienti);
      request.getSession().setAttribute("richieste", richieste);
    }

    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/listaRichieste.jsp");
    requestDispatcher.forward(request, response);
  }
}
