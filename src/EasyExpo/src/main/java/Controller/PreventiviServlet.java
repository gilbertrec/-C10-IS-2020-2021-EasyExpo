package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.PreventivoDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Preventivo;
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
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      for(Preventivo p : preventivi){
          RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
          richieste.add(r);
      }
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    }else if(partitaIva == null && codiceFiscale != null) {
      List<Preventivo> preventivi = preventivoDAO.doRetrieveByCodiceFiscale(codiceFiscale);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      ArrayList<Fornitore> fornitori = new ArrayList<>();
      FornitoreDAO fornitoreDAO = new FornitoreDAO();
      for(Preventivo p : preventivi){
        RichiestaPreventivo r = richiestaPreventivoDAO.doRetrieveByIdRichiesta(p.getIdRichiesta());
        Fornitore f = fornitoreDAO.doRetrieveByPIVA(p.getPartitaIva());
        richieste.add(r);
        fornitori.add(f);
      }
      request.getSession().setAttribute("fornitori", fornitori);
      request.getSession().setAttribute("richieste", richieste);
      request.getSession().setAttribute("preventivi", preventivi);
    }

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaPreventivi.jsp");
      requestDispatcher.forward(request, response);
    }
  }
