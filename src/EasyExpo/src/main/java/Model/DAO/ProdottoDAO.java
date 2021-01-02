package Model.DAO;

import Model.POJO.Preventivo;
import Model.POJO.Prodotto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> ProdottoDAO e' una classe di tipo DAO (Data Access Object)
 * che gestisce i dati persistenti dell'oggetto Prodotto </p>
 * @author
 * @version 1.0
 * @since   2020-12-29
 */

public class ProdottoDAO {

    /**
     * Metodo che ritorna l'oggetto di tipo Prodotto correlato ad un idProdotto dato in input
     * @param  idProdotto  codice identificativo prodotto, Intero
     * @return  Prodotto - Oggetto di tipo {@link Prodotto}
     *
     */

    public Prodotto doRetrieveByIdProdotto(int idProdotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT *  FROM Prodotto as p, Fornitore as f WHERE idProdotto=? AND p.partitaIva=f.partitaIva");
            ps.setInt(1, idProdotto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setTipo(Prodotto.Tipo.valueOf(rs.getString(5)));
                p.setQuantita(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che ritorna le istanze di tipo Prodotto contenute nel DB
     * @param  offset  indice partenza, Intero
     * @param limit  indice fine , Intero
     * @return  List &lt;Prodotto&gt; - {@link List} di oggetti di tipo {@link Prodotto}
     *
     */

    public List<Prodotto> doRetrieveAll(int offset, int limit) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con
                    .prepareStatement("SELECT * FROM Prodotto as p, Fornitore as f WHERE p.partitaIva=f.partitaIva LIMIT ?, ?");
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setIdProdotto(rs.getInt(1));
                p.setPartitaIva(rs.getString(2));
                p.setTitolo(rs.getString(3));
                p.setDescrizione(rs.getString(4));
                p.setTipo(Prodotto.Tipo.valueOf(rs.getString(5)));
                p.setQuantita(rs.getInt(6));
                p.setPrezzo(rs.getFloat(7));
                prodotti.add(p);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che crea un'istanza, all'interno del DB, di tipo Prodotto
     * @param prodotto  Oggetto di tipo {@link Preventivo}
     *
     */

    public void createProdotto(Prodotto prodotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodotto (idProdotto, partitaIva, titolo, descrizione, tipo, quantita, prezzo) VALUES(?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, prodotto.getIdProdotto());
            ps.setString(2, prodotto.getPartitaIva());
            ps.setString(3, prodotto.getTitolo());
            ps.setString(4, prodotto.getDescrizione());
            ps.setString(5, prodotto.getTipo().toString());
            ps.setInt(6, prodotto.getQuantita());
            ps.setFloat(7, prodotto.getPrezzo());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            prodotto.setIdProdotto(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo che elimina dal DB l'istanza Prodotto correlata all'idProdotto dato in input
     * @param idProdotto  codice identificativo Preventivo, Intero
     */

    public void deleteProdotto(int idProdotto) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodotto WHERE idProdotto=?");
            ps.setInt(1, idProdotto);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
