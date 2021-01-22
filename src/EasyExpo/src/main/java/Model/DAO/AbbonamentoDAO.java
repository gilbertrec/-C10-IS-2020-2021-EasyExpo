package Model.DAO;

import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> AbbonamentoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Abbonamento </p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */
public class AbbonamentoDAO {

  /**
   * Metodo che ritorna le istanze di tipo Abbonamento correlato ad una patitaIva data in input.
   *
   * @param partitaIva codice alfanumerico, String
   * @return List &lt;Abbonamento&gt; - {@link List} di oggetti di tipo {@link Abbonamento}
   */

  public List<Abbonamento> doRetrieveByPartitaIva(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM Abbonamento as a, Fornitore as f "
                      + "WHERE a.partitaIva=? AND a.partitaIva=f.partitaIva");
      ps.setString(1, partitaIva);
      ArrayList<Abbonamento> abbonamenti = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Abbonamento a = new Abbonamento();
        a.setIdAbbonamento(rs.getInt(1));
        a.setPartitaIva(rs.getString(2));
        a.setDataInizio(rs.getDate(3));
        a.setDataFine(rs.getDate(4));
        abbonamenti.add(a);
      }
      return abbonamenti;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo Abbonamento.
   *
   * @param abbonamento Oggetto di tipo {@link Abbonamento}
   */

  public boolean createAbbonamento(Abbonamento abbonamento) {
    boolean flag = false;
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO Abbonamento ( partitaIva, dataInizio, dataFine) VALUES(?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, abbonamento.getPartitaIva());
      ps.setDate(2, abbonamento.getDataInizio());
      ps.setDate(3, abbonamento.getDataFine());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      abbonamento.setIdAbbonamento(rs.getInt(1));
      flag = true;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return  flag;
  }

}