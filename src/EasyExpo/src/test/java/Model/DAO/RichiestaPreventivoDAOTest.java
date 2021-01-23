package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.RichiestaPreventivo;
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

  @BeforeEach
  void setUp() {
    frDAO = new FornitoreDAO();
    fr = new Fornitore("01234567880", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");

    clDAO = new ClienteDAO();
    cl = new Cliente();
    cl.setCodiceFiscale("RBLKTA99C55E923W");
    cl.setNome("Lucrezia");
    cl.setCognome("Robustelli");
    cl.setTelefono("3387485126");
    cl.setEmail("l.robustelli@gmail.com");
    cl.setPassword("password");
    cl.setLuogoUbicazione("Napoli");
    clDAO.createCliente(cl);

  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void doRetrieveByIdRichiesta() {
  }

  @Test
  void doRetrieveByPartitaIva() {
  }

  @Test
  void doRetrieveByCodiceFiscale() {
  }

  @Test
  void doRetrieveAll() {
  }

  @Test
  void createRichiestaPreventivo() {
  }

  @Test
  void updateRichiestaPreventivo() {
  }

  @Test
  void deleteRichiestePreventivo() {
  }
}