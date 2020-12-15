package Model;

public class RichiestaPreventivo {
    public RichiestaPreventivo(int idRichiesta, String codiceFiscale, String partitaIva, String titolo, String luogoEvento, String descrizioneEvento, String nota) {
        this.idRichiesta = idRichiesta;
        this.codiceFiscale = codiceFiscale;
        this.partitaIva = partitaIva;
        this.titolo = titolo;
        this.luogoEvento = luogoEvento;
        this.descrizioneEvento = descrizioneEvento;
        this.nota = nota;
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
                '}';
    }

    private int idRichiesta;
    private String codiceFiscale;
    private String partitaIva;
    private String titolo;
    private String luogoEvento;
    private String descrizioneEvento;
    private String nota;
}
