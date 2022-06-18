package br.inatel.C207;

import java.util.Collections;

public class Jogador implements Comparable<Jogador>{

    public int idJogador;
    public int Partida_idPartida;
    private String nome;
    private double highScoreAll;
    private double highScoreContinente;
    private double highTemp;

    void jogar(boolean modo, Jogador jogador){
        Partida p = new Partida(modo,jogador);
        //Jogador.addRank(jogador);
        //Jogador.buscaPosicao(modo , jogador);

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

    public void setHighScoreAll(double pontos) {
        this.highScoreAll = pontos;
    }

    public double getHighScoreContinente() {
        return highScoreContinente;
    }

    public void setHighScoreContinente(double pontos) {
        this.highScoreContinente = pontos;
    }

    public static void ordenaRank(){
        Rank rank = new Rank();
//        for (Jogador jTemp:rank.getRankContinente()) {
//                jTemp.highTemp = jTemp.highScoreContinente;
//            }
//        Collections.sort(rank.getRankContinente());

        for (Jogador jTemp : rank.getRankContinente()) {
                jTemp.highTemp = jTemp.highScoreAll;
            }
        Collections.sort(rank.getRankAll());
    }

    public static void addRank(Jogador jogador){
        Rank rank = new Rank();
        rank.getRankAll().add(jogador);
       // rank.getRankContinente().add(jogador);
        Jogador.ordenaRank();
    }

    public static void buscaPosicao(boolean modo, Jogador jogador){
        Rank rank = new Rank();
        int pos;
        if (modo){
            pos  = rank.getRankContinente().indexOf(jogador);
            if(pos < 1) {
                for (int i = pos; i < pos + 3; i++) {
                    System.out.println((i + 1) + " - " + rank.getRankContinente().get(i).getNome() + "  " + rank.getRankContinente().get(i).getHighScoreContinente());
                }
            }else if (pos == rank.getRankContinente().size()){
                for (int i = pos-2; i < pos; i++) {
                    System.out.println((i+1) + " - "+rank.getRankContinente().get(i).getNome() +"  "+ rank.getRankContinente().get(i).getHighScoreContinente());
                }
            }else {
                for (int i = pos-2; i < pos+2; i++) {
                    System.out.println((i+1) + " - "+rank.getRankContinente().get(i).getNome() +"  "+ rank.getRankContinente().get(i).getHighScoreContinente());
                }
            }
        }else{
            pos  = rank.getRankAll().indexOf(jogador);
            if(pos < 1) {
                for (int i = pos; i < pos + 3; i++) {
                    System.out.println((i + 1) + " - " + rank.getRankAll().get(i).getNome() + "  " + rank.getRankAll().get(i).getHighScoreAll());
                }
            }else if (pos == rank.getRankAll().size()){
                for (int i = pos-2; i < pos; i++) {
                    System.out.println((i+1) + " - "+rank.getRankAll().get(i).getNome() +"  "+ rank.getRankAll().get(i).getHighScoreAll());
                }
            }else {
                for (int i = pos-2; i < pos+2; i++) {
                    System.out.println((i+1) + " - "+rank.getRankAll().get(i).getNome() +"  "+ rank.getRankAll().get(i).getHighScoreAll());
                }
            }
        }
    }

    @Override
    public int compareTo(Jogador o) {
        if (this.highTemp < o.highTemp)
            return 1;
        if (this.highTemp > o.highTemp)
            return -1;
        return 0;
    }
}
