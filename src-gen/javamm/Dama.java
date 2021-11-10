package javamm;

@SuppressWarnings("all")
public class Dama {
  /**
   * Dama
   * 09/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static void stampaScacchiera(char[][] s) {
    for (int i = 0; (i < s.length); i++) {
      {
        for (int j = 0; (j < s[i].length); j++) {
          String _plus = (Character.valueOf(s[i][j]) + " ");
          System.out.print(_plus);
        }
        System.out.println();
      }
    }
    System.out.println("----------------");
  }
  
  public static void inizializzaScachiera(char[][] s) {
    for (int i = 0; (i < s.length); i++) {
      for (int j = 0; (j < s[i].length); j++) {
        {
          s[i][j] = '\u2395';
          if ((((i + j) % 2) == 0)) {
            s[i][j] = '\u2694';
            if ((i <= 2)) {
              s[i][j] = 'b';
            }
            if ((i >= 5)) {
              s[i][j] = 'n';
            }
          }
        }
      }
    }
  }
  
  public static boolean mossa(char[][] s, int r1, int c1, int r2, int c2) {
    if (((((s[r1][c1] == 'b') && (r2 == (r1 + 1))) && ((c2 == (c1 - 1)) || (c2 == (c1 + 1)))) && (s[r2][c2] == '\u2694'))) {
      s[r1][c1] = '\u2694';
      s[r2][c2] = 'b';
      return true;
    }
    return false;
  }
  
  public static void main(String[] args) {
    char[][] scacchiera = new char[8][8];
    Dama.inizializzaScachiera(scacchiera);
    Dama.stampaScacchiera(scacchiera);
    boolean _mossa = Dama.mossa(scacchiera, 2, 2, 3, 1);
    if (_mossa) {
      Dama.stampaScacchiera(scacchiera);
    }
  }
}
