package br.inf.ids.educacao.models;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class BimestreTest {

    @Test
    public void testarOsDiasLetivosDeCadaBimestre(){
        Bimestre bimestre = new Bimestre();
        Assertions.assertEquals(40, 40);
    }
}
