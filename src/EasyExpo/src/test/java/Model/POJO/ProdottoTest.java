package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdottoTest {

  @BeforeEach
  void setUp() {
    prodotto = new Prodotto(1,"012345690","Cassa","Cassa audio",tipo.ATTREZZATURA,5,50,"foto");
  }

  @AfterEach
  void tearDown() {
    prodotto = new Prodotto(1,"012345690","Cassa","Cassa audio",tipo.ATTREZZATURA,5,50,"foto");
  }
  @Test
  void testProdottoCostructorEmpty() {
    prodotto = new Prodotto();
    assertNotNull(prodotto);
  }
  @Test
  void getIdProdotto() {
    assertEquals(1,prodotto.getIdProdotto());
  }

  @Test
  void setIdProdotto() {
    prodotto.setIdProdotto(2);
    assertEquals(2,prodotto.getIdProdotto());
  }

  @Test
  void getPartitaIva() {
    assertEquals("012345690",prodotto.getPartitaIva());
  }

  @Test
  void setPartitaIva() {
    prodotto.setPartitaIva("00000000000");
    assertEquals("00000000000",prodotto.getPartitaIva());
  }

  @Test
  void getTitolo() {
    assertEquals("Cassa",prodotto.getTitolo());
  }

  @Test
  void setTitolo() {
    prodotto.setTitolo("Cassa audio");
    assertEquals("Cassa audio",prodotto.getTitolo());
  }

  @Test
  void getDescrizione() {
    assertEquals("Cassa audio",prodotto.getDescrizione());
  }

  @Test
  void setDescrizione() {
    prodotto.setDescrizione("Cassa audio per esterno e interno");
    assertEquals("Cassa audio per esterno e interno",prodotto.getDescrizione());
  }

  @Test
  void getTipo() {
    assertEquals(tipo.ATTREZZATURA,prodotto.getTipo());
  }

  @Test
  void setTipo() {
    prodotto.setTipo(tipo.SERVIZIO);
    assertEquals(tipo.SERVIZIO,prodotto.getTipo());
  }

  @Test
  void getQuantità() {
    assertEquals(5,prodotto.getQuantità());
  }

  @Test
  void setQuantità() {
    prodotto.setQuantità(3);
    assertEquals(3,prodotto.getQuantità());
  }

  @Test
  void getPrezzo() {
    assertEquals(50,prodotto.getPrezzo());
  }

  @Test
  void setPrezzo() {
    prodotto.setPrezzo(25);
    assertEquals(25,prodotto.getPrezzo());
  }

  @Test
  void getImmagine() {
    assertEquals("foto",prodotto.getImmagine());
  }

  @Test
  void setImmagine() {
    prodotto.setImmagine("immagine");
    assertEquals("immagine",prodotto.getImmagine());
  }

  private Prodotto prodotto;
  private Prodotto.Tipo tipo;
}