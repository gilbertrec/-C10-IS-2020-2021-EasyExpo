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

  @BeforeEach
  void setUp() {
    fornitoreDAO = new FornitoreDAO();
    fornitore = new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
        "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);

    prodottoDAO = new ProdottoDAO();
    prodotto = new Prodotto();
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
    tag.setNome("NomeTest");
    idTag = tagDAO.createTag(tag);

    tpd = new TagProdottoDAO();
    tp = new TagProdotto();
    tp.setIdProdotto(idProdotto);
    tp.setIdTag(idTag);
    tp.setPartitaIva(prodotto.getPartitaIva());
    tpd.createTagProdotto(tp);

  }

  @AfterEach
  void tearDown() {
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
    tagDAO.deleteTag(idTag);
  }

  @Test
  void doRetrieveByIdTag() {
    TagProdotto tp1 = tpd.doRetrieveByIdTag(idTag);
    assertEquals(tp.getIdTag(),tp1.getIdTag());
  }

  @Test
  void createTagProdotto() {
    tagDAO = new TagDAO();
    Tag tag2 = new Tag();
    tag2.setNome("NomeTest secondo");
    int idTag2 = tagDAO.createTag(tag2);

    TagProdotto tp2 = new TagProdotto(idTag2, idProdotto,prodotto.getPartitaIva());
    tpd.createTagProdotto(tp2);

    TagProdotto tp3 = tpd.doRetrieveByIdTag(idTag2);
    assertEquals(tp2.getIdProdotto(), tp3.getIdProdotto());
    assertEquals(tp2.getPartitaIva(), tp3.getPartitaIva());
    assertEquals(tp2.getIdTag(), tp3.getIdTag());


  }

  @Test
  void deleteTagProdotto() {
    tagDAO = new TagDAO();
    Tag tag3 = new Tag();
    tag3.setNome("NomeTest terzo");
    int idTag3 = tagDAO.createTag(tag3);

    TagProdotto tp3 = new TagProdotto(idTag3, idProdotto,prodotto.getPartitaIva());
    tpd.createTagProdotto(tp3);

    TagProdotto tp4 = tpd.doRetrieveByIdTag(idTag3);

    tpd.deleteTagProdotto(idTag3, idProdotto,prodotto.getPartitaIva());
    assertNull(tpd.doRetrieveByIdTag(idTag3));
  }

  @Test
  void doRetrieveByIdProdottoandPartitaIva() {
    TagProdotto tag5 = tpd.doRetrieveByIdProdottoandPartitaIva(tp.getIdProdotto(), prodotto.getPartitaIva());
    assertEquals(tp.getIdProdotto(), tag5.getIdProdotto());
    assertEquals(tp.getPartitaIva(), tag5.getPartitaIva());
  }
}