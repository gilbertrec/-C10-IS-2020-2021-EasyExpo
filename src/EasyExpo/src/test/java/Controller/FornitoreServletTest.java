package Controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FornitoreServletTest extends Mockito{
  private FornitoreServlet fornitoreServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  MyServletException exception = null;

  @BeforeEach
  void setUp() {

    fornitoreServlet = new FornitoreServlet();
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
  void TestFornitoreNull() {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01235597111");

    String message = "Fornitore non trovato.";

    exception = assertThrows(MyServletException.class, ()->{fornitoreServlet.doGet(mockedRequest, mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}