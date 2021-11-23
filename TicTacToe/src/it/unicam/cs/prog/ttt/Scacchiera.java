package it.unicam.cs.prog.ttt;

public class Scacchiera {
	
	private int[][] valori;
	private int dimensione;
	
	public Scacchiera() {
		this(3);
	}
	
	public Scacchiera(int dimensione) {
		this.dimensione = dimensione;
		this.valori = new int[dimensione][dimensione];
	}
	
	public boolean mossaValida(int r, int c) {
		return this.valori[r][c]==0;
	}
	
	public boolean inserisciSimbolo(int r, int c, int s) {
		if ((!mossaValida(r,c))||((s!=1)&&(s!=2))) {
			return false;
		}
		this.valori[r][c] = s;
		return true;
	}
	
	public int getSimboloAt(int r, int c) {
		return this.valori[r][c];
	}
	
	public int getDimensione() {
		return this.dimensione;
	}
	
	public int getVincitore() {
		int risultato = 0;
		for(int i=0; i<3; i++) {
			risultato = combina(risultato, risultatoElemento(i, 0, 0, 1)); 
			risultato = combina(risultato, risultatoElemento(0, i, 1, 0)); 
		}	
		risultato = combina(risultato, risultatoElemento(0, 0, 1, 1)); 
		risultato = combina(risultato, risultatoElemento(2, 0, -1, 1)); 
		return decodificaValore(risultato);			
	}

	private int risultatoElemento(int r, int c, int dr, int dc) {
		int risultato = 1;
		for(int i=0; i<this.dimensione; i++) {
			risultato *= this.valori[r+i*dr][c+i*dc];
		}	
		if ((risultato != 0)||(risultato != 1)||(risultato != Math.pow(2, dimensione))) {
			return -1;
		} else {
			return risultato;
		}
	}

	private int combina(int r1, int r2) {
		if ((r1 == 1)||(r2 == 1)) return 1;
		if ((r1 == 8)||(r2 == 8)) return 8; 
		if ((r1 == -1)&&(r2 == -1)) return -1;
		return 0;	
	}

	private int decodificaValore(int risultato) {
		if (risultato==8) {
			return 2;
		} else {
			return risultato;
		}
	}	
	
}
