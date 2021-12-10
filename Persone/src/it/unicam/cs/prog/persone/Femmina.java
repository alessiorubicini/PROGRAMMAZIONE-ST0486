package it.unicam.cs.prog.persone;
import java.util.Date;

public class Femmina extends Persona {
    private double progesterone;
    
    Femmina(String n, String c, Date d, double p) {
    	super(n,c,d);
    	progesterone = p;
    }
    
    public String esami() { return "Progesterone "+progesterone; } 
}