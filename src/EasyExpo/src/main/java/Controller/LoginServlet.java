package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        FornitoreDAO fornitoreDAO = new FornitoreDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Cliente cliente = null;
        Fornitore fornitore = null;
        if (email != null && password != null) {
            cliente = clienteDAO.doRetrieveByEmailandPassword(email, password);
            fornitore = fornitoreDAO.doRetrieveByEmailandPassword(email, password);
        }
        if (cliente == null) {
            throw new MyServletException("Email e/o password non validi.");
        } else {
            request.getSession().setAttribute("cliente", cliente);
            response.sendRedirect("HomeCliente");
        }
        request.getSession().setAttribute("cliente", cliente);
        if (fornitore == null) {
            throw new MyServletException("Email e/o password non validi.");
        } else {
            request.getSession().setAttribute("fornitore", fornitore);
            response.sendRedirect("AreaFornitore");
        }
        request.getSession().setAttribute("fornitore", fornitore);
        String address = ".";

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
