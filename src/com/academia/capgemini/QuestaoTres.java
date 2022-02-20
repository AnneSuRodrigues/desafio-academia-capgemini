package com.academia.capgemini;

import java.util.*;

public class QuestaoTres {
    /**
     * Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra podem ser realocadas
     * para formar a outra palavra. Dada uma string qualquer, desenvolva um algoritmo que encontre o número de pares
     * de substrings que são anagramas.
     * @Autor Anne Suellen
     * @param args
     */
    public static void main(String[] args) {

        Map<String,Integer> mapa = new HashMap<>();
        int contador = 0;
        List<String> conjuntos;
        if (args.length > 0) {
            for(int i = 0; i< args.length; i++){
                conjuntos = construirSubconjuntos(args[i]);
                buscarAgrupamentoEmAnagrama(mapa, contador, conjuntos);
            }
        } else {
            Scanner sc = new Scanner(System.in);
            String palavra = sc.nextLine();
            conjuntos = construirSubconjuntos(palavra);
            buscarAgrupamentoEmAnagrama(mapa, contador, conjuntos);
            sc.close();
        }
    }

    private static void buscarAgrupamentoEmAnagrama(Map<String, Integer> mapa, int contador, List<String> conjuntos) {
        for(String palavra2 : conjuntos){
            char[] temp = palavra2.toCharArray();
            Arrays.sort(temp);
            String palavraOrdenada = new String(temp);
            int count = mapa.containsKey(palavraOrdenada) ? mapa.get(palavraOrdenada) : 0;
            mapa.put(palavraOrdenada, count + 1);
            if(mapa.get(palavraOrdenada) > 1){
                contador++;
            }
        }
        System.out.println(contador);
    }

    private static List<String> construirSubconjuntos(String palavra) {
        List<String> substringDaPalavra = new ArrayList<>();
        for(int i = 0; i <= palavra.length(); i++){
            for(int j=0; j <= palavra.length() ; j++){
                if(j>i) {
                    substringDaPalavra.add(palavra.substring(i, j));
                }
            }
        }
        return substringDaPalavra;
    }
}
