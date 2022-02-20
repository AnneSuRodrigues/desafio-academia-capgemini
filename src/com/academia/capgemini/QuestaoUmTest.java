package com.academia.capgemini;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class QuestaoUmTest {
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
    public void deveRetornarUmaEscadaDeUmDegrausQuandoAEntradaForUmTest(){
        QuestaoUm.main(new String[]{"1"});
        Assertions.assertEquals("*",outputStreamCaptor.toString().replace("\r\n",""));
    }

    @Test
    public void deveRetornarUmaEscadaDeTresDegrausQuandoAEntradaForTresTest(){
        QuestaoUm.main(new String[]{"3"});
        String[] linhas = outputStreamCaptor.toString().split("\r\n");

        Assertions.assertEquals("  *",linhas[0]);
        Assertions.assertEquals(" **",linhas[1]);
        Assertions.assertEquals("***",linhas[2]);
    }

    @Test
    public void deveRetornarUmaEscadaDeSeisDegrausQuandoAEntradaForSeisTest(){
        QuestaoUm.main(new String[]{"6"});
        String[] linhas = outputStreamCaptor.toString().split("\r\n");

        Assertions.assertEquals("     *",linhas[0]);
        Assertions.assertEquals("    **",linhas[1]);
        Assertions.assertEquals("   ***",linhas[2]);
        Assertions.assertEquals("  ****",linhas[3]);
        Assertions.assertEquals(" *****",linhas[4]);
        Assertions.assertEquals("******",linhas[5]);
    }


}