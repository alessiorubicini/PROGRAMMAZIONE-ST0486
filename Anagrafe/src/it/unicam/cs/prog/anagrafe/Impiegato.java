package it.unicam.cs.prog.anagrafe;

public class Impiegato extends Persona implements Sport {
    private int stipendio;
    
    Impiegato(String n, String c, int s) { 
        super(n,c); 
        stipendio = s;
    } 
    
    public int sport() { return stipendio/10; }
    
    public String toString() {
    	return "Impiegato "+getNome()+" "+getCognome()+" stipendio "+stipendio+" sport "+sport();
    }
}