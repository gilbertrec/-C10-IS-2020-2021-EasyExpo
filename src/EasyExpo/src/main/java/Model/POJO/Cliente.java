package Model.POJO;


import java.util.Objects;

public class Cliente {
    public Cliente(String email, String password, String codiceFiscale, String nome, String cognome, String telefono, String luogoUbicazione) {
        this.email = email;
        this.password = password;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.luogoUbicazione = luogoUbicazione;
    }

    public Cliente() {

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

    public void setPassword(String password) { this.password = password; }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono=" + telefono +
                ", luogoUbicazione='" + luogoUbicazione + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(email, password, codiceFiscale, nome, cognome, telefono, luogoUbicazione);
    }

    private String email;
    private String password;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private String telefono;
    private String luogoUbicazione;
}
