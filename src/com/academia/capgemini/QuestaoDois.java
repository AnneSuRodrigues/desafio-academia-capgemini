package com.academia.capgemini;

import java.util.Scanner;

public class QuestaoDois {
    /**
     * Débora se inscreveu em uma rede social para se manter em contato com seus amigos.
     * A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte.
     * O site considera uma senha forte quando ela satisfaz os seguintes critérios:
     * @Autor Anne Suellen
     * @param args
     */
    public static void main(String... args){
        if (args.length > 0) {
            for(int i = 0; i< args.length; i++){
                System.out.println(avaliarSenha(args[i]));
            }
        } else {
            Scanner sc = new Scanner(System.in);
            String senha = sc.nextLine();
            System.out.println(avaliarSenha(senha));
            sc.close();
        }

    }

    private static int avaliarSenha(String senha) {
        int contador = 4;
        if(!senhaComConteudo(senha))
            return 6;

        if(temLetraMaiuscula(senha)) contador-- ;
        if(temLetraMinuscula(senha)) contador--;
        if(temCaracterEspecial(senha)) contador--;
        if(temDigito(senha)) contador--;

        //if(senha.length() + contador > 6) return 6;
        if(senha.length() < 6) return (6 - senha.length());

        return contador;
    }
    private static boolean senhaComConteudo(String senha){
        Boolean senhaValida = Boolean.TRUE;
        if(senha != null){
            senha = senha.trim();
            if(senha.isBlank()){
                senhaValida = Boolean.FALSE;
            }
        } else {
            senhaValida = Boolean.FALSE;
        }
        return senhaValida;
    }
    private static boolean temLetraMaiuscula(String senha){
        char[]caracteres = senha.toCharArray();
        boolean flagMaiusculo = Boolean.FALSE;
        for (char caractere : caracteres) {
            if (Character.isUpperCase(caractere)) {
                flagMaiusculo = Boolean.TRUE;
            }
        }
        return flagMaiusculo;
    }
    private static boolean temLetraMinuscula(String senha){
        char[]caracteres = senha.toCharArray();
        boolean flagMinusculo = Boolean.FALSE;
        for (char caractere : caracteres) {
            if (Character.isLowerCase(caractere)) {
                flagMinusculo = Boolean.TRUE;
            }
        }
        return flagMinusculo;
    }

    private static boolean temDigito(String senha){
        char[]caracteres = senha.toCharArray();
        boolean flagMinusculo = Boolean.FALSE;
        for (char caractere : caracteres) {
            if (Character.isDigit(caractere)) {
                flagMinusculo = Boolean.TRUE;
            }
        }
        return flagMinusculo;
    }

    private static boolean temCaracterEspecial(String senha){
        String caracteresEspeciais = "!@#$%^&*()-+";
        char[] caracterEspecial = caracteresEspeciais.toCharArray();
        for (char c : caracterEspecial) {
            if (senha.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
