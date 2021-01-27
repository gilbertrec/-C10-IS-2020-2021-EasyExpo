package Model.DAO;

import Model.POJO.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p> AdminDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Admin </p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */
public class AdminDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo Admin correlato all'email data in input.
   *
   * @param email    Indirizzo email identificativo, String
   * @param password codice identificativo, String
   * @return Admin - Oggetto di tipo {@link Admin}
   */

  public Admin doRetrieveByEmailandPassword(String email, String password) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "SELECT email, password FROM Admin WHERE email=? AND password=sha2(?, 512)");
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Admin a = new Admin();
        a.setEmail(rs.getString(1));
        a.setPassword(rs.getString(2));
        return a;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
