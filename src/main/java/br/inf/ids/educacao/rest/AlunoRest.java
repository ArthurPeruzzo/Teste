package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Aluno;
import br.inf.ids.educacao.models.DTOS.*;
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
    @Produces(MediaType.APPLICATION_JSON) //ok
    public Aluno cadastrarAluno(Aluno aluno){
        return alunoResource.cadastrarAluno(aluno);
    }

    @GET
    @Path("/buscarAlunoPorMatricula/{matricula}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //ok
    public Aluno buscarAluno(@PathParam("matricula") Long matricula){
        return alunoResource.buscar(matricula);
    }

    @GET
    @Path("/buscarTodosAlunos")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //ok
    public List<Aluno> buscarTodosOsAlunos(){
        return alunoResource.buscarTodosOsAlunos();
    }

    @GET
    @Path("/pesquisarAlunosPorCaractere/{caractere}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //ok
    public List<Aluno> pesquisarAlunos(@PathParam("caractere") String caractere){
        return alunoResource.pesquisarAlunos(caractere);
    }


    @DELETE
    @Path("/deletarAluno/{matricula}") //ok
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarAluno(@PathParam("matricula") Long matricula){
        alunoResource.delete(matricula);
    }

    @PUT
    @Path("/atualizarDadosAluno") //ok
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void uptadeAluno(Aluno aluno){
        alunoResource.update(aluno);
    }

    @GET
    @Path("/mediaFinalAluno/{matricula}") //ok
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public AlunoDTO mediaFinalDoAluno(@PathParam("matricula") Long matricula){
        return alunoResource.mediaFinalDoAluno(matricula);
    }

    @GET
    @Path("/notaDasAvaliacoesPorBimestre/{matricula}/{bimestre}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //ok
    public List<notaDasAvaliacoesPorBimestreDTO> notaDasAvaliacoesPorBimestre
            (@PathParam("matricula") Long matricula, @PathParam("bimestre") Long bimestre){
        return alunoResource.notaDasAvaliacoesPorBimestre(matricula, bimestre);
    }

    @GET
    @Path("/faltasDoAluno/{matricula}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON) //ok
    public List<FaltasAlunoDTO> faltasAluno
            (@PathParam("matricula") Long matricula){
        return alunoResource.faltasPorBimestreDeUmAluno(matricula);
    }

    @GET
    @Path("/totalDefaltasDoAluno/{matricula}")//ok
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public TotalDeFaltasDTO totalDefaltasAluno
            (@PathParam("matricula") Long matricula){
        return alunoResource.totalDeFaltasDeUmAluno(matricula);
    }

    @GET
    @Path("/mediaFinalDeUmAlunoEmCadaBimestre/{matricula}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public  List<NotaAlunoPorBimestreDTO> mediaFinalDeUmAlunoEmCadaBimestre
            (@PathParam("matricula") Long matricula){
        return alunoResource.mediaFinalDeUmAlunoEmCadaBimestre(matricula);
    }


}
