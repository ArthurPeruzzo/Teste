package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Bimestre;
import br.inf.ids.educacao.models.TipoAvaliacao;
import br.inf.ids.educacao.resources.BimestreResource;
import br.inf.ids.educacao.resources.TipoAvaliacaoResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/bimestres")
public class BimestreRest {

    @Inject
    BimestreResource bimestreResource;

    @POST
    @Path("/cadastroBimestre")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Bimestre cadastrarTipoAvaliacao(Bimestre bimestre){
        return bimestreResource.cadastrarBimestre(bimestre);
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Bimestre buscarTipoAvaliacao(@PathParam("id") Long id){
        return bimestreResource.buscarBimestre(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarTipoAvaliacao(@PathParam("id") Long id){
        bimestreResource.deleteBimestre(id);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadeTipoAvaliacao(Bimestre bimestre){
        bimestreResource.updateBimestre(bimestre);
    }
}
