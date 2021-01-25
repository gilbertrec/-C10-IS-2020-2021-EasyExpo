package Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Model.DAO.FornitoreDAO;
import Model.POJO.Fornitore;
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

class RegistrazioneFornitoreServletTest extends Mockito {

  private RegistrazioneFornitoreServlet registrazioneFornitoreServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private Fornitore fornitore;
  private Fornitore fornitore1;
  private FornitoreDAO fornitoreDAO;
  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    registrazioneFornitoreServlet = new RegistrazioneFornitoreServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore();
    fornitore.setPartitaIva("03271170361");
    fornitore.setNome("Susanna");
    fornitore.setCognome("Zaidane");
    fornitore.setTelefono("3249878965");
    fornitore.setEmail("zaidane68a@mailstop.it");
    fornitore.setPassword("SusannaZ68");
    fornitore.setLuogoUbicazione("Modena");
    fornitore.setRagioneSociale("privato");

    fornitore1 = new Fornitore();
    fornitore1.setPartitaIva("12345678902");
    fornitore1.setNome("Giuseppe");
    fornitore1.setCognome("Avino");
    fornitore1.setTelefono("3249878111");
    fornitore1.setEmail("peppe.avino12@gmail.com");
    fornitore1.setPassword("Peppe888_");
    fornitore1.setLuogoUbicazione("Roma");
    fornitore1.setRagioneSociale("privato");
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestFornitoreLoggato() {
    Mockito.when(mockedSession.getAttribute("fornitore")).thenReturn("fornitore");
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Fornitore loggato.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordSizeFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("2xneuecbcij");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordConfermaFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Le password non combaciano.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNomeFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("23");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNomeNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("jcn@m.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Email non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Email non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPartitaIvaMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("po_uchuenicec");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Partita Iva non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPartitaIvaNull() {
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Partita Iva non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }


  @Test
  void TestCognomeSizeFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCognomeMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("55");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCognomeNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestLuoboUbicazioneSizeFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestLuoboUbicazioneMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("22");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestLuoboUbicazioneNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestTelefonoMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("yu&/()=)(/&78");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero di telefono non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestTelefonoNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("privato");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero di telefono non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestRagioneSocialeMatchFailed() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");
    Mockito.when(mockedRequest.getParameter("ragioneSociale")).thenReturn("");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Ragione sociale non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestRagioneSocialeNull() {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn("12345678909");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3249878111");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe.avino12@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Roma");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Ragione sociale non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestFornitoreSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIVA")).thenReturn(fornitore1.getPartitaIva());
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn(fornitore1.getNome());
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn(fornitore1.getCognome());
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn(fornitore1.getTelefono());
    Mockito.when(mockedRequest.getParameter("email")).thenReturn(fornitore1.getEmail());
    Mockito.when(mockedRequest.getParameter("password")).thenReturn(fornitore1.getPassword());
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe888_");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione"))
        .thenReturn(fornitore1.getLuogoUbicazione());
    Mockito.when(mockedRequest.getParameter("ragioneSociale"))
        .thenReturn(fornitore1.getRagioneSociale());

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/login.jsp");

    registrazioneFornitoreServlet.doGet(mockedRequest, mockedResponse);
    fornitoreDAO.deleteFornitore(fornitore1.getPartitaIva());
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}