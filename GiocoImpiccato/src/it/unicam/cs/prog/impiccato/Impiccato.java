package it.unicam.cs.prog.impiccato;

/**
 * Questa classe ci permette di controllare una 
 * sessione di gioco dell'Impiccato.
 */
public class Impiccato {
	
	private char[] parola;					// Caratteri della parola da indovinare
	private boolean[] caratteriScoperti;	// Booleani che indicano se un carattere è stato scoperto o meno
	private int erroriPossibili;			// Errori ancora possibili prima di perdere il gioco
	private int erroriCommessi;				// Errori commessi dal giocatore
	private boolean[] caratteriUsati; 		// Booleani che indicano quali caratteri dell'alfabeto sono stati utilizzati
	
	// Costruttori
	public Impiccato(String parola) {
		this(parola, 6);
	}
	
	public Impiccato(String parola, int erroriPossibili) {
		this.parola = parola.toCharArray();
		this.caratteriScoperti = new boolean[this.parola.length];
		this.erroriPossibili = erroriPossibili;
		this.erroriCommessi = 0;
		this.caratteriUsati = new boolean['Z' - 'A'];
	}
	
	/**
	 * Controlla se il carattere passato come parametro
	 * e' presente o meno nella parola da indovinare. 
	 * Se non e' stata scoperta nessuna lettera
	 * il numero di tentativi disponibili e' decrementato di 1.
	 * 
	 * @param c il carattere da usare nel tentativo.
	 * @return true se il carattere e' stato scoperto, false altrimenti.
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
	
	/**
	 * Trasforma il carattere in un carattere valido e,
	 * se non e' stato gia' utilizzato, lo registra come utilizzato e lo ritorna
	 * altrimenti lo ritorna come asterisco in modo che
	 * non verra' trovato e considerato come errore
	 * @param c: il carattere da controllare
	 * @return il carattere opportunamente trasformato
	 */
	private char registraCarattere(char c) {
		c = toUpperCase(c);
		if (('A' <= c) && (c <= 'Z')) {
			int i = c - 'A';
			if (caratteriUsati[i]) {
				c = '*';
			} else {
				caratteriUsati[i] = true;
			}
		}
		return c;
	}
	
	/**
	 * Trasforma un carattere in maiuscolo 
	 * @param c: carattere da trasformare
	 * @return il carattere trasformato
	 */
	private char toUpperCase(char c) {
		if (('a' <= c) && (c <= 'z')) {
			c = (char) ('A'+(c-'a'));
		}
		return c;
	}

	/**
	 * Trasforma il carattere in maiuscolo e
	 * controlla se il carattere e' stato gia' utilizzato
	 * @param c: il carattere da controllare
	 * @return true se il carattere e' stato utilizzato, false altrimenti
	 */
	public boolean carattereUsato(char c) {
		c = toUpperCase(c);
		if (('A' <= c) && (c <= 'Z')) {
			return caratteriUsati[c - 'A'];
		}
		return false;
	}

	/**
	 * Prova a indovinare una lettera nella parola
	 * @param c: lettera di cui controllare la presenza nella parola
	 * @return il numero di occorrenze della lettera nella parola
	 */
	private int scopri(char c) {
		int counter = 0;
		for(int i = 0; i < parola.length; i++) {
			if (parola[i] == c) {
				caratteriScoperti[i] = true;
				counter++;
			}
		}
		return counter;
	}
	
	
	public int erroriCommessi() { return erroriCommessi; }
	
	public int erroriAncoraPossibili() { return erroriPossibili-erroriCommessi; }
	
	public int lunghezzaParola() { return parola.length; }
	
	/**
	 * Controlla lo stato di un carattere
	 * @param i: indice del carattere
	 * @return il carattere se e' stato scoperto, altrimenti il simbolo di asterisco *
	 */
	public char carattere(int i) {
		if (caratteriScoperti[i]) {
			return parola[i];
		} else {
			return '*';
		}
	}
	
	// Ritorna true se il carattere i della parola e' stato scoperto
	public boolean scoperto(int i) { return caratteriScoperti[i]; }
	
	/**
	 * Ritorna il numero di caratteri mancanti da scoprire nella parola
	 * @return il numero di caratteri mancanti
	 */
	public int caratteriMancanti() {
		int counter = 0;
		for(int i=0; i<caratteriScoperti.length; i++) {
			if (!caratteriScoperti[i]) {
				counter++;
			}
		}
		return counter;
	}
}
