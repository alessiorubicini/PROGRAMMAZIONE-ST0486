package it.unicam.cs.prog.panasonic;

public class CanaliSovrappostiException extends Exception {
	public CanaliSovrappostiException() {
		super("Non è possibile impostare due canali diversi sulla stessa frequenza.");
	}
}
