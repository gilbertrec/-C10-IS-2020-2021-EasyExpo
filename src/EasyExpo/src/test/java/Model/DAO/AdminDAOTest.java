package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdminDAOTest {
  Admin admin = new Admin();
  AdminDAO adDAO = new AdminDAO();

  @Test
  void doRetrieveByEmailandPassword() {
    Admin ad = adDAO.doRetrieveByEmailandPassword("lucrezia.robustelli@gmail.com", "lucry00*");
    assertEquals("lucrezia.robustelli@gmail.com", ad.getEmail());
  }
}