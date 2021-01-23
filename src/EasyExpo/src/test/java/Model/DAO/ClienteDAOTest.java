package Model.DAO;

import Model.POJO.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static Model.DAO.DBConnection.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOTest {
    ClienteDAO cl;
    Cliente cliente1;


    @BeforeEach
    void setUpEach(){
        cl = new ClienteDAO();
        cliente1 = new Cliente();
        cliente1.setCodiceFiscale("RBLKTA99C55E923W");
        cliente1.setNome("Lucrezia");
        cliente1.setCognome("Robustelli");
        cliente1.setTelefono("3387485126");
        cliente1.setEmail("l.robustelli@gmail.com");
        cliente1.setPassword("password");
        cliente1.setLuogoUbicazione("Napoli");
        cl.createCliente(cliente1);
    }

    @AfterEach
    void tearDown(){
        cl.deleteCliente("RBLKTA99C55E923W");
    }

    @Test
    void createCliente() {
        Cliente cliente = new Cliente();
        cliente.setCodiceFiscale("MNCKTA99C55E923F");
        cliente.setNome("Katia");
        cliente.setCognome("Monaco");
        cliente.setTelefono("3387485126");
        cliente.setEmail("k.monaco@gmail.com");
        cliente.setPassword("password");
        cliente.setLuogoUbicazione("Napoli");

        cl.createCliente(cliente);

        Cliente cliente2 = cl.doRetrieveByCF("MNCKTA99C55E923F");

        assertEquals(cliente.getCodiceFiscale(), cliente2.getCodiceFiscale());

        cl.deleteCliente("MNCKTA99C55E923F");

    }


    @Test
    void doRetrieveByCF() {
        Cliente c = cl.doRetrieveByCF("RBLKTA99C55E923W");
        assertEquals("RBLKTA99C55E923W", c.getCodiceFiscale());
    }

    @Test
    void doRetrieveByEmailandPassword() {
        Cliente c1 = cl.doRetrieveByEmailandPassword("l.robustelli@gmail.com", "password" );
        assertEquals("RBLKTA99C55E923W", c1.getCodiceFiscale());
    }

    @Test
    void deleteCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente3 = new Cliente();
        cliente3.setCodiceFiscale("RBLKTA98875E923W");
        cliente3.setNome("Sara");
        cliente3.setCognome("Robustelli");
        cliente3.setTelefono("3387485126");
        cliente3.setEmail("s.robustelli@gmail.com");
        cliente3.setPassword("password");
        cliente3.setLuogoUbicazione("Napoli");
        clienteDAO.createCliente(cliente3);

        clienteDAO.deleteCliente(cliente3.getCodiceFiscale());

        assertNull(clienteDAO.doRetrieveByCF("RBLKTA98875E923W"));
    }
}