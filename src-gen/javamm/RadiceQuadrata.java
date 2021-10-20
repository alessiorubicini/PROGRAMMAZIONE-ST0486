package javamm;

@SuppressWarnings("all")
public class RadiceQuadrata {
  public static double sqrt(double x, double a, double b, double epsilon) {
    int i = 0;
    while (((b - a) > epsilon)) {
      {
        double y = (((a + b) * (a + b)) / 4);
        if ((y > x)) {
          b = ((a + b) / 2);
        } else {
          a = ((a + b) / 2);
        }
        i++;
      }
    }
    System.out.println(("Cicli: " + Integer.valueOf(i)));
    return ((a + b) / 2);
  }
  
  public static void main(String[] args) {
    double z = RadiceQuadrata.sqrt(2, 1, 2, 0.00001);
    System.out.println(z);
    System.out.println((z * z));
  }
}
