package Model.DAO;

import Model.POJO.Cliente;
import Model.POJO.Fornitore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> FornitoreDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Fornitore </p>
 * @author
 * @version 1.0
 * @since   2020-12-29
 */
public class FornitoreDAO {

    /**
     * Metodo che ritorna l'oggetto di tipo Fornitore correlato ad una partitaIva data in input
     * @param  partitaIva  codice alfanumerico identificativo fornitore, String
     * @return  Fornitore - Oggetto di tipo {@link Fornitore}
     *
     */
    public Fornitore doRetrieveByPIVA(String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Fornitore WHERE partitaIva=?");
            ps.setString(1, partitaIva);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Fornitore f = new Fornitore();
                f.setPartitaIva(rs.getString(1));
                f.setNome(rs.getString(2));
                f.setCognome(rs.getString(3));
                f.setEmail(rs.getString(4));
                f.setPassword(rs.getString(5));
                f.setTelefono(rs.getString(6));
                f.setLuogoUbicazione(rs.getString(7));
                f.setRagioneSociale(rs.getString(8));
                return f;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna le istanze di tipo Fornitore contenute nel DB
     * @param  offset  indice partenza, Intero
     * @param limit  indice fine , Intero
     * @return List <Fornitore> - {@link List} di oggetti di tipo {@link Fornitore}
     *
     */
    public List<Fornitore> doRetrieveAll(int offset, int limit) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM Fornitore LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Fornitore> fornitori = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornitore f = new Fornitore();
                f.setPartitaIva(rs.getString(1));
                f.setNome(rs.getString(2));
                f.setCognome(rs.getString(3));
                f.setEmail(rs.getString(4));
                f.setPassword(rs.getString(5));
                f.setTelefono(rs.getString(6));
                f.setLuogoUbicazione(rs.getString(7));
                f.setRagioneSociale(rs.getString(8));
                fornitori.add(f);
            }
            return fornitori;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che crea un'istanza, all'interno del DB, di tipo Fornitore
     * @param fornitore  Oggetto di tipo {@link Fornitore}
     *
     */
    public void createFornitore(Fornitore fornitore) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Fornitore (partitaIva, nome, cognome, telefono, luogoUbicazione, email, password, ragioneSociale) VALUES(?,?,?,?,?,?,?,?)");

            ps.setString(1, fornitore.getPartitaIva());
            ps.setString(2, fornitore.getNome());
            ps.setString(3, fornitore.getCognome());
            ps.setString(6, fornitore.getEmail());
            ps.setString(7, fornitore.getPassword());
            ps.setString(4, fornitore.getTelefono());
            ps.setString(5, fornitore.getLuogoUbicazione());
            ps.setString(8, fornitore.getRagioneSociale());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            fornitore.setPartitaIva(rs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna l'oggetto di tipo Fornitore correlato all'email data in input
     * @param  email  Indirizzo email identificativo, String
     * @return Fornitore - Oggetto di tipo {@link Fornitore}
     *
     */
    public Fornitore doRetrieveByEmail(String email) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Fornitore WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Fornitore f = new Fornitore();
                f.setPartitaIva(rs.getString(1));
                f.setNome(rs.getString(2));
                f.setCognome(rs.getString(3));
                f.setEmail(rs.getString(4));
                f.setPassword(rs.getString(5));
                f.setTelefono(rs.getString(6));
                f.setLuogoUbicazione(rs.getString(7));
                f.setRagioneSociale(rs.getString(8));
                return f;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna l'oggetto di tipo Fornitore correlato all'email e password dati in input
     * @param  email  Indirizzo email identificativo, String
     * @param password Caratteri alfanumerici per accesso al sistema, String
     * @return Fornitore - Oggetto di tipo {@link Fornitore}
     *
     */
    public Fornitore doRetrieveByEmailandPassword(String email, String password){
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM Fornitore WHERE email=? AND password=?");
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Fornitore f = new Fornitore();
                    f.setPartitaIva(rs.getString(1));
                    f.setNome(rs.getString(2));
                    f.setCognome(rs.getString(3));
                    f.setEmail(rs.getString(4));
                    f.setPassword(rs.getString(5));
                    f.setTelefono(rs.getString(6));
                    f.setLuogoUbicazione(rs.getString(7));
                    f.setRagioneSociale(rs.getString(8));
                    return f;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    /**
     * Metodo che elimina dal DB l'istanza Fornitore correlata alla partitaIva data in input
     * @param partitaIva  codice alfanumerico identificativo fornitore, String
     */
    public void deleteFornitore(String partitaIva) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Fornitore WHERE partitaIva=?");
            ps.setString(1, partitaIva);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
