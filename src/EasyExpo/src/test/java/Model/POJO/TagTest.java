package Model.POJO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagTest {

private Tag t;

  @BeforeEach
  void setUp() {
  t = new Tag(2,"musica");
  }

  @AfterEach
  void tearDown() {
    t = new Tag(2,"musica");
  }

  @Test
  void testTagCostructorEmpty() {
    t = new Tag();
    assertNotNull(t);
  }
  @Test
  void getIdTag() {
    assertEquals(2, t.getIdTag());
  }

  @Test
  void setIdTag() {
    t.setIdTag(3);
    assertEquals(3, t.getIdTag());
  }

  @Test
  void getNome() {
    assertEquals("musica", t.getNome());
  }

  @Test
  void setNome() {
    t.setNome("catering");
    assertEquals("catering", t.getNome());
  }
}