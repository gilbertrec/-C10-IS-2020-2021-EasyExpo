package Model.DAO;

import Model.POJO.RichiestaPreventivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> RichiestaPreventivoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto RichiestaPreventivo </p>.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */

public class RichiestaPreventivoDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo RichiestaPreventivo correlato ad
   * un idRichiesta dato in input.
   *
   * @param idRichiesta codice identificativo, Intero
   * @return RichiestaPreventivo - Oggetto di tipo {@link RichiestaPreventivo}
   */

  public RichiestaPreventivo doRetrieveByIdRichiesta(int idRichiesta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM RichiestaPreventivo as rp, Cliente as c, Fornitore as f "
                  + "WHERE rp.idRichiesta=? AND rp.codiceFiscale=c.codiceFiscale AND"
                  + " rp.partitaIva=f.partitaIva");
      ps.setInt(1, idRichiesta);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        RichiestaPreventivo r = new RichiestaPreventivo();
        r.setIdRichiesta(rs.getInt(1));
        r.setCodiceFiscale(rs.getString(2));
        r.setPartitaIva(rs.getString(3));
        r.setTitolo(rs.getString(4));
        r.setLuogoEvento(rs.getString(5));
        r.setDescrizioneEvento(rs.getString(6));
        r.setNota(rs.getString(7));
        r.setDataRichiesta(rs.getDate(8));
        r.setStato(RichiestaPreventivo.Stato.valueOf(rs.getString(9)));
        return r;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo RichiestaPreventivo contenute nel DB.
   *
   * @param partitaIva codice alfanumeirco, String
   * @return List &lt;RichiestaPreventivo&gt; - {@link List} di oggetti di tipo
   * {@link RichiestaPreventivo}
   */

  public List<RichiestaPreventivo> doRetrieveByPartitaIva(String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM RichiestaPreventivo as rp, Cliente as c, Fornitore as "
                  + "f WHERE rp.partitaIva=? AND rp.codiceFiscale=c.codiceFiscale AND "
                  + "rp.partitaIva=f.partitaIva");
      ps.setString(1, partitaIva);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        RichiestaPreventivo r = new RichiestaPreventivo();
        r.setIdRichiesta(rs.getInt(1));
        r.setCodiceFiscale(rs.getString(2));
        r.setPartitaIva(rs.getString(3));
        r.setTitolo(rs.getString(4));
        r.setLuogoEvento(rs.getString(5));
        r.setDescrizioneEvento(rs.getString(6));
        r.setNota(rs.getString(7));
        r.setDataRichiesta(rs.getDate(8));
        r.setStato(RichiestaPreventivo.Stato.valueOf(rs.getString(9)));
        richieste.add(r);
      }
      return richieste;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo RichiestaPreventivo contenute nel DB.
   *
   * @param codiceFiscale codice alfanumerico, String
   * @return List &lt;RichiestaPreventivo&gt; - {@link List} di oggetti di tipo
   * {@link RichiestaPreventivo}
   */

  public List<RichiestaPreventivo> doRetrieveByCodiceFiscale(String codiceFiscale) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM RichiestaPreventivo as rp, Cliente as c, Fornitore as "
                  + "f WHERE rp.codiceFiscale=? AND rp.codiceFiscale=c.codiceFiscale"
                  + " AND rp.partitaIva=f.partitaIva");
      ps.setString(1, codiceFiscale);
      ArrayList<RichiestaPreventivo> richieste = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        RichiestaPreventivo r = new RichiestaPreventivo();
        r.setIdRichiesta(rs.getInt(1));
        r.setCodiceFiscale(rs.getString(2));
        r.setPartitaIva(rs.getString(3));
        r.setTitolo(rs.getString(4));
        r.setLuogoEvento(rs.getString(5));
        r.setDescrizioneEvento(rs.getString(6));
        r.setNota(rs.getString(7));
        r.setDataRichiesta(rs.getDate(8));
        r.setStato(RichiestaPreventivo.Stato.valueOf(rs.getString(9)));
        richieste.add(r);
      }
      return richieste;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo RichiestaPreventivo.
   *
   * @param richiestaPreventivo Oggetto di tipo {@link RichiestaPreventivo}
   */

  public int createRichiestaPreventivo(RichiestaPreventivo richiestaPreventivo) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO RichiestaPreventivo (codiceFiscale, "
              + "partitaIva, titolo, luogoEvento,"
              + " descrizioneEvento, nota, dataRichiesta, stato) VALUES(?,?,?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, richiestaPreventivo.getCodiceFiscale());
      ps.setString(2, richiestaPreventivo.getPartitaIva());
      ps.setString(3, richiestaPreventivo.getTitolo());
      ps.setString(4, richiestaPreventivo.getLuogoEvento());
      ps.setString(5, richiestaPreventivo.getDescrizioneEvento());
      ps.setString(6, richiestaPreventivo.getNota());
      ps.setDate(7, richiestaPreventivo.getDataRichiesta());
      ps.setString(8,
          richiestaPreventivo.getStato().toString()); //oppure .name() per caratteri uguali
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      richiestaPreventivo.setIdRichiesta(rs.getInt(1));
      return rs.getInt(1);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che aggiorna nel DB l'istanza RichiestaPreventivo correlata
   * alla RichiestaPreventivo dato in input.
   *
   * @param richiestaPreventivo Oggetto di tipo {@link RichiestaPreventivo}
   */

  public void updateRichiestaPreventivo(RichiestaPreventivo richiestaPreventivo) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "UPDATE RichiestaPreventivo SET codiceFiscale=?, partitaIva=?, titolo=?, luogoEvento=?, "
              + "descrizioneEvento=?, nota=?, dataRichiesta=?, stato=? WHERE idRichiesta=?");
      ps.setString(1, richiestaPreventivo.getCodiceFiscale());
      ps.setString(2, richiestaPreventivo.getPartitaIva());
      ps.setString(3, richiestaPreventivo.getTitolo());
      ps.setString(4, richiestaPreventivo.getLuogoEvento());
      ps.setString(5, richiestaPreventivo.getDescrizioneEvento());
      ps.setString(6, richiestaPreventivo.getNota());
      ps.setDate(7, richiestaPreventivo.getDataRichiesta());
      ps.setString(8,
          richiestaPreventivo.getStato().toString());
      ps.setInt(9, richiestaPreventivo.getIdRichiesta());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("UPDATE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che elimina dal DB l'istanza RichiestaPreventivo correlata
   * all'idRichiesta dato in input.
   *
   * @param idRichiesta codice identificativo, Intero
   */

  public void deleteRichiestePreventivo(int idRichiesta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps =
          con.prepareStatement("DELETE FROM RichiestaPreventivo "
              + "WHERE idRichiesta=?");
      ps.setInt(1, idRichiesta);
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("DELETE error.");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
