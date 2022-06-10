package br.inatel.C207;

import java.util.ArrayList;

public class Rank{

    public int idRank;
    private String nome;

    private ArrayList<Jogador> rankAll = new ArrayList<>();
    private ArrayList<Jogador> rankContinente = new ArrayList<>();

    public Rank(String nome) {
        this.nome = nome;
    }

    public Rank(){

    }

    public void mostraRank (boolean modo){
        Jogador.ordenaRank();
        if(modo) {
            for(int i = 0; i < this.rankContinente.size(); i++) {
                System.out.println("------------------------------");
                System.out.println("-----RANK-MODO CONTINENTE-----");
                System.out.println(i+"o " + this.rankContinente.get(i).getNome()+" "+this.rankContinente.get(i).getHighScoreContinente());
            }
            System.out.println("------------------------------------");
        }else {
            for(int i = 0; i < this.rankContinente.size(); i++) {
                System.out.println("------------------------------");
                System.out.println("--------RANK-MODO GLOBAL------");
                System.out.println(i+"o " + this.rankAll.get(i).getNome()+" "+this.rankAll.get(i).getHighScoreAll());
            }
            System.out.println("------------------------------------");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Jogador> getRankAll() {
        return rankAll;
    }

    public void setRankAll(ArrayList<Jogador> rankAll) {
        this.rankAll = rankAll;
    }

    public ArrayList<Jogador> getRankContinente() {
        return rankContinente;
    }

    public void setRankContinente(ArrayList<Jogador> rankContinente) {
        this.rankContinente = rankContinente;
    }
}
