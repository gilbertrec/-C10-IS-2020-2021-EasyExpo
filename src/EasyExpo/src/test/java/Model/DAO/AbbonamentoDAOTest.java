package Model.DAO;

import static org.junit.jupiter.api.Assertions.*;

import Model.POJO.Abbonamento;
import Model.POJO.Fornitore;
import java.sql.Date;
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
    abbonamentoDAO.deleteAbbonamento(abbonamento.getIdAbbonamento());
    fornitoreDAO.deleteFornitore(fornitore.getPartitaIva());
  }

  @Test
  void doRetrieveByIdAbbonamento() {
    abbonamento.setIdAbbonamento(5);
    Abbonamento abbonamento2= abbonamentoDAO.doRetrieveByIdAbbonamento(5);

    assertEquals(abbonamento2.getIdAbbonamento(), abbonamento.getIdAbbonamento());
  }

  @Test
  void doRetrieveByPartitaIva() {
  }


  @Test
  void createAbbonamento() {
    Abbonamento abbonamento1 =
        abbonamentoDAO.doRetrieveByIdAbbonamento(abbonamento.getIdAbbonamento());
    assertEquals(abbonamento.getIdAbbonamento(), abbonamento1.getIdAbbonamento());
  }

}