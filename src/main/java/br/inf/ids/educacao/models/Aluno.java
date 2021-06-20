package br.inf.ids.educacao.models;

import br.inf.ids.educacao.enums.SituacaoEnum;
import br.inf.ids.educacao.models.DTOS.AlunoDTO;
import br.inf.ids.educacao.models.DTOS.NotaAlunoPorBimestreDTO;
import br.inf.ids.educacao.models.DTOS.notaDasAvaliacoesPorBimestreDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@SqlResultSetMapping(
        name = "mediaFinalAlunoDTO",
        classes = {
                @ConstructorResult(
                        targetClass = AlunoDTO.class,
                        columns = {
                                @ColumnResult(name="matricula", type = Long.class),
                                @ColumnResult(name="nome", type = String.class),
                                @ColumnResult(name="media_final", type = Double.class)
                        }
                )
        }
)
@SqlResultSetMapping(
        name = "mediaFinalAlunoPorBimestreDTO",
        classes = {
                @ConstructorResult(
                        targetClass = NotaAlunoPorBimestreDTO.class,
                        columns = {
                                @ColumnResult(name="bimestre", type = Long.class),
                                @ColumnResult(name="matricula", type = Long.class),
                                @ColumnResult(name="nome", type = String.class),
                                @ColumnResult(name="mediaFinal", type = Double.class)
                        }
                )
        }
)
@Table(name = "tb_aluno")
public class Aluno implements Serializable {

    @Id
    private Long matricula;
    private String nome;
    private String email;
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<Presenca> presencas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany         //nomeTabela        //nome da chave estrangeira aluno e bimestre
    @JoinTable(name = "tb_AlunoBimestre", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "bimestre_id"))
    private List<Bimestre> bimestres = new ArrayList<>();

    public Aluno(){
    }

    public Aluno(Long matricula, String nome, String email, String telefone) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public List<Presenca> getPresencas() {
        return presencas;
    }

    public List<Bimestre> getBimestres() {
        return bimestres;
    }

    public List<NotaBimestre> mediaAlunoPorBimestre(){
        List<NotaBimestre> returnNotas = new ArrayList<>();
        Map<Bimestre, List<Avaliacao>> agrupados = agrupar(avaliacoes);

        for(Map.Entry<Bimestre, List<Avaliacao>> valores : agrupados.entrySet()){ //entrySet cria um conjunto dos mesmos elementos contidos no mapa hash

            Bimestre bimestreAtual = valores.getKey(); //pega a chave de 1 campo da tabela hash
            List<Avaliacao> avaliacoesPorBimestre = valores.getValue(); //pega todos os valores de 1 chave da tabela hash

            double media = 0.0;
            double somaPesos = 0.0;

            for(Avaliacao a : avaliacoesPorBimestre){//soma dos pesos por cada avaliação
                somaPesos += a.getTipoAvaliacao().getPesoAvaliacao();
            }

            double mediaBimestre=0.0;
            for(Avaliacao a : avaliacoesPorBimestre){ //media por bimestre
                media += (a.getNotaAvaliacao() * (a.getTipoAvaliacao().getPesoAvaliacao()));
            }

            mediaBimestre = media/somaPesos;
            NotaBimestre notaBimestre = new NotaBimestre(bimestreAtual, mediaBimestre);
            returnNotas.add(notaBimestre);
        }

        return returnNotas;
    }

    public Map<Bimestre, List<Avaliacao>> agrupar(List<Avaliacao> avaliacaos) {
        Map<Bimestre, List<Avaliacao>> agrupados = new HashMap<>();

        for(Avaliacao avaliacao: avaliacoes){
            Bimestre bimestreAtual = avaliacao.getBimestre();
            if (!agrupados.containsKey(bimestreAtual)) { //se a tabela hash ainda não tiver um bimestre, ela insere
                List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
                avaliacoes.add(avaliacao);
                agrupados.put(bimestreAtual, avaliacoes); //adicionar na tabela hash a avaliacao respectiva ao bimestre
            } else {
                List<Avaliacao> avaliacoesPassadas = agrupados.get(bimestreAtual); //pega o bismestre atual
                avaliacoesPassadas.add(avaliacao);
            }
        }

        return agrupados;
    }

    public double MediaFinal(){
        double mediaFinal = 0.0;
        for(NotaBimestre media : mediaAlunoPorBimestre()){
            mediaFinal += media.getNota();
        }
        return mediaFinal/4;
    }

    public List<PresencaBimestre> somaDasFaltas(){
        List<PresencaBimestre> returnPresencas = new ArrayList<>();
        Map<Bimestre, List<Presenca>> agrupados = agruparPresencas(presencas);

        for(Map.Entry<Bimestre, List<Presenca>> valores : agrupados.entrySet()){ //entrySet cria um conjunto dos mesmos elementos contidos no mapa hash

            Bimestre bimestreAtual = valores.getKey(); //pega a chave de 1 campo da tabela hash
            List<Presenca> presencasPorBimestre = valores.getValue(); //pega todos os valores de 1 chave da tabela hash

            int somaPresenca=0;
            for(Presenca a : presencasPorBimestre){ //presenca por bimestre
                somaPresenca += a.getNumeroDeFaltas();
            }

            PresencaBimestre presencaBimestre = new PresencaBimestre(bimestreAtual, somaPresenca );
            returnPresencas.add(presencaBimestre);
        }

        return returnPresencas;

    }

    public Map<Bimestre, List<Presenca>> agruparPresencas(List<Presenca> presencas) {
        Map<Bimestre, List<Presenca>> agrupados = new HashMap<>();

        for (Presenca presenca : presencas) {
            Bimestre bimestreAtual = presenca.getBimestre();
            if (!agrupados.containsKey(bimestreAtual)) { //se a tabela hash ainda não tiver um bimestre, ela insere
                List<Presenca> p = new ArrayList<>();
                p.add(presenca);
                agrupados.put(bimestreAtual, p); //adicionar na tabela hash a presenca respectiva ao bimestre
            } else {
                List<Presenca> pres = agrupados.get(bimestreAtual); //pega o bismestre atual
                pres.add(presenca);
            }
        }
        return agrupados;
    }

    public int TotalFaltas(){
        int totalFaltas=0;
        for(PresencaBimestre falta : somaDasFaltas()){
            totalFaltas += falta.getPresenca();
        }
        return totalFaltas;
    }

    public SituacaoEnum SituacaoFinal(){
        double porcentagemDaPresenca = 0.0;
        int codigo = 0;
        for(Bimestre bimestre : bimestres){
            porcentagemDaPresenca = 100.0 - ((TotalFaltas() * 100.0) / (bimestre.getdiasLetivosBimestre() * 4.0));
            if(porcentagemDaPresenca < 75.0 || MediaFinal() < 5.0){
                codigo = 2;
            }else if(porcentagemDaPresenca >= 75.0 && MediaFinal() >= 6.0){
                codigo = 1;
            }else
                codigo = 3;
        }
        return SituacaoEnum.valor(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}