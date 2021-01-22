package Model.DAO;

import Model.POJO.MetodoPagamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetodiDiPagamentoDAOTest {
    MetodiDiPagamentoDAO metodiDiPagamentoDAO;
    MetodoPagamento metodoPagamento;

    @BeforeEach
    void setUp() {
        metodiDiPagamentoDAO = new MetodiDiPagamentoDAO();
        metodoPagamento = new MetodoPagamento();
        metodoPagamento.setNumeroCarta("1234567891023456");
        /*metodoPagamento.setPartitaIva();
        metodoPagamento.setNomeIntestatario();
        metodoPagamento.setDataScadenza();
        metodoPagamento.setCvv();*/

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void doRetrieveAllByPartitaIva() {
    }

    @Test
    void doRetrieveByNumCarta() {
    }

    @Test
    void createMetodoPagamento() {
    }

    @Test
    void deleteMetodoPagamento() {
    }
}