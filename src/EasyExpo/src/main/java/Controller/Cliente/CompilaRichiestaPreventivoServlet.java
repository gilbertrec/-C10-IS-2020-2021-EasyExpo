package Controller.Cliente;

import Model.POJO.Carrello;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CompilaRichiesta")
public class CompilaRichiestaPreventivoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
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
