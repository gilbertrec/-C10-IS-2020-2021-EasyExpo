package Model.POJO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @BeforeEach
    void setUp() {
        admin = new Admin("sabatino@gmail.com","12345678");
    }

    @AfterEach
    void tearDown() {
        admin = new Admin("sabatino@gmail.com","");
    }

    @Test
    void getEmail() {
        assertEquals("sabatino@gmail.com",admin.getEmail());
    }

    @Test
    void setEmail() {
        
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    private Admin admin;
}