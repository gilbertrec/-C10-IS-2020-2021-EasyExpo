package Model.POJO;

import java.sql.Date;

/**
 * RichiestaPreventivo e' la classe che gestisce un
 * ordinario oggetto RichiestaPreventivo.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2021-01-02
 */
public class RichiestaPreventivo {

  /**
   * Metodo costruttore della classe ProdottoRichiesta.
   *
   * @param idRichiesta       codice identificativo richiesta, Intero
   * @param codiceFiscale     codice alfanumerico identificativo fornitore, String
   * @param partitaIva        codice alfanumerico identificativo fornitore, String
   * @param titolo            titolo della richiesta, String
   * @param luogoEvento       ubicazione dell'evento, String
   * @param descrizioneEvento descrizione dell'evento, String
   * @param nota              breve testo per informazioni aggiuntive, String
   * @param dataRichiesta     data della richiesta effettuata, Date
   * @param stato             stato della richiesta, Stato
   */
  public RichiestaPreventivo(int idRichiesta, String codiceFiscale, String partitaIva,
                             String titolo, String luogoEvento, String descrizioneEvento,
                             String nota, Date dataRichiesta, Stato stato) {
    this.idRichiesta = idRichiesta;
    this.codiceFiscale = codiceFiscale;
    this.partitaIva = partitaIva;
    this.titolo = titolo;
    this.luogoEvento = luogoEvento;
    this.descrizioneEvento = descrizioneEvento;
    this.nota = nota;
    this.dataRichiesta = dataRichiesta;
    this.stato = stato;
  }

  /**
   * Metodo costruttore di default della classe Prodotto.
   */
  public RichiestaPreventivo() {

  }

  /**
   * Metodo che restituisce la data della richiesta.
   *
   * @return Date - getDataRichiesta
   */
  public Date getDataRichiesta() {
    return dataRichiesta;
  }

  /**
   * Metodo che setta la data della richiesta.
   *
   * @param dataRichiesta data della richiesta effettuata, Date
   */
  public void setDataRichiesta(Date dataRichiesta) {
    this.dataRichiesta = dataRichiesta;
  }

  /**
   * Metodo che restituisce l'id della richiesta.
   *
   * @return Int - idRichiesta
   */
  public int getIdRichiesta() {
    return idRichiesta;
  }

  /**
   * Metodo che setta l'id della richiesta.
   *
   * @param idRichiesta codice identificativo richiesta, Intero
   */
  public void setIdRichiesta(int idRichiesta) {
    this.idRichiesta = idRichiesta;
  }

  /**
   * Metodo che restituisce il Codice Fiscale.
   *
   * @return String - codiceFiscale
   */
  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  /**
   * Metodo che setta il Codice Fiscale.
   *
   * @param codiceFiscale codice alfanumerico identificativo fornitore, String
   */
  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
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

  /**
   * Metodo che restituisce il Titolo.
   *
   * @return String - Titolo
   */
  public String getTitolo() {
    return titolo;
  }

  /**
   * Metodo che setta il Titolo.
   *
   * @param titolo titolo della richiesta, String
   */
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  /**
   * Metodo che restituisce il Luogo Evento.
   *
   * @return String - luogoEvento
   */
  public String getLuogoEvento() {
    return luogoEvento;
  }

  /**
   * Metodo che setta il Luogo Evento.
   *
   * @param luogoEvento ubicazione dell'evento, String
   */
  public void setLuogoEvento(String luogoEvento) {
    this.luogoEvento = luogoEvento;
  }

  /**
   * Metodo che restituisce la Descrizione dell'evento.
   *
   * @return String - descrizioneEvento
   */
  public String getDescrizioneEvento() {
    return descrizioneEvento;
  }

  /**
   * Metodo che setta la Descrizione dell'evento.
   *
   * @param descrizioneEvento descrizione dell'evento, String
   */
  public void setDescrizioneEvento(String descrizioneEvento) {
    this.descrizioneEvento = descrizioneEvento;
  }

  /**
   * Metodo che restituisce la Nota.
   *
   * @return String - nota
   */
  public String getNota() {
    return nota;
  }

  /**
   * Metodo che setta la Nota.
   *
   * @param nota breve testo per informazioni aggiuntive, String
   */
  public void setNota(String nota) {
    this.nota = nota;
  }

  /**
   * Metodo che restituisce lo Stato.
   *
   * @return Stato - stato
   */
  public Stato getStato() {
    return stato;
  }

  /**
   * Metodo che setta lo Stato.
   *
   * @param stato stato della richiesta, Stato
   */
  public void setStato(Stato stato) {
    this.stato = stato;
  }

  @Override
  public String toString() {
    return "RichiestaPreventivo{"
        + "idRichiesta=" + idRichiesta
        + ", codiceFiscale='" + codiceFiscale + '\''
        + ", partitaIva='" + partitaIva + '\''
        + ", titolo='" + titolo + '\''
        + ", luogoEvento='" + luogoEvento + '\''
        + ", descrizioneEvento='" + descrizioneEvento + '\''
        + ", nota='" + nota + '\''
        + ", dataRichiesta=" + dataRichiesta
        + ", stato=" + stato
        + '}';
  }

  private int idRichiesta;
  private String codiceFiscale;
  private String partitaIva;
  private String titolo;
  private String luogoEvento;
  private String descrizioneEvento;
  private String nota;
  private Date dataRichiesta;

  /**
   * Classe che definisce l'enum Stato.
   */
  public enum Stato {
    IN_ATTESA, CONFERMATO, RIFIUTATO
  }

  private Stato stato;
}
