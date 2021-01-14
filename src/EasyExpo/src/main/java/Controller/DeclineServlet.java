package Controller;

import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeclineServlet")
public class DeclineServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idRichiesta = request.getParameter("idRichiesta");
    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    RichiestaPreventivo richiesta =
        richiestaPreventivoDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));
      //r.setStato(RichiestaPreventivo.Stato.valueOf(rs.getString(9)));
    RichiestaPreventivo.Stato stato = RichiestaPreventivo.Stato.valueOf("RIFIUTATO");
    richiesta.setStato(stato);



  }
}
