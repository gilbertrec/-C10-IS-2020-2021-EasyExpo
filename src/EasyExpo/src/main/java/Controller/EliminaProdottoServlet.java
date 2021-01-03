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

@WebServlet("/ELiminaProdottoServlet")
public class EliminaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String partitaIva = request.getParameter("partitaIva");
       int id = Integer.parseInt(request.getParameter("IdProdotto"));
       System.out.println(id + partitaIva);

       ProdottoDAO prodottoDAO = new ProdottoDAO();
       prodottoDAO.deleteProdotto(id, partitaIva);
    }
}