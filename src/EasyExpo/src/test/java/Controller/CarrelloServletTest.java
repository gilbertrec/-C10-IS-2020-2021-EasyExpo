package Controller;

import Model.DAO.AbbonamentoDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.MetodiDiPagamentoDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Carrello;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.io.IOException;
import java.util.ArrayList;
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

class CarrelloServletTest {

  private CarrelloServlet carrelloServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  private AbbonamentoDAO abbonamentoDAO;
  private MetodiDiPagamentoDAO metodoDAO;
  private FornitoreDAO fornitoreDAO;
  private Fornitore fornitore1;
  private ArrayList<Fornitore> listaFornitori;
  private Carrello carrello;
  private Carrello.ProdottoQuantita prodottoQuantita;
  private Prodotto prodotto;
  private ProdottoDAO prodottoDAO;
  private int idProdotto;
  private ArrayList<Carrello.ProdottoQuantita> listaProdotto;


  MyServletException exception = null;

  @BeforeEach
  void setUp() {
    carrelloServlet = new CarrelloServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);

    abbonamentoDAO = new AbbonamentoDAO();
    metodoDAO = new MetodiDiPagamentoDAO();
    fornitoreDAO = new FornitoreDAO();

    fornitore1 = new Fornitore("01234567890", "Gaetano","Iuliano","3387485126", "Napoli", "g.iuliano@gmail.com", "password", "privato");
    fornitoreDAO.createFornitore(fornitore1);

    prodotto = new Prodotto();
    prodottoDAO = new ProdottoDAO();
    prodotto.setIdProdotto(2);
    prodotto.setPartitaIva(fornitore1.getPartitaIva());
    prodotto.setTitolo("Panca");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = prodottoDAO.createProdotto(prodotto);

    listaProdotto = new ArrayList<>();
    carrello = new Carrello();
    prodottoQuantita = new Carrello.ProdottoQuantita(prodotto, 2);
    listaProdotto.add(prodottoQuantita);
    carrello.put(listaProdotto);

    listaFornitori = new ArrayList<>();
    listaFornitori.add(fornitore1);
  }

  @AfterEach
  void tearDown() {
    fornitoreDAO.deleteFornitore(fornitore1.getPartitaIva());
  }


  @Test
  void testCarrelloVuoto() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(null);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(null);

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void testCarrelloPieno() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);

    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
        .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void testAggiuntaProdotto() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedRequest.getParameter("prodId")).thenReturn(String.valueOf(idProdotto));
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn(fornitore1.getPartitaIva());
    Mockito.when(mockedRequest.getParameter("addNum")).thenReturn("2");


    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void testNuovoProdottoFornitore() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedRequest.getParameter("prodId")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("addNum")).thenReturn("1");


    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void testModificaQuantitaProdotto() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedRequest.getParameter("prodId")).thenReturn(String.valueOf(idProdotto));
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn(fornitore1.getPartitaIva());



    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }

  @Test
  void testRimozioneProdotto() throws ServletException, IOException {

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedRequest.getParameter("prodId")).thenReturn(String.valueOf(idProdotto));
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn(fornitore1.getPartitaIva());



    Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/carrello.jsp");

    carrelloServlet.doPost(mockedRequest, mockedResponse);
  }


  @Test
  void doGet() {
  }

  @Test
  void doPost() {
  }
}