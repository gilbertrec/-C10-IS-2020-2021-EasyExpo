package Model.DAO;

import Model.POJO.ProdottoRichiesta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> ProdottoRichiestaDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto ProdottoRichiesta </p>
 * @author
 * @version 1.0
 * @since   2020-12-29
 */

public class ProdottoRichiestaDAO {

    /**
     * Metodo che ritorna l'oggetto di tipo ProdottoRichiesta correlato ad un id dato in input
     * @param  id  codice identificativo, Intero
     * @return  ProdottoRichiesta - Oggetto di tipo {@link ProdottoRichiesta}
     *
     */

    public ProdottoRichiesta doRetrieveById(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                .prepareStatement("SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p WHERE pr.id=? AND pr.idRichiesta=rp.idRichiesta AND pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
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


    public ProdottoRichiesta doRetrieveByIdProdottoPartitaIvaIdRichiesta(int idProdotto, String partitaIva, int idRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                .prepareStatement("SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p WHERE pr.idProdotto=? AND pr.partitaIva=? AND pr.idRichiesta=? AND pr.idRichiesta=rp.idRichiesta AND pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
            ps.setInt(1, idProdotto);
            ps.setString(2, partitaIva);
            ps.setInt(3, idRichiesta);
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

    public List<ProdottoRichiesta> doRetrieveByIdRichiesta(int idRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                .prepareStatement("SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p WHERE pr.idRichiesta=? AND pr.idRichiesta=rp.idRichiesta AND pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
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

    public List<ProdottoRichiesta> doRetrieveByIdProdottoePartitaIva(int idProdotto, String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                .prepareStatement("SELECT * FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p WHERE pr.idProdotto=? AND pr.partitaIva=? AND pr.idRichiesta=rp.idRichiesta AND pr.idProdotto=p.idProdotto AND pr.partitaIva=p.partitaIva");
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
     * Metodo che crea un'istanza, all'interno del DB, di tipo ProdottoRichiesta
     * @param prodottoRichiesta  Oggetto di tipo {@link ProdottoRichiesta}
     *
     */
    public void createProdottoRichiesta(ProdottoRichiesta prodottoRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ProdottoRichiesta (id, idRichiesta, idProdotto, partitaIva, numColli, prezzo, dataInizioNoleggio, dataFineNoleggio) VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, prodottoRichiesta.getId());
            ps.setInt(2,prodottoRichiesta.getIdRichiesta());
            ps.setInt(3, prodottoRichiesta.getIdProdotto());
            ps.setString(4, prodottoRichiesta.getPartitaIva());
            ps.setInt(5, prodottoRichiesta.getNumColli());
            ps.setFloat(6, prodottoRichiesta.getPrezzo());
            ps.setDate(7, prodottoRichiesta.getDataInizioNoleggio());
            ps.setDate(8, prodottoRichiesta.getDataFineNoleggio());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            prodottoRichiesta.setIdProdotto(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che elimina dal DB l'istanza ProdottoRichiesta correlata all'id dato in input
     * @param id  codice identificativo, Intero
     */

    public void deleteProdottoRichiesta(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ProdottoRichiesta WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
