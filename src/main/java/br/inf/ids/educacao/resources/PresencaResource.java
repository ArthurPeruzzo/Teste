package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.Presenca;
import br.inf.ids.educacao.models.TipoAvaliacao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class PresencaResource {

    @Inject
    EntityManager entityManager;

    public Presenca cadastrarPresenca(Presenca presenca){
        entityManager.persist(presenca);
        entityManager.flush();
        return presenca;
    }

    public Presenca buscarPresenca(Long id) {
        Presenca presenca;
        try{
        presenca= entityManager.find(Presenca.class, id);
        }catch (RuntimeException e) {
            throw new Exceptions(id);
        }
        return presenca;
    }

    public void updatePresenca(Presenca presenca) {
        entityManager.merge(presenca);
        entityManager.flush();
    }

    public void deletePresenca(Long id) {
        try{
            Presenca presenca = buscarPresenca(id);
            entityManager.remove(presenca);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Exceptions(id);
        }

    }
}
