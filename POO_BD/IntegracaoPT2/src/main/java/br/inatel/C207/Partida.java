package br.inatel.C207;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Partida {

    public int idPartida;
    public int Continente_idContinente;
    private boolean modo;
    private double pontos = 100000;
    private double time = 0; //tempo
    private double []dist = new double[4];
    private String []nome = new String[4];
    private ArrayList<ArrayList<String>> tem = new ArrayList<>(); // Posicão k - tabela com a letras que tem da palavra k
    private ArrayList<String> nTem = new ArrayList<>();
    private boolean[] visit = new boolean[4];
    private double in, f; //tempo inicial e tempo final
    private Palavra palavra = new Palavra();
    DecimalFormat formatador = new DecimalFormat("0.00");
    
    public Partida(boolean modo, Jogador jogador) {
        this.modo = modo;
        ContinenteBD continenteBD = new ContinenteBD();
        int aux = config();
        if(isModo())System.out.println("Partida Paises da "+ continenteBD.getContinenteNome(aux) + " - criada");
        else System.out.println("PARTIDA MUNDO");

        in = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        while(visit[0]||visit[1]||visit[2]||visit[3]){
            System.out.println(" ");
            System.out.print("País 1: " + Arrays.toString(this.palavra.palavraView[0]) + "    <- "+formatador.format(dist[0])+"km ->   ");
            System.out.println("País 2: " + Arrays.toString(this.palavra.palavraView[1]));
            System.out.println("         ^                                                                                  ^     ");
            System.out.println("      "+formatador.format(dist[3])+"km                                                                     "+formatador.format(dist[1])+"km   ");
            System.out.println("         v                                                                                  v     ");
            System.out.print("País 3: " + Arrays.toString(this.palavra.palavraView[3]) + "    <- "+formatador.format(dist[2])+"km ->   ");
            System.out.println("País 4: " + Arrays.toString(this.palavra.palavraView[2]));
            System.out.print("Digite: ");
            palavra.word = sc.nextLine();
            verificaLetras();
            System.out.println(" ");
            System.out.println(" ");

            //MOSTRAR TABELA TEM E NTEM
           // for (int i = 0; i < 4; i++) {
                //System.out.println(tem.get(i));
            //}

        }
        System.out.println("TODAS CERTAS");
        f = System.currentTimeMillis();
        //MOSTRAR PONTUAÇÃO
        this.time = (f - in)/1000;
        this.pontos /= (this.time * 0.1);
        System.out.println("Tempo: " + this.time + " s");
        System.out.println("Pontuação: " + formatador.format(this.pontos));
        if(modo)jogador.setHighScoreContinente(this.pontos);
        else jogador.setHighScoreAll(this.pontos);

    }

    public int config() {
        Paises[] p = new Paises[5];
        int aux = 0;
        if (this.modo) {
            PartidaBD partidaBD = new PartidaBD();
            aux = partidaBD.getidContinente();
            for (int i = 0; i < 4; i++) {
                visit[i] = true;
                p = partidaBD.getPaises(aux);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                visit[i] = true;


            }
            PartidaBD partidaBD = new PartidaBD();
            p = partidaBD.getPaises();
        }
        p[4] = p[0];
        calcDist(p);
        setNomes(p);
        return aux;
    }
    
    void setNomes(Paises[] paises){
        for (int i = 0; i < 4; i++) {
            this.palavra.nomepais[i] = paises[i].getNome();
            this.palavra.palavraView[i] = new char[paises[i].getNome().length()];
            for (int j = 0; j < this.palavra.palavraView[i].length; j++) {
                Palavra.fill(this.palavra.palavraView[i],'_');
            }
        }
    }

    void verificaLetras(){
        String tudo = this.palavra.nomepais[0]+this.palavra.nomepais[1]+this.palavra.nomepais[2]+this.palavra.nomepais[3];//mandar pra config()
        int c = 0;
        for (int i = 0; i < 4; i++) {
            c = 0;
            for (int j = 0; j < this.palavra.nomepais[i].length(); j++) {
                for (int k = 0; k < this.palavra.word.length(); k++) {
                    if (this.palavra.nomepais[i].charAt(j) == this.palavra.word.charAt(k)) {
                        if (j == k) {
                            c++;
                            this.palavra.palavraView[i][k] = this.palavra.word.charAt(k);//fixa posição palavra i
                            //tem.get(i).remove(String.valueOf(this.palavra.word.charAt(k)));
                            if(c == this.palavra.nomepais[i].length()){
                                this.visit[i] = false;
                            }
                        } else {
                            //tem.get(i).add(String.valueOf(this.palavra.word.charAt(k)));//tabela tem
                        }
                    }
                }
            }
        }
        for (int j = 0; j <this.palavra.word.length(); j++) {
            int aux = 0;
            for (int k = 0; k < tudo.length(); k++) {
                if (tudo.charAt(k) == this.palavra.word.charAt(j)) {
                    aux++;
                }
            }
            if (aux == 0){
                nTem.add(String.valueOf(this.palavra.word.charAt(j)));
            }
        }
    }

    void calcDist(Paises[] paises){

        double[] deltaLongitude = new double[4];
        for (int i = 0; i < 4; i++) {
            deltaLongitude[i] = paises[i].getLongitude() - paises[i+1].getLongitude();
        }
        for (int i = 0; i < 4; i++) {
            double EARTH_RADIUS_KM = 6371.0;
            this.dist[i] = Math.acos(Math.cos(paises[i].getLatitude()) * Math.cos(paises[i+1].getLatitude())
                    * Math.cos(deltaLongitude[i]) + Math.sin(paises[i].getLatitude())
                    * Math.sin(paises[i+1].getLatitude()))
                    * EARTH_RADIUS_KM;
        }
    }

    public boolean isModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }
    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
