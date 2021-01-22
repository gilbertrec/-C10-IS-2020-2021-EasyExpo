package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class MetodoPagamentoTest {

  @BeforeEach
  void setUp() {
    scadenza = new Date(2023,11,1);
    metodo = new MetodoPagamento("0000000000000000","01234567890","Mario Rossi",scadenza,123);
  }

  @AfterEach
  void tearDown() {
    scadenza = new Date(2023,11,1);
    metodo = new MetodoPagamento("0000000000000000","01234567890","Mario Rossi",scadenza,123);
  }
  @Test
  void testClientCostructorEmpty() {
    metodo = new MetodoPagamento();
    assertNotNull(metodo);
  }
  @Test
  void getNumeroCarta() {
    assertEquals("0000000000000000",metodo.getNumeroCarta());
  }

  @Test
  void setNumeroCarta() {
    metodo.setNumeroCarta("1234123412341234");
    assertEquals("1234123412341234",metodo.getNumeroCarta());
  }

  @Test
  void getPartitaIva() {
    assertEquals("01234567890",metodo.getPartitaIva());
  }

  @Test
  void setPartitaIva() {
    metodo.setPartitaIva("00000000000");
    assertEquals("00000000000",metodo.getPartitaIva());
  }

  @Test
  void getNomeIntestatario() {
    assertEquals("Mario Rossi",metodo.getNomeIntestatario());
  }

  @Test
  void setNomeIntestatario() {
    metodo.setNomeIntestatario("Giuseppe Verdi");
    assertEquals("Giuseppe Verdi",metodo.getNomeIntestatario());
  }

  @Test
  void getDataScadenza() {
    assertEquals(scadenza,metodo.getDataScadenza());
  }

  @Test
  void setDataScadenza() {
    scadenza = new Date(2025,10,1);
    metodo.setDataScadenza(scadenza);
    assertEquals(scadenza,metodo.getDataScadenza());
  }

  @Test
  void getCvv() {
    assertEquals(123,metodo.getCvv());
  }

  @Test
  void setCvv() {
    metodo.setCvv(567);
    assertEquals(567,metodo.getCvv());
  }

  private MetodoPagamento metodo;
  private Date scadenza;
}