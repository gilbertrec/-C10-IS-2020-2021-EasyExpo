package Model.POJO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class Carrello {

  public static class ProdottoQuantita {
    private final Prodotto prodotto;
    private int quantita;

    public ProdottoQuantita(Prodotto prodotto, int quantita) {
      this.prodotto = prodotto;
      this.quantita = quantita;
    }

    public int getQuantita() {
      return quantita;
    }

    public void setQuantita(int quantita) {
      this.quantita = quantita;
    }

    public Prodotto getProdotto() {
      return prodotto;
    }

  }


  private final ArrayList<Prodotto> listaProdotti = new ArrayList<>();

  private final LinkedHashMap<String, ArrayList<ProdottoQuantita>> ProdottiFornitori =
      new LinkedHashMap<>();

  public Collection<ArrayList<ProdottoQuantita>> getProdottiFornitori() {
    return this.ProdottiFornitori.values();
  }

  public ArrayList<ProdottoQuantita> get(String partitaIva) {
    return ProdottiFornitori.get(partitaIva);
  }


  public void put(ArrayList<ProdottoQuantita> prodotti) {
    String PI = prodotti.get(0).getProdotto().getPartitaIva();
    ProdottiFornitori.put(PI, prodotti);
  }

  public ArrayList<ProdottoQuantita> remove(String partitaIva) {
    return ProdottiFornitori.remove(partitaIva);
  }

  @Override
  public String toString() {
    return "Carrello{"
        + "listaProdotti=" + listaProdotti
        + ", ProdottiFornitori=" + ProdottiFornitori
        + '}';
  }
}
