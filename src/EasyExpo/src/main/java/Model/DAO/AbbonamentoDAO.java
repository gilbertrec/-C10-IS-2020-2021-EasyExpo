package Model.DAO;

import Model.POJO.Abbonamento;

import java.sql.*;


public class AbbonamentoDAO {
    public Abbonamento doRetrieveByIdAbbonamento(int idAbbonamento) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Abbonamento as a, Fornitore as f WHERE idAbbonamento=? AND a.partitaIva=f.partitaIva");
            ps.setInt(1, idAbbonamento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Abbonamento a = new Abbonamento();
                a.setIdAbbonamento(rs.getInt(1));
                a.setPartitaIva(rs.getString(2));
                a.setDataInizio(rs.getDate(3));
                a.setDataFine(rs.getDate(4));
                return a;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Abbonamento doRetrieveByPartitaIva(String partitaIva){
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM Abbonamento as a, Fornitore as f WHERE partitaIva=? AND a.partitaIva=f.partitaIva");
            ps.setString(1, partitaIva);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Abbonamento a = new Abbonamento();
                a.setIdAbbonamento(rs.getInt(1));
                a.setPartitaIva(rs.getString(2));
                a.setDataInizio(rs.getDate(3));
                a.setDataFine(rs.getDate(4));
                return a;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAbbonamento(Abbonamento abbonamento) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Abbonamento (idAbbonamento, partitaIva, dataInizio, dataFine) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, abbonamento.getIdAbbonamento());
            ps.setString(2, abbonamento.getPartitaIva());
            ps.setDate(3, abbonamento.getDataInizio());
            ps.setDate(4, abbonamento.getDataFine());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            abbonamento.setIdAbbonamento(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAbbonamento(int idAbbonamento) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Abbonamento WHERE idAbbonamento=?");
            ps.setInt(1, idAbbonamento);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}