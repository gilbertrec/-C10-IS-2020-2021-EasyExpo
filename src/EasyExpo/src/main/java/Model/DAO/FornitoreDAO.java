package Model.DAO;

import Model.POJO.Fornitore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> FornitoreDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Fornitore </p>
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */
public class FornitoreDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo Fornitore correlato ad una partitaIva data in input
   *
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   * @return Fornitore - Oggetto di tipo {@link Fornitore}
   */
  public Fornitore doRetrieveByPIVA(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT partitaIva, nome, cognome, telefono, luogoUbicazione, email, password, ragioneSociale, abbonato  FROM Fornitore WHERE partitaIva=?");
      ps.setString(1, partitaIva);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        f.setCognome(rs.getString(3));
        f.setTelefono(rs.getString(4));
        f.setLuogoUbicazione(rs.getString(5));
        f.setEmail(rs.getString(6));
        f.setPassword(rs.getString(7));
        f.setRagioneSociale(rs.getString(8));
        f.setAbbonato(rs.getBoolean(9));
        return f;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo Fornitore contenute nel DB
   *
   * @param offset indice partenza, Intero
   * @param limit  indice fine , Intero
   * @return List &lt;Fornitore&gt; - {@link List} di oggetti di tipo {@link Fornitore}
   */
  public List<Fornitore> doRetrieveAll(int offset, int limit) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement("SELECT * FROM Fornitore LIMIT ?, ?");
      ps.setInt(1, offset);
      ps.setInt(2, limit);
      ArrayList<Fornitore> fornitori = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        f.setCognome(rs.getString(3));
        f.setEmail(rs.getString(4));
        f.setPassword(rs.getString(5));
        f.setTelefono(rs.getString(6));
        f.setLuogoUbicazione(rs.getString(7));
        f.setRagioneSociale(rs.getString(8));
        f.setAbbonato(rs.getBoolean(9));
        fornitori.add(f);
      }
      return fornitori;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo Fornitore
   *
   * @param fornitore Oggetto di tipo {@link Fornitore}
   */
  public void createFornitore(Fornitore fornitore) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO Fornitore (partitaIva, nome, cognome, telefono, luogoUbicazione, email, password, ragioneSociale,abbonato) VALUES(?,?,?,?,?,?,sha2(?, 512),?,?)");

      ps.setString(1, fornitore.getPartitaIva());
      ps.setString(2, fornitore.getNome());
      ps.setString(3, fornitore.getCognome());
      ps.setString(6, fornitore.getEmail());
      ps.setString(7, fornitore.getPassword());
      ps.setString(4, fornitore.getTelefono());
      ps.setString(5, fornitore.getLuogoUbicazione());
      ps.setString(8, fornitore.getRagioneSociale());
      ps.setBoolean(9, fornitore.isAbbonato());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna l'oggetto di tipo Fornitore correlato all'email data in input
   *
   * @param email Indirizzo email identificativo, String
   * @return Fornitore - Oggetto di tipo {@link Fornitore}
   */
  public Fornitore doRetrieveByEmail(String email) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM Fornitore WHERE email=?");
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        f.setCognome(rs.getString(3));
        f.setEmail(rs.getString(4));
        f.setPassword(rs.getString(5));
        f.setTelefono(rs.getString(6));
        f.setLuogoUbicazione(rs.getString(7));
        f.setRagioneSociale(rs.getString(8));
        f.setAbbonato(rs.getBoolean(9));
        return f;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna l'oggetto di tipo Fornitore correlato all'email e password dati in input
   *
   * @param email    Indirizzo email identificativo, String
   * @param password Caratteri alfanumerici per accesso al sistema, String
   * @return Fornitore - Oggetto di tipo {@link Fornitore}
   */
  public Fornitore doRetrieveByEmailandPassword(String email, String password) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM Fornitore WHERE email=? AND password=sha2(?, 512)");
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        f.setCognome(rs.getString(3));
        f.setTelefono(rs.getString(4));
        f.setLuogoUbicazione(rs.getString(5));
        f.setEmail(rs.getString(6));
        f.setPassword(rs.getString(7));
        f.setRagioneSociale(rs.getString(8));
        f.setAbbonato(rs.getBoolean(9));
        return f;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  public List<Fornitore> doRetrieveByNome(String ricercato) {
    try (Connection con = DBConnection.getConnection()) {

      PreparedStatement ps = con.prepareStatement(
          "SELECT partitaIva, nome FROM Fornitore WHERE nome LIKE ? ");
      ps.setString(1, "%" + ricercato + "%");

      ArrayList<Fornitore> fornitore = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        fornitore.add(f);
      }
      return fornitore;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public List<Fornitore> doRetrieveByNomeECognome(String ricercato) {
    try (Connection con = DBConnection.getConnection()) {

      PreparedStatement ps = con.prepareStatement(
          "SELECT partitaIva, nome, cognome, luogoUbicazione FROM Fornitore WHERE nome LIKE ? OR cognome LIKE ? ");
      ps.setString(1, "%" + ricercato + "%");
      ps.setString(2, "%" + ricercato + "%");

      ArrayList<Fornitore> fornitore = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Fornitore f = new Fornitore();
        f.setPartitaIva(rs.getString(1));
        f.setNome(rs.getString(2));
        f.setCognome(rs.getString(3));
        f.setLuogoUbicazione(rs.getString(4));
        fornitore.add(f);
      }
      return fornitore;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  /**
   * Metodo che elimina dal DB l'istanza Fornitore correlata alla partitaIva data in input
   *
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   */
  public void deleteFornitore(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement("DELETE FROM Fornitore WHERE partitaIva=?");
      ps.setString(1, partitaIva);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
