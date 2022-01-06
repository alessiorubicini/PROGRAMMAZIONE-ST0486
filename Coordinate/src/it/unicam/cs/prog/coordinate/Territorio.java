package it.unicam.cs.prog.coordinate;

import java.util.ArrayList;

public class Territorio {
	
	private String nome;
	private ArrayList<Coordinata> vertici;
	
	public Territorio(String nome) {
		this.nome = nome;
		this.vertici = new ArrayList<Coordinata>();
		for(int i = 0; i < 3; i++) {
			this.aggiungiVertice(new Coordinata());
		}
	}
	
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; } 
	
	public void aggiungiVertice(Coordinata coordinata) {
		if(this.vertici.size() < 20) {
			this.vertici.add(coordinata);
		}
	}
	
	public double getAltezzaMedia() {
		double risultato = 0.0;
		for (Coordinata coordinata : this.vertici) {
			risultato += (double)(coordinata.getAltitudine());
		}
		return risultato/this.vertici.size();
	}
	
	@Override
	public String toString() {
		String risultato = "";
		for (Coordinata coordinata : this.vertici) {
			risultato += "Vertice -> (lat: " + coordinata.getLatitudine() + "°, long: " + coordinata.getLongitudine()
			+ "°, alt: " + coordinata.getAltitudine() + ")\n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Territorio terr = new Territorio("Italia");
		Coordinata vertice;
		try {
			vertice = new Coordinata(43.12, 13.43, 2);
		} catch (CoordinataErrataException e) {
			System.out.println(e);
			return;
		}
		terr.aggiungiVertice(vertice);
		System.out.print(terr);
		System.out.print(terr.getAltezzaMedia());
	}
}
