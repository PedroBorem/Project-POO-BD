package br.inatel.C207;

import java.util.Collections;

public class Jogador implements Comparable<Jogador>{

    public int idJogador;
    public int Partida_idPartida;
    private String nome;
    private double highScoreAll;
    private double highScoreContinente;

    void jogar(Partida p){


    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getHighScoreAll() {
        return highScoreAll;
    }

    public void setHighScoreAll(double pontos, double time) {
        this.highScoreAll = pontos/0.1*time;
    }

    public double getHighScoreContinente() {
        return highScoreContinente;
    }

    public void setHighScoreContinente(double pontos, double time) {
        this.highScoreContinente = pontos/0.1*time;
    }

    public static void ordenaRank(){
        Rank rank = new Rank();
        Collections.sort(rank.getRankAll());
        Collections.sort(rank.getRankContinente());
    }

    @Override
    public int compareTo(Jogador o) {
        if (this.highScoreAll < o.highScoreAll)
            return 1;
        if (this.highScoreAll > o.highScoreAll)
            return -1;
        return 0;
    }
}
