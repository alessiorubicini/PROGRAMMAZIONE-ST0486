package javamm;

@SuppressWarnings("all")
public class Sudoku {
  /**
   * Sudoku con matrici (si assume che la matrice è 9x9)
   * 04/11/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static int occorrenze(int v, int[] a) {
    int contatore = 0;
    for (int i = 0; (i < a.length); i++) {
      boolean _tripleEquals = (a[i] == v);
      if (_tripleEquals) {
        contatore++;
      }
    }
    return contatore;
  }
  
  /**
   * Restituisce true se il numero 'v' non occorre:
   * - sulla riga r;
   * - sulla colonna c;
   * - nel quadrato contenente (r, c);
   */
  public static boolean isValid(int[][] schema, int r, int c, int v) {
    boolean _not = (!((Sudoku.occorreNellaRiga(schema, r, v) || Sudoku.occorreNellaColonna(schema, c, v)) || Sudoku.occorreNelQuadrato(schema, r, c, v)));
    return _not;
  }
  
  public static boolean occorreNellaRiga(int[][] schema, int r, int v) {
    for (int i = 0; (i < 9); i++) {
      boolean _tripleEquals = (schema[r][i] == v);
      if (_tripleEquals) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean occorreNellaColonna(int[][] schema, int c, int v) {
    for (int i = 0; (i < 9); i++) {
      boolean _tripleEquals = (schema[i][c] == v);
      if (_tripleEquals) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean occorreNelQuadrato(int[][] schema, int r, int c, int v) {
    int rigaQuadrato = (r / 3);
    int colonnaQuadrato = (c / 3);
    for (int i = 0; (i < 3); i++) {
      for (int j = 0; (j < 3); j++) {
        boolean _tripleEquals = (schema[((rigaQuadrato * 3) + i)][((colonnaQuadrato * 3) + j)] == v);
        if (_tripleEquals) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
  }
}
