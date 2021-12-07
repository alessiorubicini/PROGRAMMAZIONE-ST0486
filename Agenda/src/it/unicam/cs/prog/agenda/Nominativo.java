package it.unicam.cs.prog.agenda;

public class Nominativo {
    private String nome, cognome, numero;
    private boolean bloccato;
    Nominativo(String nome, String cognome, String numero) {
        if (nome.length() > 0 && 
            cognome.length() > 0 && 
            numero.length() > 2) {
            this.nome = nome;
            this.cognome = cognome;
            this.numero = numero;
        }
    }  
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getNumero() { return numero; }
    public boolean getBloccato() { return bloccato; }
}