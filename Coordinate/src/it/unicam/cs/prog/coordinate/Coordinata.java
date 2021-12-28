package it.unicam.cs.prog.coordinate;

/**
 * Una coordinata sul globo terreste è determinata da due valori reali: la latitudine con valori compresi tra -90.0 e 90.0
 * e la longitudine con valori compresi tra -180.0 e 180.0. Una coordinata è inoltre caratterizzata anche dall'altitudine
 * rispetto al livello del mare, espressacome valore intero positivo.
 * @author alessiorubicini 
 */
public class Coordinata {
	
	private double latitudine;
	private double longitudine;
	private int altitudine;
	
	/**
	 * Crea un oggetto Coordinata
	 * @param latitudine						Latitudine compresa tra -90.0 e 90.0
	 * @param longitudine					Longitudine compresa tra -180.0 e 180
	 * @param altitudine						Altitudine rispetto al livello del mare
	 * @throws CoordinataErrataException	s	se le condizioni sui parametri non sono rispettate
	 */
	public Coordinata(double latitudine, double longitudine, int altitudine) throws CoordinataErrataException {
		if(((latitudine < 90.0) && (latitudine > -90.0)) && ((longitudine < 180.0) && (longitudine > -180.0)) && (altitudine >= 0)) {
			this.latitudine = latitudine;
			this.longitudine = longitudine;
			this.altitudine = altitudine;
		} else {
			throw new CoordinataErrataException();
		}
	}
	public double getLatitudine() { return latitudine; }

	public void setLatitudine(double latitudine) { this.latitudine = latitudine; }

	public double getLongitudine() { return longitudine;	}

	public void setLongitudine(double longitudine) { this.longitudine = longitudine;	}

	public int getAltitudine() { return altitudine;	}

	public void setAltitudine(int altitudine) { this.altitudine = altitudine; }
	
	/**
	 * Genera una coordinata con parametri random
	 * Metodo utile per la generazione di una coordinata random nel costruttore della classe Territorio
	 * @return oggetto Coordinata
	 */
	public static Coordinata generaCoordinataRandom() {
		try {
			return new Coordinata(
					(Math.random() * (90 + 1 - (-90)) + (-90)),
					(Math.random() * (180 + 1 - (-180)) + (-180)),
					(int)(Math.random() * (17 + 1 - 0) + 0));
		} catch (CoordinataErrataException e) {
			System.out.println(e);
			return null;
		}
	}	
}