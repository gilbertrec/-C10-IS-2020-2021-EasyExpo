package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Fornitore;
import Model.POJO.Prodotto;
import Model.POJO.Tag;
import Model.POJO.TagProdotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagProdottoDAOTest {
  private FornitoreDAO fornitoreDAO;
  private Fornitore fornitore;
  private ProdottoDAO prodottoDAO;
  private Prodotto prodotto;
  private TagDAO tagDAO;
  private Tag tag;
  private int idProdotto;
  private TagProdotto tp;
  private TagProdottoDAO tpd;
  private int idTag;
  private int idTagProdotto;

  //@BeforeEach
  /*void setUp() {
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
            "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);

    prodottoDAO = new ProdottoDAO();
    prodotto = new Prodotto();
    //prodotto.setIdProdotto(127);
    prodotto.setPartitaIva(fornitore.getPartitaIva());
    prodotto.setTitolo("TitoloTest");
    prodotto.setPrezzo(10);
    prodotto.setQuantità(2);
    prodotto.setDescrizione("DescrizioneTest");
    prodotto.setImmagine("Test");
    prodotto.setTipo(Prodotto.Tipo.ATTREZZATURA);
    idProdotto = prodottoDAO.createProdotto(prodotto);

    tagDAO = new TagDAO();
    tag = new Tag();
    //tag.setIdTag(128);
    tag.setNome("NomeTest");
    idTag = tagDAO.createTag(tag);
    System.out.println(idTag);

    tpd = new TagProdottoDAO();
    tp = new TagProdotto(tag.getIdTag(),prodotto.getIdProdotto(),prodotto.getPartitaIva());
   /*tp.setIdProdotto(idProdotto);
    tp.setIdTag(idTag);
    tp.setPartitaIva(prodotto.getPartitaIva());*/
    //tpd.createTagProdotto(tp);
  //}

  /*@AfterEach
  void tearDown() {
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
    tagDAO.deleteTag(idTag);
    tpd.deleteTagProdotto(idTag,idProdotto,prodotto.getPartitaIva());
  }

  @Test
  void doRetrieveByIdTag() {
    TagProdotto tp1 = tpd.doRetrieveByIdTag(idTag);
    assertEquals(tp.getIdTag(),tp1.getIdTag());
  }

  @Test
  void createTagProdotto() {
    tpd = new TagProdottoDAO();
    TagProdotto tp3 = new TagProdotto();
    tp3.setIdProdotto(150);
    tp3.setIdTag(145);
    tp3.setPartitaIva(fornitore.getPartitaIva());
    tpd.createTagProdotto(tp3);
  }

  @Test
  void deleteTagProdotto() {

  }

  @Test
  void doRetrieveByIdProdottoandPartitaIva() {
    TagProdotto tp2 = tpd.doRetrieveByIdProdottoandPartitaIva(idProdotto, prodotto.getPartitaIva());
    assertEquals(idProdotto,tp2.getIdProdotto());
    assertEquals(prodotto.getPartitaIva(), tp2.getPartitaIva());
  }*/
}