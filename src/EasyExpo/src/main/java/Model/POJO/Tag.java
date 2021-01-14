package Model.POJO;

/**
 * Tag e' la classe che gestisce un
 * ordinario oggetto Tag
 *
 * @author
 * @version 1.0
 * @since 2021-01-02
 */
public class Tag {

  /**
   * Metodo costruttore della classe Tag
   *
   * @param idTag codice identificativo tag, Intero
   * @param nome  nome prodotto associato al tag, String
   */
  public Tag(int idTag, String nome) {
    this.idTag = idTag;
    this.nome = nome;
  }

  /**
   * Metodo costruttore di default della classe Prodotto
   */
  public Tag() {

  }

  /**
   * Metodo che restituisce l'IdTag
   *
   * @return int - idTag
   */
  public int getIdTag() {
    return idTag;
  }

  /**
   * Metodo che setta l'IdTag
   *
   * @param idTag codice identificativo tag, Intero
   */
  public void setIdTag(int idTag) {
    this.idTag = idTag;
  }

  /**
   * Metodo che restituisce il nome
   *
   * @return String - nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * Metodo che setta il nome
   *
   * @param nome prodotto associato al tag, String
   */
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
