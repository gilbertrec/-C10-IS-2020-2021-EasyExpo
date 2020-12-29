package Model.POJO;

import java.util.Objects;

public class Fornitore {
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
  }

  public Fornitore() {
  }

  public String getPartitaIva() {
    return partitaIva;
  }

  public void setPartitaIva(String partitaIva) {
    this.partitaIva = partitaIva;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getLuogoUbicazione() {
    return luogoUbicazione;
  }

  public void setLuogoUbicazione(String luogoUbicazione) {
    this.luogoUbicazione = luogoUbicazione;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRagioneSociale() {
    return ragioneSociale;
  }

  public void setRagioneSociale(String ragioneSociale) {
    this.ragioneSociale = ragioneSociale;
  }

  @Override
  public String toString() {
    return "Fornitore{" +
        "partitaIva='" + partitaIva + '\'' +
        ", nome='" + nome + '\'' +
        ", cognome='" + cognome + '\'' +
        ", telefono='" + telefono + '\'' +
        ", luogoUbicazione='" + luogoUbicazione + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", ragioneSociale='" + ragioneSociale + '\'' +
        '}';
  }

  private String partitaIva;
  private String nome;
  private String cognome;
  private String telefono;
  private String luogoUbicazione;
  private String email;
  private String password;
  private String ragioneSociale;
}
