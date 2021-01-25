package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.POJO.Abbonamento;
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
  private MetodiDiPagamentoDAO metodoDAO;
  private Abbonamento abbonamento;
  private AbbonamentoDAO abbonamentoDAO;
  MyServletException exception = null;
  private Date data;


  @BeforeEach
  void setUp() {
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);
    sottoscrizioneAbbonamentoServlet = new SottoscrizioneAbbonamentoServlet();
    metodoDAO = new MetodiDiPagamentoDAO();

    data = new Date(2024, 01, 01);

    metodo = new MetodoPagamento();
    metodo.setCvv(278);
    metodo.setDataScadenza(new Date(2020, 01, 01));
    metodo.setPartitaIva("01391350129");
    metodo.setNumeroCarta("4522656596232265");
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
    Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn("");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Data scadenza non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCartaScaduta() {
    Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano");
    Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn(metodo.getNumeroCarta());
    Mockito.when(mockedRequest.getParameter("cvv")).thenReturn(String.valueOf(metodo.getCvv()));
    Mockito.when(mockedRequest.getParameter("dataScadenza"))
        .thenReturn(String.valueOf(metodo.getDataScadenza()));

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Carta scaduta.";

    exception = assertThrows(MyServletException.class, () -> {
      sottoscrizioneAbbonamentoServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  /* @Test
   void TestCartaSuccess() throws ServletException, IOException {
     Mockito.when(mockedRequest.getParameter("nomeIntestatario")).thenReturn("Gaetano Avino");
     Mockito.when(mockedRequest.getParameter("numeroCarta")).thenReturn("1234123412341234");
     Mockito.when(mockedRequest.getParameter("cvv")).thenReturn("123");
     Mockito.when(mockedRequest.getParameter("dataScadenza")).thenReturn(String.valueOf(data));

     Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

     Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
         .getRequestDispatcher("/areaFornitore.jsp");

     sottoscrizioneAbbonamentoServlet.doPost(mockedRequest, mockedResponse);
   }

 */
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