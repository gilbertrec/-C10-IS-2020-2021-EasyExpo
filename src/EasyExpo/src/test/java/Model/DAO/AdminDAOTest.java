package Model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import Model.POJO.Admin;
import org.junit.jupiter.api.Test;

class AdminDAOTest {
  Admin admin = new Admin();
  AdminDAO adDAO = new AdminDAO();

  @Test
  void doRetrieveByEmailandPassword() {
    Admin ad = adDAO.doRetrieveByEmailandPassword("lucrezia.robustelli@gmail.com", "lucry00*");
    assertEquals("lucrezia.robustelli@gmail.com", ad.getEmail());
  }

  @Test
  void EmailFailure() {
    Admin ad2 = adDAO.doRetrieveByEmailandPassword("fra00", "password");
    assertNull(ad2);
  }

  @Test
  void PasswodFailure() {
    Admin ad3 = adDAO.doRetrieveByEmailandPassword("lucrezia.robustelli@gmail.com", "password");
    assertNull(ad3);
  }
}