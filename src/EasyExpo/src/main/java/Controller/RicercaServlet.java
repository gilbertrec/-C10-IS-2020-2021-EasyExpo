package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String json;

        ProdottoDAO prodottoDao = new ProdottoDAO();

        FornitoreDAO fornitoreDAO = new FornitoreDAO();

        String search = request.getParameter("search");


        List<Prodotto> prodotti = prodottoDao.doRetrieveByTitolo(search);
        List<Fornitore> fornitori = fornitoreDAO.doRetrieveByNome(search);


        if(prodotti!=null){
            json = "[";
            Boolean first = true;
            for(int i = 0; i < prodotti.size(); i++){
                if(!first)
                    json += ",";
                json += "{"+
                        "\"id\":\"" + prodotti.get(i).getIdProdotto() + "\","+
                        "\"partitaIVA\":\"" + prodotti.get(i).getPartitaIva() + "\","+
                        "\"titolo\":\""+prodotti.get(i).getTitolo()+"\"" +
                        "}";
                first = false;
            }
            json += "]";

            resp = "[{\"success\":true,\"data\":"+json+"}]";
        }
        else
            resp="[{\"success\":false,\"message\":\"la lista ricercata non c'è\"}]";

        response.getWriter().append(resp);
    }
}
