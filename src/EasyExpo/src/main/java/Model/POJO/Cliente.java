package Model.POJO;

/**
 * Cliente e' la classe che gestisce un
 * ordinario oggetto Cliente.
 *
 * @author GAETANO IULIANO
 * @version 1.0
 * @since 2020-12-29
 */


public class Cliente {

  /**
   * Metedo costruttore della classe Cliente.
   *
   * @param email           Indirizzo mail, String
   * @param password        Caratteri alfanumerici per accesso al sistema, String
   * @param codiceFiscale   Codice alfanumerico identificativo cliente, String
   * @param nome            Nome del Cliente, String
   * @param cognome         Cognome del Cliente, String
   * @param telefono        Numero di telefono del Cliente, String
   * @param luogoUbicazione Indirizzo del Cliente, String
   */

  public Cliente(String codiceFiscale, String nome, String cognome, String telefono,
                 String luogoUbicazione, String email, String password) {
    this.codiceFiscale = codiceFiscale;
    this.nome = nome;
    this.cognome = cognome;
    this.telefono = telefono;
    this.luogoUbicazione = luogoUbicazione;
  }

  /**
   * Metodo costruttore di default della classe Cliente.
   */

  public Cliente() {

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
    this.password = password;
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
   * Metodo che restituisce il codiceFiscale.
   *
   * @return String - codiceFiscale
   */

  public String getCodiceFiscale() {
    return codiceFiscale;
  }

  /**
   * Metodo che setta il codiceFiscale.
   *
   * @param codiceFiscale Codice alfanumerico identificativo cliente, String
   */

  public void setCodiceFiscale(String codiceFiscale) {
    this.codiceFiscale = codiceFiscale;
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
   * @param nome Nome del Cliente, String
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
   * @param cognome Cognome del Cliente, String
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
   * @param telefono Numero di telefono del Cliente, String
   */

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  /**
   * Metodo che restituisce luogoUbicazione.
   *
   * @return String - luogoUbicazione
   */

  public String getLuogoUbicazione() {
    return luogoUbicazione;
  }

  /**
   * Metodo che setta luogoUbicazione.
   *
   * @param luogoUbicazione Indirizzo del Cliente, String
   */

  public void setLuogoUbicazione(String luogoUbicazione) {
    this.luogoUbicazione = luogoUbicazione;
  }

  /**
   * Metodo che converte l'oggetto Cliente in stringa.
   *
   * @return String
   */

  @Override
  public String toString() {
    return "Cliente{"
        + "codiceFiscale='" + codiceFiscale + '\''
        + ", nome='" + nome + '\''
        + ", cognome='" + cognome + '\''
        + ", telefono='" + telefono + '\''
        + ", luogoUbicazione='" + luogoUbicazione + '\''
        + ", email='" + email + '\''
        + ", password='" + password + '\''
        + '}';
  }


  private String codiceFiscale;
  private String nome;
  private String cognome;
  private String telefono;
  private String luogoUbicazione;
  private String email;
  private String password;

}
