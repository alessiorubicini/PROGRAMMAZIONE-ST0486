package it.unicam.cs.prog.veicoli;

/* Data la classe Veicolo sotto riportata,
 * estenderla con la classe Camion definita
 * nel modo seguente.
 *
 * La classe Camion e' caratterizzata dal peso   
 * massimo di merce che puo' trasportare (carico 
 * massimo), espresso in tonnellate (valore reale).
 * Per ogni Camion si vorra' tenere traccia di 
 * tutti i trasporti con esso effettuati, tale
 * informazione verra' utilizzata per il calcolo 
 * dell'indice di usura del camion.
 *
 * Definire il costruttore della classe Camion
 * che abbia come parametri aggiuntivi il carico 
 * massimo. 
 *
 * Definire il metodo 'inserisciTrasporto(double peso, int km)' 
 * della classe Camion per inserire un trasporto di merce
 * nello storico dei trasporti del camion in oggetto. 
 * Un trasporto e' definito dal peso del carico in quintali 
 * e dai chilometri percorsi. E' necessario fare una verifica 
 * dei dati inseriti rispetto alla caratteristica del camion
 * considerato; nel caso i valori non siano corretti il 
 * trasporto non verra' registrato senza la generazione
 * di alcuna eccezione. 
 * 
 * Definire il metodo 'calcolaUsura()' della classe Camion 
 * per il calcolo dell'indice di usura del camion, 
 * definito come media pesata dei chilometri totali 
 * percorsi rispetto al carico trasportato. 
 * Ad esempio, se un camion ha fatto due 
 * trasporti, 80km con 6.2q e 40km con 4.3q, 
 * l'indice di usura sara' dato da 
 * ((80*6.2)+(40*4.3))/(6.2+4.3).
 *
 * Sovrascrivere il metodo toString() per stampare
 * i dati del camion, cioe' velocita' massima, lunghezza, 
 * carico massimo, indice di usura e lista dei trasporti 
 * effettuati.
 * 
 * NB: la classe Veicolo non puo' essere modificata 
 * in alcun modo!
 */

public abstract class Veicolo {
	private int velocitaMax; // in Km/h
	private double lunghezza; // in metri

	public Veicolo(int v, double l) throws Exception {
		if (400 > v && v > 10 && 22 > l && l > 1) {
			velocitaMax= v;
			lunghezza = l;
		} else {
			throw new Exception("Veicolo non creato");
		}
	}

	public double getVelocitaMax() {
		return velocitaMax;
	}

	public double getLunghezza() {
		return lunghezza;
	}

		

}