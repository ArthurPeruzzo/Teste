package br.inf.ids.educacao.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class BimestreTest {

    @Inject
    BimestreResource bimestreResource;
    @Test
    public void testarOsDiasLetivosDeTodosOsBimestre(){

        long diasLetivos = bimestreResource.totalDeDiasLetivos();
        Assertions.assertEquals(160,diasLetivos);

    }

    @Test
    public void testarAQuantidadeDeBimestres(){
        long id =1;
        Long totalDeBimestres = bimestreResource.contarBimestres();
        Assertions.assertEquals(4, totalDeBimestres);

    }

    @Test
    public void testarOsDiasLetivosDeUmBimestre(){
        Long totalDeBimestres = bimestreResource.contarBimestres();
        for(long i=1; i<=totalDeBimestres; i++){
            Assertions.assertEquals(40, bimestreResource.diasLetivosBimestre(i));
        }


    }
}
