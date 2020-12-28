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

@WebServlet("/SottoscrizioneAbbonamentoServlet")
public class SottoscrizioneAbbonamentoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
        //Fornitore fornitore = (Fornitore) session.getAttribute("fornitore");
        String partitaIva = (String) request.getAttribute("abbonamento");
        System.out.println(partitaIva);
        AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();
        Abbonamento a = new Abbonamento();
        a = abbonamentoDAO.doRetrieveByPartitaIva(partitaIva);
        if(a == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/abbonamento.jsp");
            requestDispatcher.forward(request,response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/rinnovo.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
