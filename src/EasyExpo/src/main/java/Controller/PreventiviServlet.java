package Controller;

import Model.DAO.PreventivoDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
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

@WebServlet("/PreventiviServlet")
public class PreventiviServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String partitaIva = request.getParameter("partitaIva");
    String codiceFiscale = request.getParameter("codiceFiscale");

    PreventivoDAO preventivoDAO = new PreventivoDAO();
    RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();

    if(partitaIva != null && codiceFiscale == null){
      List<Preventivo> preventivi = preventivoDAO.doRetrieveByPartitaIva(partitaIva);
      List<RichiestaPreventivo> richieste = null;
      for(Preventivo p : preventivi){
          RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
          richieste.add(r);
      }
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    }else if(partitaIva == null && codiceFiscale != null) {
      List<Preventivo> preventivi = preventivoDAO.doRetrieveByCodiceFiscale(codiceFiscale);
      List<RichiestaPreventivo> richieste = null;
      for(Preventivo p : preventivi){
        RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
        richieste.add(r);
      }
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    }

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
      requestDispatcher.forward(request, response);
    }
  }
