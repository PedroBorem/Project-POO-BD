package br.inatel.C207;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){
        System.out.println("inicio main");
        ArrayList<Paises> paisesArrayList = Arquivo.lerPais();
        PaisesBD paisesBD = new PaisesBD();
        for (Paises pais:paisesArrayList) {
            if(pais != null){
                if(paisesBD.insertPais(pais))
                    System.out.println("Pais add");
                else System.out.println("erro");
            }
        }

        System.out.println("final main");
    }
}
