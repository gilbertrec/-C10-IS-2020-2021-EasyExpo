package Model.DAO;

import Model.POJO.Tag;

import java.sql.*;

public class TagDAO {

    public Tag doRetrieveByIdTag(int idTag) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT idTag, nome FROM Tag WHERE idTag=?");
            ps.setInt(1, idTag);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Tag t = new Tag();
                t.setIdTag(rs.getInt(1));
                t.setNome(rs.getString(2));
                return t;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTag(Tag tag) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Tag (idTag, nome) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tag.getIdTag());
            ps.setString(2, tag.getNome());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            tag.setIdTag(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTag(int idTag) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Tag WHERE idTag=?");
            ps.setInt(1, idTag);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
