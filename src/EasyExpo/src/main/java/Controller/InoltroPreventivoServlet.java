package Controller;

import Model.DAO.PreventivoDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InoltroPreventivoServlet")
public class InoltroPreventivoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String idRichiesta = request.getParameter("idRichiesta");
    String partitaIva = request.getParameter("partitaIva");
    String codiceFiscale = request.getParameter("codiceFiscale");

    String prezzo = request.getParameter("prezzo");
    if (!(prezzo != null && prezzo.matches("[0-9]{1,5}.[0-9]{2}"))) {
      throw new MyServletException("Prezzo non valido.");
    }

    String nota = request.getParameter("nota");
    if (!nota.matches("[A-Z a-z .,/()%”]{1,1024}")) {
      throw new MyServletException("Nota non valida.");
    }

    java.sql.Date corrente = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    Preventivo preventivo = new Preventivo();
    preventivo.setIdRichiesta(Integer.parseInt(idRichiesta));
    preventivo.setPartitaIva(partitaIva);
    preventivo.setCodiceFiscale(codiceFiscale);
    preventivo.setPrezzoTotale(Float.parseFloat(prezzo));
    preventivo.setDataPreventivo(corrente);
    preventivo.setNota(nota);
    PreventivoDAO preventivoDao = new PreventivoDAO();
    preventivoDao.createPreventivo(preventivo);

    RichiestaPreventivoDAO richiestaPreventivoDao = new RichiestaPreventivoDAO();
    RichiestaPreventivo richiesta =
        richiestaPreventivoDao.doRetrieveByIdRichiesta(Integer.parseInt(idRichiesta));
    richiestaPreventivoDao.deleteRichiestePreventivo(Integer.parseInt(idRichiesta));
    RichiestaPreventivo.Stato stato = RichiestaPreventivo.Stato.valueOf("CONFERMATO");
    richiesta.setStato(stato);
    richiestaPreventivoDao.createRichiestaPreventivo(richiesta);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
    requestDispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
