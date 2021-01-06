package Model.POJO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class Carrello {

    private ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    private LinkedHashMap<String, ArrayList<Prodotto>> ProdottiFornitori = new LinkedHashMap<>();

    public Collection<ArrayList<Prodotto>> getProdottiFornitori() {return ProdottiFornitori.values(); }

    public ArrayList<Prodotto> get(String partitaIva) { return ProdottiFornitori.get(partitaIva); }


    public void put(ArrayList<Prodotto> prodotti) {
        String PI = prodotti.get(0).getPartitaIva();
        ProdottiFornitori.put(PI, prodotti);
    }

    public ArrayList<Prodotto> remove(String partitaIva) {
        return ProdottiFornitori.remove(partitaIva);
    }

    public LinkedHashMap<String, ArrayList<Prodotto>> getLista(){
        return ProdottiFornitori;
    }

    /*public float  getPrezzoTot() { return (float) prodotti.values().stream().mapToDouble(p -> (double) p.getPrezzo_v()).sum();
    }
     */


}
