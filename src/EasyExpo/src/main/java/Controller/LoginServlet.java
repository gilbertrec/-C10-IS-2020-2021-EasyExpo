package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private final ProdottoDAO prodottoDAO = new ProdottoDAO();

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
      request.getSession().setAttribute("cliente", cliente);


      List<Prodotto> tuttiP = prodottoDAO.doRetrieveAll();
      int inizio= tuttiP.size()-4;
      List<Prodotto> prodottiNuovi = prodottoDAO.doRetrieveRandom(inizio,4);

      request.setAttribute("prodottiNuovi", prodottiNuovi);


      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
      requestDispatcher.forward(request, response);
    } else if (cliente == null && fornitore != null) {
      request.getSession().setAttribute("fornitore", fornitore);
      ProdottoDAO prodottoDAO = new ProdottoDAO();
      List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(fornitore.getPartitaIva());
      request.getSession().setAttribute("prodotti", prodotti);
      boolean flag = fornitore.isAbbonato();
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
      requestDispatcher.forward(request, response);
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}