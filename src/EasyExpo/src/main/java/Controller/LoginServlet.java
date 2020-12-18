package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.ClienteDAO;
import Model.POJO.Cliente;
import Model.DAO.FornitoreDAO;
import Model.POJO.Fornitore;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        ClienteDAO clienteDAO = new ClienteDAO();
        FornitoreDAO fornitoreDAO = new FornitoreDAO();

        Cliente cliente = null;
        Fornitore fornitore = null;


        if (email != null && password != null) {
            cliente = clienteDAO.doRetrieveByEmailPassword(email, password);
            fornitore = fornitoreDAO.doRetrieveByEmailPassword(email, password);
        }

        if (cliente == null) {
          System.out.println("Email e/o Password non validi.\n");
            response.sendRedirect(".");
            return;
        } else {
            request.getSession().setAttribute("cliente", cliente);
            response.sendRedirect("Homecliente");
            return;
        }

        if (fornitore == null) {
            System.out.println("Email e/o Password non validi.\n");
            response.sendRedirect(".");
            return;
        } else {
            request.getSession().setAttribute("fornitore", fornitore);
            response.sendRedirect("Areafornitore");
            return;

        }
    }

        protected void doGet (HttpServletRequest request,HttpServletResponse response) throws IOException{
            doPost(request, response);
        }

}

