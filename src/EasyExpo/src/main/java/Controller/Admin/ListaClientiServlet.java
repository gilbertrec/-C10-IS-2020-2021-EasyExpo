package Controller.Admin;

import Controller.HttpServlet;
import Model.DAO.ClienteDAO;
import Model.POJO.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListaClientiServlet")
public class ListaClientiServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    ClienteDAO clienteDAO = new ClienteDAO();
    List<Cliente> clienti = clienteDAO.doRetrievebyStato(1);
    //request.getSession().setAttribute("clienti", clienti);
    request.setAttribute("clienti", clienti);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("gestioneClienti.jsp");
    requestDispatcher.forward(request, response);

  }
}
