package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class AbbonamentoTest {

    @BeforeEach
    void setUp() {
        datai = new Date(2020,1,8);
        dataf = new Date(2020,2,8);
        abbonamento = new Abbonamento(0,"01234567890",datai,dataf);
    }

    @AfterEach
    void tearDown() {
        Date datai = new Date(2020,1,8);
        Date dataf = new Date(2020,2,8);
        abbonamento = new Abbonamento(0,"01234567890",datai,dataf);
    }
    @Test
    void testAbbonamentoCostructorEmpty() {
        abbonamento = new Abbonamento();
        assertNotNull(abbonamento);
    }

    @Test
    void getIdAbbonamento() {
        assertEquals(0,abbonamento.getIdAbbonamento());
    }

    @Test
    void setIdAbbonamento() {
        abbonamento.setIdAbbonamento(1);
        assertEquals(1,abbonamento.getIdAbbonamento());
    }

    @Test
    void getPartitaIva() {
        assertEquals("01234567890",abbonamento.getPartitaIva());
    }

    @Test
    void setPartitaIva() {
        abbonamento.setPartitaIva("00000000000");
        assertEquals("00000000000",abbonamento.getPartitaIva());
    }

    @Test
    void getDataInizio() {
        assertEquals(datai,abbonamento.getDataInizio());
    }

    @Test
    void setDataInizio() {
        dataTemp = new Date(2020,1,6);
        abbonamento.setDataInizio(dataTemp);
        assertEquals(dataTemp,abbonamento.getDataInizio());
    }

    @Test
    void getDataFine() {
        assertEquals(datai,abbonamento.getDataInizio());
    }

    @Test
    void setDataFine() {
        dataTemp = new Date(2020,2,6);
        abbonamento.setDataFine(dataTemp);
        assertEquals(dataTemp,abbonamento.getDataFine());
    }

    private Abbonamento abbonamento;
    private Date datai;
    private Date dataf;
    private Date dataTemp;
}