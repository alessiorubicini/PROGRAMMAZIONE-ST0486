package it.unicam.cs.prog.agenda;

public class Agenda {
    private Nominativo [] agenda;
    private int numeroNominativi;
    
    Agenda(int numero) {
    	this.agenda = new Nominativo[numero];
    	this.numeroNominativi = 0;
    }
    
    public boolean aggiungiNominativo(Nominativo x) {
    	for (int i = 0; i < numeroNominativi; i++) {
      	  if (agenda[i] == x) return false;
        }
        for (int i = 0; i < numeroNominativi; i++) {
        	if (agenda[i].getNome() == x.getNome() && agenda[i].getCognome() == x.getCognome() && agenda[i].getNumero() == x.getNumero()) {
        		return false;
      	  	}
        }
        this.agenda[numeroNominativi] = x;
        this.numeroNominativi++;
        return true;
    }
    
    public static void main(String [] args) {
    	Agenda mia = new Agenda(1500);
    	mia.aggiungiNominativo(new Nominativo("Paolo","Rossi","12345678"));
    }
}