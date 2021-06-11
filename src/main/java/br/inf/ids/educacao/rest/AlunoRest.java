package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Aluno;
import br.inf.ids.educacao.resources.AlunoResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alunos")
public class AlunoRest {

    @Inject
    AlunoResource alunoResource;

    @POST
    @Path("/cadastro")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Aluno cadastrarAluno(Aluno aluno){
        return alunoResource.cadastrarAluno(aluno);
    }
}
