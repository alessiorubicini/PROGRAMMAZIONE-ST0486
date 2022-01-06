package it.unicam.cs.prog.veicoli;

public class Trasporto {
	
	private double pesoTrasportato;
	private int chilometriPercorsi;
	
	public Trasporto(double pesoTrasportato, int chilometriPercorsi)  {
		this.pesoTrasportato = pesoTrasportato;
		this.chilometriPercorsi = chilometriPercorsi;
	}
	
	public double getPeso() { return this.pesoTrasportato; }
	public double getChilometri() { return this.chilometriPercorsi; }
	
	public void setPeso(double peso) { this.pesoTrasportato = peso; }
	public void setChilometri(int chilometri) { this.chilometriPercorsi = chilometri; }
	
}
