package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Presenca;
import br.inf.ids.educacao.resources.PresencaResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/presenca")
public class PresencaRest {

    @Inject
    PresencaResource presencaResource;

    @POST
    @Path("/cadastroPresenca")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Presenca cadastrarPresenca(Presenca presenca){
        return presencaResource.cadastrarPresenca(presenca);
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Presenca buscarPresenca(@PathParam("id") Long id){
        return presencaResource.buscarPresenca(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarPresenca(@PathParam("id") Long id){
        presencaResource.deletePresenca(id);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadePresenca(Presenca presenca){
        presencaResource.updatePresenca(presenca);
    }
}
