package it.unicam.cs.prog.vaccino;

public abstract class Vaccino {
	private final String produttore; 
    private final int dosi;
    
    Vaccino(String produttore, int dosi) throws NomeTroppoCorto, NumeroDiDosiErrato {
    	if (produttore.length() < 3) throw new NomeTroppoCorto(produttore);
    	if (dosi > 0) throw new NumeroDiDosiErrato(dosi);
    	this.produttore = produttore;
    	this.dosi = dosi;
    }
    
    public String getProduttore() { return produttore; }    
}