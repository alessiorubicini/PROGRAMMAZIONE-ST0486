package it.unicam.cs.prog.anagrafe;

public class Insegnante extends Persona implements Lettura {
	private int insegnamento;
    
	Insegnante(String n, String c, int s) { 
        super(n,c); 
        insegnamento = s;
    }  
   
    public int legge() { return insegnamento/2; }
   
    public String toString() {
    	return "Insegnante "+getNome()+" "+getCognome()+"i nsegna "+insegnamento+" legge "+legge();
    }
}