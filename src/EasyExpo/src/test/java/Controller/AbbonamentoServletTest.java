package Controller;

import static org.junit.jupiter.api.Assertions.*;

import Controller.Fornitore.AbbonamentoServlet;
import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;

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

class AbbonamentoServletTest {

  private AbbonamentoServlet abbonamentoServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private AbbonamentoDAO abbonamentoDAO;
  private MetodiDiPagamentoDAO metodoDAO;
  private  FornitoreDAO fornitoreDAO;


  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    abbonamentoServlet = new AbbonamentoServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    abbonamentoDAO = new AbbonamentoDAO();
    metodoDAO = new MetodiDiPagamentoDAO();
    fornitoreDAO = new FornitoreDAO();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestAbbonamentoNuovo() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01602620930");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/abbonamento.jsp");

    abbonamentoServlet.doPost(mockedRequest,mockedResponse);
  }

  @Test
  void TestAbbonamentoVecchio() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");

    String message = "Sei gia abbonato!";

    exception = assertThrows(MyServletException.class, () -> {abbonamentoServlet.doPost(mockedRequest,mockedResponse);});

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestAbbonamentoRinnovo() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("03271170361");

    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/rinnovo.jsp");

    abbonamentoServlet.doPost(mockedRequest,mockedResponse);
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}