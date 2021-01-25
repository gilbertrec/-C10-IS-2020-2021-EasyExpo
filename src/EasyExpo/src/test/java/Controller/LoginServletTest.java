package Controller;

import static org.junit.jupiter.api.Assertions.*;


import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import java.io.IOException;
import java.sql.SQLException;
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

class LoginServletTest extends Mockito {

  private LoginServlet loginServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private Cliente cl;
  private Fornitore fr;
  private ClienteDAO clienteDAO;
  private FornitoreDAO fornitoreDAO;

  MyServletException exception = null;

  @BeforeEach
  void setUp() {

    loginServlet = new LoginServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    fornitoreDAO = new FornitoreDAO();
    clienteDAO = new ClienteDAO();

    cl = new Cliente();
    fr = new Fornitore("01235597890", "Gaetano", "Iuliano", "3387485126", "Napoli",
        "g.iuliano@gmail.com", "password", "privato");
    fornitoreDAO.createFornitore(fr);

    cl.setCodiceFiscale("RBLKTN10C55E923W");
    cl.setNome("Lucrezia");
    cl.setCognome("Robustelli");
    cl.setTelefono("3387485126");
    cl.setEmail("l.robustelli@gmail.com");
    cl.setPassword("password");
    cl.setLuogoUbicazione("Napoli");
    clienteDAO.createCliente(cl);

  }

  @AfterEach
  void tearDown() {
    clienteDAO.deleteCliente(cl.getCodiceFiscale());
    fornitoreDAO.deleteFornitore(fr.getPartitaIva());
  }

  @Test
  void TestPasswordNull() {
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("gaetano99@gmail.com");

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    String message = "Email e/o password non validi.";

    exception = assertThrows(MyServletException.class, () -> {
      loginServlet.doPost(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailFailed() {
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("lucrezia.ro2000");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("password");

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    String message = "Email e/o password non validi.";

    exception = assertThrows(MyServletException.class, () -> {
      loginServlet.doPost(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestEmailNull() {
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("password");

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    String message = "Email e/o password non validi.";

    exception = assertThrows(MyServletException.class, () -> {
      loginServlet.doPost(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestFonitoreNull() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("gaetano99@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("gae99*");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/index.jsp");

    loginServlet.doPost(mockedRequest, mockedResponse);
    Mockito.verify(mockedServletContext).getRequestDispatcher("/index.jsp");
  }


  @Test
  void TestClienteNull() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("filly@gmail.com");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("FilBlevi78");

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/areaFornitore.jsp");

    loginServlet.doPost(mockedRequest, mockedResponse);
    Mockito.verify(mockedServletContext).getRequestDispatcher("/areaFornitore.jsp");
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}