package Model.DAO;

import Model.POJO.Preventivo;
import Model.POJO.Prodotto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> PreventivoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Preventivo </p>
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */
public class PreventivoDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo Preventivo correlato ad un idPreventivo dato in input
   *
   * @param idPreventivo codice identificativo, Intero
   * @return Preventivo - Oggetto di tipo {@link Preventivo}
   */
  public Preventivo doRetriveByIdPreventivo(int idPreventivo) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT *  FROM Preventivo as p, Fornitore as f, Cliente as c, RichiestaPreventivo as rp " +
                  "WHERE p.idPreventivo=? AND p.idRichiesta=rp.idRichiesta AND p.partitaIva=f.partitaIva AND p.codiceFiscale=c.codiceFiscale");
      ps.setInt(1, idPreventivo);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Preventivo p = new Preventivo();
        p.setIdPreventivo(rs.getInt(1));
        p.setIdRichiesta(rs.getInt(2));
        p.setPartitaIva(rs.getString(3));
        p.setCodiceFiscale(rs.getString(4));
        p.setDataPreventivo(rs.getDate(5));
        p.setPrezzoTotale(rs.getFloat(6));
        return p;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo Preventivo contenute nel DB
   *
   * @param offset indice partenza, Intero
   * @param limit  indice fine , Intero
   * @return List &lt;Preventivo&gt; - {@link List} di oggetti di tipo {@link Preventivo}
   */
  public List<Preventivo> doRetrieveAll(int offset, int limit) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM Preventivo as p, Fornitore as f, Cliente as c, RichiestaPreventivo as rp" +
                  "WHERE p.idPreventivo=? AND p.idRichiesta=rp.idRichiesta AND p.partitaIva=f.partitaIva AND p.codiceFiscale=c.codiceFiscale LIMIT ?, ?");
      ps.setInt(1, offset);
      ps.setInt(2, limit);
      ArrayList<Preventivo> preventivi = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Preventivo p = new Preventivo();
        p.setIdPreventivo(rs.getInt(1));
        p.setIdRichiesta(rs.getInt(2));
        p.setPartitaIva(rs.getString(3));
        p.setCodiceFiscale(rs.getString(4));
        p.setDataPreventivo(rs.getDate(5));
        p.setPrezzoTotale(rs.getFloat(6));
        preventivi.add(p);
      }
      return preventivi;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo Preventivo
   *
   * @param preventivo Oggetto di tipo {@link Preventivo}
   */
  public void createPreventivo(Preventivo preventivo) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO Preventivo (idRichiesta, partitaIva, codiceFiscale, dataPreventivo, prezzoTotale, nota) VALUES(?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      ps.setInt(1, preventivo.getIdRichiesta());
      ps.setString(2, preventivo.getPartitaIva());
      ps.setString(3, preventivo.getCodiceFiscale());
      ps.setDate(4, preventivo.getDataPreventivo());
      ps.setFloat(5, preventivo.getPrezzoTotale());
      ps.setString(6, preventivo.getNota());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      preventivo.setIdPreventivo(rs.getInt(1));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public List<Preventivo> doRetrieveByPartitaIva(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT *  FROM Preventivo as p, Fornitore as f, Cliente as c, RichiestaPreventivo as rp " +
                  "WHERE p.partitaIva=? AND p.idRichiesta=rp.idRichiesta AND p.partitaIva=f.partitaIva AND p.codiceFiscale=c.codiceFiscale");
      ps.setString(1, partitaIva);
      ArrayList<Preventivo> preventivi = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Preventivo p = new Preventivo();
        p.setIdPreventivo(rs.getInt(1));
        p.setIdRichiesta(rs.getInt(2));
        p.setPartitaIva(rs.getString(3));
        p.setCodiceFiscale(rs.getString(4));
        p.setDataPreventivo(rs.getDate(5));
        p.setPrezzoTotale(rs.getFloat(6));
        preventivi.add(p);
      }
      return preventivi;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Preventivo> doRetrieveByCodiceFiscale(String codiceFiscale) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT *  FROM Preventivo as p, Fornitore as f, Cliente as c, RichiestaPreventivo as rp " +
                  "WHERE p.codiceFiscale=? AND p.idRichiesta=rp.idRichiesta AND p.partitaIva=f.partitaIva AND p.codiceFiscale=c.codiceFiscale");
      ps.setString(1, codiceFiscale);
      ArrayList<Preventivo> preventivi = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Preventivo p = new Preventivo();
        p.setIdPreventivo(rs.getInt(1));
        p.setIdRichiesta(rs.getInt(2));
        p.setPartitaIva(rs.getString(3));
        p.setCodiceFiscale(rs.getString(4));
        p.setDataPreventivo(rs.getDate(5));
        p.setPrezzoTotale(rs.getFloat(6));
        preventivi.add(p);
      }
      return preventivi;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  /**
   * Metodo che elimina dal DB l'istanza Preventivo correlata all'idPreventivo dato in input
   *
   * @param idPreventivo codice identificativo Preventivo, Intero
   */
  public void deletePreventivo(int idPreventivo) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Preventivo WHERE idPreventivo=?");
      ps.setInt(1, idPreventivo);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}