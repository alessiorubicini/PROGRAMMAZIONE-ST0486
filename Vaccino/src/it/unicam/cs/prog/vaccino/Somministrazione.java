package it.unicam.cs.prog.vaccino;
import java.util.Date;

public class Somministrazione {
	private Persona persona;
	private Date data;
	private Vaccino vaccino;
	
	Somministrazione(Persona persona, Date data, Vaccino vaccino) {
		this.persona = persona;
		this.data = data;
		this.vaccino = vaccino;  
	}		
}