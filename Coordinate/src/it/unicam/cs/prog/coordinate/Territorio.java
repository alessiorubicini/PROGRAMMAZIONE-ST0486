package it.unicam.cs.prog.coordinate;
import java.util.ArrayList;

/**
 * Un territorio è una superficie delimitata da un insieme di coordinate corrispondenti ai suoi vertici.
 * Il numero massimo di vertici per un territorio è 20. Un territorio è caratterizzato anche da un nome.
 * @author alessiorubicini
 */
public class Territorio {
	private ArrayList<Coordinata> vertici;
	private String nome;
	
	public Territorio(String nome) {
		this.vertici = new ArrayList<Coordinata>();
		for(int i = 0; i < 3; i++) {
			this.vertici.add(Coordinata.generaCoordinataRandom());
		}
		this.nome = nome;
	}
	
	public String getNome() { return this.nome; }
	public void setNome(String nome) { this.nome = nome; } 
	
	public void aggiungiVertice(Coordinata coordinata) {
		if(this.vertici.size() < 20) {
			this.vertici.add(coordinata);
		}
	}
	
	public double getAltezzaMedia() {
		int risultato = 0;
		int contatore = 0;
		for (Coordinata coordinata : this.vertici) { 		      
			risultato += coordinata.getAltitudine();
			contatore++;
		}
		return (double)(risultato/contatore);
	}
	
	@Override
	public String toString() {
		String risultato = "";
		for (Coordinata coordinata : this.vertici) {
			risultato += "Vertice -> latitudine: " + coordinata.getLatitudine() + ", longitudine: "
					+ coordinata.getLongitudine() + ", altitudine: " + coordinata.getAltitudine() + "\n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Territorio terr = new Territorio("Italia");
		Coordinata vertice;
		try {
			vertice = new Coordinata(43.12, 13.43, 0);
		} catch (CoordinataErrataException e) {
			System.out.println(e);
			return;
		}
		terr.aggiungiVertice(vertice);
		System.out.print(terr);
	}
}
