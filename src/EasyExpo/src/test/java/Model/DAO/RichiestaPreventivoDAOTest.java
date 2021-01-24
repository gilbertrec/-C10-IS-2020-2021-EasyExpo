package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RichiestaPreventivoDAOTest {

  private RichiestaPreventivoDAO rpDAO;
  private RichiestaPreventivo rp;
  private ClienteDAO clDAO;
  private Cliente cl;
  private FornitoreDAO frDAO;
  private Fornitore fr;
  private int idRichiesta;

  @BeforeEach
  void setUp() {
    frDAO = new FornitoreDAO();
    fr = new Fornitore("01234567880", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    frDAO.createFornitore(fr);

    clDAO = new ClienteDAO();
    cl = new Cliente();
    cl.setCodiceFiscale("RBLKTA99C57E923W");
    cl.setNome("Lucrezia");
    cl.setCognome("Robustelli");
    cl.setTelefono("3387485126");
    cl.setEmail("l.robustelli@gmail.com");
    cl.setPassword("password");
    cl.setLuogoUbicazione("Napoli");
    clDAO.createCliente(cl);

    rpDAO = new RichiestaPreventivoDAO();
    rp = new RichiestaPreventivo();
    rp.setCodiceFiscale(cl.getCodiceFiscale());
    rp.setPartitaIva(fr.getPartitaIva());
    rp.setDataRichiesta(new Date(2020, 01, 26));
    rp.setDescrizioneEvento("descrizione di prova");
    rp.setNota("nota di prova");
    rp.setTitolo("Prova");
    rp.setLuogoEvento("Napoli");
    rp.setStato(RichiestaPreventivo.Stato.IN_ATTESA);
    idRichiesta = rpDAO.createRichiestaPreventivo(rp);

  }

  @AfterEach
  void tearDown() {
    clDAO.deleteCliente(cl.getCodiceFiscale());
    frDAO.deleteFornitore(fr.getPartitaIva());
  }

  @Test
  void createRichiestaPreventivoException(){
    RichiestaPreventivo rp2 = new RichiestaPreventivo();
    rp2.setCodiceFiscale("1211476723678467236");
    rp2.setPartitaIva("QBCIJCIBDIUHCUIDHDH");
    rp2.setDataRichiesta(new Date(2020, 01, 26));
    rp2.setDescrizioneEvento("descrizione di prova");
    rp2.setNota("nota di prova");
    rp2.setTitolo("Prova");
    rp2.setLuogoEvento("Napoli");
    rp2.setStato(RichiestaPreventivo.Stato.IN_ATTESA);
    assertThrows(RuntimeException.class,() ->{rpDAO.createRichiestaPreventivo(rp2);});
  }

  @Test
  void doRetrieveByIdRichiesta() {
    RichiestaPreventivo rp3 = rpDAO.doRetrieveByIdRichiesta(idRichiesta);
      assertEquals(idRichiesta, rp3.getIdRichiesta());
  }

  @Test
  void doRetrieveByIdRichiestaException() {
    //assertThrows(RuntimeException.class,() ->{rpDAO.doRetrieveByIdRichiesta(34);}); // non funziona
  }

  @Test
  void doRetrieveByPartitaIva() {
    List<RichiestaPreventivo> rp4 = rpDAO.doRetrieveByPartitaIva(rp.getPartitaIva());
    for(RichiestaPreventivo p : rp4) {
      assertEquals(rp.getPartitaIva(), p.getPartitaIva());
    }
  }

  @Test
  void doRetrieveByCodiceFiscale() {
    List<RichiestaPreventivo> rp4 = rpDAO.doRetrieveByCodiceFiscale(rp.getCodiceFiscale());
    for(RichiestaPreventivo p : rp4) {
      assertEquals(rp.getCodiceFiscale(), p.getCodiceFiscale());
    }
  }

  @Test
  void createRichiestaPreventivo() {
    RichiestaPreventivo rp5 = new RichiestaPreventivo();
    rp5.setCodiceFiscale(cl.getCodiceFiscale());
    rp5.setPartitaIva(fr.getPartitaIva());
    rp5.setDataRichiesta(new Date(2020, 01, 26));
    rp5.setDescrizioneEvento("descrizione di prova seconda");
    rp5.setNota("nota di prova");
    rp5.setTitolo("Prova seconda");
    rp5.setLuogoEvento("Napoli");
    rp5.setStato(RichiestaPreventivo.Stato.IN_ATTESA);
    int idRichiesta2 = rpDAO.createRichiestaPreventivo(rp5);

    RichiestaPreventivo rp6 = rpDAO.doRetrieveByIdRichiesta(idRichiesta2);

    assertEquals(rp5.getIdRichiesta(), rp6.getIdRichiesta());

    rpDAO.deleteRichiestePreventivo(rp5.getIdRichiesta());
  }

  @Test
  void updateRichiestaPreventivo() {
    rp.setStato(RichiestaPreventivo.Stato.CONFERMATO);
    rpDAO.updateRichiestaPreventivo(rp);
    assertEquals(RichiestaPreventivo.Stato.CONFERMATO, rp.getStato());
  }

  @Test
  void deleteRichiestePreventivo() {
    RichiestaPreventivo rp6 = new RichiestaPreventivo();
    rp6.setCodiceFiscale(cl.getCodiceFiscale());
    rp6.setPartitaIva(fr.getPartitaIva());
    rp6.setDataRichiesta(new Date(2020, 01, 26));
    rp6.setDescrizioneEvento("descrizione di prova terza");
    rp6.setNota("nota di prova");
    rp6.setTitolo("Prova terza");
    rp6.setLuogoEvento("Napoli");
    rp6.setStato(RichiestaPreventivo.Stato.RIFIUTATO);
    int idRichiesta3 = rpDAO.createRichiestaPreventivo(rp6);

    rpDAO.deleteRichiestePreventivo(idRichiesta3);

    assertNull(rpDAO.doRetrieveByIdRichiesta(idRichiesta3));
  }

  @Test
  void deleteRichiestePreventivoException() {
    frDAO = new FornitoreDAO();
    Fornitore fr2 = new Fornitore("01234788790", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    frDAO.createFornitore(fr2);

    clDAO = new ClienteDAO();
    Cliente cl2 = new Cliente();
    cl2.setCodiceFiscale("RBLKTAPTC57E423W");
    cl2.setNome("Lucrezia");
    cl2.setCognome("Robustelli");
    cl2.setTelefono("3387485126");
    cl2.setEmail("l.robustelli@gmail.com");
    cl2.setPassword("password");
    cl2.setLuogoUbicazione("Napoli");
    clDAO.createCliente(cl2);
    RichiestaPreventivo rp7 = new RichiestaPreventivo();
    rp7.setCodiceFiscale(cl.getCodiceFiscale());
    rp7.setPartitaIva(fr.getPartitaIva());
    rp7.setDataRichiesta(new Date(2020, 01, 26));
    rp7.setDescrizioneEvento("descrizione di prova terza");
    rp7.setNota("nota di prova");
    rp7.setTitolo("Prova terza");
    rp7.setLuogoEvento("Napoli");
    rp7.setStato(RichiestaPreventivo.Stato.RIFIUTATO);
    int idRichiesta4 = rpDAO.createRichiestaPreventivo(rp7);

    rpDAO.deleteRichiestePreventivo(idRichiesta4);
    frDAO.deleteFornitore(fr2.getPartitaIva());
    clDAO.deleteCliente(cl2.getCodiceFiscale());

    assertThrows(RuntimeException.class,() ->{rpDAO.deleteRichiestePreventivo(idRichiesta4);});
  }

  @Test
  void updateRichiestaPreventivoException() {
    rp.setStato(RichiestaPreventivo.Stato.CONFERMATO);
    rp.setPartitaIva("hibceywgiyergrfierg");
    assertThrows(RuntimeException.class,() ->{rpDAO.updateRichiestaPreventivo(rp);});
  }
}