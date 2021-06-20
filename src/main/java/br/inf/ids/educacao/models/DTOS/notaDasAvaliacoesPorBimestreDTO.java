package br.inf.ids.educacao.models.DTOS;

import java.io.Serializable;

public class notaDasAvaliacoesPorBimestreDTO {

    private Long matricula;
    private String nome;
    private Long bimestre;
    private Double notaDaAvaliacao;
    private String tipoDaAvaliacao;

    public notaDasAvaliacoesPorBimestreDTO() {
    }

    public notaDasAvaliacoesPorBimestreDTO(Long matricula, String nome, Long bimestre, Double notaDaAvaliacao, String tipoDaAvaliacao) {
        this.matricula = matricula;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
