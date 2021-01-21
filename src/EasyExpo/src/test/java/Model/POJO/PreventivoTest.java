package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class PreventivoTest {

    @BeforeEach
    void setUp() {
        data = new Date(2021,1,8);
        preventivo = new Preventivo(1,1,"012345690","ABCDEF123456AA12",data,15,"");
    }

    @AfterEach
    void tearDown() {
        data = new Date(2021,1,8);
        preventivo = new Preventivo(1,1,"012345690","ABCDEF123456AA12",data,15,"");
    }

    @Test
    void getIdPreventivo() {
        assertEquals(1,preventivo.getIdPreventivo());
    }

    @Test
    void setIdPreventivo() {
        preventivo.setIdPreventivo(2);
        assertEquals(2,preventivo.getIdPreventivo());
    }

    @Test
    void getIdRichiesta() {
        assertEquals(1,preventivo.getIdRichiesta());
    }

    @Test
    void setIdRichiesta() {
        preventivo.setIdRichiesta(2);
        assertEquals(2,preventivo.getIdRichiesta());
    }

    @Test
    void getPartitaIva() {
        assertEquals("012345690",preventivo.getPartitaIva());
    }

    @Test
    void setPartitaIva() {
        preventivo.setPartitaIva("00000000000");
        assertEquals("00000000000",preventivo.getPartitaIva());
    }

    @Test
    void getCodiceFiscale() {
        assertEquals("ABCDEF123456AA12",preventivo.getCodiceFiscale());
    }

    @Test
    void setCodiceFiscale() {
        preventivo.setCodiceFiscale("AAABBB123123AA11");
        assertEquals("AAABBB123123AA11",preventivo.getCodiceFiscale());
    }

    @Test
    void getDataPreventivo() {
        assertEquals(data,preventivo.getDataPreventivo());
    }

    @Test
    void setDataPreventivo() {
        data = new Date(2020,1,3);
        preventivo.setDataPreventivo(data);
        assertEquals(data,preventivo.getDataPreventivo());
    }

    @Test
    void getPrezzoTotale() {
        assertEquals(15,preventivo.getPrezzoTotale());
    }

    @Test
    void setPrezzoTotale() {
        preventivo.setPrezzoTotale(100);
        assertEquals(100,preventivo.getPrezzoTotale());
    }

    @Test
    void getNota() {
        assertEquals("",preventivo.getNota());
    }

    @Test
    void setNota() {
        preventivo.setNota("Do,re,mi");
        assertEquals("Do,re,mi",preventivo.getNota());
    }

    private Preventivo preventivo;
    private Date data;
}