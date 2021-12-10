package it.unicam.cs.prog.sensori;

public class SensoreVento extends Sensore {
	private int forza;			// m/s
	private int direzione;		// 0-359°
	
	SensoreVento(int direzione, int forza) {
		super();
		if(direzione >= 0 && direzione < 360 && forza >= 0) {
			this.direzione = direzione;
			this.forza = forza;
		} else {
			this.direzione = 0;
			this.forza = 0;
		}
	}
	
	public int getForza() { return this.forza; }
	public int getDirezione() { return this.direzione; }
	
	@Override public String toString() {
		return this.getDate() + ": " + forza + " m/s " + direzione + "°";
	}
}