package javamm;

@SuppressWarnings("all")
public class CamminiMinimi {
  /**
   * Trova il cammino minimo in un grafo
   * Lezione 16/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int cerca(int s, int t, int[][] g) {
    if ((s == t)) {
      return 0;
    } else {
      int min = 999999;
      for (int i = 0; (i < (g[s].length / 2)); i++) {
        {
          int _cerca = CamminiMinimi.cerca(g[s][(i * 2)], t, g);
          int p = (g[s][((i * 2) + 1)] + _cerca);
          if ((p < min)) {
            min = p;
          }
        }
      }
      return min;
    }
  }
  
  public static void main(String[] args) {
    int[][] grafo = { new int[] { 1, 3, 2, 7 }, new int[] { 3, 9, 4, 3 }, new int[] { 3, 2 }, new int[] {}, new int[] { 3, 8 } };
    System.out.println(CamminiMinimi.cerca(0, 3, grafo));
  }
}
