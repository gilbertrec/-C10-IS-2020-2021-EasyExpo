package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getSession().removeAttribute("cliente");
    request.getSession().removeAttribute("fornitore");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
    requestDispatcher.forward(request, response);

  }

}