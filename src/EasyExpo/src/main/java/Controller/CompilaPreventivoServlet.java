package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;

@WebServlet("/CompilaPreventivoServlet")
public class CompilaPreventivoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/preventivo.jsp");
    requestDispatcher.forward(request, response);
  }
}
