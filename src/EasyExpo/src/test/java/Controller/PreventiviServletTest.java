package Controller;

import Controller.Preventivo.PreventiviServlet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class PreventiviServletTest {
    private PreventiviServlet preventiviServlet;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private RequestDispatcher mockedDispatcher;
    private HttpSession mockedSession;

    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        preventiviServlet = new PreventiviServlet();
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
    void doPost() {
    }

    @Test
    void doGet() {
    }
}