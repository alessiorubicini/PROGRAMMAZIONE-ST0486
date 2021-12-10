package it.unicam.cs.prog.persone;
import java.util.Date;

public class Famiglia {
	public static void main(String [] args) {
		Persona mario =  new Maschio("Mario","Rossi",new Date(1960-1900,0,1),13.4);
		Persona paola =  new Femmina("Paola","Bianchi",new Date(1986-1900,2,2),18.6);
		Persona ugo = new Maschio("Ugo","Rossi",new Date(1982-1900,3,3),17.1);  
		Persona marcella = new Femmina("Marcella","Verdi",new Date(2001-1900,8,30),13.9);
		
		mario.addFiglio(ugo);
		mario.addFiglio(paola);
		ugo.addFiglio(marcella);
		
		System.out.println(mario.progenie(0));
    }
}
