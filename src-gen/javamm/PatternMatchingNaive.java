package javamm;

@SuppressWarnings("all")
public class PatternMatchingNaive {
  /**
   * Ricerca di un pattern in un testo
   * Lezione 29/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int naive(char[] pattern, char[] testo) {
    for (int i = 0; (i <= (testo.length - pattern.length)); i++) {
      {
        int j = 0;
        while (((j < pattern.length) && (testo[(i + j)] == pattern[j]))) {
          j++;
        }
        int _length = pattern.length;
        boolean _tripleEquals = (j == _length);
        if (_tripleEquals) {
          return i;
        }
      }
    }
    return 0;
  }
  
  public static void main(String[] args) {
    char[] testo = "Nel mezzo del cammin di nostra vita".toCharArray();
    char[] pattern = "cammin".toCharArray();
    int _naive = PatternMatchingNaive.naive(pattern, testo);
    String _plus = ("Pattern trovato alla posizione " + Integer.valueOf(_naive));
    System.out.println(_plus);
  }
}
