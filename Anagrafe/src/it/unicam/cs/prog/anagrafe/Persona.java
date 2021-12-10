package it.unicam.cs.prog.anagrafe;

public class Persona {
	private String nome, cognome;
	
	Persona(String n, String c) { nome = n; cognome = c; }
	
	public String getNome() { return nome; }
	public String getCognome() { return cognome; }
	
	public String toString() {
		return "Persona " + nome + " " + cognome;
	}
}
