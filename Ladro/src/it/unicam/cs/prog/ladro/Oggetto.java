package it.unicam.cs.prog.ladro;

public class Oggetto {
    private String nome;
    private double peso;   // espresso in kg
    private double volume; // espresso in litri (1000cc)
    
    Oggetto(String n, double p, double v) {
       if (p > 0 && v > 0) {
         nome = n; peso = p; volume = v;
       }
    }
    
    Oggetto(double p, double v) {
       if (p > 0 && v > 0) {
         nome = "sconosciuto"; peso = p; volume = v;
       }
    }
    
    public String getNome()   { return nome; }
    public double getPeso()   { return peso; }
    public double getVolume() { return volume; }
}
