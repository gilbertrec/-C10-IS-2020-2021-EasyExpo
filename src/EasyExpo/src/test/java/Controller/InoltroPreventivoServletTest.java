package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class InoltroPreventivoServletTest extends Mockito{

  private InoltroPreventivoServlet inoltroPreventivoServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;

  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    inoltroPreventivoServlet = new InoltroPreventivoServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestPrezzoMatchFailed(){
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("nota")).thenReturn("nota");

    String message = "Prezzo non valido.";

    exception = assertThrows(MyServletException.class, () -> {inoltroPreventivoServlet.doGet(mockedRequest,mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPrezzoNull(){
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("nota")).thenReturn("nota");

    String message = "Prezzo non valido.";

    exception = assertThrows(MyServletException.class, () -> {inoltroPreventivoServlet.doGet(mockedRequest,mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNotaNull(){
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("15.00");
    Mockito.when(mockedRequest.getParameter("nota")).thenReturn("");

    String message = "Nota non valida.";

    exception = assertThrows(MyServletException.class, () -> {inoltroPreventivoServlet.doGet(mockedRequest,mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPrezzoSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("15.00");
    Mockito.when(mockedRequest.getParameter("nota")).thenReturn("nota");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/areaFornitore.jsp");

    inoltroPreventivoServlet.doGet(mockedRequest,mockedResponse);
  }

  @Test
  void TestNotaSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("idRichiesta")).thenReturn("1000");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("IULGAE99C23R123R");
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("15.00");
    Mockito.when(mockedRequest.getParameter("nota")).thenReturn("nota");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/areaFornitore.jsp");

    inoltroPreventivoServlet.doGet(mockedRequest,mockedResponse);
  }

  @Test
  void doGet() {
  }

  @Test
  void doPost() {
  }
}