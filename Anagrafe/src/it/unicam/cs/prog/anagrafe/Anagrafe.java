package it.unicam.cs.prog.anagrafe;

public class Anagrafe {
	private Persona [] anagrafe = new Persona[10];
	public static void main(String [] args) {
		Anagrafe a = new Anagrafe();
		a.load();
		System.out.println(a);
	}
	private void load() {
		anagrafe[0] = new Studente("Paolo","Rossi",20);
		anagrafe[1] = new Persona("Paolo","Bisio");
		anagrafe[2] = new Insegnante("Michele","Loreti",18);
		anagrafe[3] = new Impiegato("Maria","Bianchi",30);
		anagrafe[4] = new Persona("Lucio","Battisti");
		anagrafe[5] = new Studente("Giorgia","Rossi",32);
	}
	public String toString() {
		String s = ""; int i = 0;
		while (anagrafe[i] != null) {
			System.out.println(anagrafe[i]);
	        i++;
	    }
		return s;
	} 
}