package br.inf.ids.educacao.configuracao;

import br.inf.ids.educacao.enums.BimestreEnum;
import br.inf.ids.educacao.models.*;
import br.inf.ids.educacao.resources.*;
import com.google.inject.Inject;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.enterprise.context.control.ActivateRequestContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;

@QuarkusMain
public class TesteConfig implements QuarkusApplication {
    @Inject
    AlunoResource alunoResource;

    @Inject
    TipoAvaliacaoResource tipoAvaliacaoResource;

    @Inject
    BimestreResource bimestreResource;

    @Inject
    AvaliacaoResource avaliacaoResource;

    @Inject
    PresencaResource presencaResource;

    @Override
    @ActivateRequestContext
    @Transactional
    public int run(String... args) throws Exception {
        Aluno Pedro = new Aluno(99332737L, "Pedro", "pedro@gmail.com", "99257629" );
        Aluno Maria = new Aluno(66887734L, "Maria", "maria@gmail.com", "98274531" );
        Aluno Jose = new Aluno(22553434L, "Jose", "jose@gmail.com", "99453762" );
        alunoResource.cadastrarAluno(Pedro);
        alunoResource.cadastrarAluno(Maria);
        alunoResource.cadastrarAluno(Jose);

        //adicionando tipoAvaliacao ao banco de dados

        TipoAvaliacao partSalaDeAula = new TipoAvaliacao("Participação em sala de aula", 1.5);
        TipoAvaliacao entregaDasTarefas = new TipoAvaliacao("Entrega das tarefas", 2.5);
        TipoAvaliacao trabalhoBimestral = new TipoAvaliacao("Trabalho bimestral", 3.0);
        TipoAvaliacao provaBimestral = new TipoAvaliacao("Prova bimestral", 3.0);
        tipoAvaliacaoResource.cadastrarTipoAvaliacao(partSalaDeAula);
        tipoAvaliacaoResource.cadastrarTipoAvaliacao(entregaDasTarefas);
        tipoAvaliacaoResource.cadastrarTipoAvaliacao(trabalhoBimestral);
        tipoAvaliacaoResource.cadastrarTipoAvaliacao(provaBimestral);

        //adcionando Bimestre ao bando de dados
        Bimestre bimestre1 = new Bimestre(BimestreEnum.BIMESTRE_1, LocalDate.of(2020, 2, 4), LocalDate.of(2020, 3, 15));
        Bimestre bimestre2 = new Bimestre(BimestreEnum.BIMESTRE_2, LocalDate.of(2020, 4, 23), LocalDate.of(2020, 6, 2));
        Bimestre bimestre3 = new Bimestre(BimestreEnum.BIMESTRE_3, LocalDate.of(2020, 7, 21), LocalDate.of(2020, 8, 30));
        Bimestre bimestre4 = new Bimestre(BimestreEnum.BIMESTRE_4, LocalDate.of(2020, 10, 5), LocalDate.of(2020, 11, 14));
        bimestreResource.cadastrarBimestre(bimestre1);
        bimestreResource.cadastrarBimestre(bimestre2);
        bimestreResource.cadastrarBimestre(bimestre3);
        bimestreResource.cadastrarBimestre(bimestre4);

        //adicionando Avaliacoes por bimestre do Pedro no banco de dados
        //1° Bimestre - Pedro
        Avaliacao avaliacao1PedroB1 = new Avaliacao(6.0, partSalaDeAula, bimestre1, Pedro);
        Avaliacao avaliacao2PedroB1 = new Avaliacao(6.0, entregaDasTarefas, bimestre1, Pedro);
        Avaliacao avaliacao3PedroB1 = new Avaliacao(6.0, trabalhoBimestral, bimestre1, Pedro);
        Avaliacao avaliacao4PedroB1 = new Avaliacao(2.0, provaBimestral, bimestre1, Pedro);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1PedroB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2PedroB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3PedroB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4PedroB1);

