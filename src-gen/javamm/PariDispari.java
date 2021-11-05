package javamm;

@SuppressWarnings("all")
public class PariDispari {
  /**
   * Mutua ricorsione per determinare se un numero è pari o dispari
   * 05/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static boolean pari(int n) {
    if ((n == 0)) {
      return true;
    } else {
      return PariDispari.dispari((n - 1));
    }
  }
  
  public static boolean dispari(int n) {
    if ((n == 0)) {
      return false;
    } else {
      return PariDispari.pari((n - 1));
    }
  }
  
  public static void main(String[] args) {
    System.out.println(PariDispari.pari(8));
    System.out.println(PariDispari.pari(3));
    System.out.println(PariDispari.dispari(7));
  }
}
