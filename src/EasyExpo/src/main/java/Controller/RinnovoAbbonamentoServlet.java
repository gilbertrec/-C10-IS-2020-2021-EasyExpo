package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.POJO.Abbonamento;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RinnovoAbbonamentoServlet")
public class RinnovoAbbonamentoServlet extends HttpServlet {
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

    abbonamentoDAO.createAbbonamento(abbonamento);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
