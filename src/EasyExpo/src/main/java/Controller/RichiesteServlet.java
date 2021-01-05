package Controller;

import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RichiesteServlet")
public class RichiesteServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String partitaIva = request.getParameter("partitaIva");

    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();

    List<RichiestaPreventivo> richieste = richiestaPreventivoDAO.doRetrieveByPartitaIva(partitaIva);
    request.getSession().setAttribute("richieste", richieste);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
  }
}
