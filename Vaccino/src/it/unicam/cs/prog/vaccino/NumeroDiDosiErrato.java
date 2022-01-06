package it.unicam.cs.prog.vaccino;

public class NumeroDiDosiErrato extends ErroriVaccino {
	NumeroDiDosiErrato(int numeroDosi) {
		super("" + numeroDosi);
	} 
}