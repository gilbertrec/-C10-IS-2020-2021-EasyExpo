package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdottoDAOTest {

  private ProdottoDAO pr;
  private Prodotto prodotto;
  private Fornitore fornitore;
  FornitoreDAO fornitoreDAO;
  private int idProdotto;

  @BeforeEach
  void setUp() {
    pr = new ProdottoDAO();
    prodotto = new Prodotto();
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567880", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);
    prodotto.setIdProdotto(2);
    prodotto.setPartitaIva(fornitore.getPartitaIva());
    prodotto.setTitolo("Panca");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = pr.createProdotto(prodotto);
  }

  @AfterEach
  void tearDown() {
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
  }

  @Test
  void doRetrieveByIdProdottoEPartitaIva() {
    Prodotto prodotto3 = pr.doRetrieveByIdProdottoEPartitaIva(idProdotto, prodotto.getPartitaIva());
    assertEquals(prodotto.getIdProdotto(), prodotto3.getIdProdotto());
    assertEquals(prodotto.getPartitaIva(), prodotto3.getPartitaIva());
  }

  @Test
  void doRetrieveByPartitaIva() {
    List<Prodotto> prodotti = pr.doRetrieveByPartitaIva(prodotto.getPartitaIva());
    assertEquals(1, prodotti.size());
  }

  @Test
  void doRetrieveAll() {
    List<Prodotto> prodotti2 = pr.doRetrieveAll();
    assertEquals(5, prodotti2.size());
  }

  @Test
  void createProdotto() {
    pr = new ProdottoDAO();
    Prodotto prodotto5 = new Prodotto();
    prodotto5.setIdProdotto(5);
    prodotto5.setPartitaIva(fornitore.getPartitaIva());
    prodotto5.setTitolo("Casse");
    prodotto5.setPrezzo(30);
    prodotto5.setQuantità(3);
    prodotto5.setDescrizione("bellissima cassa per la musica");
    prodotto5.setImmagine("images/foto.jsp");
    prodotto5.setTipo(Prodotto.Tipo.ATTREZZATURA);
    int idProdotto2 = pr.createProdotto(prodotto5);

    Prodotto prodotto6 = pr.doRetrieveByIdProdottoEPartitaIva(idProdotto2, prodotto5.getPartitaIva());

    assertEquals(idProdotto2, prodotto6.getIdProdotto());
    assertEquals(prodotto5.getPartitaIva(), prodotto6.getPartitaIva());

    pr.deleteProdotto(idProdotto2, prodotto5.getPartitaIva());
  }

  @Test
  void deleteProdotto() {
    Prodotto prodotto7 = new Prodotto();
    prodotto7.setIdProdotto(6);
    prodotto7.setPartitaIva(fornitore.getPartitaIva());
    prodotto7.setTitolo("Casse");
    prodotto7.setPrezzo(30);
    prodotto7.setQuantità(3);
    prodotto7.setDescrizione("bellissima cassa per la musica");
    prodotto7.setImmagine("images/foto.jsp");
    prodotto7.setTipo(Prodotto.Tipo.ATTREZZATURA);
    int idProdotto3 = pr.createProdotto(prodotto7);

    pr.deleteProdotto(idProdotto3, prodotto7.getPartitaIva());

    assertNull(pr.doRetrieveByIdProdottoEPartitaIva(idProdotto3, prodotto7.getPartitaIva()));
  }

  @Test
  void doRetrieveByTitolo() {
    List<Prodotto> prodotti9 = pr.doRetrieveByTitolo("Panca");
    for(Prodotto p : prodotti9){
      assertEquals("Panca", p.getTitolo());
    }
  }

  @Test
  void updateProdotto() {
    prodotto.setQuantità(8);
    pr.updateProdotto(prodotto);
    assertEquals(8, prodotto.getQuantità());
  }

  @Test
  void doRetrieveRandom() {
    List<Prodotto> prodotti4 = pr.doRetrieveRandom(1, 4);
    assertEquals(4, prodotti4.size());
  }
}