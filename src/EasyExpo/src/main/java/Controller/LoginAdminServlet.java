package Controller;

import java.io.IOException;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.AdminDAO;
import Model.POJO.Admin;

@WebServlet(name = "LoginAdminServlet")

public class LoginAdminServlet extends HttpServlet {

    private final AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        Admin admin = null;

        if (username != null && password != null) {
            admin = adminDAO.doRetrieveByEmailPassword(email, password);
        }

        if (admin == null) {
            response.sendRedirect(".");
            return;
        } else {
            request.getSession().setAttribute("admin", admin);
            response.sendRedirect("AreaAdmin");
            return;
        }
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            doPost(request, response);
        }

}
