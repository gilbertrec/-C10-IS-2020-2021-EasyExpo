package Model.POJO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
  private Cliente cl;

  @BeforeEach
  void setUp() {
    cl = new Cliente("DLCMLE03A31G273Y", "Emilio", "Dolce", "1122334455", "Palermo",
        "emilio.ciao@aaa.com", "Emilio20_");
  }

  @AfterEach
  void tearDown() {
    cl = new Cliente("DLCMLE03A31G273Y", "Emilio", "Dolce", "1122334455", "Palermo",
        "emilio.ciao@aaa.com", "Emilio20_");
  }

  @Test
  void testClientCostructorEmpty() {
    cl = new Cliente();
    assertNotNull(cl);
  }

  @Test
  void getEmail() {
    assertEquals("emilio.ciao@aaa.com", cl.getEmail());
  }

  @Test
  void setEmail() {
    cl.setEmail("gaetano.ciao@aaa.com");
    assertEquals("gaetano.ciao@aaa.com", cl.getEmail());
  }

  @Test
  void getPassword() {
    assertEquals("Emilio20_", cl.getPassword());
  }

  @Test
  void setPassword() {
    cl.setPassword("Gaetano20_");
    assertEquals("Gaetano20_", cl.getPassword());
  }

  @Test
  void getCodiceFiscale() {
    assertEquals("DLCMLE03A31G273Y", cl.getCodiceFiscale());
  }

  @Test
  void setCodiceFiscale() {
    cl.setCodiceFiscale("AVGMLE03A31G273Y");
    assertEquals("AVGMLE03A31G273Y", cl.getCodiceFiscale());
  }

  @Test
  void getNome() {
    assertEquals("Emilio", cl.getNome());
  }

  @Test
  void setNome() {
    cl.setNome("Gaetano");
    assertEquals("Gaetano", cl.getNome());
  }

  @Test
  void getCognome() {
    assertEquals("Dolce", cl.getCognome());
  }

  @Test
  void setCognome() {
    cl.setCognome("Iuliano");
    assertEquals("Iuliano", cl.getCognome());
  }

  @Test
  void getTelefono() {
    assertEquals("1122334455", cl.getTelefono());
  }

  @Test
  void setTelefono() {
    cl.setTelefono("4455667788");
    assertEquals("4455667788", cl.getTelefono());
  }

  @Test
  void getLuogoUbicazione() {
    assertEquals("Palermo", cl.getLuogoUbicazione());
  }

  @Test
  void setLuogoUbicazione() {
    cl.setLuogoUbicazione("Napoli");
    assertEquals("Napoli", cl.getLuogoUbicazione());
  }

  @Test
  void setStato() {
    cl.setStato(Cliente.Stato.SOSPESO);
    assertEquals(Cliente.Stato.SOSPESO, cl.getStato());
  }

  @Test
  void getStato() {
    assertEquals(Cliente.Stato.ATTIVO, cl.getStato());
  }
}