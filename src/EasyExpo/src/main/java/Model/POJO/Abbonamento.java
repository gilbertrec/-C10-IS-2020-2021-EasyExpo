package Model.POJO;

import java.util.Date;

public class Abbonamento {
    public Abbonamento(int idAbbonamento, String partitaIva, Date dataInizio, Date dataFine) {
        this.idAbbonamento = idAbbonamento;
        this.partitaIva = partitaIva;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public int getIdAbbonamento() {
        return idAbbonamento;
    }

    public void setIdAbbonamento(int idAbbonamento) {
        this.idAbbonamento = idAbbonamento;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "idAbbonamento=" + idAbbonamento +
                ", partitaIva='" + partitaIva + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }

    private int idAbbonamento;
    private String partitaIva;
    private Date dataInizio;
    private Date dataFine;
}
