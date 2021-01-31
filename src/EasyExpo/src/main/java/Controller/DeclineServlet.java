package Controller;

import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> DeclineServlet e' una Servlet che permette di
 * declinare la richiesta di preventivo di un cliente </p>.
 *
 * @author GAETANO IULIANO
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/DeclineServlet")
public class DeclineServlet extends HttpServlet {
  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idRichiesta = request.getParameter("idRichiesta");
    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    RichiestaPreventivo richiesta =
        richiestaPreventivoDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));
    richiestaPreventivoDAO.deleteRichiestePreventivo(Integer.parseInt(idRichiesta));
    RichiestaPreventivo.Stato stato = RichiestaPreventivo.Stato.valueOf("RIFIUTATO");
    richiesta.setStato(stato);
    richiestaPreventivoDAO.createRichiestaPreventivo(richiesta);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("RichiesteServlet");
    requestDispatcher.forward(request, response);
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
    doGet(request, response);
  }
}
