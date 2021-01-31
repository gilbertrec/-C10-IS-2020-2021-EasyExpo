package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> RinnovoAbbonamentoServlet e' una Servlet che permette di rinnovare
 * l'Abbonamento a un Fornitore che era già stato abbonato ma il suo utlimo abboanmento
 * è scaduto</p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/RinnovoAbbonamentoServlet")
public class RinnovoAbbonamentoServlet extends HttpServlet {
  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
    String partitaIva = request.getParameter("partitaIva");
    Abbonamento abbonamento = new Abbonamento();
    abbonamento.setPartitaIva(partitaIva);
    java.sql.Date oggi = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    abbonamento.setDataInizio(oggi);

    Calendar calendario = Calendar.getInstance();
    calendario.setTime(oggi);
    calendario.add(Calendar.DATE, 30);
    java.sql.Date scadenza = new java.sql.Date(calendario.getTime().getTime());
    abbonamento.setDataFine(scadenza);

    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    Fornitore fornitore = fornitoreDAO.doRetrieveByPIVA(partitaIva);
    fornitore.setAbbonato(true);
    fornitoreDAO.updateBooleanFornitore(fornitore);
    request.setAttribute("fornitore", fornitore);

    abbonamentoDAO.createAbbonamento(abbonamento);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
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
