package Controller;

import Model.DAO.PreventivoDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SpecificaServlet")
public class SpecifichePreventiviServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String idRichiesta = request.getParameter("idRichiesta");
    String idPreventivo = request.getParameter("idPreventivo");

    if(idRichiesta != null && idPreventivo == null){
      RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();
      RichiestaPreventivo richiesta = richiestaPreventivoDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));

      request.getSession().setAttribute("richiesta", richiesta);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/specificaRichiesta.jsp");
      requestDispatcher.forward(request, response);
    }else if(idRichiesta == null && idPreventivo != null){
      PreventivoDAO preventivoDAO = new PreventivoDAO();
      Preventivo preventivo = preventivoDAO.doRetriveByIdPreventivo(Integer.parseInt(idPreventivo));

      request.getSession().setAttribute("preventivo", preventivo);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/specificaPreventivo.jsp");
      requestDispatcher.forward(request, response);
    }


  }
}
