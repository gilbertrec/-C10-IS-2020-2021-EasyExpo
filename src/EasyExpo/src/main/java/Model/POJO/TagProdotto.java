package Model.POJO;

public class TagProdotto {
  public TagProdotto(int idTag, int idProdotto, String partitaIva) {
    this.idTag = idTag;
    this.idProdotto = idProdotto;
    this.partitaIva = partitaIva;
  }

  public TagProdotto() {

  }

  public int getIdTag() {
    return idTag;
  }

  public void setIdTag(int idTag) {
    this.idTag = idTag;
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

  @Override
  public String toString() {
    return "TagProdotto{" +
        "idTag=" + idTag +
        ", idProdotto=" + idProdotto +
        ", partitaIva='" + partitaIva + '\'' +
        '}';
  }

  private int idTag;
  private int idProdotto;
  private String partitaIva;
}
