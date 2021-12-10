package it.unicam.cs.prog.anagrafe;

public class Studente extends Persona implements Lettura, Sport {
    private int studio;
    
    Studente(String n, String c, int s) { 
        super(n,c); 
        studio = s;
    }
    
    public int legge() { return studio/3; }
    public int sport() { return studio/4; }
    
    public String toString() {
    	return "Studente "+getNome()+" "+getCognome()+" studia "+studio+" legge "+legge()+" sport "+sport();
    }
}