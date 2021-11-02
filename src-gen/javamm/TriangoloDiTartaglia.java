package javamm;

@SuppressWarnings("all")
public class TriangoloDiTartaglia {
  /**
   * Triangolo di tartaglia
   * Lezione 02/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int[][] creaMatriceTriangolare(int n) {
    int[][] t = new int[n][];
    for (int i = 0; (i < n); i++) {
      t[i] = new int[(i + 1)];
    }
    return t;
  }
  
  public static void popolaMatriceTriangolare(int[][] t) {
    for (int i = 0; (i < t.length); i++) {
      t[i][0] = 1;
    }
    for (int i = 0; (i < t.length); i++) {
      t[i][i] = 1;
    }
    for (int i = 2; (i < t.length); i++) {
      for (int j = 1; (j < i); j++) {
        int _plus = (t[(i - 1)][(j - 1)] + t[(i - 1)][j]);
        t[i][j] = _plus;
      }
    }
  }
  
  public static void stampaMatriceTriangolare(int[][] t) {
    for (int i = 0; (i < t.length); i++) {
      {
        for (int j = 0; (j < t[i].length); j++) {
          String _plus = (Integer.valueOf(t[i][j]) + " ");
          System.out.print(_plus);
        }
        System.out.println();
      }
    }
  }
  
  public static void main(String[] args) {
    int[][] tartaglia = TriangoloDiTartaglia.creaMatriceTriangolare(10);
    TriangoloDiTartaglia.popolaMatriceTriangolare(tartaglia);
    TriangoloDiTartaglia.stampaMatriceTriangolare(tartaglia);
  }
}
