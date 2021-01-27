package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.TagDAO;
import Model.DAO.TagProdottoDAO;
import Model.POJO.Prodotto;
import Model.POJO.TagProdotto;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RicercaServletTest {
  private RicercaServlet ricercaServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;

  private TagProdotto tagProdotto;
  private ProdottoDAO prodottoDAO;
  private FornitoreDAO fornitoreDAO;
  private TagDAO tagDAO;
  private TagProdottoDAO tagProdottoDAO;
  private List<Prodotto> prodotti;
  private PrintWriter print;


  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    ricercaServlet = new RicercaServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    tagProdotto = new TagProdotto();
    fornitoreDAO = new FornitoreDAO();
    prodottoDAO = new ProdottoDAO();
    tagProdottoDAO = new TagProdottoDAO();
    tagDAO = new TagDAO();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void TestRicercaProdotti() throws IOException {
    Mockito.when(mockedRequest.getParameter("search")).thenReturn("Casse");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void TestRicercaFornitori() throws IOException {
    Mockito.when(mockedRequest.getParameter("search")).thenReturn("Nicola");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void TestRicercaTag() throws IOException {
    Mockito.when(mockedRequest.getParameter("search")).thenReturn("musica");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void TestRicercaFornitoriProdotti() throws IOException {
    Mockito.when(mockedRequest.getParameter("search")).thenReturn("ca");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void TestRicercaProdottieFornitori() throws IOException {
    Mockito.when(mockedRequest.getParameter("search")).thenReturn("f");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void TestRicercaVuoto() throws IOException {
    //Mockito.when(mockedRequest.getParameter("search")).thenReturn("");

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);
    Mockito.when(mockedResponse.getWriter()).thenReturn(writer);

    ricercaServlet.doPost(mockedRequest, mockedResponse);
  }


  @Test
  void doGet() {
  }

  @Test
  void doPost() {
  }
}