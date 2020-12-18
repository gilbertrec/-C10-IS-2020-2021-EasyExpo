package Model.DAO;

import Model.POJO.Prodotto;
import Model.POJO.ProdottoRichiesta;

import java.sql.*;

public class ProdottoRichiestaDAO {

    public ProdottoRichiesta doRetrieveById(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT id, idRichiesta, idProdotto, numColli, prezzo, dataInizioNoleggio, dataFineNoleggio  FROM ProdottoRichiesta as pr, RichiestaPreventivo as rp, Prodotto as p  WHERE id=? " +
                            "AND pr.idRichiesta=rp.idRichiesta AND pr.idProdotto=p.idProdotto");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ProdottoRichiesta pr = new ProdottoRichiesta();
                pr.setId(rs.getInt(1));
                pr.setIdRichiesta(rs.getInt(2));
                pr.setIdProdotto(rs.getInt(3));
                pr.setNumColli(rs.getInt(4));
                pr.setPrezzo(rs.getFloat(5));
                pr.setDataInizioNoleggio(rs.getDate(6));
                pr.setDataFineNoleggio(rs.getDate(7));
                return pr;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createProdottoRichiesta(ProdottoRichiesta prodottoRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ProdottoRichiesta (id, idRichiesta, idProdotto, numColli, prezzo, dataInizioNoleggio, dataFineNoleggio) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, prodottoRichiesta.getId());
            ps.setInt(2,prodottoRichiesta.getIdRichiesta());
            ps.setInt(3, prodottoRichiesta.getIdProdotto());
            ps.setInt(4, prodottoRichiesta.getNumColli());
            ps.setFloat(5, prodottoRichiesta.getPrezzo());
            ps.setDate(6, prodottoRichiesta.getDataInizioNoleggio());
            ps.setDate(7, prodottoRichiesta.getDataFineNoleggio());
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
