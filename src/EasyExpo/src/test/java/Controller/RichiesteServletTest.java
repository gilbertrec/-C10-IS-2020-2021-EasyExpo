package Controller;

import Model.DAO.ClienteDAO;
import Model.DAO.FornitoreDAO;
import Model.DAO.RichiestaPreventivoDAO;
import Model.POJO.Cliente;
import Model.POJO.Fornitore;
import Model.POJO.RichiestaPreventivo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
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
    private RichiestaPreventivo richiestaPreventivo;
    private FornitoreDAO frDAO;
    private Fornitore fr;
    private ClienteDAO clDAO;
    private Cliente cl;
    private int idRichiesta;


    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        frDAO = new FornitoreDAO();
        fr = new Fornitore("01234567880", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
                "Rossi123", "Rossi");
        frDAO.createFornitore(fr);

        clDAO = new ClienteDAO();
        cl = new Cliente();
        cl.setCodiceFiscale("RBLKTA99C57E923W");
        cl.setNome("Lucrezia");
        cl.setCognome("Robustelli");
        cl.setTelefono("3387485126");
        cl.setEmail("l.robustelli@gmail.com");
        cl.setPassword("password");
        cl.setLuogoUbicazione("Napoli");
        clDAO.createCliente(cl);

        richiestaPreventivoDAO = new RichiestaPreventivoDAO();
        richiestaPreventivo = new RichiestaPreventivo();
        richiestaPreventivo.setCodiceFiscale(cl.getCodiceFiscale());
        richiestaPreventivo.setPartitaIva(fr.getPartitaIva());
        richiestaPreventivo.setDataRichiesta(new Date(2020, 01, 26));
        richiestaPreventivo.setDescrizioneEvento("descrizione di prova");
        richiestaPreventivo.setNota("nota di prova");
        richiestaPreventivo.setTitolo("Prova");
        richiestaPreventivo.setLuogoEvento("Napoli");
        richiestaPreventivo.setStato(RichiestaPreventivo.Stato.RIFIUTATO);
        idRichiesta = richiestaPreventivoDAO.createRichiestaPreventivo(richiestaPreventivo);

        richiesteServlet = new RichiesteServlet();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedDispatcher = Mockito.mock(RequestDispatcher.class);
        mockedSession = Mockito.mock(HttpSession.class);



    }

    @AfterEach
    void tearDown() {
        clDAO.deleteCliente(cl.getCodiceFiscale());
        frDAO.deleteFornitore(fr.getPartitaIva());
    }

    @Test
    void TestRichiestaPartitaIvaSuccess() throws ServletException, IOException {
        Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
        Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01234567880");

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/listaRichieste.jsp");

        richiesteServlet.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void TestRichiestaPartitaIvaNull() throws ServletException, IOException {
        Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/listaRichieste.jsp");

        richiesteServlet.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void TestRichiestaCodiceFiscaleSuccess() throws ServletException, IOException {
        Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
        Mockito.when(mockedRequest.getParameter("codiceFiscale")).thenReturn("RBLKTA99C57E923W");

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/listaRichieste.jsp");

        richiesteServlet.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void TestRichiestaRifiutato() throws ServletException, IOException {
        Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
        Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01234567880");

        assertEquals(RichiestaPreventivo.Stato.RIFIUTATO, richiestaPreventivo.getStato());

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/listaRichieste.jsp");

        richiesteServlet.doGet(mockedRequest,mockedResponse);
    }

    @Test
    void TestRichiestaNonRifiutato() throws ServletException, IOException {
        Mockito.doReturn(mockedSession).when(mockedRequest).getSession(true);
        Mockito.when(mockedRequest.getParameter("partitaIva")).thenReturn("01234567880");

        assertEquals(RichiestaPreventivo.Stato.CONFERMATO, richiestaPreventivo.getStato());

        Mockito.when(mockedRequest.getSession()).thenReturn(mockedSession);
        Mockito.doReturn(mockedServletContext).when(mockedRequest).getServletContext();
        Mockito.doReturn(mockedDispatcher).when(mockedServletContext).getRequestDispatcher("/listaRichieste.jsp");

        richiesteServlet.doGet(mockedRequest,mockedResponse);
    }


    @Test
    void doPost() {
    }

    @Test
    void doGet() {
    }
}