package javamm;

import javamm.util.Input;

@SuppressWarnings("all")
public class MCD {
  public static int getInteger() {
    int n = 0;
    do {
      n = Input.getInt("Inserisci un numero intero maggiore di 0");
    } while((n <= 0));
    return n;
  }
  
  public static int MCD(int a, int b) {
    int mcd = 0;
    int r = 0;
    while ((b != 0)) {
      {
        r = (a % b);
        a = b;
        b = r;
      }
    }
    mcd = a;
    return mcd;
  }
  
  public static void main(String[] args) {
    int a = 0;
    int b = 0;
    a = MCD.getInteger();
    b = MCD.getInteger();
    int _MCD = MCD.MCD(a, b);
    String _plus = ((((("L\'MCD tra " + Integer.valueOf(a)) + " e ") + Integer.valueOf(b)) + " \u00E8 ") + Integer.valueOf(_MCD));
    System.out.println(_plus);
  }
}
