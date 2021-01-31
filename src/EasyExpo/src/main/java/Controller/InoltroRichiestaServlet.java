package Controller;


import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoRichiestaDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Carrello;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p> InoltroRichiestaServlet e' una Servlet che permette al cliente di
 * inoltrare la richiesta al fornitore per il noleggi dei prodotti</p>.
 *
 * @author KATIA MONACO DE SIMONE
 * @version 1.0
 * @since 2020-12-29
 */
@WebServlet("/InoltroRichiesta")
public class InoltroRichiestaServlet extends HttpServlet {
  private final FornitoreDAO fornitoreDao = new FornitoreDAO();

  /**
   * doGet() method.
   *
   * @param req  is the servlet request.
   * @param resp is the servlet response.
   */
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }

  /**
   * doPost() method.
   *
   * @param req  is the servlet request.
   * @param resp is the servlet response.
   */
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    ArrayList<Carrello.ProdottoQuantita> listaProdotti =
        (ArrayList<Carrello.ProdottoQuantita>) session.getAttribute("listaProdotti");
    ArrayList<Fornitore> listaFornitori =
        (ArrayList<Fornitore>) session.getAttribute("listaFornitori");

    Cliente cliente = (Cliente) session.getAttribute("cliente");
    String partitaIvaF = listaProdotti.get(0).getProdotto().getPartitaIva();
    Fornitore fornitore = fornitoreDao.doRetrieveByPIVA(partitaIvaF);

    String titolo = req.getParameter("titolo");
    String luogo = req.getParameter("luogo");
    String nota = req.getParameter("nota");
    String descrizione = req.getParameter("descrizione");
    if (!descrizione.matches("[A-Z a-z .,/()%”]{1,1024}")) {
      throw new MyServletException("Descrizione non valida.");
    }
    //data corrente

    java.sql.Date corrente = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    String cf = cliente.getCodiceFiscale();


    RichiestaPreventivo rp = new RichiestaPreventivo();
    rp.setCodiceFiscale(cf);
    rp.setPartitaIva(partitaIvaF);
    rp.setTitolo(titolo);
    rp.setLuogoEvento(luogo);
    rp.setDescrizioneEvento(descrizione);
    rp.setNota(nota);
    rp.setDataRichiesta(corrente);
    rp.setStato(RichiestaPreventivo.Stato.IN_ATTESA);

    RichiestaPreventivoDAO richiestaPreventivoDao = new RichiestaPreventivoDAO();
    richiestaPreventivoDao.createRichiestaPreventivo(rp);

    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");


    for (int i = 0; i < listaProdotti.size(); i++) {
      ProdottoRichiesta pr = new ProdottoRichiesta();
      pr.setIdRichiesta(rp.getIdRichiesta());
      pr.setIdProdotto(listaProdotti.get(i).getProdotto().getIdProdotto());
      pr.setPartitaIva(partitaIvaF);
      pr.setNumColli(listaProdotti.get(i).getQuantita());
      pr.setPrezzo(listaProdotti.get(i).getProdotto().getPrezzo());

      //data inizio
      Date dataI = Date.valueOf(req.getParameter("dataInizio" + i));
      java.util.Date utilDate = dataI;
      Date dataF = Date.valueOf(req.getParameter("dataFine" + i));
      java.util.Date utilDate2 = dataF;


      Calendar calendario = Calendar.getInstance();
      calendario.setTime(corrente);
      java.util.Date sc = new java.util.Date(calendario.getTime().getTime());
      if (utilDate.after(sc)) {
        //se dataInizio è dopo dataAttuale(sc) e Datainizio prima di dataFine?? è true
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pr.setDataInizioNoleggio(sqlDate);
      } else {
        throw new MyServletException("Data inizio errata.");
      }


      //data fine
      Calendar calendario2 = Calendar.getInstance();
      calendario.setTime(corrente);
      if (utilDate2.after(sc) && utilDate2.after(
          utilDate)) { //se dataFine è dopo dataAttuale(sc) e dataFine è dopo dataInizio è true
        java.sql.Date sqlDate = new java.sql.Date(utilDate2.getTime());
        pr.setDataFineNoleggio(sqlDate);
      } else {
        throw new MyServletException("Data fine errata.");
      }


      ProdottoRichiestaDAO prodottoRichiestaDao = new ProdottoRichiestaDAO();
      prodottoRichiestaDao.createProdottoRichiesta(pr);
    }

    //elimina dal carrello i prodotti per cui ha inviato la richiesta
    //deve eliminare anche il fornitore (vedi carrelloServlet)
    Carrello carrello = (Carrello) session.getAttribute("carrello");
    carrello.remove(partitaIvaF);
    for (int i = 0; i < listaFornitori.size(); i++) {
      Fornitore f = listaFornitori.get(i);
      if (f.getPartitaIva()
          .equals(partitaIvaF)) {
        listaFornitori.remove(i);
      }
    }


    session.setAttribute("carrello", carrello);


    RequestDispatcher requestDispatcher =
        req.getServletContext().getRequestDispatcher("/carrello.jsp");
    requestDispatcher.forward(req, resp);
  }

}
