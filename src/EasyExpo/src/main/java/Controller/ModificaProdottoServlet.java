package Controller;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> ModificaProdottoServlet e' una Servlet che permette di dire quale prodotto
 * debba essere modifiato</p>.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
  /**
   * doPost() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  /**
   * doGet() method.
   *
   * @param request  is the servlet request.
   * @param response is the servlet response.
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));
    String partitaIva = request.getParameter("partitaIva");
    ProdottoDAO prodottoDAO = new ProdottoDAO();
    Prodotto prodotto = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(id, partitaIva);
    request.setAttribute("prodotto", prodotto);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/modificaProdotto.jsp");
    requestDispatcher.forward(request, response);
  }
}