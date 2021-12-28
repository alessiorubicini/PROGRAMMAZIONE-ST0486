package it.unicam.cs.prog.orto;
import java.util.ArrayList;

/**
 * 
 * @author alessiorubicini
 */
public class Orto {
	
	private double superficie;
	private ArrayList<Ortaggio> ortaggi;
	
	/**
	 * Crea un oggetto Orto
	 * @param superficie in metri quadri strettamente maggiore di 4
	 * @throws Exception se la superficie inserita è minore di 4
	 */
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
	
	/**
	 * Ottiene il numero di posti rimasti per le singole piante
	 * @return numero di piante ancora piantabili
	 */
	public int piantePiantabili() {
		int pianteTotali = 0;
		for(Ortaggio ortaggio: this.ortaggi) {
			pianteTotali += ortaggio.getNumeroDiPiante();
		}
		return (int)((superficie * 10) - pianteTotali);
	}
	
	/**
	 * Pianta un ortaggio nell'orto
	 * @param ortaggio
	 * @throws Exception se non c'è più spazio nell'orto
	 */
	public void pianta(Ortaggio ortaggio) throws Exception {
		if(this.piantePiantabili() > 0) {
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
		System.out.println("Piantabili: " + orto.piantePiantabili());
		try {
			orto.pianta(new Ortaggio("nsalata", 10, 20211012, 20211112));
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Piantabili: " + orto.piantePiantabili());
		System.out.println(orto);
	}
	
}
