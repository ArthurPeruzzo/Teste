package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Aluno;
import br.inf.ids.educacao.resources.AlunoResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/alunos")
public class AlunoRest {

    @Inject
    AlunoResource alunoResource;

    @POST
    @Path("/cadastroAluno")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno cadastrarAluno(Aluno aluno){
        return alunoResource.cadastrarAluno(aluno);
    }

    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Aluno buscarAluno(@PathParam("id") Long id){
        return alunoResource.buscar(id);
    }

    @GET
    @Path("/buscarTodosAlunos")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Aluno> buscarTodosOsAlunos(){
        return alunoResource.buscarTodosOsAlunos();
    }

    @GET
    @Path("/pesquisarAlunosPorCaractere/{caractere}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Aluno> pesquisarAlunos(@PathParam("caractere") String caractere){
        return alunoResource.pesquisarAlunos(caractere);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarAluno(@PathParam("id") Long id){
        alunoResource.delete(id);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadeAluno(Aluno aluno){
        alunoResource.update(aluno);
    }
}
