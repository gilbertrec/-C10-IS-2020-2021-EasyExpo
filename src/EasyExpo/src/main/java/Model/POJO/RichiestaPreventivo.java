package Model.POJO;

import java.sql.Date;

public class RichiestaPreventivo {
    public RichiestaPreventivo(int idRichiesta, String codiceFiscale, String partitaIva, String titolo, String luogoEvento, String descrizioneEvento, String nota, Date dataRichiesta, Stato stato) {
        this.idRichiesta = idRichiesta;
        this.codiceFiscale = codiceFiscale;
        this.partitaIva = partitaIva;
        this.titolo = titolo;
        this.luogoEvento = luogoEvento;
        this.descrizioneEvento = descrizioneEvento;
        this.nota = nota;
        this.dataRichiesta = dataRichiesta;
        this.stato = stato;
    }

    public RichiestaPreventivo() {

    }

    public Date getDataRichiesta() {
        return dataRichiesta;
    }

    public void setDataRichiesta(Date dataRichiesta) {
        this.dataRichiesta = dataRichiesta;
    }

    public int getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public String getLuogoEvento() {
        return luogoEvento;
    }

    public void setLuogoEvento(String luogoEvento) {
        this.luogoEvento = luogoEvento;
    }

    public String getDescrizioneEvento() {
        return descrizioneEvento;
    }

    public void setDescrizioneEvento(String descrizioneEvento) {
        this.descrizioneEvento = descrizioneEvento;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "RichiestaPreventivo{" +
                "idRichiesta=" + idRichiesta +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", partitaIva='" + partitaIva + '\'' +
                ", titolo='" + titolo + '\'' +
                ", luogoEvento='" + luogoEvento + '\'' +
                ", descrizioneEvento='" + descrizioneEvento + '\'' +
                ", nota='" + nota + '\'' +
                ", dataRichiesta=" + dataRichiesta +
                '}';
    }

    private int idRichiesta;
    private String codiceFiscale;
    private String partitaIva;
    private String titolo;
    private String luogoEvento;
    private String descrizioneEvento;
    private String nota;
    private Date dataRichiesta;

    private enum Stato {IN_ATTESA, CONFERMATO, RIFIUTATO}

    ;
    private Stato stato;
}
