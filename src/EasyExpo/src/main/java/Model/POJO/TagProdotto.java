package Model.POJO;

public class TagProdotto {
    public TagProdotto(int idTag, int idProdotto) {
        this.idTag = idTag;
        this.idProdotto = idProdotto;
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

    @Override
    public String toString() {
        return "TagProdotto{" +
                "idTag=" + idTag +
                ", idProdotto=" + idProdotto +
                '}';
    }

    private int idTag;
    private int idProdotto;
}
