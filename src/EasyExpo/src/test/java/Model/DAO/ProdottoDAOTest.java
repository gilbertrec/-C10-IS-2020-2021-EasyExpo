package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProdottoDAOTest {

  ProdottoDAO pr;
  Prodotto prodotto;
  Fornitore fornitore;
  private int idProdotto;

  @BeforeEach
  void setUp() {
    pr = new ProdottoDAO();
    prodotto = new Prodotto();
    FornitoreDAO fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
            "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);
    prodotto.setIdProdotto(1);
    prodotto.setPartitaIva("01234567890");
    prodotto.setTitolo("Casse");
    prodotto.setPrezzo(30);
    prodotto.setQuantità(3);
    prodotto.setDescrizione("bellissima cassa per la musica");
    prodotto.setImmagine("images/foto.jsp");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = pr.createProdotto(prodotto);
  }

  @AfterEach
  void tearDown() {
   /* String partitaIva = "01234567890";
    pr.deleteProdotto(idProdotto, partitaIva);*/
  }

  @Test
  void doRetrieveByIdProdotto() {
    Prodotto prodotto2 = pr.doRetrieveByIdProdotto(idProdotto);
    assertEquals(prodotto.getIdProdotto(), prodotto2.getIdProdotto());
    assertEquals(prodotto.getPartitaIva(), prodotto2.getPartitaIva());
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
    int idProdotto2 = pr.createProdotto(prodotto);


  }

  @Test
  void deleteProdotto() {
  }

  @Test
  void doRetrieveByTitolo() {
  }

  @Test
  void updateProdotto() {
  }

  @Test
  void doRetrieveRandom() {
  }
}