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

/**
 * <p> ListaClientiServlet e' una Servlet che permette all'Admin di
 * visionare la lista dei clienti iscritti al sito</p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ListaClientiServlet")
public class ListaClientiServlet extends HttpServlet {

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    doPost(request, response);
  }

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
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
