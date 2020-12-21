package Model.POJO;

import java.sql.Date;

public class Preventivo {
    public Preventivo(int idPreventivo, int idRichiesta, String partitaIva, String codiceFiscale, Date dataPreventivo, float prezzoTotale, String nota) {
        this.idPreventivo = idPreventivo;
        this.idRichiesta = idRichiesta;
        this.partitaIva = partitaIva;
        this.codiceFiscale = codiceFiscale;
        this.dataPreventivo = dataPreventivo;
        this.prezzoTotale = prezzoTotale;
        this.nota = nota;
    }

    public Preventivo() {

    }

    public int getIdPreventivo() {
        return idPreventivo;
    }

    public void setIdPreventivo(int idPreventivo) {
        this.idPreventivo = idPreventivo;
    }

    public int getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Date getDataPreventivo() {
        return dataPreventivo;
    }

    public void setDataPreventivo(Date data) {
        this.dataPreventivo = dataPreventivo;
    }

    public float getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(float prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public String getNota() { return nota; }

    public void setNota(String nota) { this.nota = nota; }

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
