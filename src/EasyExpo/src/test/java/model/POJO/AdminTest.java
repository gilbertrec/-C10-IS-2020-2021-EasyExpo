package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

  @BeforeEach
  void setUp() {
    admin = new Admin("sabatino@gmail.com", "Sabatino20_");
  }

  @AfterEach
  void tearDown() {
    admin = new Admin("sabatino@gmail.com", "Sabatino20_");
  }

    @Test
    void testAdminCostructorEmpty() {
        admin = new Admin();
        assertNotNull(admin);
    }
  @Test
  void getEmail() {
    assertEquals("sabatino@gmail.com", admin.getEmail());
  }

  @Test
  void setEmail() {
    admin.setEmail("prova@gmail.com");
    assertEquals("prova@gmail.com", admin.getEmail());
  }

  @Test
  void getPassword() {
    assertEquals("Sabatino20_", admin.getPassword());
  }

  @Test
  void setPassword() {
    admin.setPassword("davide123");
    assertEquals("davide123", admin.getPassword());
  }

  private Admin admin;
}