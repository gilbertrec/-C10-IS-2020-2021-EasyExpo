package Model.POJO;

import java.sql.Date;

/**
 * Abbonamento e' la classe che gestisce un
 * ordinario oggetto Abbonamento
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */

public class Abbonamento {

  /**
   * Metodo costruttore della classe Abbonamento
   *
   * @param idAbbonamento Codice identificativo abbonamento, Intero
   * @param partitaIva    Codice alfanumerico identificativo fornitore, String
   * @param dataInizio    Data inizio Abbonamento, Date
   * @param dataFine      Data fine Abbonamento, Date
   */

  public Abbonamento(int idAbbonamento, String partitaIva, Date dataInizio, Date dataFine) {
    this.idAbbonamento = idAbbonamento;
    this.partitaIva = partitaIva;
    this.dataInizio = dataInizio;
    this.dataFine = dataFine;
  }

  /**
   * Metodo costruttore di default della classe Abbonamento
   */

  public Abbonamento() {

  }

  /**
   * Metodo che restituisce l'idAbbonamento
   *
   * @return int - idAbbonamento
   */

  public int getIdAbbonamento() {
    return idAbbonamento;
  }

  /**
   * Metodo che setta l'idAbbonamento
   *
   * @param idAbbonamento Codice identificativo abbonamento, Intero
   */

  public void setIdAbbonamento(int idAbbonamento) {
    this.idAbbonamento = idAbbonamento;
  }

  /**
   * Metodo che restituisce la partitaIva
   *
   * @return String - partitaIva
   */

  public String getPartitaIva() {
    return partitaIva;
  }

  /**
   * Metodo che setta la partitaIva
   *
   * @param partitaIva Codice alfanumerico identificativo fornitore, String
   */

  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  /**
   * Metodo che restituisce dataInizio
   *
   * @return Date - dataInizio
   */

  public Date getDataInizio() {
    return dataInizio;
  }

  /**
   * Metodo che setta dataInizio
   *
   * @param dataInizio Data inizio Abbonamento, Date
   */

  public void setDataInizio(Date dataInizio) {
    this.dataInizio = dataInizio;
  }

  /**
   * Metodo che restituisce dataFine
   *
   * @return Date - dataFine
   */

  public Date getDataFine() {
    return dataFine;
  }

  /**
   * Metodo che setta dataFine
   *
   * @param dataFine - Data fine Abbonamento, Date
   */

  public void setDataFine(Date dataFine) {
    this.dataFine = dataFine;
  }

  /**
   * Metodo che converte l'oggetto Abbonamento in stringa
   *
   * @return String
   */

  @Override
  public String toString() {
    return "Abbonamento{" +
        "idAbbonamento=" + idAbbonamento +
        ", partitaIva='" + partitaIva + '\'' +
        ", dataInizio=" + dataInizio +
        ", dataFine=" + dataFine +
        '}';
  }

  private int idAbbonamento;
  private String partitaIva;
  private Date dataInizio;
  private Date dataFine;
}
