package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/SottoscrizioneAbbonamentoServlet")
public class SottoscrizioneAbbonamentoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
    MetodiDiPagamentoDAO metodoDAO = new MetodiDiPagamentoDAO();
        /*HttpSession session = request.getSession();
        Fornitore fornitore = (Fornitore) session.getAttribute("fornitore");*/
    String partitaIva = request.getParameter("partitaIva");
    List<Abbonamento> abbonamenti = abbonamentoDAO.doRetrieveByPartitaIva(partitaIva);

    if (abbonamenti.size() == 0) {
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/abbonamento.jsp");
      requestDispatcher.forward(request, response);
    } else {
      List<MetodoPagamento> metodi = metodoDAO.doRetrieveAllByPartitaIva(partitaIva);
      request.setAttribute("metodi", metodi);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rinnovo.jsp");
      requestDispatcher.forward(request, response);
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
}
