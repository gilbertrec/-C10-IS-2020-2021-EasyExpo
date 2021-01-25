package Controller;

import static org.junit.jupiter.api.Assertions.*;

import Model.DAO.ClienteDAO;
import Model.POJO.Cliente;
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


class RegistrazioneClienteServletTest extends Mockito {
  private RegistrazioneClienteServlet registrazioneClienteServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private Cliente cliente1;
  private Cliente cliente2;
  private String nome;
  private String cognome;
  private String email;
  private String password;
  private String passwordConferma;
  private String luogoUbicazione;
  private String telefono;
  private String codiceFiscale;
  private ClienteDAO cl;
  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    registrazioneClienteServlet = new RegistrazioneClienteServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    cl = new ClienteDAO();
    cliente1 = new Cliente();
    cliente1.setCodiceFiscale("IULGAE99C23R123R");
    cliente1.setNome("Gaetano");
    cliente1.setCognome("Iuliano");
    cliente1.setTelefono("3998765987");
    cliente1.setEmail("gaetano99@gmail.com");
    cliente1.setPassword("gae99*");
    cliente1.setLuogoUbicazione("Terzigno");

    cliente2 = new Cliente();
    cliente2.setCodiceFiscale("BRZRTN02L50C278F");
    cliente2.setNome("Giuseppe");
    cliente2.setCognome("Avino");
    cliente2.setTelefono("3319636797");
    cliente2.setEmail("peppe0113@gmail.com");
    cliente2.setPassword("Peppe9999_");
    cliente2.setLuogoUbicazione("Terzigno");
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestClienteLoggato() {
    Mockito.when(mockedSession.getAttribute("cliente")).thenReturn(String.valueOf(cliente1));
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999*");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999*");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cliente loggato.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Email non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Email non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordSizeFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("pepp");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999*");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordMatchFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("peppihcruvveubiuch");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999*");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordNull() {
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999*");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Password non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordConfermaFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("pepp");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02L50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Le password non combaciano.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPasswordConfermaNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02L50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Le password non combaciano.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestNomeFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("12");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }


  @Test
  void TestNomeNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Nome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCognomeMatchFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCognomeSizeFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCognomeNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Cognome non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestluogoUbicazioneMatchFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("22");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestluogoUbicazioneSizeFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestluogoUbicazioneNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Luogo di ubicazione non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestTelefonoFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("11111");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero di telefono non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestTelefonoNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("BRZRTN02H50C294F");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Numero di telefono non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCodiceFiscaleFailed() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("GWGWF2");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "CodiceFiscale non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestCodiceFiscaleNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Giuseppe");
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("peppe0113@gmail.com");
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn("Avino");
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn("Terzigno");
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn("3319636797");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "CodiceFiscale non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      registrazioneClienteServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestClienteSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn(cliente2.getPassword());
    Mockito.when(mockedRequest.getParameter("passwordConferma")).thenReturn("Peppe9999_");
    Mockito.when(mockedRequest.getParameter("nome")).thenReturn(cliente2.getNome());
    Mockito.when(mockedRequest.getParameter("email")).thenReturn(cliente2.getEmail());
    Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn(cliente2.getCodiceFiscale());
    Mockito.when(mockedRequest.getParameter("cognome")).thenReturn(cliente2.getCognome());
    Mockito.when(mockedRequest.getParameter("luogoUbicazione")).thenReturn(cliente2.getLuogoUbicazione());
    Mockito.when(mockedRequest.getParameter("telefono")).thenReturn(cliente2.getTelefono());

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/login.jsp");

    registrazioneClienteServlet.doPost(mockedRequest,mockedResponse);
    cl.deleteCliente(cliente2.getCodiceFiscale());

  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}