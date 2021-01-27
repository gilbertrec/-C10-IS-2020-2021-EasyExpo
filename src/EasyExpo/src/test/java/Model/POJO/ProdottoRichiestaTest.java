package Model.POJO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdottoRichiestaTest {

  @BeforeEach
  void setUp() {
    datai = new Date(2020, 1, 8);
    dataf = new Date(2020, 1, 10);
    richiesta = new ProdottoRichiesta(1, 1, 1, "01234567890", 2, 25, datai, dataf);
  }

  @AfterEach
  void tearDown() {
    datai = new Date(2020, 1, 8);
    dataf = new Date(2020, 1, 10);
    richiesta = new ProdottoRichiesta(1, 1, 1, "01234567890", 2, 25, datai, dataf);
  }

  @Test
  void testProdottoRichiestaCostructorEmpty() {
    richiesta = new ProdottoRichiesta();
    assertNotNull(richiesta);
  }

  @Test
  void getId() {
    assertEquals(1, richiesta.getId());
  }

  @Test
  void setId() {
    richiesta.setId(2);
    assertEquals(2, richiesta.getId());
  }

  @Test
  void getIdRichiesta() {
    assertEquals(1, richiesta.getIdRichiesta());
  }

  @Test
  void setIdRichiesta() {
    richiesta.setIdRichiesta(2);
    assertEquals(2, richiesta.getIdRichiesta());
  }

  @Test
  void getIdProdotto() {
    assertEquals(1, richiesta.getIdProdotto());
  }

  @Test
  void setIdProdotto() {
    richiesta.setIdProdotto(2);
    assertEquals(2, richiesta.getIdProdotto());
  }

  @Test
  void getNumColli() {
    assertEquals(2, richiesta.getNumColli());
  }

  @Test
  void setNumColli() {
    richiesta.setNumColli(3);
    assertEquals(3, richiesta.getNumColli());
  }

  @Test
  void getPrezzo() {
    assertEquals(25, richiesta.getPrezzo());
  }

  @Test
  void setPrezzo() {
    richiesta.setPrezzo(20);
    assertEquals(20, richiesta.getPrezzo());
  }

  @Test
  void getDataInizioNoleggio() {
    assertEquals(datai, richiesta.getDataInizioNoleggio());
  }

  @Test
  void setDataInizioNoleggio() {
    datai = new Date(2020, 1, 7);
    richiesta.setDataInizioNoleggio(datai);
    assertEquals(datai, richiesta.getDataInizioNoleggio());
  }

  @Test
  void getDataFineNoleggio() {
    assertEquals(dataf, richiesta.getDataFineNoleggio());
  }

  @Test
  void setDataFineNoleggio() {
    dataf = new Date(2020, 1, 12);
    richiesta.setDataFineNoleggio(dataf);
    assertEquals(dataf, richiesta.getDataFineNoleggio());
  }

  @Test
  void getPartitaIva() {
    assertEquals("01234567890", richiesta.getPartitaIva());
  }

  @Test
  void setPartitaIva() {
    richiesta.setPartitaIva("00000000000");
    assertEquals("00000000000", richiesta.getPartitaIva());
  }

  private Date datai;
  private Date dataf;
  private ProdottoRichiesta richiesta;
}