package Model.DAO;

import Model.POJO.Abbonamento;
import Model.POJO.Admin;
import Model.POJO.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> ClienteDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Cliente </p>
 * @author
 * @version 1.0
 * @since   2020-12-29
 */
public class ClienteDAO {

    /**
     * Metodo che ritorna l'oggetto di tipo Cliente correlato al codiceFiscale dato in input
     * @param  codiceFiscale  codice alfanumerico identificativo cliente, String
     * @return  Cliente - Oggetto di tipo {@link Cliente}
     *
     */
    public Cliente doRetrieveByCF(String codiceFiscale) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Cliente WHERE codiceFiscale=?");
            ps.setString(1, codiceFiscale);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCodiceFiscale(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setCognome(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setLuogoUbicazione(rs.getString(7));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna le istanze di tipo Cliente contenute nel DB
     * @param  offset  indice partenza, Intero
     * @param limit  indice fine , Intero
     * @return  Cliente - Oggetto di tipo {@link Cliente}
     *
     */
    public List<Cliente> doRetrieveAll(int offset, int limit) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM Cliente LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Cliente> clienti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCodiceFiscale(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setCognome(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setLuogoUbicazione(rs.getString(7));
                clienti.add(c);
            }
            return clienti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che crea un'istanza, all'interno del DB, di tipo Cliente
     * @param cliente  Oggetto di tipo {@link Cliente}
     *
     */
    public void createCliente(Cliente cliente) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Cliente (codiceFiscale, nome, cognome, telefono, luogoUbicazione, email, password) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCodiceFiscale());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCognome());
            ps.setString(6, cliente.getEmail());
            ps.setString(7, cliente.getPassword());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getLuogoUbicazione());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            cliente.setCodiceFiscale(rs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna l'oggetto di tipo Cliente correlato all'email data in input
     * @param  email  Indirizzo email identificativo, String
     * @return Cliente - Oggetto di tipo {@link Cliente}
     *
     */
    public Cliente doRetrieveByEmail(String email) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Cliente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCodiceFiscale(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setCognome(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setLuogoUbicazione(rs.getString(7));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna l'oggetto di tipo Cliente correlato all'email e password dati in input
     * @param  email  Indirizzo email identificativo, String
     * @param password Caratteri alfanumerici per accesso al sistema, String
     * @return Cliente - Oggetto di tipo {@link Cliente}
     *
     */
    public Cliente doRetrieveByEmailandPassword(String email, String password){
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM Cliente WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setCodiceFiscale(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setCognome(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPassword(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setLuogoUbicazione(rs.getString(7));
                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che elimina dal DB l'istanza Cliente correlata al codiceFiscale dato in input
     * @param codiceFiscale  codice alfanumerico identificativo cliente, String
     */
    public void deleteCliente(String codiceFiscale) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Cliente WHERE codiceFiscale=?");
            ps.setString(1, codiceFiscale);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
