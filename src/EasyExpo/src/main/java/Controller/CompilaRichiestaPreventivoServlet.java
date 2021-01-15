package Controller;

import Model.POJO.Carrello;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;

@WebServlet("/CompilaRichiesta")
public class CompilaRichiestaPreventivoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   doPost(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    Carrello carrello = (Carrello) session.getAttribute("carrello");
    String partitaIva = request.getParameter("fornitore");
    ArrayList<Carrello.ProdottoQuantita> listaProdotti = carrello.get(partitaIva);

    request.getSession().setAttribute("listaProdotti", listaProdotti);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("richiestaPreventivo.jsp");
    requestDispatcher.forward(request, response);
  }
}
