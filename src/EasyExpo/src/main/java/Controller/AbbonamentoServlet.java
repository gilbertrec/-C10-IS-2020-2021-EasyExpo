package Controller;


import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AbbonamentoServlet")
public class AbbonamentoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
    MetodiDiPagamentoDAO metodoDAO = new MetodiDiPagamentoDAO();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
        /*HttpSession session = request.getSession();
        Fornitore fornitore = (Fornitore) session.getAttribute("fornitore");*/
    String partitaIva = request.getParameter("partitaIva");
    Fornitore fornitore = fornitoreDAO.doRetrieveByPIVA(partitaIva);
    List<Abbonamento> abbonamenti = abbonamentoDAO.doRetrieveByPartitaIva(partitaIva);

    if (abbonamenti.size() == 0) {
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/abbonamento.jsp");
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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rinnovo.jsp");
        requestDispatcher.forward(request, response);
      } else {
        throw new MyServletException("Sei gia abbonato!");
      }


    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
