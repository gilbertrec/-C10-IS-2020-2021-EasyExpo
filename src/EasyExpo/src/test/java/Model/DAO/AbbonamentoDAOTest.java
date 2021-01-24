package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbbonamentoDAOTest {
  AbbonamentoDAO abbonamentoDAO;
  Abbonamento abbonamento;
  FornitoreDAO fornitoreDAO;
  Fornitore fornitore;

  @BeforeEach
  void setUp() {
    abbonamentoDAO = new AbbonamentoDAO();
    fornitoreDAO = new FornitoreDAO();
    abbonamento = new Abbonamento();
    fornitore =
        new Fornitore("01234567890", "Mario", "Rossi", "1234567890", "Roma", "rossi@gmail.com",
            "Rossi123", "Rossi");
    fornitoreDAO.createFornitore(fornitore);
    abbonamento.setPartitaIva("01234567890");
    abbonamento.setDataInizio(new Date(2019, 12, 30));
    abbonamento.setDataFine(new Date(2020, 01, 15));
    abbonamentoDAO.createAbbonamento(abbonamento);
  }

  @AfterEach
  void tearDown() {
    String par = fornitore.getPartitaIva();
    fornitoreDAO.deleteFornitore(par);
  }

  @Test
  void doRetrieveByPartitaIva() {
    List<Abbonamento> a = abbonamentoDAO.doRetrieveByPartitaIva("01234567890");
    assertEquals("01234567890", a.get(0).getPartitaIva());
  }

  @Test
  void doRetrieveByPartitaIvaFailure() {
    List<Abbonamento> a;
    //= abbonamentoDAO.doRetrieveByPartitaIva("01234567890");
    assertEquals(0, abbonamentoDAO.doRetrieveByPartitaIva("01239238090").size());
  }


  @Test
  void createAbbonamento() {
    Abbonamento a = new Abbonamento();
    a.setIdAbbonamento(2);
    a.setPartitaIva("01234567890");
    a.setDataInizio(new Date(2020, 10, 01));
    a.setDataFine(new Date(2020, 10, 11));
    abbonamentoDAO.createAbbonamento(a);
    assertEquals(2, abbonamentoDAO.doRetrieveByPartitaIva("01234567890").size());
  }

  @Test
  void createAbbonamentoException() {
    Abbonamento a = new Abbonamento();
    a.setIdAbbonamento(2);
    a.setPartitaIva("0123456789034rfdf");
    a.setDataInizio(new Date(2020, 10, 01));
    a.setDataFine(new Date(2020, 10, 11));
    assertThrows(RuntimeException.class, () -> {abbonamentoDAO.createAbbonamento(a);});
  }



}