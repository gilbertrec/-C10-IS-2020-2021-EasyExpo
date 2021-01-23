package Model.DAO;

import Model.POJO.Abbonamento;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PreventivoDAOTest {
  PreventivoDAO preventivoDAO;
  Preventivo preventivo;
  RichiestaPreventivoDAO rpDAO;
  RichiestaPreventivo rp;
  FornitoreDAO fDAO;
  Fornitore f;
  ClienteDAO cDAO;
  Cliente c;
  int idPreventivo;

  @BeforeEach
  void setUp() {
    fDAO = new FornitoreDAO();
    f = new Fornitore("65655655555", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fDAO.createFornitore(f);

    cDAO = new ClienteDAO();
    c = new Cliente();
    c.setCodiceFiscale("HGJSLKS34ERT4RGF");
    c.setNome("Lucrezia");
    c.setCognome("Robustelli");
    c.setTelefono("3387485126");
    c.setEmail("l.robustelli@gmail.com");
    c.setPassword("password");
    c.setLuogoUbicazione("Napoli");
    cDAO.createCliente(c);

    rpDAO = new RichiestaPreventivoDAO();
    rp = new RichiestaPreventivo(1, c.getCodiceFiscale(), f.getPartitaIva(),
        "Prova", "Milano", "Test di prova per Richiesta Preventivo",
        "nota di prova", new Date(2021, 2, 1), RichiestaPreventivo.Stato.IN_ATTESA);
    rpDAO.createRichiestaPreventivo(rp);


    preventivoDAO = new PreventivoDAO();
    preventivo = new Preventivo();
    preventivo.setIdPreventivo(1);
    preventivo.setIdRichiesta(rp.getIdRichiesta());
    preventivo.setPartitaIva(f.getPartitaIva());
    preventivo.setCodiceFiscale(c.getCodiceFiscale());
    preventivo.setDataPreventivo(new Date(2021, 3, 1));
    preventivo.setPrezzoTotale(300);
    preventivo.setNota("nota di prova di preventivo");

    idPreventivo = preventivoDAO.createPreventivo(preventivo);


  }

  @AfterEach
  void tearDown() {
    fDAO.deleteFornitore(f.getPartitaIva());
    cDAO.deleteCliente(c.getCodiceFiscale());
    preventivoDAO.deletePreventivo(idPreventivo);
  }

  @Test
  void doRetriveByIdPreventivo() {
    Preventivo p = preventivoDAO.doRetriveByIdPreventivo(idPreventivo);
    assertEquals(idPreventivo, p.getIdPreventivo());

  }

  @Test
  void doRetrieveAll() {
  }

  @Test
  void createPreventivo() {
    Preventivo p = new Preventivo();
    p.setIdPreventivo(5);
    p.setCodiceFiscale(c.getCodiceFiscale());
    p.setPartitaIva(f.getPartitaIva());
    p.setDataPreventivo(new Date(2020,5,2));
    p.setIdRichiesta(rp.getIdRichiesta());
    preventivoDAO.createPreventivo(p);
    assertEquals(2, preventivoDAO.doRetrieveByPartitaIva(p.getPartitaIva()).size());
  }

  @Test
  void doRetrieveByPartitaIva() {
    List<Preventivo> preventivi = preventivoDAO.doRetrieveByPartitaIva("65655655555");
    for(Preventivo p : preventivi){
      assertEquals("65655655555", p.getPartitaIva());
    }
  }

  @Test
  void doRetrieveByCodiceFiscale() {
    List<Preventivo> preventivi = preventivoDAO.doRetrieveByCodiceFiscale("HGJSLKS34ERT4RGF");
    for(Preventivo p : preventivi){
      assertEquals("HGJSLKS34ERT4RGF", p.getCodiceFiscale());
    }
  }


  @Test
  void deletePreventivo() {
    Preventivo preventivo2 = new Preventivo();
    preventivo2.setIdPreventivo(4);
    preventivo2.setIdRichiesta(rp.getIdRichiesta());
    preventivo2.setPartitaIva(f.getPartitaIva());
    preventivo2.setCodiceFiscale(c.getCodiceFiscale());
    preventivo2.setDataPreventivo(new Date(2022, 3, 1));
    preventivo2.setPrezzoTotale(400);
    preventivo2.setNota("nota di prova di preventivo2");

    int idPreventivo2 = preventivoDAO.createPreventivo(preventivo2);

    preventivoDAO.deletePreventivo(idPreventivo2);

    assertNull(preventivoDAO.doRetriveByIdPreventivo(idPreventivo2)); //non funziona
  }
}