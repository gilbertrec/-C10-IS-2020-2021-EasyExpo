package Controller;

import Model.DAO.FornitoreDAO;
import Model.POJO.Fornitore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaFornitoriSospesiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        FornitoreDAO fornitoreDAO = new FornitoreDAO();
        List<Fornitore> fornitori = fornitoreDAO.doRetrieveAll(0,100);
        request.setAttribute("fornitori", fornitori);


    }
}