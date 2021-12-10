	package it.unicam.cs.prog.persone;
	import java.util.Date;
	
	public class Maschio extends Persona {
	    private double testosterone;
	    
	    Maschio(String n, String c, Date d, double t) {
	      super(n,c,d);
	      testosterone = t;
	    }
	    
	    public String esami() { return "Testosterone " + testosterone; }
	}