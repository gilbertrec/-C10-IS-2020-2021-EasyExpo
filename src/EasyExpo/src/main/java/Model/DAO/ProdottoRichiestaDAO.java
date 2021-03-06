package Model.DAO;

import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * ProdottoRichiestaDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto ProdottoRichiesta.
 *
 * @author GIUSEPPE AVINO
 * @version 1.0
 * @since 2020-12-29
 */

public class ProdottoRichiestaDAO {

  /**
   * Metodo che ritorna l'oggetto di tipo ProdottoRichiesta correlato ad un id dato in input.
   *
   * @param id codice identificativo, Intero
   * @return ProdottoRichiesta - Oggetto di tipo {@link ProdottoRichiesta}
   */

  public ProdottoRichiesta doRetrieveById(int id) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo "
                      + "as rp, Prodotto as p WHERE pr.id=? AND pr.idRichiesta=rp.idRichiesta "
                      + "AND pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        ProdottoRichiesta pr = new ProdottoRichiesta();
        pr.setId(rs.getInt(1));
        pr.setIdRichiesta(rs.getInt(2));
        pr.setIdProdotto(rs.getInt(3));
        pr.setPartitaIva(rs.getString(4));
        pr.setNumColli(rs.getInt(5));
        pr.setPrezzo(rs.getFloat(6));
        pr.setDataInizioNoleggio(rs.getDate(7));
        pr.setDataFineNoleggio(rs.getDate(8));
        return pr;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo ProdottoRicheista contenute nel DB.
   *
   * @param idRichiesta codice nuemerico, Intero
   * @return List &lt;ProdottoRichiesta&gt; - {@link List} di oggetti di tipo
   * {@link ProdottoRichiesta}
   */


  public List<ProdottoRichiesta> doRetrieveByIdRichiesta(int idRichiesta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo "
                      + "as rp, Prodotto as p WHERE pr.idRichiesta=? "
                      + "AND pr.idRichiesta=rp.idRichiesta "
                      + "AND pr.idProdotto=p.idProdotto "
                      + "AND pr.partitaIva=p.partitaIva");
      ps.setInt(1, idRichiesta);
      ArrayList<ProdottoRichiesta> prichieste = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        ProdottoRichiesta pr = new ProdottoRichiesta();
        pr.setId(rs.getInt(1));
        pr.setIdRichiesta(rs.getInt(2));
        pr.setIdProdotto(rs.getInt(3));
        pr.setPartitaIva(rs.getString(4));
        pr.setNumColli(rs.getInt(5));
        pr.setPrezzo(rs.getFloat(6));
        pr.setDataInizioNoleggio(rs.getDate(7));
        pr.setDataFineNoleggio(rs.getDate(8));
        prichieste.add(pr);
      }
      return prichieste;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che ritorna le istanze di tipo ProdottoRicheista contenute nel DB.
   *
   * @param idProdotto codice numerico, Intero
   * @param partitaIva codice alfanumerico, String
   * @return List &lt;ProdottoRichiesta&gt; - {@link List} di oggetti di tipo
   * {@link ProdottoRichiesta}
   */


  public List<ProdottoRichiesta> doRetrieveByIdProdottoePartitaIva(int idProdotto,
                                                                   String partitaIva) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con
          .prepareStatement(
              "SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p "
                      + "WHERE pr.idProdotto=? AND pr.partitaIva=? "
                      + "AND pr.idRichiesta=rp.idRichiesta AND "
                      + "pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
      ps.setInt(1, idProdotto);
      ps.setString(2, partitaIva);
      ArrayList<ProdottoRichiesta> prichieste = new ArrayList<>();
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        ProdottoRichiesta pr = new ProdottoRichiesta();
        pr.setId(rs.getInt(1));
        pr.setIdRichiesta(rs.getInt(2));
        pr.setIdProdotto(rs.getInt(3));
        pr.setPartitaIva(rs.getString(4));
        pr.setNumColli(rs.getInt(5));
        pr.setPrezzo(rs.getFloat(6));
        pr.setDataInizioNoleggio(rs.getDate(7));
        pr.setDataFineNoleggio(rs.getDate(8));
        prichieste.add(pr);
      }
      return prichieste;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Metodo che crea un'istanza, all'interno del DB, di tipo ProdottoRichiesta.
   *
   * @param prodottoRichiesta Oggetto di tipo {@link ProdottoRichiesta}
   */
  public int createProdottoRichiesta(ProdottoRichiesta prodottoRichiesta) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO ProdottoRichiesta (idRichiesta, idProdotto, partitaIva, numColli,"
              + " prezzo, dataInizioNoleggio, dataFineNoleggio) VALUES(?,?,?,?,?,?,?)",
          Statement.RETURN_GENERATED_KEYS);


      ps.setInt(1, prodottoRichiesta.getIdRichiesta());
      ps.setInt(2, prodottoRichiesta.getIdProdotto());
      ps.setString(3, prodottoRichiesta.getPartitaIva());
      ps.setInt(4, prodottoRichiesta.getNumColli());
      ps.setFloat(5, prodottoRichiesta.getPrezzo());
      ps.setDate(6, prodottoRichiesta.getDataInizioNoleggio());
      ps.setDate(7, prodottoRichiesta.getDataFineNoleggio());
      if (ps.executeUpdate() != 1) {
        throw new RuntimeException("INSERT error.");
      }
      ResultSet rs = ps.getGeneratedKeys();
      rs.next();
      prodottoRichiesta.setId(rs.getInt(1));
      return rs.getInt(1);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
