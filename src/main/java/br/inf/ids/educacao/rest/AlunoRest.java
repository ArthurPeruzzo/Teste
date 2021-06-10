package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Aluno;
import br.inf.ids.educacao.resources.AlunoResource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/alunos")
public class AlunoRest {

    @Inject
    AlunoResource alunoResource;

    @GET
    @Path("/cadastrar")
    public Aluno cadastrarAluno(Aluno aluno){
        return alunoResource.cadastrarAluno(aluno);
    }
}
