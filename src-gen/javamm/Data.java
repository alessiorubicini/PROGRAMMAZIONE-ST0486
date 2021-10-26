package javamm;

@SuppressWarnings("all")
public class Data {
  /**
   * Manipolazione di date in formato numerico
   * 14/10/2021
   * ST0486 Programmazione 2021/22
   * Università degli Studi di Camerino - Informatica/Informatica per la comunicazione digitale
   * 
   * Fare riferimento al documento 'Esercizi Programmazione' caricato dal Prof. Loreti su Google drive
   */
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
    return (((yyyy % 4) == 0) && (((yyyy % 100) != 0) || ((yyyy % 400) == 0)));
  }
  
  public static boolean corretta(int d) {
    int yyyy = Data.anno(d);
    int mm = Data.mese(d);
    int dd = Data.giorno(d);
    if ((yyyy < 1900)) {
      return false;
    }
    if (((mm < 1) || (mm > 12))) {
      return false;
    }
    if (((dd < 1) || (dd > Data.giorniMese(mm, Data.bisestile(yyyy))))) {
      return false;
    }
    return true;
  }
  
  /**
   * --------------------------------------------------------------------------------
   */
  public static int data(int anno, int mese, int giorno) {
    return (((anno * 10000) + (mese * 100)) + giorno);
  }
  
  public static int sommaSottraiGiorni(int data, int n) {
    int giorni = Data.giorno(data);
    int mese = Data.mese(data);
    int anno = Data.anno(data);
    int i = 0;
    boolean _xjconditionalexpression = false;
    if ((n < 0)) {
      int _minus = (-n);
      _xjconditionalexpression = (i != _minus);
    } else {
      _xjconditionalexpression = (i != n);
    }
    boolean _while = _xjconditionalexpression;
    while (_while) {
      {
        if ((n < 0)) {
          giorni--;
        } else {
          giorni++;
        }
        boolean _xjconditionalexpression_1 = false;
        if ((n < 0)) {
          _xjconditionalexpression_1 = (giorni <= 0);
        } else {
          int _giorniMese = Data.giorniMese(Data.mese(data), Data.bisestile(Data.anno(data)));
          _xjconditionalexpression_1 = (giorni > _giorniMese);
        }
        if (_xjconditionalexpression_1) {
          if ((n < 0)) {
            mese--;
          } else {
            mese++;
          }
          if ((n < 0)) {
            giorni = Data.giorniMese(mese, Data.bisestile(anno));
          } else {
            giorni = 1;
          }
        }
        boolean _xjconditionalexpression_2 = false;
        if ((n < 0)) {
          _xjconditionalexpression_2 = (mese < 0);
        } else {
          _xjconditionalexpression_2 = (mese > 12);
        }
        if (_xjconditionalexpression_2) {
          if ((n < 0)) {
            mese = 12;
          } else {
            mese = 1;
          }
          if ((n < 0)) {
            anno--;
          } else {
            anno++;
          }
        }
        i++;
      }
      boolean _xjconditionalexpression_1 = false;
      if ((n < 0)) {
        int _minus_1 = (-n);
        _xjconditionalexpression_1 = (i != _minus_1);
      } else {
        _xjconditionalexpression_1 = (i != n);
      }
      _while = _xjconditionalexpression_1;
    }
    return Data.data(anno, mese, giorni);
  }
  
  public static int dataMaggiore(int d1, int d2) {
    if ((d1 == d2)) {
      return 0;
    } else {
      if ((((Data.anno(d1) > Data.anno(d2)) || ((Data.anno(d1) == Data.anno(d2)) && (Data.mese(d1) > Data.mese(d2)))) || (((Data.anno(d1) == Data.anno(d2)) && (Data.mese(d1) == Data.mese(d2))) && (Data.giorno(d1) > Data.giorno(d2))))) {
        return d1;
      } else {
        return d2;
      }
    }
  }
  
  public static int differenzaInGiorni(int d1, int d2) {
    int data = Data.dataMaggiore(d1, d2);
    if ((data == 0)) {
      return 0;
    }
    int dataSottratta = data;
    int i = 0;
    int _xjconditionalexpression = (int) 0;
    if ((data == d1)) {
      _xjconditionalexpression = d2;
    } else {
      _xjconditionalexpression = d1;
    }
    boolean _tripleNotEquals = (dataSottratta != _xjconditionalexpression);
    boolean _while = _tripleNotEquals;
    while (_while) {
      {
        dataSottratta = Data.sommaSottraiGiorni(dataSottratta, -1);
        i++;
      }
      int _xjconditionalexpression_1 = (int) 0;
      if ((data == d1)) {
        _xjconditionalexpression_1 = d2;
      } else {
        _xjconditionalexpression_1 = d1;
      }
      boolean _tripleNotEquals_1 = (dataSottratta != _xjconditionalexpression_1);
      _while = _tripleNotEquals_1;
    }
    return i;
  }
  
  public static void main(String[] args) {
    int _differenzaInGiorni = Data.differenzaInGiorni(20211025, 20211102);
    String _plus = ("Giorni di differenza tra il 25/10/2021 e il 02/11/2021 = " + Integer.valueOf(_differenzaInGiorni));
    System.out.println(_plus);
    int _differenzaInGiorni_1 = Data.differenzaInGiorni(20211025, 20211025);
    String _plus_1 = ("Giorni di differenza tra il 25/10/2021 e il 25/10/2021 = " + Integer.valueOf(_differenzaInGiorni_1));
    System.out.println(_plus_1);
  }
}
