package Controller;

import Model.DAO.FornitoreDAO;
import Model.DAO.ProdottoDAO;
import Model.DAO.TagDAO;
import Model.DAO.TagProdottoDAO;
import Model.POJO.Prodotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RicercaServletTest {
    private RicercaServlet ricercaServlet;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private ServletContext mockedServletContext;
    private RequestDispatcher mockedDispatcher;
    private HttpSession mockedSession;

    private ProdottoDAO prodottoDAO;
    private FornitoreDAO fornitoreDAO;
    private TagDAO tagDAO;
    private TagProdottoDAO tagProdottoDAO;
    private List<Prodotto> prodotti;
    private PrintWriter print;


    MyServletException exception = null;

    @BeforeEach
    void setUp() {
        ricercaServlet = new RicercaServlet();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        mockedServletContext = Mockito.mock(ServletContext.class);
        mockedDispatcher = Mockito.mock(RequestDispatcher.class);
        mockedSession = Mockito.mock(HttpSession.class);


        fornitoreDAO = new FornitoreDAO();
        prodottoDAO = new ProdottoDAO();
        tagProdottoDAO = new TagProdottoDAO();
        tagDAO = new TagDAO();



    }

    @AfterEach
    void tearDown() {
    }

    /*@Test
    void TestRicerca() throws IOException {
        Mockito.when(mockedRequest.getParameter("search")).thenReturn("Casse");
        List<Prodotto> prodotti = prodottoDAO.doRetrieveByTitolo("Casse");

        assertEquals(1,prodotti.size());
        Mockito.when(mockedResponse.getWriter()).thenReturn(print);
        ricercaServlet.doPost(mockedRequest,mockedResponse);
    }*/

    @Test
    void doGet() {
    }

    @Test
    void doPost() {
    }
}