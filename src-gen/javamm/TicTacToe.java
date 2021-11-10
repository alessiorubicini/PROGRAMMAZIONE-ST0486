package javamm;

@SuppressWarnings("all")
public class TicTacToe {
  /**
   * Quale informazione dobbiamo rappresentare? Lo schema del TTT
   * Come la rappresentiamo?
   * 	- Usiamo una matrice di dimensione 3x3
   * 	- Usiamo lo 0 per rappresentare una cella vuota, 1 rappresenta la X, 2 rappresenta il cerchio
   * Di quali operazioni abbiamo bisogno?
   * 	- Operazioni di input
   * 		- scrivere un metodo che preso in input l'intero del giocatore corrente e lo schema
   * 		  chiede in input riga e colonna dove inserire la pedina
   * 	- Controllo della vittoria
   * 		- Scrivere un metodo che preso in input verifica se c'è un vincitore e restituisce un
   * 		  intero che indica il risultato
   * 	- Controllo della validità di una mossa
   * 		- Scrivere un metodo che preso in input lo schema e gli interi che rappresentano riga e colonna
   * 		  restituisce true o false se la posizione è valida o meno
   * 	- Costruire lo schema
   * 		- Scrivere un metodo che non prende parametri e restituisce un nuovo schema
   * 	- Operazioni di output
   * 		- Scrivere un metodo che preso in input uno schema lo stampa a console
   * 	- Alternare il turno di gioco
   * 		- Scrivere un metodo che continua a chiedere la mossa ai due giocatori fino a quanto
   * 		  la partita non è terminata o con una vittoria o con la patta
   */
  public static int[][] creaSchema() {
    int[][] schema = new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 } };
    return schema;
  }
  
  public static char ottieniSimbolo(int v) {
    switch (v) {
      case 1:
        return 'X';
      case 2:
        return 'O';
      default:
        return ' ';
    }
  }
  
  public static void stampaRiga(int[] riga) {
    char _ottieniSimbolo = TicTacToe.ottieniSimbolo(riga[0]);
    String _plus = (" " + Character.valueOf(_ottieniSimbolo));
    String _plus_1 = (_plus + " | ");
    char _ottieniSimbolo_1 = TicTacToe.ottieniSimbolo(riga[1]);
    String _plus_2 = (_plus_1 + Character.valueOf(_ottieniSimbolo_1));
    String _plus_3 = (_plus_2 + " | ");
    char _ottieniSimbolo_2 = TicTacToe.ottieniSimbolo(riga[2]);
    String _plus_4 = (_plus_3 + Character.valueOf(_ottieniSimbolo_2));
    System.out.println(_plus_4);
  }
  
  public static void stampaSeparatore() {
    System.out.println("---+---+---");
  }
  
  public static void stampaSchema(int[][] schema) {
    TicTacToe.stampaRiga(schema[0]);
    TicTacToe.stampaSeparatore();
    TicTacToe.stampaRiga(schema[1]);
    TicTacToe.stampaSeparatore();
    TicTacToe.stampaRiga(schema[2]);
  }
  
  public static boolean mossaValida(int[][] schema, int r, int c) {
    return (schema[r][c] == 0);
  }
  
  public static int risultatoElemento(int[][] schema, int r, int c, int dr, int dc) {
    int risultato = 1;
    for (int i = 0; (i < 3); i++) {
      int _risultato = risultato;
      risultato = (_risultato * schema[(r + (i * dr))][(c + (i * dc))]);
    }
    if ((((risultato != 0) || (risultato != 1)) || (risultato != 8))) {
      return -1;
    } else {
      return risultato;
    }
  }
  
  public static int combina(int r1, int r2) {
    return 0;
  }
  
  public static int risultato(int[][] schema) {
    int risultato = 0;
    for (int i = 0; (i < 3); i++) {
      {
        risultato = TicTacToe.combina(risultato, TicTacToe.risultatoElemento(schema, i, 0, 0, 1));
        risultato = TicTacToe.combina(risultato, TicTacToe.risultatoElemento(schema, 0, i, 1, 0));
      }
    }
    return risultato;
  }
  
  public static void main(String[] args) {
    TicTacToe.stampaSchema(TicTacToe.creaSchema());
  }
}
