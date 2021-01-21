package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornitoreTest {

    @BeforeEach
    void setUp() {
        fornitore = new Fornitore("01234567890","Mario","Rossi","1234567890","Roma","rossi@gmail.com","Rossi123","Rossi");
    }

    @AfterEach
    void tearDown() {
        fornitore = new Fornitore("01234567890","Mario","Rossi","1234567890","Roma","rossi@gmail.com","Rossi123","Rossi");
    }

    @Test
    void getPartitaIva() {
        assertEquals("01234567890",fornitore.getPartitaIva());
    }

    @Test
    void setPartitaIva() {
        fornitore.setPartitaIva("00000000000");
        assertEquals("00000000000",fornitore.getPartitaIva());
    }

    @Test
    void getNome() {
        assertEquals("Mario",fornitore.getNome());
    }

    @Test
    void setNome() {
        fornitore.setNome("Giuseppe");
        assertEquals("Giuseppe",fornitore.getNome());
    }

    @Test
    void getCognome() {
        assertEquals("Rossi",fornitore.getCognome());
    }

    @Test
    void setCognome() {
        fornitore.setCognome("Verdi");
        assertEquals("Verdi",fornitore.getCognome());
    }

    @Test
    void getTelefono() {
        assertEquals("1234567890",fornitore.getTelefono());
    }

    @Test
    void setTelefono() {
        fornitore.setTelefono("3333333333");
        assertEquals("3333333333",fornitore.getTelefono());
    }

    @Test
    void getLuogoUbicazione() {
        assertEquals("Roma",fornitore.getLuogoUbicazione());
    }

    @Test
    void setLuogoUbicazione() {
        fornitore.setLuogoUbicazione("Milano");
        assertEquals("Milano",fornitore.getLuogoUbicazione());
    }

    @Test
    void getEmail() {
        assertEquals("rossi@gmail.com",fornitore.getEmail());
    }

    @Test
    void setEmail() {
        fornitore.setEmail("mario@gmail.com");
        assertEquals("mario@gmail.com",fornitore.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("Rossi123",fornitore.getPassword());
    }

    @Test
    void setPassword() {
        fornitore.setPassword("Anonimo123");
        assertEquals("Anonimo123",fornitore.getPassword());
    }

    @Test
    void getRagioneSociale() {
        assertEquals("Rossi",fornitore.getRagioneSociale());
    }

    @Test
    void setRagioneSociale() {
        fornitore.setRagioneSociale("Rossi&co.");
        assertEquals("Rossi&co.",fornitore.getRagioneSociale());
    }

    private Fornitore fornitore;
}