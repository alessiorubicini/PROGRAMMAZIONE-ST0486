package javamm;

import javamm.util.Input;

@SuppressWarnings("all")
public class CorrectDate {
  public static int anno(int d) {
    return (d / 10000);
  }
  
  public static int mese(int d) {
    return ((d / 100) % 100);
  }
  
  public static int giorno(int d) {
    return (d % 100);
  }
  
  public static int giorniMese(int mm, boolean bisestile) {
    switch (mm) {
      case 11:
      case 4:
      case 6:
      case 9:
        return 30;
      case 2:
        if (bisestile) {
          return 29;
        } else {
          return 28;
        }
      default:
        return 31;
    }
  }
  
  public static boolean bisestile(int yyyy) {
    return (((yyyy % 4) == 0) && (((yyyy % 100) != 0) || ((yyyy % 100) == 0)));
  }
  
  public static boolean corretta(int d) {
    int yyyy = CorrectDate.anno(d);
    int mm = CorrectDate.mese(d);
    int dd = CorrectDate.giorno(d);
    if ((yyyy < 1900)) {
      return false;
    }
    if (((mm < 1) || (mm > 12))) {
      return false;
    }
    if (((dd < 1) || (dd > CorrectDate.giorniMese(mm, CorrectDate.bisestile(yyyy))))) {
      return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    int date = Input.getInt("Inserisci una data nel formato YYYYMMDD");
  }
}
