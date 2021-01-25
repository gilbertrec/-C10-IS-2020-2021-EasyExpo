package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SpecifichePreventiviServletTest extends Mockito {
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private SpecifichePreventiviServlet specifichePreventiviServlet;
  private HttpSession mockedSession;

  @BeforeEach
  void setUp() {
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    specifichePreventiviServlet = new SpecifichePreventiviServlet();
    mockedSession = Mockito.mock(HttpSession.class);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestIdRichiestaNull() throws ServletException, IOException {
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.when(mockedRequest.getParameter("idPreventivo")).thenReturn("7002");//esiste
    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/specificaPreventivo.jsp");

    specifichePreventiviServlet.doGet(mockedRequest, mockedResponse);
  }

  @Test
  void TestIdPreventivoNull() throws ServletException, IOException {
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");//esiste
    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/specificaRichiesta.jsp");

    specifichePreventiviServlet.doGet(mockedRequest, mockedResponse);
  }


  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}