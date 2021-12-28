package it.unicam.cs.prog.lavoratore;

/* Data la classe Persona sotto riportata,
 * estenderla con la classe Lavoratore definita
 * nel modo seguente.
 * Un lavoratore e' caratterizzato dalle seguenti 
 * informazioni aggiuntive: retribuzione oraria 
 * standard in euro, retribuzione oraria degli 
 * straordinari in euro, e lista delle ore standard 
 * e straordinarie svolte giornalmente (si assume 
 * un numero massimo di 20 giornate di lavoro al mese).  
 * La retribuzione degli straordinari deve essere 
 * strettamente maggiore di quella standard. 
 * 
 * Definire il metodo della classe Lavoratore per 
 * inserire le ore di una singola giornata di 
 * lavoro. Il metodo prende le ore totali della 
 * giornata come unico parametro; fino ad un 
 * massimo di 8 vengono considerate come ore 
 * standard, eventuali ore aggiuntive sono 
 * considerate come straordinari, comunque nel 
 * totale le ore giornaliere non possono superare
 * le 12 ore.  
 * 
 * Definire il metodo della classe Lavoratore per 
 * il calcolo dello stipendio mensile, basato sul 
 * numero di ore standard/straordinarie e le 
 * rispettive retribuzioni. Il metodo svuotera' 
 * le liste delle ore in vista del mese successivo.   
 * 
 * Sovrascrivere il metodo toString() restituendo 
 * tutti i dati del lavoratore, cioe' nome, cognome, 
 * eta', lista delle ore attualmente svolte nel 
 * mese in corso.  
 * 
 * NB: la classe Persona non puo' essere modificata
 * in alcun modo! 
 */


public abstract class Persona {
	private String cognome;
	private String nome;
	private int eta;
	
	public Persona(String c, String n, int e) throws Exception {
		if (c.length()>1 && n.length()>1 && e>=0) {
			cognome = c; 
			nome = n; 
			eta = e;
		} else {
			throw new Exception("Persona non creata");
		}		 
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}		
}

