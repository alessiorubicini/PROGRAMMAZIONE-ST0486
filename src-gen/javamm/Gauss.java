package javamm;

@SuppressWarnings("all")
public class Gauss {
  /**
   * Formula di Gauss
   * Lezione 15/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int gauss1(int n) {
    return ((n * (n + 1)) / 2);
  }
  
  public static int gauss2(int n) {
    int i = 0;
    int somma = 0;
    while ((i <= n)) {
      {
        int _somma = somma;
        somma = (_somma + i);
        i++;
      }
    }
    return somma;
  }
  
  public static double f(double x) {
    return ((((3 * x) * x) + (2 * x)) + 1);
  }
  
  public static double retta(double x) {
    return x;
  }
  
  public static double costante(double x) {
    return 10.0;
  }
  
  public static double integrale(double a, double b) {
    double dx = 0.0001;
    double x = a;
    double i = 0.0;
    while ((x < b)) {
      {
        x = (x + dx);
        double _f = Gauss.f(x);
        double _multiply = (_f * dx);
        double _plus = (i + _multiply);
        i = _plus;
      }
    }
    return i;
  }
  
  public static void main(String[] args) {
    System.out.println(Gauss.gauss1(100));
    System.out.println(Gauss.gauss2(100));
    System.out.println(Gauss.integrale(1, 100));
  }
}