        //2° Bimestre - Pedro
        Avaliacao avaliacao1PedroB2 = new Avaliacao(5.0, partSalaDeAula, bimestre2, Pedro);
        Avaliacao avaliacao2PedroB2 = new Avaliacao(6.0, entregaDasTarefas, bimestre2, Pedro);
        Avaliacao avaliacao3PedroB2 = new Avaliacao(6.0, trabalhoBimestral, bimestre2, Pedro);
        Avaliacao avaliacao4PedroB2 = new Avaliacao(6.0, provaBimestral, bimestre2, Pedro);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1PedroB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2PedroB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3PedroB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4PedroB2);

        //3° Bimestre - Pedro
        Avaliacao avaliacao1PedroB3 = new Avaliacao(6.0, partSalaDeAula, bimestre3, Pedro);
        Avaliacao avaliacao2PedroB3 = new Avaliacao(6.0, entregaDasTarefas, bimestre3, Pedro);
        Avaliacao avaliacao3PedroB3 = new Avaliacao(6.5, trabalhoBimestral, bimestre3, Pedro);
        Avaliacao avaliacao4PedroB3 = new Avaliacao(4.0, provaBimestral, bimestre3, Pedro);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1PedroB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2PedroB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3PedroB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4PedroB3);

        //4° Bimestre - Pedro
        Avaliacao avaliacao1PedroB4 = new Avaliacao(6.0, partSalaDeAula, bimestre4, Pedro);
        Avaliacao avaliacao2PedroB4 = new Avaliacao(6.0, entregaDasTarefas, bimestre4, Pedro);
        Avaliacao avaliacao3PedroB4 = new Avaliacao(6.5, trabalhoBimestral, bimestre4, Pedro);
        Avaliacao avaliacao4PedroB4 = new Avaliacao(6.0, provaBimestral, bimestre4, Pedro);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1PedroB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2PedroB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3PedroB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4PedroB4);

        //adicionando Avaliacoes por bimestre da Maria no banco de dados
        //1° Bimestre - Maria
        Avaliacao avaliacao1MariaB1 = new Avaliacao(10.0, partSalaDeAula, bimestre1, Maria);
        Avaliacao avaliacao2MariaB1 = new Avaliacao(10.0, entregaDasTarefas, bimestre1, Maria);
        Avaliacao avaliacao3MariaB1 = new Avaliacao(10.0, trabalhoBimestral, bimestre1, Maria);
        Avaliacao avaliacao4MariaB1 = new Avaliacao(10.0, provaBimestral, bimestre1, Maria);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1MariaB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2MariaB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3MariaB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4MariaB1);

        //2° Bimestre - Maria
        Avaliacao avaliacao1MariaB2 = new Avaliacao(10.0, partSalaDeAula, bimestre2, Maria);
        Avaliacao avaliacao2MariaB2 = new Avaliacao(10.0, entregaDasTarefas, bimestre2, Maria);
        Avaliacao avaliacao3MariaB2 = new Avaliacao(10.0, trabalhoBimestral, bimestre2, Maria);
        Avaliacao avaliacao4MariaB2 = new Avaliacao(10.0, provaBimestral, bimestre2, Maria);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1MariaB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2MariaB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3MariaB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4MariaB2);

        //3° Bimestre - Maria
        Avaliacao avaliacao1MariaB3 = new Avaliacao(10.0, partSalaDeAula, bimestre3, Maria);
        Avaliacao avaliacao2MariaB3 = new Avaliacao(10.0, entregaDasTarefas, bimestre3, Maria);
        Avaliacao avaliacao3MariaB3 = new Avaliacao(10.0, trabalhoBimestral, bimestre3, Maria);
        Avaliacao avaliacao4MariaB3 = new Avaliacao(10.0, provaBimestral, bimestre3, Maria);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1MariaB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2MariaB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3MariaB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4MariaB3);

        //4° Bimestre - Maria
        Avaliacao avaliacao1MariaB4 = new Avaliacao(10.0, partSalaDeAula, bimestre4, Maria);
        Avaliacao avaliacao2MariaB4 = new Avaliacao(10.0, entregaDasTarefas, bimestre4, Maria);
        Avaliacao avaliacao3MariaB4 = new Avaliacao(10.0, trabalhoBimestral, bimestre4, Maria);
        Avaliacao avaliacao4MariaB4 = new Avaliacao(10.0, provaBimestral, bimestre4, Maria);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1MariaB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2MariaB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3MariaB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4MariaB4);

        //adicionando Avaliacoes por bimestre do Jose no banco de dados
        //1° Bimestre - Jose
        Avaliacao avaliacao1JoseB1 = new Avaliacao(5.0, partSalaDeAula, bimestre1, Jose);
        Avaliacao avaliacao2JoseB1 = new Avaliacao(5.5, entregaDasTarefas, bimestre1, Jose);
        Avaliacao avaliacao3JoseB1 = new Avaliacao(5.0, trabalhoBimestral, bimestre1, Jose);
        Avaliacao avaliacao4JoseB1 = new Avaliacao(10.0, provaBimestral, bimestre1, Jose);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1JoseB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2JoseB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3JoseB1);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4JoseB1);

        //2° Bimestre - Jose
        Avaliacao avaliacao1JoseB2 = new Avaliacao(5.0, partSalaDeAula, bimestre2, Jose);
        Avaliacao avaliacao2JoseB2 = new Avaliacao(5.0, entregaDasTarefas, bimestre2, Jose);
        Avaliacao avaliacao3JoseB2 = new Avaliacao(5.5, trabalhoBimestral, bimestre2, Jose);
        Avaliacao avaliacao4JoseB2 = new Avaliacao(6.0, provaBimestral, bimestre2, Jose);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1JoseB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2JoseB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3JoseB2);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4JoseB2);

        //3° Bimestre - Jose
        Avaliacao avaliacao1JoseB3 = new Avaliacao(5.0, partSalaDeAula, bimestre3, Jose);
        Avaliacao avaliacao2JoseB3 = new Avaliacao(5.0, entregaDasTarefas, bimestre3, Jose);
        Avaliacao avaliacao3JoseB3 = new Avaliacao(5.5, trabalhoBimestral, bimestre3, Jose);
        Avaliacao avaliacao4JoseB3 = new Avaliacao(5.0, provaBimestral, bimestre3, Jose);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1JoseB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2JoseB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3JoseB3);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4JoseB3);

        //4° Bimestre - Jose
        Avaliacao avaliacao1JoseB4 = new Avaliacao(5.0, partSalaDeAula, bimestre4, Jose);
        Avaliacao avaliacao2JoseB4 = new Avaliacao(5.5, entregaDasTarefas, bimestre4, Jose);
        Avaliacao avaliacao3JoseB4 = new Avaliacao(4.5, trabalhoBimestral, bimestre4, Jose);
        Avaliacao avaliacao4JoseB4 = new Avaliacao(3.0, provaBimestral, bimestre4, Jose);
        avaliacaoResource.cadastrarAvaliacao(avaliacao1JoseB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao2JoseB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao3JoseB4);
        avaliacaoResource.cadastrarAvaliacao(avaliacao4JoseB4);

        //Adicionando presenças do Pedro

        Presenca presencaPedroB1 = new Presenca(5, bimestre1, Pedro);
        Presenca presencaPedroB2 = new Presenca(4, bimestre2, Pedro);
        Presenca presencaPedroB3 = new Presenca(3, bimestre3, Pedro);
        Presenca presencaPedroB4 = new Presenca(2, bimestre4, Pedro);
        presencaResource.cadastrarPresenca(presencaPedroB1);
        presencaResource.cadastrarPresenca(presencaPedroB2);
        presencaResource.cadastrarPresenca(presencaPedroB3);
        presencaResource.cadastrarPresenca(presencaPedroB4);

        //Adicionando presenças da Maria

        Presenca presencaMariaB1 = new Presenca(2, bimestre1, Maria);
        Presenca presencaMariaB2 = new Presenca(1, bimestre2, Maria);
        Presenca presencaMariaB3 = new Presenca(2, bimestre3, Maria);
        Presenca presencaMariaB4 = new Presenca(3, bimestre4, Maria);
        presencaResource.cadastrarPresenca(presencaMariaB1);
        presencaResource.cadastrarPresenca(presencaMariaB2);
        presencaResource.cadastrarPresenca(presencaMariaB3);
        presencaResource.cadastrarPresenca(presencaMariaB4);

        //Adicionando presenças do Jose

        Presenca presencaJoseB1 = new Presenca(12, bimestre1, Jose);
        Presenca presencaJoseB2 = new Presenca(15, bimestre2, Jose);
        Presenca presencaJoseB3 = new Presenca(19, bimestre3, Jose);
        Presenca presencaJoseB4 = new Presenca(20, bimestre4, Jose);
        presencaResource.cadastrarPresenca(presencaJoseB1);
        presencaResource.cadastrarPresenca(presencaJoseB2);
        presencaResource.cadastrarPresenca(presencaJoseB3);
        presencaResource.cadastrarPresenca(presencaJoseB4);

        //associações dos alunos aos bimestres
        Pedro.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        Maria.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        Jose.getBimestres().addAll(Arrays.asList(bimestre1, bimestre2, bimestre3, bimestre4));
        alunoResource.cadastrarAluno(Pedro);
        alunoResource.cadastrarAluno(Maria);
        alunoResource.cadastrarAluno(Jose);

        return 0;
    }
}