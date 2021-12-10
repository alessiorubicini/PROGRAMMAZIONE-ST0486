package it.unicam.cs.prog.sensori;

public class SensorePioggia extends Sensore {
	private int millimetri;
	
	SensorePioggia(int millimetri) {
		super();
		if(millimetri >= 0) {
			this.millimetri = millimetri;
		}
	}
	
	public int getPrecipitazioni() { return this.millimetri; }
	
	@Override public String toString() {
		return this.getDate() + ": " + this.millimetri + " mm";
	}
}
