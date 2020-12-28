package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
        List<Abbonamento> abbonamenti = abbonamentoDAO.doRetrieveByPartitaIva(request.getParameter("partitaIva"));
        for (Abbonamento a: abbonamenti) {
        System.out.println(a);
        }
        if (abbonamenti == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/abbonamento.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rinnovo.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
