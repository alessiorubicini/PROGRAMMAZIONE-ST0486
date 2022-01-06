package it.unicam.cs.prog.vaccino;

public class Comirnaty extends Vaccino {
	
	private int richiamoSettimaneMinimo;
	private int richiamoSettimaneMassimo;
	
	Comirnaty() throws ErroriVaccino {
		super("Pfizer",2);
		this.richiamoSettimaneMinimo = 3;
		this.richiamoSettimaneMassimo = 4;     
    }

	public int getRichiamoSettimaneMinimo() {
		return richiamoSettimaneMinimo;
	}

	public void setRichiamoSettimaneMinimo(int richiamoSettimaneMinimo) {
		this.richiamoSettimaneMinimo = richiamoSettimaneMinimo;
	}

	public int getRichiamoSettimaneMassimo() {
		return richiamoSettimaneMassimo;
	}

	public void setRichiamoSettimaneMassimo(int richiamoSettimaneMassimo) {
		this.richiamoSettimaneMassimo = richiamoSettimaneMassimo;
	}
	
}