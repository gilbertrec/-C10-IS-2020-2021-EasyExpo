package Model.POJO;

public class Tag {
    public Tag(int idTag, String nome) {
        this.idTag = idTag;
        this.nome = nome;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "idTag=" + idTag +
                ", nome='" + nome + '\'' +
                '}';
    }

    private int idTag;
    private String nome;
}
