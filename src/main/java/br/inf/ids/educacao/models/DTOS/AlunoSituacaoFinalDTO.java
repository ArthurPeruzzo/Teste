package br.inf.ids.educacao.models.DTOS;

import br.inf.ids.educacao.enums.SituacaoEnum;

public class AlunoSituacaoFinalDTO {

    private Long matricula;
    private String nome;
    private Double mediaFinal;
    private SituacaoEnum situacaoFinal;

    public AlunoSituacaoFinalDTO() {
    }

    public AlunoSituacaoFinalDTO(Long matricula, String nome, Double mediaFinal, SituacaoEnum situacaoFinal) {
        this.matricula = matricula;
        this.nome = nome;
        this.mediaFinal = mediaFinal;
        this.situacaoFinal = situacaoFinal;
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

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public SituacaoEnum getSituacaoFinal() {
        return situacaoFinal;
    }

    public void setSituacaoFinal(SituacaoEnum situacaoFinal) {
        this.situacaoFinal = situacaoFinal;
    }
}
