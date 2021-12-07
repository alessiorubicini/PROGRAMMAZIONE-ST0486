package it.unicam.cs.prog.agenda;

public class Agenda {
    private Nominativo [] agenda;
    private int numeroNominativi;
    
    Agenda(int numero) {
    	agenda = new Nominativo[numero];
    	numeroNominativi = 0;
    }
    
    public boolean aggiungiNominativo(Nominativo x) {
    	for (int i = 0; i < numeroNominativi; i++) {
      	  if (agenda[i] == x) return false;
        }
        for (int i = 0; i < numeroNominativi; i++) {
      	  if (agenda[i].getNome() == x.getNome() && agenda[i].getCognome() == x.getCognome() && agenda[i].getNumero() == x.getNumero()) return false; 
        }
        agenda[numeroNominativi] = x;
        numeroNominativi++;
        return true;
    }
    
    public static void main(String [] args) {
    	Agenda mia = new Agenda(1500);
    	mia.aggiungiNominativo(new Nominativo("Paolo","Rossi","12345678"));
    }
}