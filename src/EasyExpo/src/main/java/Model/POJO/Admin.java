package Model.POJO;

/**
 * Admin e' la classe che gestisce un
 * ordinario oggetto Admin
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */

public class Admin {

  /**
   * Metodo costruttore della classe Admin
   *
   * @param email    Indirizzo mail, String
   * @param password Caratteri alfanumerici per accesso al sistema, String
   */

  public Admin(String email, String password) {
    this.email = email;
    this.password = password;
  }

  /**
   * Metodo costruttore di default della classe Admin
   */

  public Admin() {

  }

  /**
   * Metodo che restituisce l'email
   *
   * @return String - email
   */

  public String getEmail() {
    return email;
  }

  /**
   * Metodo che setta l'email
   *
   * @param email Indirizzo mail, String
   */

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Metodo che restituisce la password
   *
   * @return String - password
   */

  public String getPassword() {
    return password;
  }

  /**
   * Metodo che setta la password
   *
   * @param password Caratteri alfanumerici per accesso al sistema, String
   */

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Metodo che converte l'oggetto Admin in stringa
   *
   * @return String
   */

  @Override
  public String toString() {
    return "Admin{" +
        "email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  private String email;
  private String password;
}
