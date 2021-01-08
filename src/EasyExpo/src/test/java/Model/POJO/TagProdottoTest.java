package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TagProdottoTest {

    @BeforeEach
    void setUp() {
        TagProdotto tagprodotto = new TagProdotto(0, 0, "01234567890");
    }

    @AfterEach
    void tearDown() {
        tagprodotto = new TagProdotto(0, 0, "01234567890");
    }

    @Test
    void getIdTag() {

        assertEquals(0,tagprodotto.getIdTag);
    }

    @Test
    void setIdTag() {
    }

    @Test
    void getIdProdotto() {
    }

    @Test
    void setIdProdotto() {
    }

    @Test
    void getPartitaIva() {
    }

    @Test
    void setPartitaIva() {
    }

    private TagProdotto tagprodotto;
}