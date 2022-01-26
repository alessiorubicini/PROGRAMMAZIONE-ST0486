package it.unicam.cs.prog.veicoli;

import java.util.ArrayList;

public class Camion extends Veicolo {
	private double caricoMassimo;
	private ArrayList<Trasporto> storicoTrasporti;
	
	public Camion(int velMassima, double lunghezza, double caricoMassimo) throws Exception {
		super(velMassima, lunghezza);
		this.caricoMassimo = caricoMassimo;
		this.storicoTrasporti = new ArrayList<Trasporto>();
	}
	
	public double getCaricoMassimo() { return this.caricoMassimo; }
	public void setCaricoMassimo(double maxCarico) { this.caricoMassimo = maxCarico; }
	
	public void inserisciTrasporto(double peso, int km) {
		if((peso > 0 && km > 0) && (peso/10 <= this.caricoMassimo)) {
			Trasporto trasporto = new Trasporto(peso, km);
			this.storicoTrasporti.add(trasporto);
		}
	}
	
	public double calcolaUsura() {
		double risultato = 0.0;
		for (Trasporto trasporto : this.storicoTrasporti) {
			risultato += (trasporto.getChilometri() * trasporto.getPeso());
		}
		return risultato/this.pesoTotaleTrasportato();
	}
	
	private double pesoTotaleTrasportato() {
		double risultato = 0.0;
		for (Trasporto trasporto : this.storicoTrasporti) {
			risultato += trasporto.getPeso();
		}
		return risultato;
	}
	
	@Override
	public String toString() {
		String risultato = "Camion -> Velocità max: " + this.getVelocitaMax() + "Km/h, lunghezza: " + this.getLunghezza()
		+ "m, carico massimo: " + this.getCaricoMassimo() + "t, indice di usura: " + this.calcolaUsura() + "\nTRASPORTI:\n";
		for (Trasporto trasporto : this.storicoTrasporti) {
			risultato += "- " + trasporto.getPeso() + "q, " + trasporto.getChilometri() + "km \n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Camion camion;
		try {
			camion = new Camion(90, 15.0, 200.0);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		camion.inserisciTrasporto(120.3, 80);
		camion.inserisciTrasporto(180.3, 200);
		camion.inserisciTrasporto(120.3, 80);
		System.out.println(camion);
	}
}
