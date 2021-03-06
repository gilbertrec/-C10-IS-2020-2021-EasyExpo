package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
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
 * <p> LoginServlet e' una Servlet che permette al Cliente e
 * al Fornitore di accedere al sito</p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private final ProdottoDAO prodottoDAO = new ProdottoDAO();

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ClienteDAO clienteDAO = new ClienteDAO();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    Cliente cliente = null;
    Fornitore fornitore = null;
    if (email != null && password != null) {
      cliente = clienteDAO.doRetrieveByEmailandPassword(email, password);
      fornitore = fornitoreDAO.doRetrieveByEmailandPassword(email, password);
    }
    if (cliente == null && fornitore == null) {
      throw new MyServletException("Email e/o password non validi.");
    } else if (cliente != null && fornitore == null) {
      if (cliente.getStato() == Cliente.Stato.SOSPESO) {
        throw new MyServletException("Utente sospeso!");
      }
      request.getSession().setAttribute("cliente", cliente);
      List<Prodotto> tuttiP = prodottoDAO.doRetrieveAll();
      int inizio = tuttiP.size() - 4;
      List<Prodotto> prodottiNuovi = prodottoDAO.doRetrieveRandom(inizio, 4);

      //request.setAttribute("prodottiNuovi", prodottiNuovi);
      request.getSession().setAttribute("prodottiNuovi", prodottiNuovi);

      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/index.jsp");
      requestDispatcher.forward(request, response);
    } else if (cliente == null && fornitore != null) {
      if (fornitore.getStato() == Fornitore.Stato.SOSPESO) {
        throw new MyServletException("Utente sospeso!");
      }
      request.getSession().setAttribute("fornitore", fornitore);
      ProdottoDAO prodottoDAO = new ProdottoDAO();
      List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(fornitore.getPartitaIva());
      request.getSession().setAttribute("prodotti", prodotti);
      boolean flag = fornitore.isAbbonato();
      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/areaFornitore.jsp");
      requestDispatcher.forward(request, response);
    }

  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}