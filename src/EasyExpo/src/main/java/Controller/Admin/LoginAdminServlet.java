package Controller.Admin;

import Controller.HttpServlet;
import Model.DAO.AdminDAO;
import Model.POJO.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Admin admin = null;
        if (email != null && password != null) {
            admin = adminDAO.doRetrieveByEmailandPassword(email, password);
        }
        if (admin == null) {
            request.getSession().setAttribute("Errore",1);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminLoginSegreto.jsp");
            requestDispatcher.forward(request,response);
        }else {
            request.getSession().setAttribute("LeaderSupremo", admin);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/adminHome.jsp");
            requestDispatcher.forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
