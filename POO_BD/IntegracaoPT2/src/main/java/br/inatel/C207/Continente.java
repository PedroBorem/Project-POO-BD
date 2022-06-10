package br.inatel.C207;

public class Continente {

    public int idContinente;
    private String nome;

    public Continente(String nome) {
        this.nome = nome;
    }

    public Continente(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
