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
		this.parola = this.arrayToUpperCase(parola.toCharArray());
		this.caratteriScoperti = new boolean[this.lunghezzaParola()];
		this.erroriPossibili = erroriPossibili;
		this.erroriCommessi = 0;
		this.caratteriUsati = new boolean['Z' - 'A'];
	}
	
	/**
	 * Controlla se il carattere passato come parametro
	 * e' presente o meno nella parola da indovinare. 
	 * Se non e' stata scoperta nessuna lettera
	 * il numero di errori commessi e' aumentato di 1.
	 * 
	 * @param carattere: il carattere da usare nel tentativo.
	 * @return true se il carattere e' stato scoperto, false altrimenti.
	 */
	public boolean tentativo(char carattere) {
		carattere = registraCarattere(carattere);
		int numeroCaratteriScoperti = scopri(carattere);
		if (numeroCaratteriScoperti == 0) {
			this.erroriCommessi++;
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
	 * @param carattere: il carattere da controllare
	 * @return il carattere opportunamente trasformato
	 */
	private char registraCarattere(char carattere) {
		carattere = this.toUpperCase(carattere);
		if (('A' <= carattere) && (carattere <= 'Z')) {
			int i = carattere - 'A';
			if (this.caratteriUsati[i]) {
				carattere = '*';
			} else {
				this.caratteriUsati[i] = true;
			}
		}
		return carattere;
	}
	
	/**
	 * Trasforma un carattere in maiuscolo 
	 * @param carattere: carattere da trasformare
	 * @return il carattere trasformato
	 */
	private char toUpperCase(char carattere) {
		if (('a' <= carattere) && (carattere <= 'z')) {
			carattere = (char) ('A' + (carattere - 'a'));
		}
		return carattere;
	}
	
	/**
	 * Trasforma i caratteri di un array in maiuscolo
	 * @param array: l'array di caratteri da trasformare
	 * @return l'array trasformato
	 */
	private char[] arrayToUpperCase(char[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = this.toUpperCase(array[i]);
		}
		return array;
	}

	/**
	 * Trasforma il carattere in maiuscolo e
	 * controlla se il carattere e' stato gia' utilizzato
	 * @param carattere: il carattere da controllare
	 * @return true se il carattere e' stato utilizzato, false altrimenti
	 */
	public boolean carattereUsato(char carattere) {
		carattere = this.toUpperCase(carattere);
		if (('A' <= carattere) && (carattere <= 'Z')) {
			return this.caratteriUsati[carattere - 'A'];
		}
		return false;
	}

	/**
	 * Prova a indovinare una lettera nella parola
	 * @param c: lettera di cui controllare la presenza nella parola
	 * @return il numero di occorrenze della lettera nella parola
	 */
	private int scopri(char carattere) {
		int counter = 0;
		for(int i = 0; i < this.parola.length; i++) {
			if (this.parola[i] == carattere) {
				this.caratteriScoperti[i] = true;
				counter++;
			}
		}
		return counter;
	}
	
	public int erroriCommessi() { return this.erroriCommessi; }
	
	public int erroriAncoraPossibili() { return this.erroriPossibili - this.erroriCommessi; }
	
	public int lunghezzaParola() { return this.parola.length; }
	
	/**
	 * Controlla lo stato di un carattere
	 * @param i: indice del carattere
	 * @return il carattere se e' stato scoperto, altrimenti il simbolo di asterisco *
	 */
	public char carattere(int i) {
		if (this.caratteriScoperti[i]) {
			return this.parola[i];
		} else {
			return '*';
		}
	}
	
	// Ritorna true se il carattere i della parola e' stato scoperto
	public boolean scoperto(int i) { return this.caratteriScoperti[i]; }
	
	/**
	 * Ritorna il numero di caratteri mancanti da scoprire nella parola
	 * @return il numero di caratteri mancanti
	 */
	public int caratteriMancanti() {
		int counter = 0;
		for(int i = 0; i < this.caratteriScoperti.length; i++) {
			if (!this.caratteriScoperti[i]) {
				counter++;
			}
		}
		return counter;
	}
}
