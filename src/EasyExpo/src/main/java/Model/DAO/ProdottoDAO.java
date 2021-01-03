package Model.DAO;

import Model.POJO.Prodotto;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    public Prodotto doRetrieveByIdProdotto(int idProdotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Prodotto as p, Fornitore as f WHERE idProdotto=? AND p.partitaIva=f.partitaIva");
            ps.setInt(1, idProdotto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                String a = rs.getString(5);
                Prodotto.Tipo t = Prodotto.Tipo.valueOf(a);
                p.setTipo(t);
                p.setQuantità(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                p.setImmagine(rs.getString(8));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Prodotto doRetrieveByIdProdottoEPartitaIva(int idProdotto, String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Prodotto as p, Fornitore as f WHERE idProdotto=? AND p.partitaIva=? AND p.partitaIva=f.partitaIva");
            ps.setInt(1, idProdotto);
            ps.setString(2, partitaIva);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                String a = rs.getString(5);
                Prodotto.Tipo t = Prodotto.Tipo.valueOf(a);
                p.setTipo(t);
                p.setQuantità(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                p.setImmagine(rs.getString(8));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveByPartitaIva(String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Prodotto as p WHERE p.partitaIva=?");
            ps.setString(1, partitaIva);

            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                String a = rs.getString(5);
                Prodotto.Tipo t = Prodotto.Tipo.valueOf(a);
                p.setTipo(t);
                p.setQuantità(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                p.setImmagine(rs.getString(8));
                prodotti.add(p);
            }
            return prodotti;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveAll(int offset, int limit) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM Prodotto as p, Fornitore as f WHERE p.partitaIva=f.partitaIva LIMIT ?, ?");
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
                String a = rs.getString(5);
                Prodotto.Tipo t = Prodotto.Tipo.valueOf(a);
                p.setTipo(t);
                p.setQuantità(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                p.setImmagine(rs.getString(8));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProdotto(Prodotto prodotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotto (partitaIva, titolo, descrizione, tipo, quantita, prezzo, immagine) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, prodotto.getPartitaIva());
            ps.setString(2, prodotto.getTitolo());
            ps.setString(3, prodotto.getDescrizione());
            ps.setString(4, prodotto.getTipo().toString());
            ps.setInt(5, prodotto.getQuantità());
            ps.setFloat(6, prodotto.getPrezzo());
            ps.setString(7, prodotto.getImmagine());
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

    public void deleteProdotto(int idProdotto, String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE idProdotto=? AND partitaIva=?");
            ps.setInt(1, idProdotto);
            ps.setString(2, partitaIva);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Prodotto> doRetrieveByTitolo(String ricercato) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                    "SELECT idProdotto, partitaIva, titolo, prezzo, immagine FROM Prodotto WHERE titolo LIKE ? ");
            ps.setString(1, "%" + ricercato + "%");

            ArrayList<Prodotto> prodotto = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setPrezzo(rs.getFloat(4));
                p.setImmagine(rs.getString(5));
                prodotto.add(p);
            }
            return prodotto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateProdotto(Prodotto prodotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE Prodotto SET titolo=?, descrizione=?, tipo=?, quantita=?, prezzo=?, immagine=? WHERE idProdotto=? AND partitaIva=?");
            ps.setString(1, prodotto.getTitolo());
            ps.setString(2, prodotto.getDescrizione());
            ps.setString(3, prodotto.getTipo().toString());
            ps.setInt(4, prodotto.getQuantità());
            ps.setFloat(5, prodotto.getPrezzo());
            ps.setString(6, prodotto.getImmagine());
            ps.setInt(7, prodotto.getIdProdotto());
            ps.setString(8, prodotto.getPartitaIva());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
