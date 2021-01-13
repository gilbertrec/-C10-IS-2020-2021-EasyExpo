package Model.POJO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

public class Carrello {

    public static class ProdottoQuantita {
        private Prodotto prodotto;
        private int quantita;

        public ProdottoQuantita(Prodotto prodotto, int quantita) {
            this.prodotto = prodotto;
            this.quantita = quantita;
        }

        public int getQuantita() {
            return quantita;
        }

        public void setQuantita(int quantita) {
            this.quantita = quantita;
        }

        public Prodotto getProdotto() {
            return prodotto;
        }



        /*public long getPrezzoTotCent() {
            return quantita * prodotto.getPrezzoCent();
        }

        public String getPrezzoTotEuro() {
            return String.format("%.2f", quantita * prodotto.getPrezzoCent() / 100.);
        }*/
    }




    private ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    private LinkedHashMap<String, ArrayList<ProdottoQuantita>> ProdottiFornitori = new LinkedHashMap<>();

    public Collection<ArrayList<ProdottoQuantita>> getProdottiFornitori() {return ProdottiFornitori.values(); }

    public ArrayList<ProdottoQuantita> get(String partitaIva) { return ProdottiFornitori.get(partitaIva); }



    public void put(ArrayList<ProdottoQuantita> prodotti) {
        String PI = prodotti.get(0).getProdotto().getPartitaIva();
        ProdottiFornitori.put(PI, prodotti);
    }

    public ArrayList<ProdottoQuantita> remove(String partitaIva) {
        return ProdottiFornitori.remove(partitaIva);
    }

    public LinkedHashMap<String, ArrayList<ProdottoQuantita>> getLista(){
        return ProdottiFornitori;
    }

    /*public float  getPrezzoTot() { return (float) prodotti.values().stream().mapToDouble(p -> (double) p.getPrezzo_v()).sum();
    }
     */

    @Override
    public String toString() {
        return "Carrello{" +
                "listaProdotti=" + listaProdotti +
                ", ProdottiFornitori=" + ProdottiFornitori +
                '}';
    }


}
