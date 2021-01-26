package Controller;

import static org.junit.jupiter.api.Assertions.*;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
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

class ModificaAvvenutaServletTest {

  private ModificaAvvenutaServlet modificaAvvenutaServlet;
  private HttpServletRequest mockedRequest;
  private HttpServletResponse mockedResponse;
  private ServletContext mockedServletContext;
  private RequestDispatcher mockedDispatcher;
  private HttpSession mockedSession;
  MyServletException exception = null;
  private Prodotto prodotto;
  private FornitoreDAO fornitoreDAO;
  private Fornitore fornitore;
  private ProdottoDAO pr;
  private int idProdotto;

  @BeforeEach
  void setUp() {
    modificaAvvenutaServlet = new ModificaAvvenutaServlet();
    mockedRequest = Mockito.mock(HttpServletRequest.class);
    mockedResponse = Mockito.mock(HttpServletResponse.class);
    mockedServletContext = Mockito.mock(ServletContext.class);
    mockedDispatcher = Mockito.mock(RequestDispatcher.class);
    mockedSession = Mockito.mock(HttpSession.class);


    pr = new ProdottoDAO();
    prodotto = new Prodotto();
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567880", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);
    prodotto.setIdProdotto(2);
    prodotto.setPartitaIva(fornitore.getPartitaIva());
    prodotto.setTitolo("Panca");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = pr.createProdotto(prodotto);
  }

  @AfterEach
  void tearDown() {
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
  }

  @Test
  void TestTitoloFailed() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse*");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Titolo non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestTitoloNull() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Titolo non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPrezzoMatchFailed() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("uveiur");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Prezzo non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestPrezzoNull() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Prezzo non valido.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }


  @Test
  void TestQuantitaMatchFailed() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("3tyu");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Quantità non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestQuantitaNull() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Quantità non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestDescrizioneMatchFailed() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");
    Mockito.when(mockedRequest.getParameter("descrizione")).thenReturn("molto belle23");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Descrizione non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void TestDescrizioneNull() {
    Mockito.when(mockedRequest.getParameter("idProdotto")).thenReturn("1");
    Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");
    Mockito.when(mockedRequest.getParameter("titolo")).thenReturn("Casse");
    Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(String.valueOf(Prodotto.Tipo.ATTREZZATURA));
    Mockito.when(mockedRequest.getParameter("prezzo")).thenReturn("30.00");
    Mockito.when(mockedRequest.getParameter("quantita")).thenReturn("34");


    Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);

    String message = "Descrizione non valida.";

    exception = assertThrows(MyServletException.class, () -> {
      modificaAvvenutaServlet.doGet(mockedRequest, mockedResponse);
    });

    assertEquals(message, exception.getMessage());
  }

  @Test
  void doPost() {
  }

  @Test
  void doGet() {
  }
}