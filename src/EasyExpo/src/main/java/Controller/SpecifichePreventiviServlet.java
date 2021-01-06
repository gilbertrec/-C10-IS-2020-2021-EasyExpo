package Controller;

import Model.DAO.PreventivoDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.ProdottoRichiestaDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Preventivo;
import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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

      ProdottoRichiestaDAO prodottoRichiestaDAO = new ProdottoRichiestaDAO();
      List<ProdottoRichiesta> prichiesta = prodottoRichiestaDAO.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));

      ArrayList<Prodotto> prodotto = new ArrayList<>();
      ProdottoDAO prodottoDAO = new ProdottoDAO();

      for(ProdottoRichiesta a : prichiesta){
       int idProdotto =  a.getIdProdotto();
       String partitaIva = a.getPartitaIva();
       Prodotto p = prodottoDAO.doRetrieveByIdProdottoEPartitaIva(idProdotto, partitaIva);

       prodotto.add(p);
      }

      request.getSession().setAttribute("richiesta", richiesta);
      request.getSession().setAttribute("prichiesta", prichiesta);
      request.getSession().setAttribute("prodotto", prodotto);

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
