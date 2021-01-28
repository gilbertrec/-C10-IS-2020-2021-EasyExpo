package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

class ProdottoServletTest {
  private ProdottoServlet prodottoServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;

  MyServletException exception = null;


  @BeforeEach
  void setUp() {
    prodottoServlet = new ProdottoServlet();
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
  void TestProdottoNull() {
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("18");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");

    String message = "Prodotto non trovato.";

    exception = assertThrows(MyServletException.class, () -> {
      prodottoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestIdNull() {
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("cs");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129sdchghbdc");

    String message = "Id prodotto non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      prodottoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestProdottoSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/specificheProdotto.jsp");

    prodottoServlet.doGet(mockedRequest, mockedResponse);
  }

  @Test
  void TestProdottoSuccessTag() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("id")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("03271170361");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/specificheProdotto.jsp");

    prodottoServlet.doGet(mockedRequest, mockedResponse);
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}