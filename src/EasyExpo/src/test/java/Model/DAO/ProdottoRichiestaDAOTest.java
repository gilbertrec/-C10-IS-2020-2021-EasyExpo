package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;
import java.sql.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdottoRichiestaDAOTest {

  private ProdottoRichiestaDAO prodottoRichiestaDAO;
  private ProdottoRichiesta prodottoRichiesta;
  private ProdottoDAO prodottoDAO;
  private Prodotto prodotto;
  private FornitoreDAO fornitoreDAO;
  private Fornitore fornitore;
  private RichiestaPreventivoDAO richiestaPreventivoDAO;
  private RichiestaPreventivo richiestaPreventivo;
  private ClienteDAO clienteDAO;
  private Cliente cliente;
  private int idProdottoRichiesta;
  private int idRichiesta;
  private int idProdotto;

  @BeforeEach
  void setUp() {
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);

    clienteDAO = new ClienteDAO();
    cliente = new Cliente();
    cliente.setCodiceFiscale("RBLKTA99C55E923W");
    cliente.setNome("Lucrezia");
    cliente.setCognome("Robustelli");
    cliente.setTelefono("3387485126");
    cliente.setEmail("l.robustelli@gmail.com");
    cliente.setPassword("password");
    cliente.setLuogoUbicazione("Napoli");
    clienteDAO.createCliente(cliente);

    richiestaPreventivoDAO = new RichiestaPreventivoDAO();
    richiestaPreventivo = new RichiestaPreventivo(2, cliente.getCodiceFiscale(),
        fornitore.getPartitaIva(), "matrimonio", "Napoli",
        "descizione evento prova", "nota di prova",
        new Date(2020, 12, 22), RichiestaPreventivo.Stato.IN_ATTESA);
    idRichiesta = richiestaPreventivoDAO.createRichiestaPreventivo(richiestaPreventivo);

    prodottoDAO = new ProdottoDAO();
    prodotto = new Prodotto();
    prodotto.setIdProdotto(3);
    prodotto.setPartitaIva(fornitore.getPartitaIva());
    prodotto.setTitolo("Casse");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = prodottoDAO.createProdotto(prodotto);

    prodottoRichiestaDAO = new ProdottoRichiestaDAO();
    prodottoRichiesta = new ProdottoRichiesta();
    prodottoRichiesta.setId(5);
    prodottoRichiesta.setIdRichiesta(richiestaPreventivo.getIdRichiesta());
    prodottoRichiesta.setIdProdotto(prodotto.getIdProdotto());
    prodottoRichiesta.setPartitaIva(prodotto.getPartitaIva());
    prodottoRichiesta.setNumColli(6);
    prodottoRichiesta.setPrezzo(45);
    prodottoRichiesta.setDataInizioNoleggio(new Date(2020, 12, 22));
    prodottoRichiesta.setDataFineNoleggio(new Date(2021, 01, 13));
    idProdottoRichiesta = prodottoRichiestaDAO.createProdottoRichiesta(prodottoRichiesta);
  }

  @AfterEach
  void tearDown() {
    clienteDAO.deleteCliente(cliente.getCodiceFiscale());
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
    richiestaPreventivoDAO.deleteRichiestePreventivo(idRichiesta);
    prodottoDAO.deleteProdotto(idProdotto, prodotto.getPartitaIva());
    prodottoRichiestaDAO.deleteProdottoRichiesta(idProdottoRichiesta);
  }

  @Test
  void doRetrieveById() {
    //non viene usato
  }

  @Test
  void doRetrieveByIdProdottoPartitaIvaIdRichiesta() {
    //non vengono usate
  }

  @Test
  void doRetrieveByIdRichiesta() {
  }

  @Test
  void doRetrieveByIdProdottoePartitaIva() {
  }

  @Test
  void createProdottoRichiesta() {
  }

  @Test
  void deleteProdottoRichiesta() {
  }
}