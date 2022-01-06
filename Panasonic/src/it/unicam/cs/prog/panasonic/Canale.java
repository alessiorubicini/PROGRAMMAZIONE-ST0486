package it.unicam.cs.prog.panasonic;

public class Canale {
	private int numero;
	private int frequenza;
	
	/**
	 * Costruttore classe Canale
	 * @param numero: numero del canale
	 * @param frequenza: frequenza in Mhz compresa tra 550 e 790
	 * @throws Exception se la frequenza inserita è fuori dal range previsto
	 */
	public Canale(int numero, int frequenza) throws Exception {
		if(frequenza < 550 || frequenza > 790) {
			throw new Exception("Parametro frequenza errato");
		} else {
			this.frequenza = frequenza;
			this.numero = numero;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(int frequenza) {
		this.frequenza = frequenza;
	}
}
