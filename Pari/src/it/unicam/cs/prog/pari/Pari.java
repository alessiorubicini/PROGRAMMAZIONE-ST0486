package it.unicam.cs.prog.pari;

public class Pari {
	
	private int numero;
	
	Pari(int n) throws NumeroNonPari {
		if (n%2==0) numero = n;
		else throw new NumeroNonPari(n);
	}
	   
	Pari() { numero = 0; }
	   
	public int getNumero() { return numero; }
	   
	public void setNumero(int n) throws NumeroNonPari {
		if (n%2==0) numero = n;
		else throw new NumeroNonPari(n);
	}
	   
	public Pari somma(Pari n) {
		Pari x = null;
		try {
			x = new Pari(numero+n.getNumero());
		} catch (NumeroNonPari e) {}
			return x;
	   	}
	   
	public Pari sottrazione(Pari n) {
		Pari x = null;
		try {
			x = new Pari(numero-n.getNumero());
		} catch (NumeroNonPari e) {}
			return x;
		}
	   
	public Pari Moltiplicazione(Pari n) {
		Pari x = null;
		try {
			x = new Pari(numero*n.getNumero());
		} catch (NumeroNonPari e) {}
			return x;
	   	}
	   
	public Pari divisione(Pari n) throws  DivisionePerZero, NumeroNonPari {
		if (n.getNumero() == 0) throw new DivisionePerZero();
		if ((numero/n.getNumero()) % 2 != 0) throw new NumeroNonPari();
		Pari x = null;
		try {
			x = new Pari(numero-n.getNumero());
		} catch (NumeroNonPari e) {} 
			return x;
	    }
	    
	public void segno() { numero = -numero; }
	
	@Override
	public String toString() {
		return ""+numero;
	}
}