package Controller.Admin;

import Controller.MyServletException;
import Model.DAO.AdminDAO;
import Model.POJO.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginAdminServletTest {
    private LoginAdminServlet loginAdminServlet;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private RequestDispatcher mockedDispatcher;
    private HttpSession mockedSession;
    private Admin admin;
    private AdminDAO adminDAO;

    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        loginAdminServlet = new LoginAdminServlet();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedDispatcher = Mockito.mock(RequestDispatcher.class);
        mockedSession = Mockito.mock(HttpSession.class);

        adminDAO = new AdminDAO();

        admin = new Admin();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestEmailPasswordNull() throws ServletException, IOException {
        Mockito.when(mockedRequest.getParameter("email")).thenReturn("lucrezia.robustelli@gmail.com");
        Mockito.when(mockedRequest.getParameter("password")).thenReturn("lucry00*");

        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/adminHome.jsp");

        loginAdminServlet.doPost(mockedRequest,mockedResponse);

    }

    @Test
    void doPost() {
    }

    @Test
    void doGet() {
    }
}