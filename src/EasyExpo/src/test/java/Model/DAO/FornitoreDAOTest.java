package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Fornitore;
import Model.POJO.RichiestaPreventivo;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FornitoreDAOTest {

  FornitoreDAO fr;
  Fornitore fornitore;


  @BeforeEach
  void setUpEach(){
    fr = new FornitoreDAO();
    fornitore = new Fornitore("01234567890", "Gaetano","Iuliano","3387485126", "Napoli", "g.iuliano@gmail.com", "password", "privato");
    /*fornitore.setPartitaIva("01234567890");
    fornitore.setNome("Gaetano");
    fornitore.setCognome("Iuliano");
    fornitore.setTelefono("3387485126");
    fornitore.setEmail("g.iuliano@gmail.com");
    fornitore.setPassword("password");
    fornitore.setLuogoUbicazione("Napoli");
    fornitore.setRagioneSociale("privato");
    fornitore.setAbbonato(false);*/
    fr.createFornitore(fornitore);
  }


  @AfterEach
  void tearDown() {
    fr.deleteFornitore("01234567890");
  }

  @Test
  void doRetrieveByPIVA() {
    Fornitore f = fr.doRetrieveByPIVA("01234567890");
    assertEquals("01234567890", f.getPartitaIva());
  }

  @Test
  void createFornitore() {
    Fornitore fornitore2 = new Fornitore();
    fornitore2.setPartitaIva("12345678901");
    fornitore2.setNome("Giuseppe");
    fornitore2.setCognome("Avino");
    fornitore2.setTelefono("3387485126");
    fornitore2.setEmail("g.avino@gmail.com");
    fornitore2.setPassword("password");
    fornitore2.setLuogoUbicazione("Napoli");
    fornitore2.setRagioneSociale("privato");
    fornitore2.setAbbonato(false);
    fornitore2.setStato(Fornitore.Stato.ATTIVO);

    fr.createFornitore(fornitore2);

    Fornitore fornitore3 = fr.doRetrieveByPIVA("12345678901");

    assertEquals(fornitore2.getPartitaIva(), fornitore3.getPartitaIva());

    fr.deleteFornitore("12345678901");
  }

  @Test
  void createFornitoreException() {
    fornitore = new Fornitore();
    fornitore.setPartitaIva("12345677898901");
    fornitore.setNome("Giuseppe");
    fornitore.setCognome("Avino");
    fornitore.setTelefono("3387485126");
    fornitore.setEmail("g.avino@gmail.com");
    fornitore.setPassword("password");
    fornitore.setLuogoUbicazione("Napoli");
    fornitore.setRagioneSociale("privato");
    fornitore.setAbbonato(false);

    assertThrows(RuntimeException.class,() ->{fr.createFornitore(fornitore);});
  }

  @Test
  void doRetrieveByEmailandPassword() {
    Fornitore f1 = fr.doRetrieveByEmailandPassword("g.iuliano@gmail.com", "password" );
    assertEquals("01234567890", f1.getPartitaIva());
  }

  @Test
  void doRetrieveByNomeECognome() {
    List<Fornitore> f2 = fr.doRetrieveByNomeECognome("Gaetano");
    for(Fornitore f : f2){
      assertEquals("Gaetano", f.getNome());
    }
  }

  @Test
  void deleteFornitore() {
    Fornitore fornitore3 = new Fornitore();
    fornitore3.setPartitaIva("12345678909");
    fornitore3.setNome("Luigi");
    fornitore3.setCognome("PierAntonio");
    fornitore3.setTelefono("3387485126");
    fornitore3.setEmail("l.pier@gmail.com");
    fornitore3.setPassword("password");
    fornitore3.setLuogoUbicazione("Napoli");
    fornitore3.setRagioneSociale("dipendente");
    fornitore3.setAbbonato(false);

    fr.createFornitore(fornitore3);

    fr.deleteFornitore("12345678909");

    assertNull(fr.doRetrieveByPIVA("12345678909"));
  }

  @Test
  void deleteFornitoreException() {
    assertThrows(RuntimeException.class,() ->{fr.deleteFornitore("12345668909");});
  }

  @Test
  void updateBooleanFornitore() {
    fornitore.setAbbonato(true);
    fr.updateBooleanFornitore(fornitore);
    assertEquals(true, fornitore.isAbbonato());
  }

  @Test
  void updateBooleanFornitoreException() {
    fornitore.setPartitaIva("ydkykdd6565786guf");
    fornitore.setAbbonato(true);
    assertThrows(RuntimeException.class,() ->{fr.updateBooleanFornitore(fornitore);});
  }

  @Test
  void doRetrievebyStato(){
    List<Fornitore> fornitore5 =  fr.doRetrievebyStato(1);
    for(Fornitore f : fornitore5) {
      assertEquals(Fornitore.Stato.ATTIVO, f.getStato());
    }
  }

  @Test
  void updateStato(){
   fr.updateStato(2, fornitore.getPartitaIva());
   Fornitore fornitore7 = fr.doRetrieveByPIVA(fornitore.getPartitaIva());
   assertEquals(Fornitore.Stato.SOSPESO, fornitore7.getStato());
  }
}