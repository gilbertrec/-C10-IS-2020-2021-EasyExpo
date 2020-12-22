package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Controller.MyServletException;
import Model.DAO.AdminDAO;
import Model.POJO.Admin;

@WebServlet(name = "LoginAdmin")

public class LoginAdmin extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        AdminDAO adminDAO = new AdminDAO();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = null;

        if (email != null && password != null) {
            admin = adminDAO.doRetrieveByEmail(email);
        }
        if (admin == null) {
            throw new MyServletException("Email e/o password non validi.");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/HomeAdmin.jsp");
            requestDispatcher.forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}