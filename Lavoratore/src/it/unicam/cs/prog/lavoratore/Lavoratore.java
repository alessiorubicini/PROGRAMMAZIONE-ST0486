package it.unicam.cs.prog.lavoratore;
import java.util.ArrayList;

/**
 * Rappresenta un lavoratore
 * @author alessiorubicini
 */
public class Lavoratore extends Persona {
	
	private int retribuzioneOraria;
	private int retribuzioneOrariaStraordinari;
	private ArrayList<Integer> oreStandard;
	private ArrayList<Integer> oreStraordinari;
	
	/**
	 * Crea un oggetto Lavoratore
	 * @param cognome					Cognome del lavoratore (di almeno 1 caratteri)
	 * @param nome						Nome del lavoratore (di almeno 1 caratteri)
	 * @param eta						Età (maggiore di 0)
	 * @param retrOraria				Retribuzione oraria standard
	 * @param retrOrariaStraordinaria	Retrbuzione oraria per gli straordinari
	 * @throws Exception				se le condizioni sui parametri non sono rispettate
	 */
	public Lavoratore(String cognome, String nome, int eta, int retrOraria, int retrOrariaStraordinaria) throws Exception {
		super(cognome, nome, eta);
		this.retribuzioneOraria = retrOraria;
		this.retribuzioneOrariaStraordinari = retrOrariaStraordinaria;
		this.oreStandard = new ArrayList<Integer>();
		this.oreStraordinari = new ArrayList<Integer>();
	}

	public int getRetribuzioneOraria() { return retribuzioneOraria; }

	public void setRetribuzioneOraria(int retribuzioneOraria) { this.retribuzioneOraria = retribuzioneOraria; }

	public int getRetribuzioneOrariaStraordinari() { return retribuzioneOrariaStraordinari; }

	public void setRetribuzioneOrariaStraordinari(int retribuzioneOrariaStraordinari) { this.retribuzioneOrariaStraordinari = retribuzioneOrariaStraordinari; }
	
	/**
	 * Inserisce le ore di una singola giornata di lavoro
	 * @param oreTotali: ore totali della giornata
	 */
	public void inserisciOreDiLavoro(int ore) {
		if(ore <= 12) {
			if(ore <= 8) {
				this.oreStandard.add(ore);
			} else {
				this.oreStandard.add(8);
				this.oreStraordinari.add(ore - 8);
			}
		}
	}
	
	/**
	 * Calcola una specifica retribuzione mensilee
	 * @param ore: lista delle ore di lavoro
	 * @param retribuzione: retribuzione oraria
	 * @return retribuzione totale
	 */
	public int calcolaRetribuzione(ArrayList<Integer> ore, int retribuzione) {
		int risultato = 0;
		for(Integer ora: ore) {
			risultato += (ora * retribuzione);
		}
		return risultato;
	}
	
	/**
	 * Calcola lo stipendio mensile del lavoratore e svuota le liste delle ore di lavoro
	 * @return stipendio mensile del lavoratore
	 */
	public int calcolaStipendioMensile() {
		int stipendio = 0;
		stipendio += this.calcolaRetribuzione(this.oreStandard, this.retribuzioneOraria);
		stipendio += this.calcolaRetribuzione(this.oreStraordinari, this.retribuzioneOrariaStraordinari);
		this.oreStandard.removeAll(oreStandard);
		this.oreStraordinari.removeAll(oreStraordinari);
		return stipendio;
	}
	
	/**
	 * Restituisce le ore di lavoro del lavoratore giorno per giorno
	 * @return lista delle ore di lavoro come stringa
	 */
	public String ottieniListaOrediLavoro() {
		String risultato = "";
		for(int i = 0; i < this.oreStandard.size(); i++) {
			risultato += "Giorno " + (i+1) + ": " + oreStandard.get(i) + "h";
			if(oreStraordinari.size() >= i+1) {
				risultato += " + " + oreStraordinari.get(i) + "h, ";
			} else {
				risultato += ", ";
			}
		}
		return risultato;
	}
	
	@Override
	public String toString() {
		String risultato = "";
		risultato += "- Nome: "+ this.getNome() + ", Cognome: " + this.getCognome() + ", Età: " + this.getEta() + " anni. ";
		risultato += "Ore di lavoro: [" + this.ottieniListaOrediLavoro();
		risultato += "]\n";
		return risultato;
	}

	// Metodo main per test classe
	public static void main(String[] args) {
		Lavoratore lav;
		try {
			lav = new Lavoratore("Rubicini", "Alessio", 19, 7, 11);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		lav.inserisciOreDiLavoro(10);
		System.out.println(lav);
		System.out.println(lav.calcolaStipendioMensile());
	}
	
}
