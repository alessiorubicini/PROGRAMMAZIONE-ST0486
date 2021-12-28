package it.unicam.cs.prog.pari;
import javax.swing.JOptionPane;

public class Calcolatrice {
   public static void main(String [] args) {
     String primaStringa = JOptionPane.showInputDialog("Primo numero pari"); 
     String secondaStringa = JOptionPane.showInputDialog("Secondo numero pari"); 
     int primoIntero = 0, secondoIntero = 0;
     try {
        primoIntero = Integer.parseInt(primaStringa);
        secondoIntero = Integer.parseInt(secondaStringa);
     } catch (NumberFormatException e) { 
       JOptionPane.showMessageDialog(null,"Non sono numeri","Errore",JOptionPane.PLAIN_MESSAGE); 
       return;
     }
     try {
       Pari primo = new Pari(primoIntero); // int primo = primoIntero;
       Pari secondo = new Pari(secondoIntero); // int secondo = secondoIntero;
       Pari terzo = new Pari(); // int terzo;
       
       Pari somma = primo.somma(secondo); // int somma = primo + secondo
       Pari divisione = primo.divisione(secondo); // int divisione = primo / secondo
       JOptionPane.showMessageDialog(null,somma,"Somma",JOptionPane.PLAIN_MESSAGE); 
       JOptionPane.showMessageDialog(null,divisione,"Divisione",JOptionPane.PLAIN_MESSAGE);
     } catch(NumeroNonPari e) 
     { JOptionPane.showMessageDialog(null,"Non sono numeri pari","Errore",JOptionPane.PLAIN_MESSAGE); 
       return;
     }
       catch(DivisionePerZero e) { 
       JOptionPane.showMessageDialog(null,"Dividione per zero","Errore",JOptionPane.PLAIN_MESSAGE); 
       return;
     }
   
   }
}