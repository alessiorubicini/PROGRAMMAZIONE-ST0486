package it.unicam.cs.prog.panasonic;

import java.util.ArrayList;

public class Panasonic extends TV {
	private int numeroDiCanali;
	private String risoluzione;
	private ArrayList<Canale> canali;
	
	/**
	 * Crea un oggetto Panasonic
	 * @param modello: nome del modello
	 * @param pollici: numero di pollici dello schermo
	 * @param numeroDiCanali: numero di canali, strettamente maggiore di 12
	 * @param risoluzione: risoluzione dello schermo (es. Full-HD)
	 * @throws Exception se il numero di canali inseriti è minore di 12
	 */
	public Panasonic(String modello, int pollici, int numeroDiCanali, String risoluzione) throws Exception {
		super(pollici);
		if(numeroDiCanali > 12) {
			this.nomeModello = modello;
			this.numeroDiCanali = numeroDiCanali;
			this.risoluzione = risoluzione;
			this.canali = new ArrayList<Canale>();
		} else {
			throw new Exception("Numero di canali errato");
		}
	}

	public int getNumeroDiCanali() { return numeroDiCanali; }

	public void setNumeroDiCanali(int numeroDiCanali) { this.numeroDiCanali = numeroDiCanali; }

	public String getRisoluzione() { return risoluzione; }

	public void setRisoluzione(String risoluzione) { this.risoluzione = risoluzione; }
	
	/**
	 * Controlla se la frequenza è impostata per altri canali o meno
	 * @param frequenza in Mhz
	 * @return true se la frequenza è libera, false se è già presa da un altro canalae
	 */
	private boolean frequenzaLibera(int frequenza) {
		for(Canale canale: this.canali) {
			if(canale.getFrequenza() == frequenza) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Imposta un nuovo canale sulla televisione
	 * @param numero del canale
	 * @param frequenza del canale in Mhz
	 * @throws CanaliSovrappostiException se la frequenza è già presa da un altro canale
	 */
	public void setCanale(int numero, int frequenza) throws CanaliSovrappostiException {
		if(this.frequenzaLibera(frequenza)) {
			try {
				this.canali.add(new Canale(numero, frequenza));
				this.numeroDiCanali++;
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			throw new CanaliSovrappostiException();
		}
	}
	
	@Override
	public String toString() {
		String risultato = "";
		risultato += "Modello: " + this.nomeModello + ", pollici: " + this.getPollici() + ", risoluzione: " + this.risoluzione + ". Canali:\n";
		for(Canale canale: this.canali) {
			risultato += "- Canale " + canale.getNumero() + ", frequenza: " + canale.getFrequenza() + "Mhz\n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Panasonic tv;
		try {
			tv = new Panasonic("SmartTV 2021", 50, 20, "Full-HD");
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		try {
			tv.setCanale(8, 700);
		} catch (CanaliSovrappostiException e) {
			System.out.println(e);
		}
		System.out.println(tv);
	}
	
}
