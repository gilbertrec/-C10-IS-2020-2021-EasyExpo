package Model.POJO;

import java.sql.Date;

/**
 * Preventivo e' la classe che gestisce un
 * ordinario oggetto Preventivo
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */

public class Preventivo {

    /**
     * Metodo costruttore della classe Preventivo
     *
     * @param idPreventivo Codice identificativo, Intero
     * @param idRichiesta Codice identificativo, Intero
     * @param partitaIva Codice alfanumerico identificativo fornitore, String
     * @param codiceFiscale Codice alfanumerico identificativo cliente, String
     * @param dataPreventivo Data del preventivo, Date
     * @param prezzoTotale Prezzo totale preventivato, float
     * @param nota Nota aggiuntiva, String
     */

    public Preventivo(int idPreventivo, int idRichiesta, String partitaIva, String codiceFiscale, Date dataPreventivo, float prezzoTotale, String nota) {
        this.idPreventivo = idPreventivo;
        this.idRichiesta = idRichiesta;
        this.partitaIva = partitaIva;
        this.codiceFiscale = codiceFiscale;
        this.dataPreventivo = dataPreventivo;
        this.prezzoTotale = prezzoTotale;
        this.nota = nota;
    }

    /**
     * Metodo costruttore di default della classe Preventivo
     */

    public Preventivo() {

    }

    /**
     * Metodo che restituisce l'idPreventivo
     * @return int - idPreventivo
     */

    public int getIdPreventivo() {
        return idPreventivo;
    }

    /**
     * Metodo che setta l'idPreventivo
     * @param idPreventivo Codice identificativo, Intero
     */

    public void setIdPreventivo(int idPreventivo) {
        this.idPreventivo = idPreventivo;
    }

    /**
     * Metodo che restituisce l'idRichiesta
     * @return int - idRichiesta
     */

    public int getIdRichiesta() {
        return idRichiesta;
    }

    /**
     * Metodo che setta l'idRichiesta
     * @param idRichiesta Codice identificativo, Intero
     */

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
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
     * Metodo che restituisce il codiceFiscale
     * @return String - codiceFiscale
     */

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Metodo che setta il codiceFiscale
     * @param codiceFiscale Codice alfanumerico identificativo cliente, String
     */

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Metodo che restituisce la dataPreventivo
     * @return Date - dataPreventivo
     */

    public Date getDataPreventivo() {
        return dataPreventivo;
    }

    /**
     * Metodo che setta la dataPreventivo
     * @param dataPreventivo Data del preventivo, Date
     */

    public void setDataPreventivo(Date dataPreventivo) {
        this.dataPreventivo = dataPreventivo;
    }

    /**
     * Motodo che restitutisce il prezzoTotale
     * @return float - prezzoTotale
     */

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    /**
     * Metodo che setta il prezzoTotale
     * @param prezzoTotale Prezzo totale preventivato, float
     */

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    /**
     * Metodo che ritorna la nota
     * @return String - nota
     */

    public String getNota() {
        return nota;
    }

    /**
     * Metodo che setta la nota
     * @param nota Nota aggiuntiva, String
     */

    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * Metodo che converte l'oggetto Preventivo in stringa
     * @return String
     */

    @Override
    public String toString() {
        return "Preventivo{" +
                "idPreventivo=" + idPreventivo +
                ", idRichiesta=" + idRichiesta +
                ", partitaIva='" + partitaIva + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", dataPreventivo=" + dataPreventivo +
                ", prezzoTotale=" + prezzoTotale +
                ", nota='" + nota + '\'' +
                '}';
    }

    private int idPreventivo;
    private int idRichiesta;
    private String partitaIva;
    private String codiceFiscale;
    private Date dataPreventivo;
    private float prezzoTotale;
    private String nota;
}
