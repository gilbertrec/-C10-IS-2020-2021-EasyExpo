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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        FornitoreDAO fornitoreDAO = new FornitoreDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Cliente cliente = new Cliente();
        Fornitore fornitore = new Fornitore();
        if (email != null && password != null) {
            cliente = clienteDAO.doRetrieveByEmailandPassword(email, password);
            fornitore = fornitoreDAO.doRetrieveByEmailandPassword(email, password);
        }
        if (cliente == null && fornitore == null) {
            throw new MyServletException("Email e/o password non validi.");
        }else if(cliente !=null && fornitore == null){
            request.getSession().setAttribute("cliente", cliente);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request,response);
        }else if(cliente == null && fornitore != null){
            request.getSession().setAttribute("fornitore", fornitore);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}