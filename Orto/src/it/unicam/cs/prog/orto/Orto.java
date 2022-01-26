package it.unicam.cs.prog.orto;

import java.util.ArrayList;

public class Orto {
	private double superficie;
	private ArrayList<Ortaggio> ortaggi;
	
	public Orto(double superficie) throws Exception {
		if(superficie >= 4) {
			this.superficie = superficie;
			this.ortaggi = new ArrayList<Ortaggio>();
		} else {
			throw new Exception("Parametro superficie errato: orto non creato");
		}
	}

	public double getSuperficie() {return superficie; }
	public void setSuperficie(double superficie) { this.superficie = superficie; }
	
	public int pianteAncoraPiantabili() {
		int pianteTotali = 0;
		for(Ortaggio ortaggio: this.ortaggi) {
			pianteTotali += ortaggio.getNumeroDiPiante();
		}
		return (int)((superficie * 10) - pianteTotali);
	}
	
	public void pianta(Ortaggio ortaggio) throws Exception {
		if(this.pianteAncoraPiantabili() > 0) {
			this.ortaggi.add(ortaggio);
		} else {
			throw new Exception("Spazio insufficiente nell'orto");
		}
	}
	
	@Override
	public String toString() {
		String risultato = "ORTAGGI:\n";
		for(Ortaggio ortaggio: this.ortaggi) {
		 	risultato += "- " + ortaggio.getNome() + ", " + ortaggio.getNumeroDiPiante() + " piante, data semina: " +
		 	ortaggio.getDataSemina() + ", data raccolta prevista: " + ortaggio.getDataRaccoltaPrevista() + "\n";
		}
		return risultato;
	}
	
	// Metodo main per test classe
	public static void main(String[] args) {
		Orto orto;
		try {
			orto = new Orto(4);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		System.out.println("Piantabili: " + orto.pianteAncoraPiantabili());
		try {
			orto.pianta(new Ortaggio("nsalata", 10, 20211012, 20211112));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Piantabili: " + orto.pianteAncoraPiantabili());
		System.out.println(orto);
	}
	
}
