package Model.POJO;

public class Fornitore {
    public Fornitore(String email, String password, String partitaIva, String nome, String cognome, int telefono, String luogoUbicazione, String ragioneSociale) {
        this.email = email;
        this.password = password;
        this.partitaIva = partitaIva;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.luogoUbicazione = luogoUbicazione;
        this.ragioneSociale = ragioneSociale;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLuogoUbicazione() {
        return luogoUbicazione;
    }

    public void setLuogoUbicazione(String luogoUbicazione) {
        this.luogoUbicazione = luogoUbicazione;
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
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", partitaIva='" + partitaIva + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono=" + telefono +
                ", luogoUbicazione='" + luogoUbicazione + '\'' +
                ", ragioneSociale='" + ragioneSociale + '\'' +
                '}';
    }

    private String email;
    private String password;
    private String partitaIva;
    private String nome;
    private String cognome;
    private int telefono;
    private String luogoUbicazione;
    private String ragioneSociale;
}
