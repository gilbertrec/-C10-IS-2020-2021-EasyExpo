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
        if (request.getParameter("flag").equals("1")) {
            FornitoreDAO fornitoreDAO = new FornitoreDAO();
            fornitoreDAO.updateStato(2, request.getParameter("id"));
            request.getSession().setAttribute("fornitori",null);
            response.sendRedirect("gestioneFornitori.jsp");
        }
        if (request.getParameter("flag").equals("2")) {
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.updateStato(2, request.getParameter("id"));
            request.getSession().setAttribute("clienti",null);
            response.sendRedirect("gestioneClienti.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }
}