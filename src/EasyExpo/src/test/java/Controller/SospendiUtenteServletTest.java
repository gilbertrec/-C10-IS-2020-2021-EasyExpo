package Controller;

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

class SospendiUtenteServletTest extends Mockito {
  private SospendiUtenteServlet sospendiUtenteServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;

  @BeforeEach
  void setUp() {
    sospendiUtenteServlet = new SospendiUtenteServlet();
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

    sospendiUtenteServlet.doGet(mockedRequest,mockedResponse);

  }


  @Test
  void TestFlagFornitore() throws IOException, ServletException {
    Mockito.when(mockedRequest.getParameter("flag")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("03271170361");
    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("gestioneFornitori.jsp");

    sospendiUtenteServlet.doGet(mockedRequest, mockedResponse);
  }

  @Test
  void TestFlagCliente() throws IOException, ServletException {
    Mockito.when(mockedRequest.getParameter("flag")).thenReturn("2");
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("gestioneClienti.jsp");

    sospendiUtenteServlet.doGet(mockedRequest, mockedResponse);
  }

  @Test
  void doGet() {
  }

  @Test
  void doPost() {
  }
}