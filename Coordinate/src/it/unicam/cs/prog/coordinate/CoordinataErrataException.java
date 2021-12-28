package it.unicam.cs.prog.coordinate;

/**
 * Eccezione sollevata se i parametri di una coordinata sono errati
 * @author alessiorubicini
 */
public class CoordinataErrataException extends Exception {
	public CoordinataErrataException() {
		super("Errore: i valori inseriti sono errati");
	}
}
