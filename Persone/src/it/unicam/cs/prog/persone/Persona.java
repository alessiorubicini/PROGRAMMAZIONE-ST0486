package it.unicam.cs.prog.persone;
import java.util.Date;

abstract class Persona { 
	  private String nome; 
	  private String cognome;
	  private Date dataDiNascita;
	  private Persona [] figli = new Persona[20];
	  private int numeroFigli;
	  
	  Persona(String n, String c, Date d) {
	     nome = n; cognome = c; dataDiNascita = d;
	  }
	  
	  public void addFiglio(Persona x) {
	      figli[numeroFigli++] = x;
	  }
	  
	  public String progenie(int n) {
	      String r = "";
	      int s = n;
	      while (s>0) { r+="  "; s--; }
	      r += nome + " " + cognome + " " + dataDiNascita + " "+ esami() + "\n";
	      for (int i = 0; i < numeroFigli; i++) {
	    	  r += figli[i].progenie(n+1);
	      }
	      return r;
	  }
	  
	  abstract public String esami();
}
	  
