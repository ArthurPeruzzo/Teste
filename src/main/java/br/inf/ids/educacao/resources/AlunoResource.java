package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.models.Aluno;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class AlunoResource {

    @Inject
    EntityManager entityManager;

    public Aluno cadastrarAluno(Aluno aluno){
        entityManager.persist(aluno);
        entityManager.flush();
        return aluno;
    }
}
