package it.unicam.cs.prog.lavoratore;

import java.util.ArrayList;

public class Lavoratore extends Persona {
	
	private int retribuzioneOraria;
	private int retribuzioneOrariaStraordinari;
	private ArrayList<Integer> oreStandard;
	private ArrayList<Integer> oreStraordinari;
	
	public Lavoratore(String cognome, String nome, int eta, int retrOraria, int retrOrariaStraordinaria) throws Exception {
		super(cognome, nome, eta);
		this.retribuzioneOraria = retrOraria;
		this.retribuzioneOrariaStraordinari = retrOrariaStraordinaria;
		this.oreStandard = new ArrayList<Integer>();
		this.oreStraordinari = new ArrayList<Integer>();
	}

	public int getRetribuzioneOraria() { return retribuzioneOraria; }

	public void setRetribuzioneOraria(int retribuzioneOraria) { this.retribuzioneOraria = retribuzioneOraria; }

	public int getRetribuzioneOrariaStraordinari() { return retribuzioneOrariaStraordinari; }

	public void setRetribuzioneOrariaStraordinari(int retribuzioneOrariaStraordinari) { this.retribuzioneOrariaStraordinari = retribuzioneOrariaStraordinari; }
	
	public void inserisciOreDiLavoro(int ore) {
		if(ore <= 12) {
			if(ore <= 8) {
				this.oreStandard.add(ore);
			} else {
				this.oreStandard.add(8);
				this.oreStraordinari.add(ore - 8);
			}
		}
	}
	
	public int calcolaRetribuzione(ArrayList<Integer> ore, int retribuzione) {
		int risultato = 0;
		for(Integer ora: ore) {
			risultato += (ora * retribuzione);
		}
		return risultato;
	}

	public int calcolaStipendioMensile() {
		int stipendio = 0;
		stipendio += this.calcolaRetribuzione(this.oreStandard, this.retribuzioneOraria);
		stipendio += this.calcolaRetribuzione(this.oreStraordinari, this.retribuzioneOrariaStraordinari);
		this.oreStandard.removeAll(oreStandard);
		this.oreStraordinari.removeAll(oreStraordinari);
		return stipendio;
	}
	
	public String ottieniListaOrediLavoro() {
		String risultato = "";
		for(int i = 0; i < this.oreStandard.size(); i++) {
			risultato += "Giorno " + (i+1) + ": " + oreStandard.get(i) + "h";
			if(oreStraordinari.size() >= i+1) {
				risultato += " + " + oreStraordinari.get(i) + "h, ";
			} else {
				risultato += ", ";
			}
		}
		return risultato;
	}
	
	@Override
	public String toString() {
		String risultato = "";
		risultato += "- Nome: "+ this.getNome() + ", Cognome: " + this.getCognome() + ", Età: " + this.getEta() + " anni. ";
		risultato += "Ore di lavoro: [" + this.ottieniListaOrediLavoro();
		risultato += "]\n";
		return risultato;
	}

	// Metodo main per test classe
	public static void main(String[] args) {
		Lavoratore lav;
		try {
			lav = new Lavoratore("Rubicini", "Alessio", 19, 7, 11);
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
		lav.inserisciOreDiLavoro(10);
		System.out.println(lav);
		System.out.println(lav.calcolaStipendioMensile());
	}
	
}
