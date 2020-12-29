package Model.DAO;

import Model.POJO.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;

public class ClienteDAO {

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

  public void createCliente(Cliente cliente) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "INSERT INTO Cliente (codiceFiscale, nome, cognome, telefono, luogoUbicazione, email, password) VALUES(?,?,?,?,?,?,sha2(?, 512))");
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
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

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
        c.setEmail(rs.getString(6));
        c.setPassword(rs.getString(7));
        c.setTelefono(rs.getString(4));
        c.setLuogoUbicazione(rs.getString(5));
        return c;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Cliente doRetrieveByEmailandPassword(String email, String password) {
    try (Connection con = DBConnection.getConnection()) {
      PreparedStatement ps = con.prepareStatement(
          "SELECT * FROM Cliente WHERE email=? AND password=sha2(?, 512)");
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Cliente c = new Cliente();
        c.setCodiceFiscale(rs.getString(1));
        c.setNome(rs.getString(2));
        c.setCognome(rs.getString(3));
        c.setTelefono(rs.getString(4));
        c.setLuogoUbicazione(rs.getString(5));
        c.setEmail(rs.getString(6));
        c.setPassword(rs.getString(7));
        return c;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

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
