package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrazioneFormCliente")
public class RegistrazioneFormClienteServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("cliente") != null) {
      throw new MyServletException("Cliente loggato.");
    }
    RequestDispatcher requestDispatcher =
        request.getRequestDispatcher("WEB-INF/formRegistrazione.jsp");
    requestDispatcher.forward(request, response);
  }
}
