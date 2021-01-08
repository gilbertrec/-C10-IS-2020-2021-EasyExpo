package Model.POJO;

/**
 * Prodotto e' la classe che gestisce un
 * ordinario oggetto Prodotto
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */

public class Prodotto {

    /**
     * Metodo costruttore della classe Prodotto
     * @param idProdotto Codice identificativo prodotto, Intero
     * @param partitaIva Codice alfanumerico identificativo fornitore, String
     * @param titolo Titolo del prodotto, String
     * @param descrizione Descrizione del prodotto, String
     * @param tipo Tipo di allestimento, {@link Tipo}
     * @param quantita Quantita' del prodotto, Intero
     * @param prezzo Prezzo unitario del prodotto, float
     */

    public Prodotto(int idProdotto, String partitaIva, String titolo, String descrizione, Tipo tipo, int quantità, float prezzo, String immagine) {
        this.idProdotto = idProdotto;
        this.partitaIva = partitaIva;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.immagine = immagine;
    }

    /**
     * Metodo costruttore di default della classe Prodotto
     */

    public Prodotto() {

    }

    /**
     * Metodo che restituisce l'idProdotto
     * @return int - idProdotto
     */

    public int getIdProdotto() {
        return idProdotto;
    }

    /**
     * Metodo che setta l'idProdotto
     * @param idProdotto Codice identificativo prodotto, Intero
     */

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    /**
     * Metodo che restituisce la partitaIva
     * @return String - partitaIva
     */

    public String getPartitaIva() {
        return partitaIva;
    }

    /**
     * Metodo che setta la partitaIva
     * @param partitaIva Codice alfanumerico identificativo fornitore, String
     */

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    /**
     * Metodo che restituisce il titolo
     * @return String - titolo
     */

    public String getTitolo() {
        return titolo;
    }

    /**
     * Metodo che setta il titolo
     * @param titolo Titolo del prodotto, String
     */

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Metodo che restituisce la descrizione
     * @return String - descrizione
     */

    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Metodo che setta la descrizione
     * @param descrizione Descrizione del prodotto, String
     */

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Metodo che restituisce il tipo
     * @return {@link Tipo} - tipo
     */

    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Metodo che setta il tipo
     * @param tipo Tipo di allestimento, {@link Tipo}
     */

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo che restituisce la quantita'
     * @return int - quantita
     */

    public int getQuantita() {
        return quantita;
    }

    /**
     * Metodo che setta la quantita'
     * @param quantita Quantita' del prodotto, Intero
     */

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    /**
     * Metodo che restituisce il prezzo
     * @return float - prezzo
     */

    public float getPrezzo() {
        return prezzo;
    }

    /**
     * Metodo che setta il prezzo
     * @param prezzo Prezzo unitario del prodotto, float
     */

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

   
    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    /**
     * Metodo che converte l'oggetto Prodotto in stringa
     * @return String
     */
    @Override
    public String toString() {
        return "Prodotto{" +
            "idProdotto=" + idProdotto +
            ", partitaIva='" + partitaIva + '\'' +
            ", titolo='" + titolo + '\'' +
            ", descrizione='" + descrizione + '\'' +
            ", tipo=" + tipo +
            ", quantità=" + quantità +
            ", prezzo=" + prezzo +
            ", immagine='" + immagine + '\'' +
            '}';
    }

    private int idProdotto;
    private String partitaIva;
    private String titolo;
    private String descrizione;


    public enum Tipo {SERVIZIO, ATTREZZATURA};
    private Tipo tipo;
    private int quantita;
    private float prezzo;
    private String immagine;
}
