package Model.POJO;

public class Prodotto {
    public Prodotto(int idProdotto, String partitaIva, String titolo, String descrizione, /*Tipo valore*/, int quantità, float prezzo) {
        this.idProdotto = idProdotto;
        this.partitaIva = partitaIva;
        this.titolo = titolo;
        this.descrizione = descrizione;
        //this.Tipo = valore;
        this.quantità = quantità;
        this.prezzo = prezzo;
    }

    public Prodotto() {

    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /*public Tipo getTipo() {
        return Tipo.v;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }*/

    public int getQuantità() {
        return quantità;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "idProdotto=" + idProdotto +
                ", partitaIva='" + partitaIva + '\'' +
                ", titolo='" + titolo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipo='" + Tipo. + '\'' +
                ", quantità=" + quantità +
                '}';
    }

    private int idProdotto;
    private String partitaIva;
    private String titolo;
    private String descrizione;
    private enum Tipo{PRODOTTO,SERVIZIO};
    private Tipo valore;
    private int quantità;
    private float prezzo;
}
