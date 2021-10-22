package javamm;

import javamm.util.Input;

@SuppressWarnings("all")
public class NumeriPrimi {
  public static boolean[] eratostene(boolean[] vettore) {
    for (int i = 2; (i < vettore.length); i++) {
      boolean _tripleEquals = (Boolean.valueOf(vettore[i]) == Boolean.valueOf(true));
      if (_tripleEquals) {
        int j = (i * 2);
        int _length = vettore.length;
        boolean _lessThan = (j < _length);
        boolean _while = _lessThan;
        while (_while) {
          vettore[j] = false;
          int _j = j;
          j = (_j + i);
          int _length_1 = vettore.length;
          boolean _lessThan_1 = (j < _length_1);
          _while = _lessThan_1;
        }
      }
    }
    return vettore;
  }
  
  public static void stampaRisultato(boolean[] vettore) {
    System.out.print("[");
    for (int k = 2; (k < vettore.length); k++) {
      boolean _tripleEquals = (Boolean.valueOf(vettore[k]) == Boolean.valueOf(true));
      if (_tripleEquals) {
        String _plus = (Integer.valueOf(k) + ",");
        System.out.print(_plus);
      }
    }
    System.out.print("]");
  }
  
  public static void main(String[] args) {
    int n = Input.getInt("Inserisci n");
    boolean[] numeri = new boolean[n];
    for (int i = 0; (i < numeri.length); i++) {
      numeri[i] = true;
    }
    NumeriPrimi.stampaRisultato(NumeriPrimi.eratostene(numeri));
  }
}
