package it.unicam.cs.prog.panasonic;

/*
 * Data la classe TV, che descrive
 * un TV generico con le sole caratteristiche
 * del numero di pollici (intero positivo) e 
 * del nome del modello (stringa),
 * estenderla con la classe Panasonic.
 *
 * La classe Panasonic permette di instanziare
 * oggetti fornendo, oltre ai pollici e al modello,
 * anche il numero di canali (intero positivo) e 
 * la risoluzione (stringa, tipo HD-Ready, Full-HD, 
 * ecc.). Il costruttore della classe Panasonic 
 * accerta che il numero di canali
 * sia maggiore strettamente di 12.
 *
 * Nella classe Panasonic deve essere definito un
 * metodo setCanale, che permette di impostare la
 * frequenza per un determinato canale. Il canale è
 * identificato da un numero intero positivo, mentre la
 * frequenza è un numero intero che deve essere
 * compreso tra 550 e 790 (estremi inclusi). Ad
 * esempio, il TV potrebbe avere il canale
 * 8 alla frequenza 714. 
 * Deve essere garantito che non ci siano canali 
 * diversi con la stessa frequenza (caratteristica 
 * specifica dei tv Panasonic); se si tenta di impostare 
 * a canali diversi la stessa frequenza, il metodo 
 * setCanale lancierà un'eccezzione di tipo CanaliSovrapposti  
 * (eccezzione personalizzata che dovrà essere quindi 
 * definita).
 *
 * Infine, riscrivere nella classe Panasonic
 * il metodo toString per la stampa dei dati del
 * TV, ovvero nome modello, numero di
 * pollici, risoluzione e lista dei canali (cioè la lista di
 * coppie canale-frequenza per tutti i canali
 * che sono stati impostati).
 */


public abstract class TV {
	private int pollici;
	protected String nomeModello;

	public TV(int p) throws Exception {
		if (p > 1)
			pollici = p;
		else
			throw new Exception("Dimensione tv errata");
	}


	public int getPollici() {
		return pollici;
	}
}