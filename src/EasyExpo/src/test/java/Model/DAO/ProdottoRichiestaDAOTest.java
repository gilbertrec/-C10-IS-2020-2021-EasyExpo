package Model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import Model.POJO.RichiestaPreventivo;
import java.sql.Date;
import java.util.List;
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
    fornitore =
        new Fornitore("99999999999", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
            "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);

    clienteDAO = new ClienteDAO();
    cliente = new Cliente();
    cliente.setCodiceFiscale("baoJtA98d55E923o");
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
  }

  @Test
  void doRetrieveById() {
    ProdottoRichiesta prodottoRichiesta2 = prodottoRichiestaDAO.doRetrieveById(idProdottoRichiesta);
    assertEquals(idProdottoRichiesta, prodottoRichiesta2.getId());
  }

  @Test
  void doRetrieveByIdRichiesta() {
    List<ProdottoRichiesta> richieste = prodottoRichiestaDAO.doRetrieveByIdRichiesta(idRichiesta);
    for (ProdottoRichiesta p : richieste) {
      assertEquals(idRichiesta, p.getIdRichiesta());
    }
  }

  @Test
  void doRetrieveByIdProdottoePartitaIva() {
    List<ProdottoRichiesta> richieste = prodottoRichiestaDAO
        .doRetrieveByIdProdottoePartitaIva(idProdotto, fornitore.getPartitaIva());
    for (ProdottoRichiesta p : richieste) {
      assertEquals(idProdotto, p.getIdProdotto());
      assertEquals(fornitore.getPartitaIva(), p.getPartitaIva());
    }
  }

  @Test
  void createProdottoRichiesta() {
    ProdottoRichiesta prodRich = new ProdottoRichiesta();
    prodRich.setId(5);
    prodRich.setIdRichiesta(idRichiesta);
    prodRich.setIdProdotto(idProdotto);
    prodRich.setPartitaIva(fornitore.getPartitaIva());
    prodRich.setNumColli(10);
    prodRich.setPrezzo(20);
    prodRich.setDataInizioNoleggio(new Date(2019, 12, 30));
    prodRich.setDataFineNoleggio(new Date(2020, 2, 3));

    idProdottoRichiesta = prodottoRichiestaDAO.createProdottoRichiesta(prodRich);
    ProdottoRichiesta prodRich2 = prodottoRichiestaDAO.doRetrieveById(idProdottoRichiesta);

    assertEquals(idProdottoRichiesta, prodRich2.getId());

  }
}