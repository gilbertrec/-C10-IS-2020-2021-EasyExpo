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

@WebServlet("/ModificaProdottoServlet")
public class ModificaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("prodottoId"));
        ProdottoDAO prodottodao = new ProdottoDAO() ;
        Prodotto prodotto = prodottodao.doRetrieveByIdProdotto(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/modificaProdotto.jsp");
        requestDispatcher.forward(request, response);
    }
}