package Controller;

import Model.POJO.Carrello;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * <p> CompilaRichiesta e' una Servlet che permette di
 * compilare la richiesta di preventivo per il noleggio
 * dei prodotti presenti nel carrello </p>.
 *
 * @author KATIA MONACO DE SIMONE
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/CompilaRichiesta")
public class CompilaRichiestaPreventivoServlet extends HttpServlet {

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Carrello carrello = (Carrello) session.getAttribute("carrello");
    String partitaIva = request.getParameter("fornitore");
    ArrayList<Carrello.ProdottoQuantita> listaProdotti = carrello.get(partitaIva);

    request.getSession().setAttribute("listaProdotti", listaProdotti);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("richiestaPreventivo.jsp");
    requestDispatcher.forward(request, response);
  }
}
