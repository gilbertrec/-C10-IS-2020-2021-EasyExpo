package Controller;


import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> AbbonamentoServlet e' una Servlet che permette di
 * svolgere l'abbonamento al sito da parte dei fornitori </p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */

@WebServlet("/AbbonamentoServlet")
public class AbbonamentoServlet extends HttpServlet {
  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
    MetodiDiPagamentoDAO metodoDAO = new MetodiDiPagamentoDAO();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    String partitaIva = request.getParameter("partitaIva");
    Fornitore fornitore = fornitoreDAO.doRetrieveByPIVA(partitaIva);
    List<Abbonamento> abbonamenti = abbonamentoDAO.doRetrieveByPartitaIva(partitaIva);

    if (abbonamenti.size() == 0) {
      RequestDispatcher requestDispatcher =
          request.getServletContext().getRequestDispatcher("/abbonamento.jsp");
      requestDispatcher.forward(request, response);
    } else {
      List<MetodoPagamento> metodi = metodoDAO.doRetrieveAllByPartitaIva(partitaIva);
      request.setAttribute("metodi", metodi);

      java.sql.Date corrente = new java.sql.Date(Calendar.getInstance().getTime().getTime());
      Calendar calendario = Calendar.getInstance();
      calendario.setTime(corrente);
      java.util.Date sc = new java.util.Date(calendario.getTime().getTime());
      fornitore.setAbbonato(false);
      for (Abbonamento a : abbonamenti) {
        if (a.getDataFine().after(sc)) {
          fornitore.setAbbonato(true);
        }
      }
      if (fornitore.isAbbonato() == false) {
        RequestDispatcher requestDispatcher =
            request.getServletContext().getRequestDispatcher("/rinnovo.jsp");
        requestDispatcher.forward(request, response);
      } else {
        throw new MyServletException("Sei gia abbonato!");
      }


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
