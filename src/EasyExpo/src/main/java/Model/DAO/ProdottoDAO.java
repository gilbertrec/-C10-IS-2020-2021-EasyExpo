package Model.DAO;

import Model.POJO.Fornitore;
import Model.POJO.Prodotto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public Prodotto doRetrieveByIdProdotto(int idProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idProdotto, partitaIva, titolo, descrizione, prezzo, tipo, quantita  FROM Prodotto WHERE idProdotto=?");
            ps.setInt(1, idProdotto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setTipo(rs.getString(6));
                p.setQuantità(rs.getInt(7));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Prodotto> doRetrieveAll(int offset, int limit) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idProdotto, partitaIva, titolo, descrizione, prezzo, tipo, quantita FROM Prodotto LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setPrezzo(rs.getFloat(5));
                p.setTipo(rs.getString(6));
                p.setQuantità(rs.getInt(7));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProdotto(Prodotto prodotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotto (idProdotto, partitaIva, titolo, descrizione, prezzo, tipo, quantita) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, prodotto.getIdProdotto());
            ps.setString(2,prodotto.getPartitaIva());
            ps.setString(3, prodotto.getTitolo());
            ps.setString(4, prodotto.getDescrizione());
            ps.setFloat(5, prodotto.getPrezzo());
            ps.setString(6, prodotto.getTipo());
            ps.setInt(7, prodotto.getQuantità());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            prodotto.setIdProdotto(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProdotto(int idProdotto) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE idProdotto=?");
            ps.setInt(1, idProdotto);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
