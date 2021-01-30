package Model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Model.POJO.Fornitore;
import Model.POJO.MetodoPagamento;
import java.sql.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MetodiDiPagamentoDAOTest {
  MetodiDiPagamentoDAO metodiDiPagamentoDAO;
  MetodoPagamento metodoPagamento;
  FornitoreDAO fornitoreDAO;
  Fornitore fornitore;

  @BeforeEach
  void setUp() {
    fornitoreDAO = new FornitoreDAO();
    fornitore =
        new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
            "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);


    metodiDiPagamentoDAO = new MetodiDiPagamentoDAO();
    metodoPagamento = new MetodoPagamento();
    metodoPagamento.setNumeroCarta("1234567891023456");
    metodoPagamento.setPartitaIva("01234567890");
    metodoPagamento.setNomeIntestatario("Mario");
    metodoPagamento.setDataScadenza(new Date(2022, 12, 30));
    metodoPagamento.setCvv(321);
    metodiDiPagamentoDAO.createMetodoPagamento(metodoPagamento);

  }

  @AfterEach
  void tearDown() {
    String par = fornitore.getPartitaIva();
    fornitoreDAO.deleteFornitore(par);
  }

  @Test
  void doRetrieveAllByPartitaIva() {
    List<MetodoPagamento> lista = metodiDiPagamentoDAO.doRetrieveAllByPartitaIva("01234567890");
    assertEquals("01234567890", lista.get(0).getPartitaIva());
  }

  @Test
  void doRetrieveByNumCarta() {
    MetodoPagamento mp = metodiDiPagamentoDAO.doRetrieveByNumCarta("1234567891023456");
    assertEquals("1234567891023456", mp.getNumeroCarta());
  }

  @Test
  void doRetrieveByNumCartaBoolean() {
    boolean flag = metodiDiPagamentoDAO.doRetrieveByNumCartaBoolean("1452896574587589");
    assertEquals(true, flag);
  }

  @Test
  void doRetrieveByNumCartaNull() {
    //MetodoPagamento mp = metodiDiPagamentoDAO.doRetrieveByNumCarta("1234567891023421");
    assertEquals(null, metodiDiPagamentoDAO.doRetrieveByNumCarta("1234567891023421"));

  }


  @Test
  void createMetodoPagamento() {
    MetodoPagamento metodoPagamento1 = new MetodoPagamento();
    metodoPagamento1.setNumeroCarta("9876543211452368");
    metodoPagamento1.setPartitaIva("01234567890");
    metodoPagamento1.setNomeIntestatario("Rossi");
    metodoPagamento1.setDataScadenza(new Date(2021, 10, 25));
    metodoPagamento1.setCvv(112);
    metodiDiPagamentoDAO.createMetodoPagamento(metodoPagamento1);
    assertEquals(2, metodiDiPagamentoDAO.doRetrieveAllByPartitaIva("01234567890").size());


  }
}