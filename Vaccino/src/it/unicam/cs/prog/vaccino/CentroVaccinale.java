package it.unicam.cs.prog.vaccino;

import java.util.Date;

public class CentroVaccinale {
	
	public static void main(String [] args) {
		Somministrazione [] elenco = new Somministrazione[100];
		try {
			elenco[0] = new Somministrazione(new Persona("Paolo","Rossi"), new Date(), new Vaxzevria());
			elenco[1] = new Somministrazione(new Persona("Maria","Bianchi"), new Date(), new Janssen());
			elenco[2] = new Somministrazione(new Persona("Luca","Verdi"), new Date(), new Comirnaty());                                     
		} catch (ErroriVaccino e) {
			System.out.println(e);
		}  
	}
	
}