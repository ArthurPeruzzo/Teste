package br.inf.ids.educacao.models;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AlunoTest {

    @Test
    public void testarTotalDeFaltas(){
        Aluno aluno = new Aluno();
        Assertions.assertNotEquals(40, aluno.TotalFaltas());

    }
}
