package Model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Model.POJO.Tag;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TagDAOTest {
  TagDAO tag;
  Tag t;

  @BeforeEach
  void setUp() {
    tag = new TagDAO();
    t = new Tag();
    t.setIdTag(1);
    t.setNome("TagTest");
    tag.createTag(t);
  }

  @AfterEach
  void tearDown() {
    tag.deleteTag(1);
  }

  @Test
  void doRetrieveByIdTag() {
    Tag t1 = tag.doRetrieveByIdTag(1);
    assertEquals(1, t1.getIdTag());
  }

  @Test
  void doRetrieveByNome() {
    List<Tag> t1 = tag.doRetrieveByNome("TagTest");
    assertEquals("TagTest", t1.get(0).getNome());
  }

  @Test
  void createTag() {
    Tag tag1 = new Tag();
    tag1.setIdTag(2);
    tag1.setNome("TestTest");

    tag.createTag(tag1);
    Tag tag2 = tag.doRetrieveByIdTag(2);

    assertEquals(tag1.getIdTag(), tag2.getIdTag());

    tag.deleteTag(2);
  }

  @Test
  void createTagException() {
    Tag tag1 = new Tag();
    tag1.setIdTag(2);
    tag1.setNome("TestTestvceeygciwuixowndibcbiebcowbdjebcueubcuhdie");
    assertThrows(RuntimeException.class, () -> {
      tag.createTag(tag1);
    });
  }

  @Test
  void deleteTag() {
    Tag tag2 = new Tag();
    tag2.setNome("TestTest");

    int idTag = tag.createTag(tag2);
    Tag tag3 = tag.doRetrieveByIdTag(idTag);

    tag.deleteTag(idTag);
    assertNull(tag.doRetrieveByIdTag(idTag));
  }
}