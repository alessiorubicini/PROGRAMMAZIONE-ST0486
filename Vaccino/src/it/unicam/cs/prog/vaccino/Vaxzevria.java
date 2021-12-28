package it.unicam.cs.prog.vaccino;

public class Vaxzevria extends Vaccino {
    private int richiamoSettimaneMinimo;
    private int richiamoSettimaneMassimo;
    
    Vaxzevria() throws ErroriVaccino {
    	super("AstraZeneca",2);
    	richiamoSettimaneMinimo = 8;
    	richiamoSettimaneMassimo = 12;
    }
}