package br.inatel.C207;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner sc  = new Scanner(System.in);
        boolean flag = true;
        int op;

        while(flag){
            System.out.println("                MUNDÉCO              ");
            System.out.println("Menu");
            System.out.println(" Nova Partida - 1");
            System.out.println(" Sair - 2");
            op = sc.nextInt();
            switch (op){
                case 1:
                    System.out.println();
                    sc.nextLine();
                    System.out.println("Digite o nome do Novo Jogador: ");
                    String nome = sc.nextLine();
                    Jogador jogador = new Jogador(nome);
                    System.out.println("Selecione o modo: All / Continente");
                    if (sc.nextLine().equalsIgnoreCase("All")){
                        System.out.println(" ");
                        jogador.jogar(false,jogador);
                    }else {
                        System.out.println("Modo em Manutenção");
                        //jogador.jogar(true,jogador);
                    }
                    break;
                case 2:
                    System.out.println("Você Saiu!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }

        Jogador jogador = new Jogador("Pedro");
        jogador.jogar(false,jogador);
    }
}
