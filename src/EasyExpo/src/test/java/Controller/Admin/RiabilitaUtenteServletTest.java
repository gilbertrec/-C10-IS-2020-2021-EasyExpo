package Controller.Admin;

import Controller.MyServletException;
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

class RiabilitaUtenteServletTest {
    private RiabilitaUtenteServlet riabilitaUtenteServletTest;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private RequestDispatcher mockedDispatcher;
    private HttpSession mockedSession;

    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        riabilitaUtenteServletTest = new RiabilitaUtenteServlet();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedDispatcher = Mockito.mock(RequestDispatcher.class);
        mockedSession = Mockito.mock(HttpSession.class);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void TestNoId() throws IOException, ServletException {
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("");
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/adminHome.jsp");

        riabilitaUtenteServletTest.doGet(mockedRequest,mockedResponse);

    }


    @Test
    void TestFlagFornitore() throws IOException, ServletException {
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("1");
        Mockito.when(mockedRequest.getParameter("id")).thenReturn("03271170361");

        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("gestioneFornitoriSospesi.jsp");

        riabilitaUtenteServletTest.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void TestFlagCliente() throws IOException, ServletException {
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("id")).thenReturn("IULGAE99C23R123R");

        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("gestioneClientiSospesi.jsp");

        riabilitaUtenteServletTest.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void doGet() throws IOException, ServletException {
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("id")).thenReturn("IULGAE99C23R123R");


        riabilitaUtenteServletTest.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void doPost() throws IOException, ServletException {
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("id")).thenReturn("IULGAE99C23R123R");


        riabilitaUtenteServletTest.doGet(mockedRequest,mockedResponse);
    }
}