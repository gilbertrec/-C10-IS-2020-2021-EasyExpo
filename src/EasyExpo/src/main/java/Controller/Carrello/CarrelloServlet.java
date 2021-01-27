package Controller.Carrello;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Carrello;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
  private final ProdottoDAO prodottoDao = new ProdottoDAO();
  private final FornitoreDAO fornitoreDao = new FornitoreDAO();

  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doPost(req, resp);
  }

  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();

    Carrello carrello = (Carrello) session.getAttribute("carrello");
    ArrayList<Fornitore> listaFornitori =
        (ArrayList<Fornitore>) session.getAttribute("listaFornitori");
    if (carrello == null) /*se è vuoto il carrello anche listaPI è vuota*/ {
      carrello = new Carrello();
      session.setAttribute("carrello", carrello);
      listaFornitori = new ArrayList<>();
      session.setAttribute("listaFornitori", listaFornitori);
    }


    String prodIdStr = req.getParameter("prodId");
    String partitaIva = req.getParameter("partitaIva");

    if (prodIdStr != null) /*caso aggiunta*/ {
      int prodId = Integer.parseInt(prodIdStr);

      String addNumStr = req.getParameter("addNum");
      if (addNumStr != null) {
        int addNum = Integer.parseInt(addNumStr);

        ArrayList<Carrello.ProdottoQuantita> prodotti1 = carrello.get(partitaIva);

        if (prodotti1 == null) {  /*se la lista di prodotti assegnata a quel fornitore è vuota*/
          /*trovo il fornitore legato a quella partita iva*/
          Fornitore forni = fornitoreDao.doRetrieveByPIVA(partitaIva);
          /*e lo aggiungo alla lista dei fornitori*/
          listaFornitori.add(forni);

          /* crea l'array list di prodottoQuantità da aggiungere */
          ArrayList<Carrello.ProdottoQuantita> prodottiQ = new ArrayList<>();
          /*cerco il prodotto*/
          Prodotto prod = prodottoDao.doRetrieveByIdProdottoEPartitaIva(prodId, partitaIva);
          /*creo il prodottoQuantità*/
          Carrello.ProdottoQuantita proQua = new Carrello.ProdottoQuantita(prod, addNum);

          /*aggiungi elemento alla lista*/
          prodottiQ.add(proQua);

          /*aggiungi al carrello la nuova lista legata al fornitore*/
          carrello.put(prodottiQ);

        } else {
          //se già c'è la lista di prodotti assegnata a quel fornitore
          //in listaFornitori c'è già il fornitore e la sua partitaIva

          //controllo se il prodotto che voglio aggiungere c'è già o meno,  COME?

          /* vedo prima quale prodotto sto cercando quindi me lo devo cercare nel DB e creare*/

          //in prodCercato c'è il prodotto che voglio vedere se ho già aggiunto in passato
          Prodotto prodCercato = prodottoDao.doRetrieveByIdProdottoEPartitaIva(prodId, partitaIva);
          // ora devo controllare se questo prodotto appena creato c'è in prodotti1

          ArrayList<Prodotto> prodottiCont = new ArrayList<>();
          for (int i = 0; i < prodotti1.size(); i++) {
            Carrello.ProdottoQuantita prodQu = prodotti1.get(i);
            Prodotto por = prodQu.getProdotto();
            prodottiCont.add(por);
          }
          //prodottiCont ora contiene tutti i prodotti di prodotti1
          //posso ora vedere se c'è quello da me cercato
          boolean trovato = false;
          int j;
          int indice = 0;
          for (j = 0; j < prodottiCont.size(); j++) {
            Prodotto preso = prodottiCont.get(j);
            String presoP = preso.getPartitaIva();
            Integer presoI = preso.getIdProdotto();
            String cercatoP = prodCercato.getPartitaIva();
            Integer cercatoI = prodCercato.getIdProdotto();
            if (cercatoP.equals(presoP)) {
              if (cercatoI == presoI) {
                trovato = true;
                //salvo l'indice dove si dovrebbe trovare il prodotto da sostituire
                indice = j;
              }
            }
          }

          if (trovato) {
            //se c'è lo devo togliere sia da prodottiCont che da prodotti1
            Carrello.ProdottoQuantita pq1 = prodotti1.get(indice);
            prodotti1.remove(pq1);

            //aggiorno la quantità facendo + addNum
            pq1.setQuantita(pq1.getQuantita() + addNum);
            //lo rimetto con la quantità aggiornata
            prodotti1.add(pq1);
          } else {
            //se non c'è lo creo con il prodotto e la quantita
            Carrello.ProdottoQuantita pqNuovo = new Carrello.ProdottoQuantita(prodCercato, addNum);
            //e lo aggiungo a prodotti1
            prodotti1.add(pqNuovo);
          }

          //devo fare l'aggiornamento dei prodotti legati a quella partita iva prima di reiserirli
          carrello.remove(partitaIva);
          carrello.put(prodotti1);

        }

      } else {
        //caso rimozione prodotto poichè non c'è addNum
        //devo prima prendere la lista dei prodotti legati a quel fornitore
        ArrayList<Carrello.ProdottoQuantita> prodottiQuantitaF = carrello.get(partitaIva);

        //devo fare il ciclo di nuovo
        ArrayList<Prodotto> prodottiF = new ArrayList<>();
        for (int i = 0; i < prodottiQuantitaF.size(); i++) {
          Carrello.ProdottoQuantita prodQuantita = prodottiQuantitaF.get(i);
          Prodotto prodSingolo = prodQuantita.getProdotto();
          prodottiF.add(prodSingolo);
        }

        Prodotto prodottoDaEliminare =
            prodottoDao.doRetrieveByIdProdottoEPartitaIva(prodId, partitaIva);

        //prodottiF ora contiene tutti i prodotti di prodottiQuanantitaF
        boolean trovato = false;
        int j;
        int indice = 0;
        for (j = 0; j < prodottiF.size(); j++) {
          Prodotto preso = prodottiF.get(j);
          String presoPi = preso.getPartitaIva();
          Integer presoId = preso.getIdProdotto();
          String cercatoPi = prodottoDaEliminare.getPartitaIva();
          Integer cercatoId = prodottoDaEliminare.getIdProdotto();
          if (cercatoPi.equals(presoPi)) {
            if (cercatoId == presoId) {
              trovato = true;
              //salvo l'indice dove si dovrebbe trovare il prodotto da eliminare
              indice = j;
            }
          }
        }
        if (trovato) {
          //lo devo togliere da prodottiQuanantitaF
          Carrello.ProdottoQuantita pq1 = prodottiQuantitaF.get(indice);
          prodottiQuantitaF.remove(pq1);

        }

        if (!prodottiQuantitaF.isEmpty()) {
          //e mettere la lista aggiornata di nuovo nel carrello
          carrello.put(prodottiQuantitaF);
        } else if (prodottiQuantitaF.isEmpty()) {
          carrello.remove(partitaIva);
          for (int i = 0; i < listaFornitori.size(); i++) {
            Fornitore f = listaFornitori.get(i);
            if (f.getPartitaIva()
                .equals(fornitoreDao.doRetrieveByPIVA(partitaIva).getPartitaIva())) {
              listaFornitori.remove(i);
            }
          }
        }

      }
    }

    RequestDispatcher requestDispatcher =
        req.getServletContext().getRequestDispatcher("/carrello.jsp");
    requestDispatcher.forward(req, resp);
  }

}
