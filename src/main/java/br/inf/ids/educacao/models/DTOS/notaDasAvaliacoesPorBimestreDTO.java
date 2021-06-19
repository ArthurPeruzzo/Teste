package br.inf.ids.educacao.models.DTOS;

import java.io.Serializable;

public class notaDasAvaliacoesPorBimestreDTO implements Serializable {

    private Long matricula;
    private Long bimestre;
    private Double notaDaAvaliacao;
    private String tipoDaAvaliacao;

    public notaDasAvaliacoesPorBimestreDTO() {
    }

    public notaDasAvaliacoesPorBimestreDTO(Long matricula, Long bimestre, Double notaDaAvaliacao, String tipoDaAvaliacao) {
        this.matricula = matricula;
        this.bimestre = bimestre;
        this.notaDaAvaliacao = notaDaAvaliacao;
        this.tipoDaAvaliacao = tipoDaAvaliacao;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Long getBimestre() {
        return bimestre;
    }

    public void setBimestre(Long bimestre) {
        this.bimestre = bimestre;
    }

    public Double getNotaDaAvaliacao() {
        return notaDaAvaliacao;
    }

    public void setNotaDaAvaliacao(Double notaDaAvaliacao) {
        this.notaDaAvaliacao = notaDaAvaliacao;
    }

    public String getTipoDaAvaliacao() {
        return tipoDaAvaliacao;
    }

    public void setTipoDaAvaliacao(String tipoDaAvaliacao) {
        this.tipoDaAvaliacao = tipoDaAvaliacao;
    }
}
