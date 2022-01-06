package it.unicam.cs.prog.vaccino;

public abstract class ErroriVaccino extends Exception { 
	
	ErroriVaccino(String n) {
		super(n);
	}
	
	ErroriVaccino() {
		super();
	}
	
}