package com.academia.capgemini;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class QuestaoTresTest {
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
    public void deveRetornarDoisQuandoQuandoAPalavraForOvoTest(){
        QuestaoTres.main(new String[]{"ovo"});
        Assertions.assertEquals("2",outputStreamCaptor.toString().replace("\r\n",""));
    }
    @Test
    public void deveRetornarTresQuandoQuandoAPalavraForOvoTest(){
        QuestaoTres.main(new String[]{"ifailuhkqq"});
        Assertions.assertEquals("3",outputStreamCaptor.toString().replace("\r\n",""));
    }

}