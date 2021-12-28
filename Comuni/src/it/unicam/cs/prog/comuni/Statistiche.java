package it.unicam.cs.prog.comuni;
import java.io.*;

public class Statistiche {
	public static void main(String [] args) {
		Elenco comuniItaliani = null;
		try {
			comuniItaliani = new Elenco(args[0]); 
		} catch (ComuneException e) {
			System.out.println("Il file è corrotto"); 
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.out.println("Il file non esist	e");
			System.exit(2);
		}
		
		System.out.println("I comuni italiani sono"+ comuniItaliani.getElementi());
		
		System.out.println("Comune più popoloso ha "+ comuniItaliani.max()+" abitanti");
		
		System.out.println("Comuni della provincia di Macerata sono"+comuniItaliani.comuniInProvincia("MC"));
  }
} 