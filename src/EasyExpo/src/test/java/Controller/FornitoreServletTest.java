package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Fornitore.FornitoreServlet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FornitoreServletTest extends Mockito {
  private FornitoreServlet fornitoreServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  MyServletException exception = null;

  @BeforeEach
  void setUp() {

    fornitoreServlet = new FornitoreServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
  }

  @AfterEach
  void tearDown() {

  }

  @Test
  void TestFornitoreNull() {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01235597111");

    String message = "Fornitore non trovato.";

    exception = assertThrows(MyServletException.class, () -> {
      fornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }


  @Test
  void TestFornitoreSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("03271170361");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/specificheFornitore.jsp");

    fornitoreServlet.doGet(mockedRequest, mockedResponse);
  }


  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}