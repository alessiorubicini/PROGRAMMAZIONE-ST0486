package javamm;

import javamm.util.Input;

@SuppressWarnings("all")
public class DNA {
  /**
   * Realizzare il metodo creaDNA che produca una catena
   * DNA con valori casuali di 'A', 'T', 'C', 'G'.
   * Il parametro intero n definisce la lunghezza della catena.
   */
  public static char[] creaDNA(int n) {
    char[] risultato = new char[n];
    int random = 0;
    for (int i = 0; (i < risultato.length); i++) {
      {
        double _random = Math.random();
        double _multiply = (_random * 5);
        double _plus = (_multiply + 1);
        random = ((int) _plus);
        switch (random) {
          case 1:
            risultato[i] = 'A';
            break;
          case 2:
            risultato[i] = 'T';
            break;
          case 3:
            risultato[i] = 'C';
            break;
          case 4:
            risultato[i] = 'G';
            break;
          default:
            break;
        }
      }
    }
    return risultato;
  }
  
  public static void stampaDNA(char[] dna) {
    System.out.print("[");
    for (int k = 0; (k < dna.length); k++) {
      {
        System.out.print(dna[k]);
        int _length = dna.length;
        int _minus = (_length - 1);
        boolean _tripleNotEquals = (k != _minus);
        if (_tripleNotEquals) {
          System.out.print(",");
        }
      }
    }
    System.out.print("]");
  }
  
  public static void main(String[] args) {
    int n = Input.getInt("Inserisci un valore n > 0");
    char[] dna = DNA.creaDNA(n);
    DNA.stampaDNA(dna);
  }
}
