package Controller;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AggiungiProdottoServlet")
public class AggiungiProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String partitaIva = request.getParameter("partitaIva");
        String titolo = request.getParameter("titolo");
        String tipo = request.getParameter("tipo");
        float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        String descrizione = request.getParameter("descrizione");
        //foto
        Prodotto prodotto = new Prodotto();
        prodotto.setPartitaIva(partitaIva);
        prodotto.setTitolo(titolo);
        prodotto.setDescrizione(descrizione);
        prodotto.setTipo(Prodotto.Tipo.valueOf(tipo));
        prodotto.setQuantità(quantita);
        prodotto.setPrezzo(prezzo);
        ProdottoDAO prodottodao = new ProdottoDAO();
        prodottodao.createProdotto(prodotto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/aggiuntaProdotto.jsp");
        requestDispatcher.forward(request, response);
    }
}