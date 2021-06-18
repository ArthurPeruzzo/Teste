package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.enums.BimestreEnum;
import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.*;
import br.inf.ids.educacao.models.DTOS.AlunoDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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





   /* public List<Bimestre> relacaoBimestreAluno(){
        return aluno.getBimestres();
    }*/

    /*public AlunoDTO teste() {
        String sql = "select aluno.matricula as matricula, sum(avaliacao.notaavaliacao * tipo_avaliacao.pesoavaliacao / 10)/4 as media_final
        from tb_aluno aluno
        inner join tb_alunobimestre aluno_bimestre
        on aluno.matricula = aluno_bimestre.aluno_id
        inner join tb_bimestre bimestre
        on aluno_bimestre.bimestre_id = bimestre.id
        inner join tb_avaliacao avaliacao
        on 	bimestre.id = avaliacao.bimestre_id
        and avaliacao.aluno_id = aluno.matricula
        inner join tb_tipoavaliacao tipo_avaliacao
        on avaliacao.tipoavaliacao_id = tipo_avaliacao.id
        where aluno.matricula = 22553434 --jose
        group by aluno.matricula";
        Query q = entityManager.createNativeQuery(sql, "mediaFinalAlunoDTO");
        return (AlunoDTO) q.getSingleResult();
    }*/


}
