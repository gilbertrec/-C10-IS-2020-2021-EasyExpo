package Model.POJO;

import java.sql.Date;

/**
 * ProdottoRichiesta e' la classe che gestisce un
 * ordinario oggetto ProdottoRichiesta
 *
 * @author
 * @version 1.0
 * @since 2021-01-02
 */

public class ProdottoRichiesta {

  /**
   * Metodo costruttore della classe ProdottoRichiesta
   *
   * @param id                 Codice Identificativo , Intero
   * @param idRichiesta        Codice Identificativo richiesta, Intero
   * @param idProdotto         Codice Identificativo prodotto, Intero
   * @param numColli           Quantita' prodotti , intero
   * @param prezzo             Prezzo unitario del prodotto, float
   * @param dataInizioNoleggio Data inizio del noleggio, Date
   * @param dataFineNoleggio   Data fine del noleggio, Date
   */
  public ProdottoRichiesta(int id, int idRichiesta, int idProdotto, String partitaIva, int numColli,
                           float prezzo, Date dataInizioNoleggio, Date dataFineNoleggio) {
    this.id = id;
    this.idRichiesta = idRichiesta;
    this.idProdotto = idProdotto;
    this.numColli = numColli;
    this.prezzo = prezzo;
    this.dataInizioNoleggio = dataInizioNoleggio;
    this.dataFineNoleggio = dataFineNoleggio;
    this.partitaIva = partitaIva;
  }

  /**
   * Metodo costruttore di default della classe Prodotto
   */
  public ProdottoRichiesta() {

  }

  /**
   * Metodo che restituisce l'id
   *
   * @return int - id
   */
  public int getId() {
    return id;
  }

  /**
   * Metodo che setta l'id
   *
   * @param id Codice Identificativo , Intero
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Metodo che restituisce l'idRichiesta
   *
   * @return int - idRichiesta
   */
  public int getIdRichiesta() {
    return idRichiesta;
  }

  /**
   * Metodo che setta l'idRichiesta
   *
   * @param idRichiesta Codice Identificativo richiesta, Intero
   */
  public void setIdRichiesta(int idRichiesta) {
    this.idRichiesta = idRichiesta;
  }

  /**
   * Metodo che restituisce l'idProdotto
   *
   * @return int - idProdotto
   */
  public int getIdProdotto() {
    return idProdotto;
  }

  /**
   * Metodo che setta l'idProdotto
   *
   * @param idProdotto Codice Identificativo prodotto, Intero
   */
  public void setIdProdotto(int idProdotto) {
    this.idProdotto = idProdotto;
  }

  /**
   * Metodo che restituisce il numero colli
   *
   * @return int - numColli
   */
  public int getNumColli() {
    return numColli;
  }

  /**
   * Metodo che setta il numero colli
   *
   * @param numColli Quantita' prodotti , Intero
   */
  public void setNumColli(int numColli) {
    this.numColli = numColli;
  }

  /**
   * Metodo che restituisce il prezzo
   *
   * @return int - prezzo
   */
  public float getPrezzo() {
    return prezzo;
  }

  /**
   * Metodo che setta il prezzo
   *
   * @param prezzo Prezzo unitario prodotto, Float
   */
  public void setPrezzo(float prezzo) {
    this.prezzo = prezzo;
  }

  /**
   * Metodo che restituisce la data di inizio noleggio
   *
   * @return Date - dataInizioNoleggio
   */
  public Date getDataInizioNoleggio() {
    return dataInizioNoleggio;
  }

  /**
   * Metodo che setta la data di inizio noleggio
   *
   * @param dataInizioNoleggio Data inizio del noleggio, Date
   */
  public void setDataInizioNoleggio(Date dataInizioNoleggio) {
    this.dataInizioNoleggio = dataInizioNoleggio;
  }

  /**
   * Metodo che restituisce la data di fine noleggio
   *
   * @return Date - dataFineNoleggio
   */
  public Date getDataFineNoleggio() {
    return dataFineNoleggio;
  }

  /**
   * Metodo che Metodo che setta la data di inizio noleggio
   *
   * @param dataFineNoleggio Data fine del noleggio, Date
   */
  public void setDataFineNoleggio(Date dataFineNoleggio) {
    this.dataFineNoleggio = dataFineNoleggio;
  }

  public String getPartitaIva() {
    return partitaIva;
  }

  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  @Override
  public String toString() {
    return "ProdottoRichiesta{" +
        "id=" + id +
        ", idRichiesta=" + idRichiesta +
        ", idProdotto=" + idProdotto +
        ", numColli=" + numColli +
        ", partitaIva='" + partitaIva + '\'' +
        ", prezzo=" + prezzo +
        ", dataInizioNoleggio=" + dataInizioNoleggio +
        ", dataFineNoleggio=" + dataFineNoleggio +
        '}';
  }

  private int id;
  private int idRichiesta;
  private int idProdotto;
  private int numColli;
  private String partitaIva;
  private float prezzo;
  private Date dataInizioNoleggio;
  private Date dataFineNoleggio;
}
