package Model.POJO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RichiestaPreventivoTest {
  private RichiestaPreventivo rp;
  private Date data;
  private Date d;
  private RichiestaPreventivo.Stato stato;

  @BeforeEach
  void setUp() {
    data = new Date(2021, 1, 18);
    rp = new RichiestaPreventivo(1, "DLCMLE03A31G273Y", "01234567890", "RichiestaTest", "LuogoTest",
        "DescrizioneTest", "NotaTest", data, RichiestaPreventivo.Stato.CONFERMATO);
  }

  @AfterEach
  void tearDown() {
    data = new Date(2021, 1, 18);
    rp = new RichiestaPreventivo(1, "DLCMLE03A31G273Y", "01234567890", "RichiestaTest", "LuogoTest",
        "DescrizioneTest", "NotaTest", data, RichiestaPreventivo.Stato.CONFERMATO);
  }

  @Test
  void testRichiestaPreventivoCostructorEmpty() {
    rp = new RichiestaPreventivo();
    assertNotNull(rp);
  }

  @Test
  void getDataRichiesta() {
    assertEquals(data, rp.getDataRichiesta());
  }

  @Test
  void setDataRichiesta() {
    d = new Date(2021, 1, 15);
    rp.setDataRichiesta(d);
    assertEquals(d, rp.getDataRichiesta());
  }

  @Test
  void getIdRichiesta() {
    assertEquals(1, rp.getIdRichiesta());
  }

  @Test
  void setIdRichiesta() {
    rp.setIdRichiesta(2);
    assertEquals(2, rp.getIdRichiesta());
  }

  @Test
  void getCodiceFiscale() {
    assertEquals("DLCMLE03A31G273Y", rp.getCodiceFiscale());
  }

  @Test
  void setCodiceFiscale() {
    rp.setCodiceFiscale("DLCMLE03A31G5555");
    assertEquals("DLCMLE03A31G5555", rp.getCodiceFiscale());
  }

  @Test
  void getPartitaIva() {
    assertEquals("01234567890", rp.getPartitaIva());
  }

  @Test
  void setPartitaIva() {
    rp.setPartitaIva("55555567890");
    assertEquals("55555567890", rp.getPartitaIva());
  }

  @Test
  void getTitolo() {
    assertEquals("RichiestaTest", rp.getTitolo());
  }

  @Test
  void setTitolo() {
    rp.setTitolo("Test");
    assertEquals("Test", rp.getTitolo());
  }

  @Test
  void getLuogoEvento() {
    assertEquals("LuogoTest", rp.getLuogoEvento());
  }

  @Test
  void setLuogoEvento() {
    rp.setLuogoEvento("Test");
    assertEquals("Test", rp.getLuogoEvento());
  }

  @Test
  void getDescrizioneEvento() {
    assertEquals("DescrizioneTest", rp.getDescrizioneEvento());
  }

  @Test
  void setDescrizioneEvento() {
    rp.setDescrizioneEvento("Test");
    assertEquals("Test", rp.getDescrizioneEvento());
  }

  @Test
  void getNota() {
    assertEquals("NotaTest", rp.getNota());
  }

  @Test
  void setNota() {
    rp.setNota("Test");
    assertEquals("Test", rp.getNota());
  }

  @Test
  void getStato() {
    assertEquals(RichiestaPreventivo.Stato.CONFERMATO, rp.getStato());
  }

  @Test
  void setStato() {
    rp.setStato(RichiestaPreventivo.Stato.RIFIUTATO);
    assertEquals(RichiestaPreventivo.Stato.RIFIUTATO, rp.getStato());
  }
}