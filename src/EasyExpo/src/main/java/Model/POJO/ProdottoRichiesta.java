package Model.POJO;

import java.sql.Date;

public class ProdottoRichiesta {
    public ProdottoRichiesta(int id, int idRichiesta, int idProdotto, String partitaIva, int numColli, float prezzo, Date dataInizioNoleggio, Date dataFineNoleggio) {
        this.id = id;
        this.idRichiesta = idRichiesta;
        this.idProdotto = idProdotto;
        this.numColli = numColli;
        this.prezzo = prezzo;
        this.dataInizioNoleggio = dataInizioNoleggio;
        this.dataFineNoleggio = dataFineNoleggio;
        this.partitaIva = partitaIva;
    }

    public ProdottoRichiesta() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRichiesta() {
        return idRichiesta;
    }

    public void setIdRichiesta(int idRichiesta) {
        this.idRichiesta = idRichiesta;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getNumColli() {
        return numColli;
    }

    public void setNumColli(int numColli) {
        this.numColli = numColli;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Date getDataInizioNoleggio() {
        return dataInizioNoleggio;
    }

    public void setDataInizioNoleggio(Date dataInizioNoleggio) {
        this.dataInizioNoleggio = dataInizioNoleggio;
    }

    public Date getDataFineNoleggio() {
        return dataFineNoleggio;
    }

    public void setDataFineNoleggio(Date dataFineNoleggio) {
        this.dataFineNoleggio = dataFineNoleggio;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    @Override
    public String toString() {
        return "ProdottoRichiesta{" +
            "id=" + id +
            ", idRichiesta=" + idRichiesta +
            ", idProdotto=" + idProdotto +
            ", numColli=" + numColli +
            ", partitaIva='" + partitaIva + '\'' +
            ", prezzo=" + prezzo +
            ", dataInizioNoleggio=" + dataInizioNoleggio +
            ", dataFineNoleggio=" + dataFineNoleggio +
            '}';
    }

    private int id;
    private int idRichiesta;
    private int idProdotto;
    private int numColli;
    private String partitaIva;
    private float prezzo;
    private Date dataInizioNoleggio;
    private Date dataFineNoleggio;
}
