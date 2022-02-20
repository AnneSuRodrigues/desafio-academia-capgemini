package com.academia.capgemini;

import java.util.Scanner;

public class QuestaoUm {
    /**
     * Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços.
     * A base e altura da escada devem ser iguais ao valor de n. A última linha não deve conter nenhum espaço.
     * @Autor Anne Suellen
     * @param args
     */
    public static void main(String... args){
        if (args.length > 0) {
            for(int i = 0; i< args.length; i++){
                preencherEscada(Integer.parseInt(args[i]));
            }
        } else {
            Scanner sc = new Scanner(System.in);
            int numeroLinhas = sc.nextInt();
            preencherEscada(numeroLinhas);
            if(sc!=null) sc.close();
        }

    }

    private static void preencherEscada(int numeroLinhas) {
        int numeroColunas = numeroLinhas;
        for(int linha = 1; linha <= numeroLinhas; linha++) {
            StringBuilder strb = new StringBuilder();
            int qtdEspacosEmBranco = numeroLinhas - linha;
            for(int coluna = 1; coluna <= numeroColunas; coluna++){
                if(coluna <= qtdEspacosEmBranco) {
                    strb.append(" ");
                }else{
                    strb.append("*");
                }
            }
            System.out.println(strb);
        }
    }
}
