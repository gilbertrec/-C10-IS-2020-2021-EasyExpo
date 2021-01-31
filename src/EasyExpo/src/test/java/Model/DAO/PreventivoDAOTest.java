package Model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Preventivo;
import Model.POJO.RichiestaPreventivo;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreventivoDAOTest {
  PreventivoDAO preventivoDAO;
  Preventivo preventivo;
  RichiestaPreventivoDAO rpDAO;
  RichiestaPreventivo rp;
  FornitoreDAO fDAO;
  Fornitore fornitore;
  ClienteDAO cDAO;
  Cliente cliente;
  int idPreventivo;
  int idPreventivo2;

  @BeforeEach
  void setUp() {
    fDAO = new FornitoreDAO();
    fornitore = new Fornitore("65655655555", "Mario", "Rossi",
        "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fDAO.createFornitore(fornitore);

    cDAO = new ClienteDAO();
    cliente = new Cliente();
    cliente.setCodiceFiscale("HGJSLKS34ERT4RGF");
    cliente.setNome("Lucrezia");
    cliente.setCognome("Robustelli");
    cliente.setTelefono("3387485126");
    cliente.setEmail("l.robustelli@gmail.com");
    cliente.setPassword("password");
    cliente.setLuogoUbicazione("Napoli");
    cDAO.createCliente(cliente);

    rpDAO = new RichiestaPreventivoDAO();
    rp = new RichiestaPreventivo(1, cliente.getCodiceFiscale(), fornitore.getPartitaIva(),
        "Prova", "Milano", "Test di prova per Richiesta Preventivo",
        "nota di prova", new Date(2021, 2, 1), RichiestaPreventivo.Stato.IN_ATTESA);
    rpDAO.createRichiestaPreventivo(rp);


    preventivoDAO = new PreventivoDAO();
    preventivo = new Preventivo();
    preventivo.setIdPreventivo(1);
    preventivo.setIdRichiesta(rp.getIdRichiesta());
    preventivo.setPartitaIva(fornitore.getPartitaIva());
    preventivo.setCodiceFiscale(cliente.getCodiceFiscale());
    preventivo.setDataPreventivo(new Date(2021, 3, 1));
    preventivo.setPrezzoTotale(300);
    preventivo.setNota("nota di prova di preventivo");


    idPreventivo = preventivoDAO.createPreventivo(preventivo);


  }

  @AfterEach
  void tearDown() {
    fDAO.deleteFornitore(fornitore.getPartitaIva());
    cDAO.deleteCliente(cliente.getCodiceFiscale());
    preventivoDAO.deletePreventivo(idPreventivo);
  }

  @Test
  void doRetriveByIdPreventivo() {
    Preventivo p = preventivoDAO.doRetriveByIdPreventivo(idPreventivo);
    assertEquals(idPreventivo, p.getIdPreventivo());

  }

  @Test
  void doRetrieveByIdPreventivoNull() {
    assertEquals(null, preventivoDAO.doRetriveByIdPreventivo(655));


  }

  @Test
  void createPreventivo() {
    Preventivo p = new Preventivo();
    p.setIdPreventivo(5);
    p.setCodiceFiscale(cliente.getCodiceFiscale());
    p.setPartitaIva(fornitore.getPartitaIva());
    p.setDataPreventivo(new Date(2020, 5, 2));
    p.setIdRichiesta(rp.getIdRichiesta());
    preventivoDAO.createPreventivo(p);
    assertEquals(2, preventivoDAO.doRetrieveByPartitaIva(p.getPartitaIva()).size());
  }

  @Test
  void doRetrieveByPartitaIva() {
    List<Preventivo> preventivi = preventivoDAO.doRetrieveByPartitaIva("65655655555");
    for (Preventivo p : preventivi) {
      assertEquals("65655655555", p.getPartitaIva());
    }
  }

  @Test
  void doRetrieveByCodiceFiscale() {
    List<Preventivo> preventivi = preventivoDAO.doRetrieveByCodiceFiscale("HGJSLKS34ERT4RGF");
    for (Preventivo p : preventivi) {
      assertEquals("HGJSLKS34ERT4RGF", p.getCodiceFiscale());
    }
  }
}