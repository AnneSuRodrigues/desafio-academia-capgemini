package com.academia.capgemini;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class QuestaoDoisTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    public void deveRetornarTresQuandoQuandoAPalavraForYa3Test(){
        QuestaoDois.main(new String[]{"Ya3"});
        Assertions.assertEquals("3",outputStreamCaptor.toString().replace("\r\n",""));
    }
    @Test
    public void deveRetornarCincoQuandoQuandoAPalavraForYaTest(){
        QuestaoDois.main(new String[]{"Y"});
        Assertions.assertEquals("5",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarSeisQuandoQuandoAPalavraForVaziaTest(){
        QuestaoDois.main(new String[]{""});
        Assertions.assertEquals("6",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarUmQuandoAPalavraForNaoTiverCaracterEspecialTest(){
        QuestaoDois.main(new String[]{"Yia1aad"});
        Assertions.assertEquals("1",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarUmQuandoNaoTiverLetraMaiusculaTest(){
        QuestaoDois.main(new String[]{"bia1aa$"});
        Assertions.assertEquals("1",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarUmQuandoNaoTiverLetraMinusculaTest(){
        QuestaoDois.main(new String[]{"BIA1AA$"});
        Assertions.assertEquals("1",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarZeroQuandoTiverCaracteresEspeciaisTest(){
        String[] args = new String[]{"Yia1aad!", "Yia1aad@", "Yia1aad#", "Yia1aad$",
                "Yia1aad%","Yia1aad^","Yia1aad&","Yia1aad*","Yia1aad(","Yia1aad)",
                "Yia1aad-","Yia1aad+"};
        QuestaoDois.main(args);
        String[] linhas = outputStreamCaptor.toString().split("\r\n");
        for(int i=0; i < args.length; i++){
            Assertions.assertEquals("0",linhas[i]);
        }
    }


}