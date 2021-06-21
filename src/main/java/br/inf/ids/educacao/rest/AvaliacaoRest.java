package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Avaliacao;
import br.inf.ids.educacao.resources.AvaliacaoResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/avaliacao")
public class AvaliacaoRest {

    @Inject
    AvaliacaoResource avaliacaoResource;

    @POST
    @Path("/cadastroAvaliacao")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao){
        return avaliacaoResource.cadastrarAvaliacao(avaliacao);
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Avaliacao buscarAvaliacao(@PathParam("id") Long id){
        return avaliacaoResource.buscarAvaliacao(id);
    }

    @GET
    @Path("/listarAvaliacaoPorNota")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Avaliacao> listarAvaliacaoPorNota(){
        return avaliacaoResource.listarAvaliacaoPorNota();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarTipoAvaliacao(@PathParam("id") Long id){
        avaliacaoResource.deleteAvaliacao(id);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadeTipoAvaliacao(Avaliacao avaliacao){
        avaliacaoResource.updateAvaliacao(avaliacao);
    }
}
