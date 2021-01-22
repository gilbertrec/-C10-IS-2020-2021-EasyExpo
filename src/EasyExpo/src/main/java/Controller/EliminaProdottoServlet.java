package Controller;

import Model.DAO.ProdottoDAO;
import Model.POJO.Prodotto;

import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EliminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String partitaIva = request.getParameter("partitaIva");
         int id = Integer.parseInt(request.getParameter("id"));
         System.out.println(id + partitaIva);

         ProdottoDAO prodottoDAO = new ProdottoDAO();
         prodottoDAO.deleteProdotto(id, partitaIva);
         List<Prodotto> prodotti = prodottoDAO.doRetrieveByPartitaIva(partitaIva);
         request.getSession().setAttribute("prodotti", prodotti);


         if(request.getSession().getAttribute("LeaderSupremo") != null){
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("/gestioneProdotti.jsp");
             requestDispatcher.forward(request, response);
         }

         RequestDispatcher requestDispatcher = request.getRequestDispatcher("/areaFornitore.jsp");
         requestDispatcher.forward(request, response);


    }
}