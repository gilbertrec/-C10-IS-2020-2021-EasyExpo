package Controller;

import Model.POJO.Cliente;
import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LoginServletTest extends Mockito {

    private LoginServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;


    @BeforeEach //prima di ogni test
    public void setUp() {
        servlet = new LoginServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        request.addParameter("email", "kattmon00@gmail.com");
        request.addParameter("password", "KatiaM00_");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doPost() {

    }

    @Test
    void testClienteEmailFail1() throws ServletException, IOException {
        request.addParameter("email", "k@g.com");
        String message = "Valore email sbagliata";
       // Cliente cliente = new Cliente("kattmon00@gmail.com", "KatiaM00_");


    }

    @Test
    void doGet() {
    }
}