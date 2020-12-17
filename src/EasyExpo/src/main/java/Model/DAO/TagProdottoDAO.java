package Model.DAO;

import Model.POJO.TagProdotto;

import java.sql.*;

public class TagProdottoDAO {


    public TagProdotto doRetrieveByIdTag(int idTag) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idTag, idProdotto, partitaIva FROM Tag as t, TagProdotto as tp, Prodotto as p, Fornitore as f WHERE idTag=? " +
                            "AND tp.idProdotto=p.idProdotto AND tp.idTag=t.idTag AND tp.partitaIva=f.partitaIva");
            ps.setInt(1, idTag);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TagProdotto tp = new TagProdotto();
                tp.setIdTag(rs.getInt(1));
                tp.setIdProdotto(rs.getInt(2));
                tp.setPartitaIva(rs.getString(3));
                return tp;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTagProdotto(TagProdotto tagProdotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO TagPrdotto (idTag, idProdotto, partitaIva) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tagProdotto.getIdTag());
            ps.setInt(2, tagProdotto.getIdProdotto());
            ps.setString(3, tagProdotto.getPartitaIva());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            tagProdotto.setIdTag(rs.getInt(1));
            tagProdotto.setIdProdotto(rs.getInt(2));
            tagProdotto.setPartitaIva(rs.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTagProdotto(int idTag, int idProdotto, String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM TagProdotto WHERE idTag=? AND idProdotto=? AND partitaIva=?");
            ps.setInt(1, idTag);
            ps.setInt(2, idProdotto);
            ps.setString(3, partitaIva);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TagProdotto doRetrieveByIdProdottoandPartitaIva(int idProdotto, String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idTag, idProdotto, partitaIva FROM Tag as t, TagProdotto as tp, Prodotto as p, Fornitore as f WHERE idProdotto=? AND partitaIva=?" +
                            "AND tp.idProdotto=p.idProdotto AND tp.idTag=t.idTag AND tp.partitaIva=f.partitaIva");
            ps.setInt(1, idProdotto);
            ps.setString(1, partitaIva);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TagProdotto tp = new TagProdotto();
                tp.setIdTag(rs.getInt(1));
                tp.setIdProdotto(rs.getInt(2));
                tp.setPartitaIva(rs.getString(3));
                return tp;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
