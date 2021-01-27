package Controller;

import static org.junit.jupiter.api.Assertions.*;

import Controller.Cliente.InoltroRichiestaServlet;
import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.ProdottoRichiestaDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Carrello;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
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

class InoltroRichiestaServletTest extends Mockito {
  private InoltroRichiestaServlet inoltroRichiestaServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  MyServletException exception = null;
  private ProdottoRichiesta prodottoRichiesta;
  private RichiestaPreventivo richiestaPreventivo;
  private ArrayList<Prodotto> listaProdotti;
  private ArrayList<Fornitore> listaFornitori;
  private ArrayList<Carrello.ProdottoQuantita> listaPCarrello;
  private Cliente cliente;
  private ClienteDAO clienteDAO;
  private Fornitore fornitore;
  private FornitoreDAO fornitoreDAO;
  private Prodotto prodotto;
  private ProdottoDAO prodottoDAO;
  private RichiestaPreventivoDAO richiestaPreventivoDAO;
  private ProdottoRichiestaDAO prodottoRichiestaDAO;
  private Carrello carrello;
  private Carrello.ProdottoQuantita prodottoQuantita;
  private int idProdotto;
  private int idProdottoRichiesta;
  private int idRichiesta;
  private java.util.Date data;

  private java.sql.Date corrente;

  @BeforeEach
  void setUp() {
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);
    inoltroRichiestaServlet = new InoltroRichiestaServlet();
    listaFornitori = new ArrayList<>();
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("99999999999", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);
    listaFornitori.add(fornitore);

    clienteDAO = new ClienteDAO();
    cliente = new Cliente();
    cliente.setCodiceFiscale("baoJtA98d55E923o");
    cliente.setNome("Lucrezia");
    cliente.setCognome("Robustelli");
    cliente.setTelefono("3387485126");
    cliente.setEmail("l.robustelli@gmail.com");
    cliente.setPassword("password");
    cliente.setLuogoUbicazione("Napoli");
    clienteDAO.createCliente(cliente);

    prodottoDAO = new ProdottoDAO();
    prodotto = new Prodotto();
    prodotto.setIdProdotto(3);
    prodotto.setPartitaIva(fornitore.getPartitaIva());
    prodotto.setTitolo("Casse");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = prodottoDAO.createProdotto(prodotto);
    listaProdotti = new ArrayList<>();
    listaProdotti.add(prodotto);

    listaPCarrello = new ArrayList<>();
    carrello = new Carrello();
    prodottoQuantita = new Carrello.ProdottoQuantita(prodotto, 2);
    listaPCarrello.add(prodottoQuantita);
    carrello.put(listaPCarrello);
    data = new Date(2018, 11, 12);

    corrente = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    richiestaPreventivo = new RichiestaPreventivo(1000, "baoJtA98d55E923o", "99999999999",
             "titolo", "Napoli", "descrizioneEvento",
            "nota", corrente, RichiestaPreventivo.Stato.IN_ATTESA);

    prodottoRichiesta = new ProdottoRichiesta(4000, 1000, idProdotto, "99999999999", 3,
            30, new Date(2021, 11, 12), new Date(2022, 11, 12));
    prodottoRichiestaDAO = new ProdottoRichiestaDAO();
    prodottoRichiestaDAO.createProdottoRichiesta(prodottoRichiesta);



  }

  @AfterEach
  void tearDown() {
    clienteDAO.deleteCliente(cliente.getCodiceFiscale());
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
  }

  @Test
  void TestSuccess() throws ServletException, IOException {
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("concerto");
    Mockito.when(mockedRequest.getParameter("luogo")).thenReturn("nola");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto bello");
    Mockito.when(mockedRequest.getParameter("dataInizio0"))
            .thenReturn(String.valueOf(new Date(2012, 01, 20)));
    Mockito.when(mockedRequest.getParameter("dataFine0"))
            .thenReturn(String.valueOf(new Date(2013, 01, 18)));
    Mockito.when(mockedSession.getAttribute("listaProdotti")).thenReturn(listaPCarrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("cliente")).thenReturn(cliente);

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);


    Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
    Mockito.doReturn(mockedDispatcher).when(mockedServletContext)
            .getRequestDispatcher("/carrello.jsp");

    inoltroRichiestaServlet.doPost(mockedRequest, mockedResponse);
  }


  @Test
  void TestDataFineErrata() {
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("concerto");
    Mockito.when(mockedRequest.getParameter("luogo")).thenReturn("nola");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto bello");
    Mockito.when(mockedRequest.getParameter("dataFine0"))
        .thenReturn(String.valueOf(new Date(2025, 01, 29)));
    Mockito.when(mockedRequest.getParameter("dataInizio0"))
            .thenReturn(String.valueOf(new Date(2025, 11, 12)));
    /*Mockito.when(mockedRequest.getParameter("dataInizio1"))
        .thenReturn(String.valueOf(new Date(2025, 01, 27)));
    Mockito.when(mockedRequest.getParameter("dataFine1"))
        .thenReturn(String.valueOf(new Date(2025, 01, 30)));*/
    Mockito.when(mockedSession.getAttribute("listaProdotti")).thenReturn(listaPCarrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("cliente")).thenReturn(cliente);

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Data fine errata.";

    exception = assertThrows(MyServletException.class, () -> {
      inoltroRichiestaServlet.doPost(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }



  @Test
  void doGet() {
  }

  @Test
  void doPost() {
  }
}