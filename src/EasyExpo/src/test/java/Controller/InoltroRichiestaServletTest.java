package Controller;

import static org.junit.jupiter.api.Assertions.*;

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
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

    richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    richiestaPreventivo = new RichiestaPreventivo(2, cliente.getCodiceFiscale(),
        fornitore.getPartitaIva(), "matrimonio", "Napoli",
        "descizione evento prova", "nota di prova",(
        (Date)new java.util.Date(2020, 12, 22)), RichiestaPreventivo.Stato.IN_ATTESA);
    idRichiesta = richiestaPreventivoDAO.createRichiestaPreventivo(richiestaPreventivo);

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

    prodottoRichiestaDAO = new ProdottoRichiestaDAO();
    prodottoRichiesta = new ProdottoRichiesta();
    prodottoRichiesta.setId(5);
    prodottoRichiesta.setIdRichiesta(richiestaPreventivo.getIdRichiesta());
    prodottoRichiesta.setIdProdotto(prodotto.getIdProdotto());
    prodottoRichiesta.setPartitaIva(prodotto.getPartitaIva());
    prodottoRichiesta.setNumColli(6);
    prodottoRichiesta.setPrezzo(45);
    prodottoRichiesta.setDataInizioNoleggio((Date) new java.util.Date(2020,12,15));
    prodottoRichiesta.setDataFineNoleggio((Date)new java.util.Date(2021, 01, 13));
    idProdottoRichiesta = prodottoRichiestaDAO.createProdottoRichiesta(prodottoRichiesta);

    listaPCarrello = new ArrayList<>();
    carrello = new Carrello();
    prodottoQuantita = new Carrello.ProdottoQuantita(prodotto, 2);
    listaPCarrello.add(prodottoQuantita);
    carrello.put(listaPCarrello);
  }

  @AfterEach
  void tearDown() {
    clienteDAO.deleteCliente(cliente.getCodiceFiscale());
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
  }

  @Test
  void TestDataInizioNull() {
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn(prodotto.getTitolo());
    Mockito.when(mockedRequest.getParameter("luogo")).thenReturn(richiestaPreventivo.getLuogoEvento());
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn(richiestaPreventivo.getDescrizioneEvento());
    Mockito.when(mockedRequest.getParameter("dataInizio"))
        .thenReturn(String.valueOf(prodottoRichiesta.getDataInizioNoleggio()));
    Mockito.when(mockedRequest.getParameter("dataFine"))
        .thenReturn(String.valueOf(prodottoRichiesta.getDataFineNoleggio()));
    Mockito.when(mockedRequest.getParameter("corrente"))
        .thenReturn(String.valueOf(richiestaPreventivo.getDataRichiesta()));
    Mockito.when(mockedSession.getAttribute("listaProdotti")).thenReturn(listaPCarrello);
    Mockito.when(mockedSession.getAttribute("listaFornitori")).thenReturn(listaFornitori);
    Mockito.when(mockedSession.getAttribute("carrello")).thenReturn(carrello);
    Mockito.when(mockedSession.getAttribute("cliente")).thenReturn(cliente);

    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Data inizio errata.";

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