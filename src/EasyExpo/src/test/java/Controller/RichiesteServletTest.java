package Controller;

import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Cliente;
import Model.POJO.RichiestaPreventivo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RichiesteServletTest {
    private RichiesteServlet richiesteServlet;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private RequestDispatcher mockedDispatcher;
    private HttpSession mockedSession;
    RichiestaPreventivoDAO richiestaPreventivoDAO;

    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        richiesteServlet = new RichiesteServlet();
        richiestaPreventivoDAO = new RichiestaPreventivoDAO();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedDispatcher = Mockito.mock(RequestDispatcher.class);
        mockedSession = Mockito.mock(HttpSession.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestRichiestaFornitore(){
        Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01391350129");

        List<RichiestaPreventivo> richiesteComplessive =
                richiestaPreventivoDAO.doRetrieveByPartitaIva("01391350129");

        /*for (RichiestaPreventivo rp : richiesteComplessive) {
            if (!rp.getStato().toString().equals("RIFIUTATO")) {
                richieste.add(rp);
                Cliente c = clienteDAO.doRetrieveByCF(rp.getCodiceFiscale());
                clienti.add(c);
            }

        }*/




    }

    @Test
    void doPost() {
    }

    @Test
    void doGet() {
    }
}