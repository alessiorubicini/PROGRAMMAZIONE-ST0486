package it.unicam.cs.prog.pari;

public class NumeroNonPari extends Exception {
	
	NumeroNonPari(int n) {
		super(""+n);  
	}
	
	NumeroNonPari() { super(); }
	
}