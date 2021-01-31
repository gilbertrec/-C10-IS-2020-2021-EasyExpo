package Model.POJO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

/**
 * Abbonamento e' la classe che gestisce un
 * ordinario oggetto Abbonamento.
 *
 * @author KATIA MONACO DE SIMONE
 * @version 1.0
 * @since 2020-12-29
 */

public class Carrello {

  /**
   * Classe statica di ProdottoQuantità.
   */
  public static class ProdottoQuantita {
    private final Prodotto prodotto;
    private int quantita;

    /**
     * Metodo costruttore della classe Abbonamento.
     *
     * @param prodotto Codice identificativo ProdottoQuantità, Oggetto di tipo {@link Prodotto}
     * @param quantita Codice alfanumerico identificativo fornitore, String
     */
    public ProdottoQuantita(Prodotto prodotto, int quantita) {
      this.prodotto = prodotto;
      this.quantita = quantita;
    }

    /**
     * Metodo che restituisce la quantità.
     *
     * @return int - quantità
     */
    public int getQuantita() {
      return quantita;
    }

    /**
     * Metodo che setta l'idAbbonamento.
     *
     * @param quantita , Intero
     */
    public void setQuantita(int quantita) {
      this.quantita = quantita;
    }

    /**
     * Metodo che restituisce il prodotto.
     *
     * @return Prodotto - Oggetto di tipo {@link Prodotto}
     */
    public Prodotto getProdotto() {
      return prodotto;
    }

  }


  private final ArrayList<Prodotto> listaProdotti = new ArrayList<>();

  private final LinkedHashMap<String, ArrayList<ProdottoQuantita>> ProdottiFornitori =
      new LinkedHashMap<>();

  /**
   * Metodo che restituisce una collezione di ArrayList di ProdottiQuantita.
   *
   * @return Collection - Oggetto di tipo {@link Collection}
   */
  public Collection<ArrayList<ProdottoQuantita>> getProdottiFornitori() {
    return this.ProdottiFornitori.values();
  }

  /**
   * Metodo che restituisce un ArrayList di ProdottiQuantita.
   *
   * @return ArrayList - Oggetto di tipo {@link ArrayList}
   */
  public ArrayList<ProdottoQuantita> get(String partitaIva) {
    return ProdottiFornitori.get(partitaIva);
  }

  /**
   * Metodo che inserisce un ProdottiQuantita in un ArrayList.
   *
   * @param prodotti - Oggetto di tipo {@link ArrayList}
   */
  public void put(ArrayList<ProdottoQuantita> prodotti) {
    String PI = prodotti.get(0).getProdotto().getPartitaIva();
    ProdottiFornitori.put(PI, prodotti);
  }

  /**
   * Metodo che rimuove da un ArrayList un ProdottiQuantita.
   *
   * @param partitaIva - Oggetto di tipo String
   * @return ArrayList - Oggetto di tipo {@link ArrayList}
   */
  public ArrayList<ProdottoQuantita> remove(String partitaIva) {
    return ProdottiFornitori.remove(partitaIva);
  }

  /**
   * Metodo che converte l'oggetto Carrello in stringa.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Carrello{"
        + "listaProdotti=" + listaProdotti
        + ", ProdottiFornitori=" + ProdottiFornitori
        + '}';
  }
}
