package Model.DAO;

import Model.POJO.RichiestaPreventivo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RichiestaPreventivoDAO {
    public RichiestaPreventivo doRetrieveByIdRichiesta(int idRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM RichiestaPreventivo as rp, Cliente as c, Fornitore as f WHERE idRichiesta=?" +
                            "AND rp.codiceFiscale=c.codiceFiscale AND rp.partitaIva=f.partitaIva");
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
    public List<RichiestaPreventivo> doRetrieveAll(int offset, int limit) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM RichiestaPreventivo as rp, Cliente as c, Fornitore as f WHERE" +
                            "rp.codiceFiscale=c.codiceFiscale AND rp.partitaIva=f.partitaIva LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
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
    public void createRichiestaPreventivo(RichiestaPreventivo richiestaPreventivo) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO RichiestaPreventivo (idRichiesta, codiceFiscale, partitaIva, titolo, luogoEvento, descrizioneEvento, nota, dataRichiesta, stato) VALUES(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, richiestaPreventivo.getIdRichiesta());
            ps.setString(2,richiestaPreventivo.getCodiceFiscale());
            ps.setString(3, richiestaPreventivo.getPartitaIva());
            ps.setString(4, richiestaPreventivo.getTitolo());
            ps.setString(5, richiestaPreventivo.getLuogoEvento());
            ps.setString(6, richiestaPreventivo.getDescrizioneEvento());
            ps.setString(7, richiestaPreventivo.getNota());
            ps.setDate(8, richiestaPreventivo.getDataRichiesta());
            ps.setString(9, richiestaPreventivo.getStato().toString());//oppure .name() per caratteri uguali
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
                richiestaPreventivo.setIdRichiesta(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRichiestePreventivo(int idRichiesta) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM RichiestaPreventivo WHERE idRichiesta=?");
            ps.setInt(1, idRichiesta);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
