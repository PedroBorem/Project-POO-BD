package br.inatel.C207;

public class Palavra {
    String word;
    String[] nomepais;
    char[][] palavraView = new char[4][];

    public Palavra(){

    }

    public Palavra(String word, String [] nomepais) {
        this.word = word;
        this.nomepais = nomepais;
    }


}
