package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Model.POJO.MetodoPagamento;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SottoscrizioneAbbonamentoServletTest extends Mockito {
  private SottoscrizioneAbbonamentoServlet sottoscrizioneAbbonamentoServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private MetodoPagamento metodo;
  MyServletException exception = null;


  @BeforeEach
  void setUp() {
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);
    sottoscrizioneAbbonamentoServlet = new SottoscrizioneAbbonamentoServlet();

    metodo = new MetodoPagamento();
    metodo.setCvv(278);
    metodo.setDataScadenza(new Date(2020, 01, 01));
    metodo.setPartitaIva("01391350129");
    metodo.setNumeroCarta("1234432112344321");
  }

  @Test
  void TestNomeIntestatarioMatchFailed() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome intestatario non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNomeIntestatarioNull() {
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome intestatario non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNumeroCartaMatchFailed() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero carta non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNumeroCartaEsistente() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1452896574587589");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero carta non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNumeroCartaNull() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero carta non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCvvMatchFailed() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cvv non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCvvNull() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("20210113");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cvv non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestDataScadenzaNull() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Data scadenza non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestDataScadenzaMatchFailed() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234567890987654");
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("321");
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Data scadenza non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
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