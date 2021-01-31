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
  void TestClienteNull() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/listaPreventivi.jsp");

    preventiviServlet.doGet(mockedRequest, mockedResponse);

  }

  @Test
  void TestClienteFornitoreNull() throws ServletException, IOException {

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/listaPreventivi.jsp");

    preventiviServlet.doGet(mockedRequest, mockedResponse);

  }

  @Test
  void TestFornitoreNull() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/listaPreventivi.jsp");

    preventiviServlet.doGet(mockedRequest, mockedResponse);

  }

  @Test
  void TestNotNull() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");


    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/listaPreventivi.jsp");

    preventiviServlet.doGet(mockedRequest, mockedResponse);

  }


  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}