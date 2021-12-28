package it.unicam.cs.prog.vaccino;

public class Comirnaty extends Vaccino {
	private int richiamoSettimaneMinimo;
	private int richiamoSettimaneMassimo;
	
	Comirnaty() throws ErroriVaccino {
       super("Pfizer",2);
       richiamoSettimaneMinimo = 3;
       richiamoSettimaneMassimo = 4;     
    }
}