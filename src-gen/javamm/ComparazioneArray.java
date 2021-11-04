package javamm;

@SuppressWarnings("all")
public class ComparazioneArray {
  /**
   * Comparazione di array
   * 28/10/2021 - 04/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int occorrenze(int v, int[] a) {
    int contatore = 0;
    for (int i = 0; (i < a.length); i++) {
      boolean _tripleEquals = (a[i] == v);
      if (_tripleEquals) {
        contatore++;
      }
    }
    return contatore;
  }
  
  public static boolean sottoinsiemeElementi(int[] a1, int[] a2) {
    for (int i = 0; (i < a1.length); i++) {
      int _occorrenze = ComparazioneArray.occorrenze(a1[i], a2);
      boolean _tripleEquals = (_occorrenze == 0);
      if (_tripleEquals) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean stessoInsiemeElementi(int[] a1, int[] a2) {
    return (ComparazioneArray.sottoinsiemeElementi(a1, a2) && ComparazioneArray.sottoinsiemeElementi(a2, a1));
  }
  
  public static boolean stesseOccorrenzeElementi(int[] a1, int[] a2) {
    int _length = a1.length;
    int _length_1 = a2.length;
    boolean _tripleNotEquals = (_length != _length_1);
    if (_tripleNotEquals) {
      return false;
    }
    for (int i = 0; (i < a1.length); i++) {
      int _occorrenze = ComparazioneArray.occorrenze(a1[i], a1);
      int _occorrenze_1 = ComparazioneArray.occorrenze(a1[i], a2);
      boolean _tripleNotEquals_1 = (_occorrenze != _occorrenze_1);
      if (_tripleNotEquals_1) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
  }
}
