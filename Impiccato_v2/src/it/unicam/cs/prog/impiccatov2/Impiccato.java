package it.unicam.cs.prog.impiccatov2;

/**
 * Questa classe ci permette di controllare una 
 * sessione di gioco dell'Impiccato.
 */
public class Impiccato {
	
	private char[] parola; 
	private boolean[] caratteriScoperti;
	private int erroriPossibili;
	private int erroriCommessi;
	private boolean[] caratteriUsati; 

	public Impiccato(int erroriPossibili, String parola) {
		this.parola = parola.toUpperCase().toCharArray();
		this.caratteriScoperti = new boolean[this.parola.length];
		this.erroriPossibili = erroriPossibili;
		this.caratteriUsati = new boolean[(int) ('Z'-'A')+1];
	}
	
	

	/**
	 * Controlla se il carattere passato come parametro
	 * e' presente o meno nella parola da indovinare. 
	 * Il numero di tentativi disponibili è decrementato 
	 * di 1.
	 * 
	 * @param c il carattere da usare nel tentativo.
	 * @return true se il carattere e' stato scoperto.
	 */
	public boolean tentativo(char c) {
		c = registraCarattere(c);
		int scoperti = scopri(c);
		if (scoperti == 0) {
			erroriCommessi++;
			return false;
		} else {
			return true;
		}
	}
	
	
	
	private char registraCarattere(char c) {
		c = toUpperCase(c);
		if (('A'<=c)&&(c<='Z')) {
			int i = c - 'A';
			if (caratteriUsati[i]) {
				c = '*';
			} else {
				caratteriUsati[i] = true;
			}
		}
		return c;
	}
	
	private char toUpperCase(char c) {
		if (('a'<=c)&&(c<='z')) {
			c = (char) ('A'+(c-'a'));
		}
		return c;
	}



	public boolean carattereUsato(char c) {
		c = toUpperCase(c);
		if (('A'<=c)&&(c<='Z')) {
			return caratteriUsati[c-'A'];
		}
		return false;
	}

	private int scopri(char c) {
		int counter = 0;
		for(int i=0; i<parola.length; i++) {
			if (parola[i]==c) {
				caratteriScoperti[i] = true;
				counter++;
			}
		}
		return counter;
	}
	
	public int erroriCommessi() {
		return erroriCommessi;
	}
	
	public int erroriAncoraPossibili() {
		return erroriPossibili-erroriCommessi;
	}
	
	public int lunghezzaParola() {
		return parola.length;
	}
	
	public char carattere(int i) {
		if (caratteriScoperti[i]) {
			return parola[i];
		} else {
			return '*';
		}
	}
	
	public boolean scoperto(int i) {
		return caratteriScoperti[i];
	}
	

	
	public int caratteriMancanti() {
		int counter = 0;
		for(int i=0; i<caratteriScoperti.length; i++) {
			if (!caratteriScoperti[i]) {
				counter++;
			}
		}
		return counter;
	}

	public String rivelaParola() {
		return new String(parola);
	}
}

