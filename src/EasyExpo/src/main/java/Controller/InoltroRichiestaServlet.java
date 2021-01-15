package Controller;


import Model.DAO.FornitoreDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet("/InoltroRichiesta")
public class InoltroRichiestaServlet extends HttpServlet{
    private final FornitoreDAO fornitoreDao = new FornitoreDAO();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        ArrayList<Carrello.ProdottoQuantita> listaProdotti =
                (ArrayList<Carrello.ProdottoQuantita>) session.getAttribute("listaProdotti");
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String partitaIvaF = listaProdotti.get(0).getProdotto().getPartitaIva();
        Fornitore fornitore = fornitoreDao.doRetrieveByPIVA(partitaIvaF);

        String titolo = req.getParameter("titolo");
        String luogo = req.getParameter("luogo");
        String nota = req.getParameter("nota");
        String descrizione = req.getParameter("descrizione");
        //prendere tutte le date con AJAX?
        Date dataInizio = Date.valueOf(req.getParameter("dataInizio"));
        Date dataFine = Date.valueOf(req.getParameter("dataFine"));

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

        RichiestaPreventivoDAO richiestaPreventivoDAO = new RichiestaPreventivoDAO();
        richiestaPreventivoDAO.createRichiestaPreventivo(rp);


        for(int i=0; i<listaProdotti.size(); i++){
            ProdottoRichiesta pr = new ProdottoRichiesta();
            //L'ID NON BISOGNA AGGIUNGERLO PERCHE' E' AUTOGENERATO, GIUSTO?
            pr.setIdRichiesta(rp.getIdRichiesta());
            pr.setIdProdotto(listaProdotti.get(i).getProdotto().getIdProdotto());
            pr.setPartitaIva(partitaIvaF);
            pr.setNumColli(listaProdotti.get(i).getQuantita());
            pr.setPrezzo(listaProdotti.get(i).getProdotto().getPrezzo());


            pr.setDataInizioNoleggio(dataInizio);
            pr.setDataFineNoleggio(dataFine);

        }




        RequestDispatcher requestDispatcher = req.getRequestDispatcher("carrello.jsp");
        requestDispatcher.forward(req, resp);
    }

}
