package Controller;

import Model.DAO.FornitoreDAO;
import Model.POJO.Fornitore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListaFornitoriSospesiServlet")
public class ListaFornitoriSospesiServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        FornitoreDAO fornitoreDAO = new FornitoreDAO();
        List<Fornitore> fornitori = fornitoreDAO.doRetrievebyStatoSospeso(0,100);
        request.setAttribute("fornitori", fornitori);

        RequestDispatcher requestDispatcher= request.getRequestDispatcher("gestioneFornitoriSospesi.jsp");
        requestDispatcher.forward(request,response);
    }
}