package javamm;

@SuppressWarnings("all")
public class Caratteri {
  /**
   * Conta caratteri
   * Lezione 16/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   */
  public static void conta(String stringa, int[] risultati) {
    for (int i = 0; (i < stringa.length()); i++) {
      char _charAt = stringa.charAt(i);
      switch (_charAt) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          risultati[0]++;
          break;
        case ',':
        case ';':
        case ':':
        case '!':
        case '?':
          risultati[2]++;
          break;
        case ' ':
          risultati[3]++;
          break;
        default:
          risultati[1]++;
      }
    }
  }
  
  public static void main(String[] args) {
    String dante = "Nel mezzo del cammin di nostra vita\n\nmi ritrovai per una selva oscura,\n\nch\u00E9 la diritta via era smarrita.\n\n\nAhi quanto a dir qual era \u00E8 cosa dura\n\t\nesta selva selvaggia e aspra e forte\n\t\t\t\nche nel pensier rinova la paura!";
    int[] risultati = { 0, 0, 0, 0 };
    Caratteri.conta(dante, risultati);
    String _plus = ("vocali: " + Integer.valueOf(risultati[0]));
    String _plus_1 = (_plus + " consonanti: ");
    String _plus_2 = (_plus_1 + Integer.valueOf(risultati[1]));
    String _plus_3 = (_plus_2 + " punteggiatura: ");
    String _plus_4 = (_plus_3 + Integer.valueOf(risultati[2]));
    String _plus_5 = (_plus_4 + " spazi: ");
    String _plus_6 = (_plus_5 + Integer.valueOf(risultati[3]));
    System.out.println(_plus_6);
  }
}
