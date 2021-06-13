package br.inf.ids.educacao.configuracao;

import br.inf.ids.educacao.models.Aluno;
import br.inf.ids.educacao.resources.AlunoResource;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

import javax.inject.Inject;

public class TesteConfig implements QuarkusApplication {
    @Inject
    AlunoResource alunoResource;
    @Override
    public int run(String... args) throws Exception {
        Aluno Pedro = new Aluno(99332737L, "Pedro", "pedro@gmail.com", "99257629");
        Aluno Maria = new Aluno(66887734L, "Maria", "maria@gmail.com", "98274531");
        Aluno Jose = new Aluno(22553434L, "Jose", "jose@gmail.com", "99453762");
        alunoResource.cadastrarAluno(Pedro);
        Quarkus.waitForExit();
        return 0;
    }
}
