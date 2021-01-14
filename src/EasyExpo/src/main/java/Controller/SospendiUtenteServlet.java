package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SospendiUtenteServlet")
public class SospendiUtenteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getRequestURL().toString().contains("/listaFornitori.jsp")) {
            FornitoreDAO fornitoreDAO = new FornitoreDAO();
            fornitoreDAO.updateStato(2, request.getParameter("id"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gestioneFornitori.jsp");
            requestDispatcher.forward(request,response);
        }

            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.updateStato(2, request.getParameter("id"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gestioneClienti.jsp");
        requestDispatcher.forward(request,response);
        }



    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}
