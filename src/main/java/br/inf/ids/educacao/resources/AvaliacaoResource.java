package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.Avaliacao;
import br.inf.ids.educacao.models.TipoAvaliacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class AvaliacaoResource {

    @Inject
    EntityManager entityManager;

    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao){
        entityManager.persist(avaliacao);
        entityManager.flush();
        return avaliacao;
    }

    public Avaliacao buscarAvaliacao(Long id) {
        Avaliacao avaliacao;
        try{
        avaliacao= entityManager.find(Avaliacao.class, id);
        }catch (RuntimeException e) {
            throw new Exceptions(id);
        }
        return avaliacao;
    }

    public void updateAvaliacao(Avaliacao avaliacao) {
        entityManager.merge(avaliacao);
        entityManager.flush();
    }

    public void deleteAvaliacao(Long id) {
        try{
           Avaliacao avaliacao = buscarAvaliacao(id);
            entityManager.remove(avaliacao);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Exceptions(id);
        }

    }
    public List<Avaliacao> listarAvaliacaoPorAvaliacao(){
        String queryJPQL = "SELECT s FROM Avaliacao s ORDER BY notaAvaliacao DESC";
        return entityManager.createQuery(queryJPQL, Avaliacao.class)
                .setMaxResults(20)
                .getResultList();
    }


}
