package Model.POJO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarrelloTest {
 private Prodotto.Tipo tipo;
 private Carrello car;
 private Prodotto p;
 private Carrello.ProdottoQuantita pq;
 private ArrayList<Carrello.ProdottoQuantita> lista;
  @BeforeEach
  void setUp() {
    p = new Prodotto(1,"01234567890","Cassa","Cassa audio",tipo.ATTREZZATURA,5,50,"foto");
    pq = new Carrello.ProdottoQuantita(p,2);
    car = new Carrello();
    lista = new ArrayList<>();
    lista.add(pq);
    car.put(lista);
  }

  @AfterEach
  void tearDown() {
    p = new Prodotto(1,"01234567890","Cassa","Cassa audio",tipo.ATTREZZATURA,5,50,"foto");
    pq = new Carrello.ProdottoQuantita(p,2);
    car = new Carrello();
    lista = new ArrayList<>();
    lista.add(pq);
    car.put(lista);
  }

  @Test
  void getProdottiFornitori() {
    assertNotNull(car.getProdottiFornitori());
  }

  @Test
  void get() {
    ArrayList<Carrello.ProdottoQuantita>lista3 = car.get("01234567890");
    assertEquals(1,lista3.size());
  }

  @Test
  void put() {
    Prodotto prodotto = new Prodotto(2,"01234567000","Cassa","Cassa audio",tipo.ATTREZZATURA,5,50,"foto");
    Carrello.ProdottoQuantita cpq = new Carrello.ProdottoQuantita(prodotto,2);
    ArrayList<Carrello.ProdottoQuantita>lista2 = new ArrayList<>();
    lista2.add(cpq);
    car.put(lista2);
    assertEquals(2,car.getProdottiFornitori().size());
  }

  @Test
  void remove() {
    car.remove("01234567890");
    assertNull(car.get("01234567890"));
  }
}