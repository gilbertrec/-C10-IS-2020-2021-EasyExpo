package Model.DAO;

import Model.POJO.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        cliente1.setEmail("k.robustelli@gmail.com");
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




        /*cl.createCliente(cliente1);
        Cliente c = cl.doRetrieveByCF("KBLKTA99C55E923W");

        assertEquals(cliente1.getCodiceFiscale(), c.getCodiceFiscale());*/
    }



    @Test
    void doRetrieveByCF() {
    }

    @Test
    void doRetrieveAll() {
    }



    @Test
    void doRetrieveByEmail() {
    }

    @Test
    void doRetrieveByEmailandPassword() {
    }

    @Test
    void deleteCliente() {
    }
}