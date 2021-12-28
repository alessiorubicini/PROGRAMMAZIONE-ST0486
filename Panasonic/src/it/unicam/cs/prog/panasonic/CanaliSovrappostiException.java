package it.unicam.cs.prog.panasonic;

/**
 * Eccezione sollevata se una frequenza è già presa da un canale sulla televisione
 * @author alessiorubicini
 */
public class CanaliSovrappostiException extends Exception {
	public CanaliSovrappostiException() {
		super("Non è possibile impostare due canali diversi sulla stessa frequenza.");
	}
}
