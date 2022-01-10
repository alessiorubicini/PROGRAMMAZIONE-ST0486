package it.unicam.cs.prog.panasonic;

public class Panasonic extends TV {
	private String risoluzione;
	private int numeroDiCanali;
	private int[] canali;
	
	/**
	 * Crea un oggetto Panasonic
	 * @param modello: nome del modello
	 * @param pollici: numero di pollici dello schermo
	 * @param numeroDiCanali: numero di canali, strettamente minore di 12
	 * @param risoluzione: risoluzione dello schermo (es. Full-HD)
	 * @throws Exception se il numero di canali inseriti è minore di 12
	 */
	public Panasonic(String modello, int pollici, int numeroDiCanali, String risoluzione) throws Exception {
		super(pollici);
		if(numeroDiCanali < 13) {
			this.nomeModello = modello;
			this.numeroDiCanali = numeroDiCanali;
			this.risoluzione = risoluzione;
			this.canali = new int[numeroDiCanali];
		} else {
			throw new Exception("Numero di canali errato");
		}
	}

	public String getRisoluzione() { return risoluzione; }
	
	/**
	 * Imposta un nuovo canale sulla televisione
	 * @param numero del canale, compreso tra 1 e il numero di canali della TV
	 * @param frequenza del canale in Mhz, compresa tra 550 e 790 MHz
	 * @throws CanaliSovrappostiException se la frequenza è già presa da un altro canale
	 */
	public void setCanale(int numero, int frequenza) throws CanaliSovrappostiException {
		if((numero >= 1 && numero <= this.numeroDiCanali) && (frequenza >= 550 && frequenza <= 790)) {
			for(int i = 0; i < canali.length; i++) {
				if(this.canali[i] == frequenza) {
					throw new CanaliSovrappostiException();
				}
			}
			this.canali[numero - 1] = frequenza;
		}
	}
	
	@Override
	public String toString() {
		String risultato = "";
		risultato += "Modello: " + this.nomeModello + ", pollici: " + this.getPollici() + ", risoluzione: " + this.risoluzione + "\n";
		for(int i = 0; i < canali.length; i++) {
			risultato += "- Canale " + (i+1) + " " + this.canali[i] + "Mhz\n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Panasonic tv;
		try {
			tv = new Panasonic("SmartTV 2021", 50, 10, "Full-HD");
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		try {
			tv.setCanale(1, 700);
			tv.setCanale(2, 600);
		} catch (CanaliSovrappostiException e) {
			System.out.println(e);
		}
		System.out.println(tv);
	}
	
}
