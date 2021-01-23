package Model.POJO;

/**
 * TagProdotto e' la classe che gestisce un
 * ordinario oggetto TagProdotto.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2021-01-02
 */
public class TagProdotto {

  /**
   * Metodo costruttore della classe TagProdotto.
   *
   * @param idTag      codice identificativo tag, Intero
   * @param idProdotto codice identificativo prodotto, Intero
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   */
  public TagProdotto(int idTag, int idProdotto, String partitaIva) {
    this.idTag = idTag;
    this.idProdotto = idProdotto;
    this.partitaIva = partitaIva;
  }

  /**
   * Metodo costruttore di default della classe Prodotto.
   */
  public TagProdotto() {

  }

  /**
   * Metodo che restituisce l'IdTag.
   *
   * @return int - idTag
   */
  public int getIdTag() {
    return idTag;
  }

  /**
   * Metodo che setta l'IdTag.
   *
   * @param idTag codice identificativo tag, Intero
   */
  public void setIdTag(int idTag) {
    this.idTag = idTag;
  }

  /**
   * Metodo che restituisce l'IdProdotto.
   *
   * @return int - idProdotto
   */
  public int getIdProdotto() {
    return idProdotto;
  }

  /**
   * Metodo che setta l'IdProdotto.
   *
   * @param idProdotto codice identificativo prodotto, Intero
   */
  public void setIdProdotto(int idProdotto) {
    this.idProdotto = idProdotto;
  }

  /**
   * Metodo che restituisce la Partita Iva.
   *
   * @return String - PartitaIva
   */
  public String getPartitaIva() {
    return partitaIva;
  }

  /**
   * Metodo che setta la Partita Iva.
   *
   * @param partitaIva codice alfanumerico identificativo fornitore, String
   */
  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  @Override
  public String toString() {
    return "TagProdotto{"
        + "idTag=" + idTag
        + ", idProdotto=" + idProdotto
        + ", partitaIva='" + partitaIva + '\''
        + '}';
  }

  private int idTag;
  private int idProdotto;
  private String partitaIva;
}
