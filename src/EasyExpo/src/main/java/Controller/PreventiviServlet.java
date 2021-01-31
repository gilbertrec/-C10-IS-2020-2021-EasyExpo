package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.PreventivoDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Preventivo;
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
 * <p> PreventiviServlet e' una Servlet che permette di visionare
 * tutti i preventivi di un Cliente o di un Fornitore</p>.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/PreventiviServlet")
public class PreventiviServlet extends HttpServlet {
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

    PreventivoDAO preventivoDAO = new PreventivoDAO();
    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();

    if (partitaIva != null && codiceFiscale == null) {
      List<Preventivo> preventivi = preventivoDAO.doRetrieveByPartitaIva(partitaIva);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      ArrayList<Fornitore> fornitori = new ArrayList<>();
      FornitoreDAO fornitoreDAO = new FornitoreDAO();
      for (Preventivo p : preventivi) {
        RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
        Fornitore f = fornitoreDAO.doRetrieveByPIVA(p.getPartitaIva());
        richieste.add(r);
        fornitori.add(f);
      }
      request.getSession().setAttribute("fornitori", fornitori);
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    } else if (partitaIva == null && codiceFiscale != null) {
      List<Preventivo> preventivi = preventivoDAO.doRetrieveByCodiceFiscale(codiceFiscale);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      ArrayList<Fornitore> fornitori = new ArrayList<>();
      FornitoreDAO fornitoreDAO = new FornitoreDAO();
      for (Preventivo p : preventivi) {
        RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
        Fornitore f = fornitoreDAO.doRetrieveByPIVA(p.getPartitaIva());
        richieste.add(r);
        fornitori.add(f);
      }
      request.getSession().setAttribute("fornitori", fornitori);
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    }

    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/listaPreventivi.jsp");
    requestDispatcher.forward(request, response);
  }
}
