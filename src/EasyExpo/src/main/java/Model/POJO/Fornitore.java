package Model.POJO;

/**
 * Fornitore e' la classe che gestisce un
 * ordinario oggetto Fornitore.
 *
 * @author LUCREZIA ROBUSTELLI
 * @version 1.0
 * @since 2020-12-29
 */

public class Fornitore {

  /**
   * Metodo costruttore della classe Fornitore.
   *
   * @param email           Indirizzo mail, String
   * @param password        Caratteri alfanumerici per accesso al sistema, String
   * @param partitaIva      Codice alfanumerico identificativo fornitore, String
   * @param nome            Nome del fornitore, String
   * @param cognome         Cognome del fornitore, String
   * @param telefono        Numero di telefono del fornitore, String
   * @param luogoUbicazione Indirizzo del fornitore, String
   * @param ragioneSociale  Ragione sociale del fornitore, String
   */

  public Fornitore(String partitaIva, String nome, String cognome, String telefono,
                   String luogoUbicazione, String email, String password, String ragioneSociale) {
    this.partitaIva = partitaIva;
    this.nome = nome;
    this.cognome = cognome;
    this.telefono = telefono;
    this.luogoUbicazione = luogoUbicazione;
    this.email = email;
    this.password = password;
    this.ragioneSociale = ragioneSociale;
    this.stato = Stato.ATTIVO;
  }

  public Fornitore() {
  }

  /**
   * Metodo che restituisce la partitaIva.
   *
   * @return String - partitaIva
   */

  public String getPartitaIva() {
    return partitaIva;
  }

  /**
   * Metodo che setta la partitaIva.
   *
   * @param partitaIva Codice alfanumerico identificativo fornitore, String
   */

  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  /**
   * Metodo che restituisce il nome.
   *
   * @return String - nome
   */

  public String getNome() {
    return nome;
  }

  /**
   * Metodo che setta il nome.
   *
   * @param nome Nome del fornitore, String
   */

  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Metodo che restituisce il cognome.
   *
   * @return String - cognome
   */

  public String getCognome() {
    return cognome;
  }

  /**
   * Metodo che setta il cognome.
   *
   * @param cognome Cognome del fornitore, String
   */

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  /**
   * Metodo che restituisce il telefono.
   *
   * @return String - telefono
   */

  public String getTelefono() {
    return telefono;
  }

  /**
   * Metodo che setta il telefono.
   *
   * @param telefono Indirizzo del fornitore, String
   */

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Metodo che restituisce il luogoUbicazione.
   *
   * @return String - luogoUbicazione
   */

  public String getLuogoUbicazione() {
    return luogoUbicazione;
  }

  /**
   * Metodo che setta il luogoUbicazione.
   *
   * @param luogoUbicazione Indirizzo del fornitore, String
   */

  public void setLuogoUbicazione(String luogoUbicazione) {
    this.luogoUbicazione = luogoUbicazione;
  }

  /**
   * Metodo che restituisce l'email.
   *
   * @return String - email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Metodo che setta l'email.
   *
   * @param email Indirizzo mail, String
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Metodo che restituisce la password.
   *
   * @return String - password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Metodo che setta la password.
   *
   * @param password Caratteri alfanumerici per accesso al sistema, String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Metodo che restituisce la ragioneSociale.
   *
   * @return String - ragioneSociale
   */
  public String getRagioneSociale() {
    return ragioneSociale;
  }

  /**
   * Metodo che setta la ragioneSociale.
   *
   * @param ragioneSociale Ragione sociale del fornitore, String
   */

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  /**
   * Metodo che restituisce se è abbonato.
   *
   * @return boolean - abbonato
   */

  public boolean isAbbonato() {
    return abbonato;
  }

  /**
   * Metodo che setta l'abbonamento.
   *
   * @param abbonato Abbonamento del fornitore, boolean
   */

  public void setAbbonato(boolean abbonato) {
    this.abbonato = abbonato;
  }

  /**
   * Metodo che restituisce lo stato.
   *
   * @return stato - Stato
   */

  public Stato getStato() {
    return stato;
  }

  /**
   * Metodo che setta l'abbonamento.
   *
   * @param stato Stato del fornitore, Stato
   */

  public void setStato(Stato stato) {
    this.stato = stato;
  }

  /**
   * Metodo che converte l'oggetto Fornitore in stringa.
   *
   * @return String
   */


  @Override
  public String toString() {
    return "Fornitore{"
        + "partitaIva='" + partitaIva + '\''
        + ", nome='" + nome + '\''
        + ", cognome='" + cognome + '\''
        + ", telefono='" + telefono + '\''
        + ", luogoUbicazione='" + luogoUbicazione + '\''
        + ", email='" + email + '\''
        + ", password='" + password + '\''
        + ", ragioneSociale='" + ragioneSociale + '\''
        + ", abbonato=" + abbonato
        + '}';
  }

  private String partitaIva;
  private String nome;
  private String cognome;
  private String telefono;
  private String luogoUbicazione;
  private String email;
  private String password;
  private String ragioneSociale;
  private boolean abbonato;

  public enum Stato {
    ATTIVO, SOSPESO
  }

  private Stato stato;
}
