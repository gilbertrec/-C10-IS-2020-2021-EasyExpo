package Controller;

import static org.junit.jupiter.api.Assertions.*;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistrazioneClienteServletTest {

  private LoginServlet loginServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private Cliente cl;
  private ClienteDAO clienteDAO;

  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    loginServlet = new LoginServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    cl = new Cliente();
    clienteDAO = new ClienteDAO();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestEmailError(){
    Mockito.when(mockedRequest.getParameter("email")).thenReturn("");
    Mockito.when(mockedRequest.getParameter("password")).thenReturn("password");

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

    String message = "Email e/o password non validi.";

    exception = assertThrows(MyServletException.class, ()->{loginServlet.doPost(mockedRequest, mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}