package Model.POJO;

import java.sql.Date;

/**
 * MetodoPagamento è la classe che gestisce un
 * ordinario oggetto MetodoPagamento
 *
 * @author
 * @version 1.0
 * @since 2020-12-29
 */

public class MetodoPagamento {

    /**
     * Metodo costruttore della classe MetodoPagamento
     *
     * @param numeroCarta Codice numerico identificativo metodoPagamento, String
     * @param partitaIva Codice alfanumerico identificativo fornitore, String
     * @param nomeIntestatario Nome e cognome dell'intestatario della carta, String
     * @param dataScadenza Data scadenza della carta, Date
     * @param cvv Codice di sicurezza della carta, int
     */

    public MetodoPagamento(String numeroCarta, String partitaIva, String nomeIntestatario, Date dataScadenza, int cvv) {
        this.numeroCarta = numeroCarta;
        this.partitaIva = partitaIva;
        this.nomeIntestatario = nomeIntestatario;
        this.dataScadenza = dataScadenza;
        this.cvv = cvv;
    }

    /**
     * Metodo costruttore di default della classe MetodoPagamento
     */

    public MetodoPagamento(){

    }

    /**
     * Metodo che restituisce il numeroCarta
     * @return String - numeroCarta
     */

    public String getNumeroCarta() {
        return numeroCarta;
    }

    /**
     * Metodo che setta il numeroCarta
     * @param numeroCarta Codice numerico identificativo metodoPagamento, String
     */

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
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
     * Metodo che restituisce il nomeIntestatario
     * @return String - nomeIntestatario
     */

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    /**
     * Metodo che setta il nomeIntestatario
     * @param nomeIntestatario Nome e cognome dell'intestatario della carta, String
     */

    public void setNomeIntestatario(String nomeIntestatario) {
        this.nomeIntestatario = nomeIntestatario;
    }

    /**
     * Metodo che restituisce la dataScadenza
     * @return Date - dataScadenza
     */

    public Date getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Metodo che setta la dataScadenza
     * @param dataScadenza Data scadenza della carta, Date
     */

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    /**
     * Metodo che restituisce il cvv
     * @return int - cvv
     */

    public int getCvv() {
        return cvv;
    }

    /**
     * Metodo che setta il cvv
     * @param cvv Codice di sicurezza della carta, int
     */

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    /**
     * Metodo che converte l'oggetto MetodoPagamento in stringa
     * @return String
     */

    @Override
    public String toString() {
        return "MetodoPagamento{" +
                "numeroCarta=" + numeroCarta +
                ", partitaIva='" + partitaIva + '\'' +
                ", nomeIntestatario='" + nomeIntestatario + '\'' +
                ", dataScadenza=" + dataScadenza +
                ", cvv=" + cvv +
                '}';
    }

    private String numeroCarta;
    private String partitaIva;
    private String nomeIntestatario;
    private Date dataScadenza;
    private int cvv;
}
