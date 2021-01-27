package Model.POJO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagProdottoTest {
  private TagProdotto tp;

  @BeforeEach
  void setUp() {
    tp = new TagProdotto(1, 2, "71272150567");
  }

  @AfterEach
  void tearDown() {
    tp = new TagProdotto(1, 2, "71272150567");
  }

  @Test
  void testTagProdottoCostructorEmpty() {
    tp = new TagProdotto();
    assertNotNull(tp);
  }

  @Test
  void getIdTag() {
    assertEquals(1, tp.getIdTag());
  }

  @Test
  void setIdTag() {
    tp.setIdTag(3);
    assertEquals(3, tp.getIdTag());
  }

  @Test
  void getIdProdotto() {
    assertEquals(2, tp.getIdProdotto());
  }

  @Test
  void setIdProdotto() {
    tp.setIdProdotto(4);
    assertEquals(4, tp.getIdProdotto());
  }

  @Test
  void getPartitaIva() {
    assertEquals("71272150567", tp.getPartitaIva());
  }

  @Test
  void setPartitaIva() {
    tp.setPartitaIva("71272150123");
    assertEquals("71272150123", tp.getPartitaIva());
  }
}