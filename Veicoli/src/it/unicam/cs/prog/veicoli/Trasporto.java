package it.unicam.cs.prog.veicoli;

/**
 * Rappresenta un trasporto nello storico del camion
 * @author alessiorubicini
 */
public class Trasporto {
	
	private double peso;
	private int chilometri;
	
	/**
	 * Crea un oggetto Trasporto
	 * @param peso			peso del carico in quintali
	 * @param chilometri		chilometri percorsi
	 */
	public Trasporto(double peso, int chilometri)  {
		this.peso = peso;
		this.chilometri = chilometri;
	}
	
	public double getPeso() { return this.peso; }
	public double getChilometri() { return this.chilometri; }
	
	public void setPeso(double peso) { this.peso = peso; }
	public void setChilometri(int chilometri) { this.chilometri = chilometri; }
	
}
