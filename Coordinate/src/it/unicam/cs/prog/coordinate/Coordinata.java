package it.unicam.cs.prog.coordinate;

public class Coordinata {
	private double latitudine;
	private double longitudine;
	private int altitudine;
	
	/**
	 * Crea un oggetto Coordinata
	 * @param latitudine	Latitudine compresa tra -90.0 e 90.0
	 * @param longitudine	Longitudine compresa tra -180.0 e 180
	 * @param altitudine	Altitudine rispetto al livello del mare
	 * @throws CoordinataErrataException	s se le condizioni sui parametri non sono rispettate
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
	
	/**
	 * Crea un oggetto Coordinata con valori casuali
	 */
	public Coordinata() {
		this.latitudine = (Math.random() * (90 + 1 - (-90)) + (-90));
		this.longitudine = (Math.random() * (180 + 1 - (-180)) + (-180));
		this.altitudine = (int)(Math.random() * (17000 + 1 - 0) + 0);
	}
	
	public double getLatitudine() { return latitudine; }

	public void setLatitudine(double latitudine) { this.latitudine = latitudine; }

	public double getLongitudine() { return longitudine;	}

	public void setLongitudine(double longitudine) { this.longitudine = longitudine;	}

	public int getAltitudine() { return altitudine;	}

	public void setAltitudine(int altitudine) { this.altitudine = altitudine; }
}