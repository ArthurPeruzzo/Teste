package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecoes.Exceptions;
import br.inf.ids.educacao.models.Bimestre;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RequestScoped
public class BimestreResource {

    @Inject
    EntityManager entityManager;

    Bimestre bimestre;

    public Bimestre cadastrarBimestre(Bimestre bimestre){
        entityManager.persist(bimestre);
        entityManager.flush();
        return bimestre;
    }

    public Bimestre buscarBimestre(Long id) {
        Bimestre bimestre;
        try{
        bimestre= entityManager.find(Bimestre.class, id);
        }catch (RuntimeException e) {
            throw new Exceptions(id);
        }
        return bimestre;
    }

    public void updateBimestre(Bimestre bimestre) {
        entityManager.merge(bimestre);
        entityManager.flush();
    }

    public void deleteBimestre(Long id) {
        try{
            Bimestre bimestre = buscarBimestre(id);
            entityManager.remove(bimestre);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Exceptions(id);
        }
    }

    public List<Bimestre> listarBimestresPorData(){
        String queryJPQL = "SELECT s FROM Bimestre s ORDER BY s.inicioBimestre";
        return entityManager.createQuery(queryJPQL, Bimestre.class).getResultList();
    }


    public long totalDeDiasLetivos(){
        long totalDeDiasLetivos = 0l;
        List<Bimestre> bimestres = listarBimestresPorData();
        for(Bimestre bimestre : bimestres){
            totalDeDiasLetivos += ChronoUnit.DAYS.between(bimestre.getInicioBimestre(), bimestre.getFimBimestre());
        }
        return  totalDeDiasLetivos;
    }

    public long diasLetivosBimestre(Long id){

    String queryJPQL = " SELECT s FROM Bimestre s where s.id =1 ";
      Query q = entityManager.createQuery(queryJPQL, Bimestre.class);
        Bimestre bimestre = (Bimestre) q.getSingleResult();

        return ChronoUnit.DAYS.between(bimestre.getInicioBimestre(), bimestre.getFimBimestre());
    }
}
