package Model.DAO;

import Model.POJO.MetodoPagamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodiDiPagamentoDAO {

    public List<MetodoPagamento> doRetrieveAllByPartitaIva(String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT numeroCarta, partitaIva, nomeIntestatario, dataScadenza, cvv FROM MetodoPagamento as mp, Fornitore as f WHERE partitaIva=? AND mp.partitaIva=f.partitaIva");
            ps.setString(1, partitaIva);
            ArrayList<MetodoPagamento> metodiPagamenti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MetodoPagamento c = new MetodoPagamento();
                c.setNumeroCarta(rs.getInt(1));
                c.setPartitaIva(rs.getString(2));
                c.setNomeIntestatario(rs.getString(3));
                c.setDataScadenza(rs.getDate(4));
                c.setCvv(rs.getInt(5));
                metodiPagamenti.add(c);
            }
            return metodiPagamenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMetodoPagamento(MetodoPagamento metodoPagamento) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO MetodoPagamento (numeroCarta, partitaIva, nomeIntestatario, dataScadenza, cvv) VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, metodoPagamento.getNumeroCarta());
            ps.setString(2, metodoPagamento.getPartitaIva());
            ps.setString(3, metodoPagamento.getNomeIntestatario());
            ps.setDate(4, metodoPagamento.getDataScadenza());
            ps.setInt(5, metodoPagamento.getCvv());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            metodoPagamento.setNumeroCarta(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMetodoPagamento(int numeroCarta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM MetodoPagamento WHERE numeroCarta=?");
            ps.setInt(1, numeroCarta);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}