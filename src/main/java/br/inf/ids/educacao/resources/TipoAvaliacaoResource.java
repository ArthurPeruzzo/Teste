package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.TipoAvaliacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class TipoAvaliacaoResource {

    @Inject
    EntityManager entityManager;

    public TipoAvaliacao cadastrarTipoAvaliacao(TipoAvaliacao tipoAvaliacao){
        entityManager.persist(tipoAvaliacao);
        entityManager.flush();
        return tipoAvaliacao;
    }

    public TipoAvaliacao buscarTipoAvaliacao(Long id) {
        TipoAvaliacao tipoAvaliacao;
        try{
        tipoAvaliacao= entityManager.find(TipoAvaliacao.class, id);
        }catch (RuntimeException e) {
            throw new Exceptions(id);
        }
        return tipoAvaliacao;
    }

    public void updateTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        entityManager.merge(tipoAvaliacao);
        entityManager.flush();
    }

    public void deleteTipoAvaliacao(Long id) {
        try{
           TipoAvaliacao tipoAvaliacao = buscarTipoAvaliacao(id);
            entityManager.remove(tipoAvaliacao);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Exceptions(id);
        }

    }
}
