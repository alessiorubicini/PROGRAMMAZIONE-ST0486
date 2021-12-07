package it.unicam.cs.prog.impiccatov2;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Loreti
 *
 */
public class Gioco {
	
	public final static int ERRORI_AMMESSI = 6;

	public final static String SCHEMA0 = 
			  "+---+\n"
			+ "|    \n"
			+ "|    \n"
			+ "|    \n"
			+ "|    \n"
			+ "+    \n";
	
	public final static String SCHEMA1 = 
			  "+---+\n"
			+ "|   o\n"
			+ "|    \n"
			+ "|    \n"
			+ "|    \n"
			+ "+    \n";

	public final static String SCHEMA2 = 
			  "+---+\n"
			+ "|   o\n"
			+ "|   |\n"
			+ "|    \n"
			+ "|    \n"
			+ "+    \n";

	public final static String SCHEMA3 = 
			  "+---+\n"
			+ "|   o\n"
			+ "|  /|\n"
			+ "|    \n"
			+ "|    \n"
			+ "+    \n";

	public final static String SCHEMA4 = 
			  "+---+  \n"
			+ "|   o  \n"
			+ "|  /|\\ \n"
			+ "|      \n"
			+ "|      \n"
			+ "+      \n";

	public final static String SCHEMA5 = 
			  "+---+  \n"
			+ "|   o  \n"
			+ "|  /|\\ \n"
			+ "|  /   \n"
			+ "|      \n"
			+ "+      \n";

	public final static String SCHEMA6 = 
			  "+---+  \n"
			+ "|   o  \n"
			+ "|  /|\\ \n"
			+ "|  / \\  \n"
			+ "|      \n"
			+ "+      \n";

	private static final String MESSAGGIO_SCEGLI_CARATTERE = "Quale carattere vuoi inserire?";
	private static final String MESSAGGIO_CARATTERI_USATI = "Hai già usato: ";
	private static final String MESSAGGIO_INPUT_CARATTERE = "Inserisci carattere: ";

	private static final String MESSAGGIO_VITTORIA = "Hai vinto!";

	private static final String MESSAGGIO_SCONFITTA = "Hai perso!";

	private static final String MESSAGGIO_MOSTRA_PAROLA = "La parola da indovinare era: ";

	public static String[] schema = new String[] {
			SCHEMA0, SCHEMA1, SCHEMA2, SCHEMA3, SCHEMA4, SCHEMA5, SCHEMA6 
	};
	
	private String[] parole = new String[] {
		"ELEFANTE",
		"GATTO",
		"CANE",
		"INFORMATICA",
		"CORIANDOLO",
		"CORNICIONE",
		"BENEDETTO",
		"COMUNICAZIONE",
		"PRECIPITEVOLISSIMEVOLMENTE"
	};
	
	private Impiccato impiccato;
	private Scanner input = new Scanner(System.in);
	private PrintStream output = System.out;
	
	private void gioca() {
		impiccato = new Impiccato(ERRORI_AMMESSI, scegliParola());
		while ((impiccato.caratteriMancanti()!=0)
			&&(impiccato.erroriAncoraPossibili()!=0)) {
			stampaSchema();
			stampaParola();
			char c = scegliCarattere();
			impiccato.tentativo(c);
		}
		stampaRisultato();
	}

	private void stampaParola() {
		output.print("   ");
		for(int i=0; i<impiccato.lunghezzaParola();i++) {
			if (impiccato.scoperto(i)) {
				output.print(impiccato.carattere(i));
			} else {
				output.print("_");
			}
		}
		output.println("\n\n");
	}

	private void stampaRisultato() {
		if (impiccato.caratteriMancanti()==0) {
			stampaParola();
			output.println(MESSAGGIO_VITTORIA);
		} else {
			stampaSchema();
			output.println(MESSAGGIO_SCONFITTA);
			output.print(MESSAGGIO_MOSTRA_PAROLA);
			output.println(impiccato.rivelaParola());
		}
	}

	private char scegliCarattere() {
		String rigaLetta = "";
		while (rigaLetta.isBlank()) {
			output.println(MESSAGGIO_SCEGLI_CARATTERE);
			stampaCaratteriUsati();
			output.print(MESSAGGIO_INPUT_CARATTERE);
			output.flush();
			rigaLetta = input.nextLine();
		}
		return rigaLetta.charAt(0);
	}

	private void stampaCaratteriUsati() {
		for(int i=0; i<'Z'-'A'+1; i++) {
			char c = (char) ('A'+i);
			if (impiccato.carattereUsato(c)) {
				output.print(c+" ");	
			}
		}
		output.println();
	}

	private String scegliParola() {
		Random random = new Random();
		return parole[random.nextInt(parole.length)];
	}
	
	private void stampaSchema() {
		System.out.println(Gioco.schema[impiccato.erroriCommessi()]);
	}
	
	
	public static void main(String[] argv) {
		Gioco gioco = new Gioco();
		gioco.gioca();
	}
	
}
