package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> SottoscrizioneAbbonamentoServlet e' una Servlet che permette al
 * Forntiore di sottoscrivere un abbonamento</p>.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/SottoscrizioneAbbonamentoServlet")
public class SottoscrizioneAbbonamentoServlet extends HttpServlet {
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

    String partitaIva = request.getParameter("partitaIva");

    String nomeIntestatario = request.getParameter("nomeIntestatario");
    if (!(nomeIntestatario != null && nomeIntestatario.matches("[A-Z a-z]{1,50}"))) {
      throw new MyServletException("Nome intestatario non valido.");
    }

    String numeroCarta = request.getParameter("numeroCarta");
    boolean esiste = false;
    esiste = metodoDAO.doRetrieveByNumCartaBoolean(numeroCarta);
    if (!(numeroCarta != null && numeroCarta.matches("[0-9]{4}[0-9]{4}[0-9]{4}[0-9]{4}")
        && esiste == false)) {
      throw new MyServletException("Numero carta non valido.");
    }

    String cvv = request.getParameter("cvv");
    if (!(cvv != null && cvv.matches("[0-9]{3}"))) {
      throw new MyServletException("Cvv non valido.");
    }

    String dataScadenza = request.getParameter("dataScadenza");
    if (!(dataScadenza != null && dataScadenza.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}"))) {
      throw new MyServletException("Data scadenza non valida.");
    }

    MetodoPagamento metodo = new MetodoPagamento();
    metodo.setNomeIntestatario(nomeIntestatario);
    metodo.setNumeroCarta(numeroCarta);
    metodo.setPartitaIva(partitaIva);
    metodo.setCvv(Integer.parseInt(cvv));
    FornitoreDAO fornitoreDao = new FornitoreDAO();
    Fornitore fornitore = fornitoreDao.doRetrieveByPIVA(partitaIva);

    try {
      Date data = Date.valueOf(request.getParameter("dataScadenza"));
      java.util.Date utilDate = data;
      java.sql.Date corrente = new java.sql.Date(Calendar.getInstance().getTime().getTime());
      Calendar calendario = Calendar.getInstance();
      calendario.setTime(corrente);
      java.util.Date sc = new java.util.Date(calendario.getTime().getTime());
      if (utilDate.after(sc)) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        metodo.setDataScadenza(sqlDate);
        fornitore.setAbbonato(true);
        fornitoreDao.updateBooleanFornitore(fornitore);
        request.getSession().setAttribute("fornitore",fornitore);
      } else {
        throw new MyServletException("Carta scaduta.");
      }
    } catch (MyServletException e) {
      e.printStackTrace();
    }


    Abbonamento abbonato = new Abbonamento();
    abbonato.setPartitaIva(partitaIva);


    java.sql.Date oggi = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    abbonato.setDataInizio(oggi);

    Calendar calendario = Calendar.getInstance();
    calendario.setTime(oggi);
    calendario.add(Calendar.DATE, 30);
    java.sql.Date scadenza = new java.sql.Date(calendario.getTime().getTime());
    abbonato.setDataFine(scadenza);

    metodoDAO.createMetodoPagamento(metodo);
    abbonamentoDAO.createAbbonamento(abbonato);

    RequestDispatcher requestDispatcher =
        request.getServletContext().getRequestDispatcher("/areaFornitore.jsp");
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
