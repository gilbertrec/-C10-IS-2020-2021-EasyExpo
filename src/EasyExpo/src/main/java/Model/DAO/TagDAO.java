package Model.DAO;

import Model.POJO.Fornitore;
import Model.POJO.Tag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> TagDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Tag </p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */

public class TagDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo Tag correlato ad un idTag dato in input.
   *
   * @param idTag codice identificativo, Intero
   * @return Tag - Oggetto di tipo {@link Tag}
   */

  public Tag doRetrieveByIdTag(int idTag) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement("SELECT * FROM Tag WHERE idTag=?");
      ps.setInt(1, idTag);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Tag t = new Tag();
        t.setIdTag(rs.getInt(1));
        t.setNome(rs.getString(2));
        return t;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo Tag contenute nel DB.
   *
   * @param ricercato , String
   * @return List &lt;Tag&gt; - {@link List} di oggetti di tipo
   * {@link Tag}
   */

  public List<Tag> doRetrieveByNome(String ricercato) {
    try (Connection con = DBConnection.getConnection()) {

      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM Tag WHERE nome LIKE ? ");
      ps.setString(1, "%" + ricercato + "%");

      ArrayList<Tag> tag = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Tag t = new Tag();
        t.setIdTag(rs.getInt(1));
        t.setNome(rs.getString(2));
        tag.add(t);
      }
      return tag;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo Tag.
   *
   * @param tag Oggetto di tipo {@link Tag}
   */
  public void createTag(Tag tag) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO Tag (idTag, nome) VALUES(?,?)",
          Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, tag.getIdTag());
      ps.setString(2, tag.getNome());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      tag.setIdTag(rs.getInt(1));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che elimina dal DB l'istanza Tag correlata all'idTag dato in input.
   *
   * @param idTag codice identificativo, Intero
   */

  public void deleteTag(int idTag) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Tag WHERE idTag=?");
      ps.setInt(1, idTag);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
