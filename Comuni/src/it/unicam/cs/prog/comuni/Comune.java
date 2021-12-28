package it.unicam.cs.prog.comuni;

public class Comune {
	private final String nome;
	private final String provincia;
	private final String CAP;
	private final int abitanti;
	
	Comune(String n, String p, String c, int a) throws ComuneException {
		if (p.length() == 2 && a <= 9999999 && a >= 10) {
			nome = n; provincia = p; CAP = c; abitanti = a;
		} else throw new ComuneException();
	}
	
	public String getNome() { return nome; }
	
	public String getProvincia() { return provincia; }
	
	public String getCAP() { return CAP; }
	
	public int getAbitanti() { return abitanti; }
}