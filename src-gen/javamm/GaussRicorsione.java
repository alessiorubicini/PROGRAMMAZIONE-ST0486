package javamm;

@SuppressWarnings("all")
public class GaussRicorsione {
  /**
   * Formula di Gauss con ricorsione
   * 05/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int somma(int n) {
    int somma = 0;
    for (int i = 1; (i <= n); i++) {
      int _somma = somma;
      somma = (_somma + i);
    }
    return somma;
  }
  
  public static int sommaRicorsiva(int n) {
    if ((n == 0)) {
      return 0;
    } else {
      int _sommaRicorsiva = GaussRicorsione.sommaRicorsiva((n - 1));
      return (n + _sommaRicorsiva);
    }
  }
  
  public static double sommaReali(int n) {
    double somma = 0.0;
    for (int i = 1; (i <= n); i++) {
      double _somma = somma;
      somma = (_somma + (1.0 / (1L << i)));
    }
    return somma;
  }
  
  public static double sommaRealiRicorsiva(int n) {
    double _xjconditionalexpression = (double) 0;
    if ((n == 1)) {
      _xjconditionalexpression = (1.0 / 2);
    } else {
      double _sommaRealiRicorsiva = GaussRicorsione.sommaRealiRicorsiva((n - 1));
      _xjconditionalexpression = ((1.0 / (1L << n)) + _sommaRealiRicorsiva);
    }
    return _xjconditionalexpression;
  }
  
  public static void main(String[] args) {
    System.out.println(GaussRicorsione.somma(100));
    System.out.println(GaussRicorsione.sommaRicorsiva(100));
    System.out.println(GaussRicorsione.sommaReali(53));
    System.out.println(GaussRicorsione.sommaRealiRicorsiva(53));
  }
}
