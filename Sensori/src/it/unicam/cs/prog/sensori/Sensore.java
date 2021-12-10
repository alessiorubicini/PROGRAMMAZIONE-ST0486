package it.unicam.cs.prog.sensori;
import java.util.Date;

public abstract class Sensore {
	private Date now;
	
	Sensore() {
		this.now = new Date();
	}
	
	public Date getDate() { return this.now; }
}
