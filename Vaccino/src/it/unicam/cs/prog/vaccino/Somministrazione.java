package it.unicam.cs.prog.vaccino;
import java.util.Date;

public class Somministrazione {
	private Persona persona;
	private Date data;
	private Vaccino vaccino;
	
	Somministrazione(Persona p, Date d, Vaccino v) {
		persona = p;
		data = d;
		vaccino = v;  
	}		
}