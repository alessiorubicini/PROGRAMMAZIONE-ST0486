package it.unicam.cs.prog.ladro;

public class Sacco {
    private Oggetto [] sacco;
    private int numeroOggetti = 0;
    private double volumeTotale, pesoTotale;
    private double volumeOggetti = 0.0, pesoOggetti = 0.0;
    
    public static void main(String [] args) {
        Sacco saccoDelLadro = new Sacco(20.0,30.0);
        saccoDelLadro.aggiungi(new Oggetto("Scarpe",1.0,2.0));
        saccoDelLadro.aggiungi(new Oggetto("Quadro",6.9,6.0));
        saccoDelLadro.aggiungi(new Oggetto(20.0,18.5));
        saccoDelLadro.aggiungi(new Oggetto("Portafoglio",0.3,0.2));
        System.out.println(saccoDelLadro.stampaOggetti());
    }
    
    Sacco(double volume, double peso) { 
        if (volume > 0.0 && peso > 0.0) {
           this.volumeTotale = volume;
           this.pesoTotale = peso;
           this.sacco = new Oggetto[(int)(volume*peso)+1]; 
        }
    }
    
    public void aggiungi(Oggetto o) {
      if ((numeroOggetti < sacco.length) && (volumeOggetti + o.getVolume() < volumeTotale && pesoOggetti + o.getPeso() < pesoTotale)) {
	        sacco[numeroOggetti] = o;
	        numeroOggetti++;
	        volumeOggetti += o.getVolume();
	        pesoOggetti   += o.getPeso();
        }
    }
    
    public String stampaOggetti() {
        String s = "Oggetti \n";
        for (int i = 0; i < numeroOggetti; i++) {
        	s += sacco[i].getNome()   +" "+ sacco[i].getPeso()   + " "+ sacco[i].getVolume() + "\n";
            s +="Totale peso " + pesoOggetti + "\n" + "Volume oggetti " + volumeOggetti;      
        }
        return s;
    }
}