package javamm;

@SuppressWarnings("all")
public class Array {
  /**
   * Manipolazione di array
   * Lezione 25/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static char[] creaArray(int n) {
    char[] r = new char[n];
    for (int i = 0; (i < n); i++) {
      double _random = Math.random();
      double _multiply = (_random * 26);
      int _plus = ('a' + ((int) _multiply));
      r[i] = ((char) _plus);
    }
    return r;
  }
  
  public static void stampaArray(char[] a) {
    for (int i = 0; (i < a.length); i++) {
      System.out.print(a[i]);
    }
    System.out.print("\n");
  }
  
  public static void invertiArray(char[] a) {
    for (int i = 0; (i < (a.length / 2)); i++) {
      {
        char t = a[i];
        a[i] = a[((a.length - 1) - i)];
        a[((a.length - 1) - i)] = t;
      }
    }
  }
  
  public static char[] invertiArray2(char[] a) {
    char[] r = new char[a.length];
    for (int i = 0; (i < (a.length / 2)); i++) {
      r[((a.length - 1) - i)] = a[i];
    }
    return r;
  }
  
  public static void main(String[] args) {
    char[] string = Array.creaArray(100);
    Array.stampaArray(string);
    Array.invertiArray(string);
    Array.stampaArray(string);
  }
}
