package javamm;

@SuppressWarnings("all")
public class Data {
  /**
   * Manipolazione di date in formato numerico
   * 14/10/2021
   * Esercizio iniziato da Michele Loreti e continuato da Alessio Rubicini
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
  
  public static int data(int anno, int mese, int giorno) {
    return (((anno * 10000) + (mese * 100)) + giorno);
  }
  
  public static int aggiungiGiorni(int data, int n) {
    int giorni = Data.giorno(data);
    int mese = Data.mese(data);
    int anno = Data.anno(data);
    int i = 0;
    while ((i != n)) {
      {
        giorni++;
        int _giorniMese = Data.giorniMese(Data.mese(data), Data.bisestile(Data.anno(data)));
        boolean _greaterThan = (giorni > _giorniMese);
        if (_greaterThan) {
          giorni = 1;
          mese++;
        }
        if ((mese > 12)) {
          mese = 1;
          anno++;
        }
        i++;
      }
    }
    return Data.data(anno, mese, giorni);
  }
  
  public static int sottraiGiorni(int data, int n) {
    int giorni = Data.giorno(data);
    int mese = Data.mese(data);
    int anno = Data.anno(data);
    int i = 0;
    while ((i != n)) {
      {
        giorni--;
        if ((giorni < 0)) {
          mese--;
          giorni = Data.giorniMese(mese, Data.bisestile(anno));
        }
        if ((mese < 1)) {
          mese = 12;
          anno--;
        }
        i++;
      }
    }
    return Data.data(anno, mese, giorni);
  }
  
  public static int dataMaggiore(int d1, int d2) {
    int _anno = Data.anno(d1);
    int _anno_1 = Data.anno(d2);
    boolean _greaterThan = (_anno > _anno_1);
    if (_greaterThan) {
      return d1;
    } else {
      if (((Data.anno(d1) == Data.anno(d2)) && (Data.mese(d1) > Data.mese(d2)))) {
        return d1;
      } else {
        if ((((Data.anno(d1) == Data.anno(d2)) && (Data.mese(d1) == Data.mese(d2))) && (Data.giorno(d1) > Data.giorno(d2)))) {
          return d1;
        } else {
          return d2;
        }
      }
    }
  }
  
  public static int differenzaGiorni(int d1, int d2) {
    int i = 0;
    int data = Data.dataMaggiore(d1, d2);
    int giorno = Data.giorno(data);
    int mese = Data.mese(data);
    int anno = Data.anno(data);
    int _data = Data.data(anno, mese, giorno);
    int _xjconditionalexpression = (int) 0;
    if ((data == d1)) {
      _xjconditionalexpression = d2;
    } else {
      _xjconditionalexpression = d1;
    }
    boolean _tripleNotEquals = (_data != _xjconditionalexpression);
    boolean _while = _tripleNotEquals;
    while (_while) {
      {
        giorno--;
        if ((giorno < 0)) {
          giorno = Data.giorniMese(data, Data.bisestile(anno));
          mese--;
        }
        if ((mese < 0)) {
          mese = 12;
          anno--;
        }
        i++;
      }
      int _data_1 = Data.data(anno, mese, giorno);
      int _xjconditionalexpression_1 = (int) 0;
      if ((data == d1)) {
        _xjconditionalexpression_1 = d2;
      } else {
        _xjconditionalexpression_1 = d1;
      }
      boolean _tripleNotEquals_1 = (_data_1 != _xjconditionalexpression_1);
      _while = _tripleNotEquals_1;
    }
    return i;
  }
  
  public static void main(String[] args) {
    System.out.println(Data.differenzaGiorni(20211101, 20211022));
    System.out.println(Data.differenzaGiorni(20211022, 20211101));
  }
}
