package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.TagDAO;
import Model.DAO.TagProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.Tag;
import Model.POJO.TagProdotto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RicercaServlet")
public class RicercaServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, NumberFormatException {
        String resp;
        String json = "[";
        Boolean first;
        first = true;

        ProdottoDAO prodottoDao = new ProdottoDAO();

        FornitoreDAO fornitoreDAO = new FornitoreDAO();

        TagDAO tagDAO = new TagDAO();

        TagProdottoDAO tagProdottoDAO = new TagProdottoDAO();

        String search = request.getParameter("search");


        List<Prodotto> prodotti = prodottoDao.doRetrieveByTitolo(search);
        List<Fornitore> fornitori = fornitoreDAO.doRetrieveByNome(search);
        List<Tag> tag = tagDAO.doRetrieveByNome(search);



        for (int i = 0; i < prodotti.size(); i++) {
            if (!first)
                json += ",";
            json += "{" +
                    "\"id\":\"" + prodotti.get(i).getIdProdotto() + "\"," +
                    "\"partitaIVA\":\"" + prodotti.get(i).getPartitaIva() + "\"," +
                    "\"titolo\":\"" + prodotti.get(i).getTitolo() + "\"" +
                    "}";
            first = false;
        }

        for (int i = 0; i < fornitori.size(); i++) {
            if (!first) /* se è passato da prodotti mette la virgola poichè first è stato settato già a false*/
                /* se non è passato da prodotti non mette la virgola perchè è settato a true */
                json += ",";

            json += "{" +
                    "\"partitaIVAfornitore\":\"" + fornitori.get(i).getPartitaIva() + "\"," +
                    "\"nome\":\"" + fornitori.get(i).getNome() + "\"" +
                    "}";
            first = false;
        }

        //TAG
        for(int j=0; j<tag.size(); j++){
            int idTag = tag.get(j).getIdTag();
            TagProdotto tagProdotto = tagProdottoDAO.doRetrieveByIdTag(idTag);
            int idProdotto = tagProdotto.getIdProdotto();
            String partitaIva = tagProdotto.getPartitaIva();
            Prodotto prod = prodottoDao.doRetrieveByIdProdottoEPartitaIva(idProdotto, partitaIva);

            /* deve mettere la virgola se fornitori o prodotti o entrambi non sono vuote*/
            /* non la deve mettere se entrambe le liste sono vuote */
            if (!first)
                json += ",";
            json += "{" +
                    "\"id\":\"" + prod.getIdProdotto() + "\"," +
                    "\"partitaIVA\":\"" + prod.getPartitaIva() + "\"," +
                    "\"titolo\":\"" + prod.getTitolo() + "\"" +
                    "}";
        }


        json += "]";

        resp = "[{\"success\":true,\"data\":"+json+"}]";



        response.getWriter().append(resp);
    }
}
