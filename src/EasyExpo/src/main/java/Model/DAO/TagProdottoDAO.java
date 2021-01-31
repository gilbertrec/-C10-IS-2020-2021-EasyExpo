package Model.DAO;

import Model.POJO.Tag;
import Model.POJO.TagProdotto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * <p> TagProdottoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto TagProdotto </p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */

public class TagProdottoDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo TagProdotto correlato ad un idTag dato in input.
   *
   * @param idTag codice identificativo, Intero
   * @return TagProdotto - Oggetto di tipo {@link TagProdotto}
   */

  public TagProdotto doRetrieveByIdTag(int idTag) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT tp.idTag, tp.partitaIva, tp.idProdotto "
                  + "FROM TagProdotto as tp, Tag as t, Prodotto as p WHERE tp.idTag=? "
                  + "AND tp.idTag=t.idTag AND tp.partitaIva=p.partitaIva "
                  + "AND tp.idProdotto=p.idProdotto");
      ps.setInt(1, idTag);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        TagProdotto tp = new TagProdotto();
        tp.setIdTag(rs.getInt(1));
        tp.setPartitaIva(rs.getString(2));
        tp.setIdProdotto(rs.getInt(3));

        return tp;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo tagProdotto contenute nel DB.
   *
   * @return ArrayList &lt;TagProdotto&gt; -
   * {@link ArrayList} di oggetti di tipo {@link TagProdotto}
   */

  public ArrayList<TagProdotto> doRetrieveByIdProdottoPartitaIva(int idProdotto,
                                                                 String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT tp.idTag, tp.partitaIva, tp.idProdotto "
                  + "FROM TagProdotto tp, Tag t, Prodotto p WHERE tp.partitaIva=? "
                  + "AND tp.idProdotto=? AND tp.idTag = t.idTag AND tp.partitaIva = p.partitaIva "
                  + "AND tp.idProdotto = p.idProdotto");

      ps.setString(1, partitaIva);
      ps.setInt(2, idProdotto);
      ResultSet rs = ps.executeQuery();
      ArrayList<TagProdotto> tags = new ArrayList<>();
      while (rs.next()) {
        TagProdotto tp = new TagProdotto();
        tp.setIdTag(rs.getInt(1));
        tp.setPartitaIva(rs.getString(2));
        tp.setIdProdotto(rs.getInt(3));
        tags.add(tp);
      }
      return tags;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo TagProdotto.
   *
   * @param tagProdotto Oggetto di tipo {@link Tag}
   */

  public void createTagProdotto(TagProdotto tagProdotto) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO TagProdotto (idTag, idProdotto, partitaIva) VALUES(?,?,?)");
      ps.setInt(1, tagProdotto.getIdTag());
      ps.setInt(2, tagProdotto.getIdProdotto());
      ps.setString(3, tagProdotto.getPartitaIva());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che elimina dal DB l'istanza TagProdotto correlata all'idTag,
   * all'idProdotto e alla partitaIva dati in input.
   *
   * @param idTag      codice identificativo tag, Intero
   * @param idProdotto codice identificativo prodotto, Intero
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   */

  public void deleteTagProdotto(int idTag, int idProdotto, String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "DELETE FROM TagProdotto WHERE idTag=? AND idProdotto=? AND partitaIva=?");
      ps.setInt(1, idTag);
      ps.setInt(2, idProdotto);
      ps.setString(3, partitaIva);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna l'oggetto di tipo TagProdotto correlato ad una partitaIva data in input.
   *
   * @param idProdotto codice identificativo prodotto, Intero
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   * @return TagProdotto - Oggetto di tipo {@link TagProdotto}
   */

  public TagProdotto doRetrieveByIdProdottoandPartitaIva(int idProdotto, String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT tp.idTag, tp.idProdotto, tp.partitaIva FROM Tag as t, "
                  + "TagProdotto as tp, Prodotto as p "
                  + "WHERE tp.idProdotto=? AND tp.partitaIva=? "
                  + "AND tp.idProdotto=p.idProdotto AND tp.idTag=t.idTag "
                  + "AND tp.partitaIva=p.partitaIva");
      ps.setInt(1, idProdotto);
      ps.setString(2, partitaIva);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        TagProdotto tp = new TagProdotto();
        tp.setIdTag(rs.getInt(1));
        tp.setIdProdotto(rs.getInt(2));
        tp.setPartitaIva(rs.getString(3));
        return tp;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
