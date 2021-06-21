package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Bimestre;
import br.inf.ids.educacao.models.TipoAvaliacao;
import br.inf.ids.educacao.resources.BimestreResource;
import br.inf.ids.educacao.resources.TipoAvaliacaoResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bimestres")
public class BimestreRest {

    @Inject
    BimestreResource bimestreResource;

    @POST
    @Path("/cadastroBimestre")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Bimestre cadastrarBimestre(Bimestre bimestre){
        return bimestreResource.cadastrarBimestre(bimestre);
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Bimestre buscarBimestre(@PathParam("id") Long id){
        return bimestreResource.buscarBimestre(id);
    }

    @GET
    @Path("/listarBimestresPorData")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Bimestre> listarBimestresPorData(){
        return bimestreResource.listarBimestresPorData();
    }

    @GET
    @Path("/totalDeDiasLetivos")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public long totalDeDiasLetivos(){
        return bimestreResource.totalDeDiasLetivos();
    }

    @GET
    @Path("/diasLetivosDeUmBimestre/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public long totalDeDiasLetivosDeUmBimestre(@PathParam("id") Long id){
        return bimestreResource.diasLetivosBimestre(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarBimestre(@PathParam("id") Long id){
        bimestreResource.deleteBimestre(id);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadeBimestre(Bimestre bimestre){
        bimestreResource.updateBimestre(bimestre);
    }
}
