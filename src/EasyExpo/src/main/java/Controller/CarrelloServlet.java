package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Carrello;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {
    private final ProdottoDAO prodottoDAO = new ProdottoDAO();
    private final FornitoreDAO fornitoreDAO = new FornitoreDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Carrello carrello = (Carrello) session.getAttribute("carrello");
        ArrayList<Fornitore> listaFornitori = (ArrayList<Fornitore>) session.getAttribute("listaFornitori");
        if (carrello == null) /*se è vuoto il carrello anche listaPI è vuota*/
        {
            carrello = new Carrello();
            session.setAttribute("carrello", carrello);
            listaFornitori = new ArrayList<>();
            session.setAttribute("listaFornitori", listaFornitori);
        }


        String prodIdStr = req.getParameter("prodId");
        String partitaIva = req.getParameter("partitaIva");

        if (prodIdStr != null) /*caso aggiunta*/
        {
            int prodId = Integer.parseInt(prodIdStr);

            String addNumStr = req.getParameter("addNum");
                if (addNumStr != null)
                {
                    ArrayList<Prodotto> prodotti1 = carrello.get(partitaIva);

                    if(prodotti1==null){  /*se la lista di prodotti assegnata a quel fornitore è vuota*/
                        /*trovo il fornitore legato a quella partita iva*/
                        Fornitore forni = fornitoreDAO.doRetrieveByPIVA(partitaIva);
                        /*e lo aggiungo alla lista dei fornitori*/
                        listaFornitori.add(forni);

                        /* crea l'array list di prodotti da aggiungere */
                        ArrayList<Prodotto> prodotti = new ArrayList<>();
                        /*aggiungi elemento alla lista*/
                        prodotti.add(prodottoDAO.doRetrieveByIdProdottoEPartitaIva(prodId,partitaIva));
                        /*aggiungi al carrello la nuova lista legata al fornitore*/
                        carrello.put(prodotti);
                    }else {//se già c'è la lista di prodotti assegnata a quel fornitore devo fare ANCHE l'aggiornamento!!
                        //in listaFornitori c'è già il fornitore e la sua partitaIva
                        //aggiungo il prodotto a prodotti1
                        prodotti1.add(prodottoDAO.doRetrieveByIdProdottoEPartitaIva(prodId,partitaIva));
                        //devo fare l'aggiornamento dei prodotti legati a quella partita iva prima di reiserirli
                        carrello.remove(partitaIva);
                        carrello.put(prodotti1);
                    }

                }else{
                        //caso rimozione prodotto
                }
        }

        RequestDispatcher requestDispatcher =  req.getRequestDispatcher("carrello.jsp");
        requestDispatcher.forward(req,resp);
    }

}
