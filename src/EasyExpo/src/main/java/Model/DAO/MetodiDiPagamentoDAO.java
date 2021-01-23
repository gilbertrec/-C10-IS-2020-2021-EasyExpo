package Model.DAO;

import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> MetodoDiPagamentoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto MetodoPagamento </p>.
 *
 * @author DAVIDE PAPPALARDO
 * @version 1.0
 * @since 2020-12-29
 */
public class MetodiDiPagamentoDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo MetodoPagamento correlato ad una partitaIva data in input.
   *
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   * @return MetodoPagamento - Oggetto di tipo {@link MetodoPagamento}
   */
  public List<MetodoPagamento> doRetrieveAllByPartitaIva(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM MetodoPagamento as mp, Fornitore as f "
                      + "WHERE mp.partitaIva=? AND mp.partitaIva=f.partitaIva");
      ps.setString(1, partitaIva);
      ArrayList<MetodoPagamento> metodiPagamenti = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        MetodoPagamento c = new MetodoPagamento();
        c.setNumeroCarta(rs.getString(1));
        c.setPartitaIva(rs.getString(2));
        c.setNomeIntestatario(rs.getString(3));
        c.setDataScadenza(rs.getDate(4));
        c.setCvv(rs.getInt(5));
        metodiPagamenti.add(c);
      }
      return metodiPagamenti;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna l'oggetto di tipo MetodoPagamento correlato ad un numeroCarta dato in input.
   *
   * @param numCarta codice numerico, String
   * @return MetodoPagamento - Oggetto di tipo {@link MetodoPagamento}
   */

  public MetodoPagamento doRetrieveByNumCarta(String numCarta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM MetodiPagamento WHERE numCarta=?");
      ps.setString(1, numCarta);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        MetodoPagamento c = new MetodoPagamento();
        c.setNumeroCarta(rs.getString(1));
        c.setPartitaIva(rs.getString(2));
        c.setNomeIntestatario(rs.getString(3));
        c.setDataScadenza(rs.getDate(4));
        c.setCvv(rs.getInt(5));
        return c;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo MetodoPagamento.
   *
   * @param metodoPagamento Oggetto di tipo {@link MetodoPagamento}
   */
  public void createMetodoPagamento(MetodoPagamento metodoPagamento) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO MetodoPagamento (numeroCarta, partitaIva, nomeIntestatario, "
                  + "dataScadenza, cvv) VALUES(?,?,?,?,?)");
      ps.setString(1, metodoPagamento.getNumeroCarta());
      ps.setString(2, metodoPagamento.getPartitaIva());
      ps.setString(3, metodoPagamento.getNomeIntestatario());
      ps.setDate(4, metodoPagamento.getDataScadenza());
      ps.setInt(5, metodoPagamento.getCvv());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che elimina dal DB l'istanza MetodoPagamento correlata al numeroCarta dato in input.
   *
   * @param numeroCarta Codice numerico identificativo metodoPagamento, String
   */
  public void deleteMetodoPagamento(String numeroCarta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("DELETE FROM MetodoPagamento WHERE numeroCarta=?");
      ps.setString(1, numeroCarta);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
