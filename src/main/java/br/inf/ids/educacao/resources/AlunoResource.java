package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.Aluno;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class AlunoResource {

    @Inject
    EntityManager entityManager;

    Aluno aluno;
    public Aluno cadastrarAluno(Aluno aluno){
        entityManager.persist(aluno);
        entityManager.flush();
        return aluno;
    }

    public Aluno buscar(Long id) {
        Aluno aluno;
        try {
            aluno = entityManager.find(Aluno.class, id);
        }catch (RuntimeException e) {
            throw new Exceptions(id);
        }
        return aluno;
    }

    public void update(Aluno aluno) {
        entityManager.merge(aluno);
        entityManager.flush();
    }

    public void delete(Long id) {
        try{
            Aluno aluno = buscar(id);
            entityManager.remove(aluno);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Exceptions(id);
        }
    }
    public List<Aluno> buscarTodosOsAlunos(){
        String queryJPQL = "SELECT s FROM Aluno s";
        return entityManager.createQuery(queryJPQL, Aluno.class)
                .setMaxResults(3)
                .getResultList();
    }


    public List<Aluno> pesquisarAlunos(String caractere){
        String queryJPQL = "SELECT s FROM Aluno s WHERE UPPER(s.nome) LIKE :caractere";
        return entityManager.createQuery(queryJPQL, Aluno.class)
                .setMaxResults(3)
                .setParameter("caractere", "%" + caractere.toUpperCase() + "%")
                .getResultList();
    }


}
