package Model.POJO;

import java.sql.Date;

public class MetodoPagamento {
    public MetodoPagamento(int numeroCarta, String partitaIva, String nomeIntestatario, Date dataScadenza, int cvv) {
        this.numeroCarta = numeroCarta;
        this.partitaIva = partitaIva;
        this.nomeIntestatario = nomeIntestatario;
        this.dataScadenza = dataScadenza;
        this.cvv = cvv;
    }

    public MetodoPagamento(){

    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    public void setNomeIntestatario(String nomeIntestatario) {
        this.nomeIntestatario = nomeIntestatario;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

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
