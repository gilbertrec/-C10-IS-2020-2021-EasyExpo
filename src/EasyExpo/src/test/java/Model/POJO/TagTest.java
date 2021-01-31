package Model.POJO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagTest {

  private Tag tag;

  @BeforeEach
  void setUp() {
    tag = new Tag(2, "musica");
  }

  @AfterEach
  void tearDown() {
    tag = new Tag(2, "musica");
  }

  @Test
  void testTagCostructorEmpty() {
    tag = new Tag();
    assertNotNull(tag);
  }

  @Test
  void getIdTag() {
    assertEquals(2, tag.getIdTag());
  }

  @Test
  void setIdTag() {
    tag.setIdTag(3);
    assertEquals(3, tag.getIdTag());
  }

  @Test
  void getNome() {
    assertEquals("musica", tag.getNome());
  }

  @Test
  void setNome() {
    tag.setNome("catering");
    assertEquals("catering", tag.getNome());
  }
}