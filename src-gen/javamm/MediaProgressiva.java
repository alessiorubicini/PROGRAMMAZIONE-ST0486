package javamm;

import javamm.util.Input;

@SuppressWarnings("all")
public class MediaProgressiva {
  public static void main(String[] args) {
    int i = 0;
    int n = 0;
    double m = 0.0;
    do {
      {
        i = Input.getInt("Inserisci un intero o 0 per terminare");
        if ((i == 0)) {
          break;
        }
        m = (((n * m) + i) / (n + 1));
        n++;
        System.out.println(("La media \u00E8 " + Double.valueOf(m)));
      }
    } while((i != 0));
    System.out.println("Programma terminato");
  }
}
