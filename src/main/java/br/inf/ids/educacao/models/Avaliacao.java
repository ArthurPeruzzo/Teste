package br.inf.ids.educacao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double notaAvaliacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tipoAvaliacao_id") //nome da chave estrangeira
    private TipoAvaliacao tipoAvaliacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "avaliacao_id") //nome da chave estrangeira
    private Bimestre bimestre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Avaliacao(){
    }

    public Avaliacao(Double notaAvaliacao, TipoAvaliacao tipoAvaliacao, Bimestre bimestre, Aluno aluno) {
        this.notaAvaliacao = notaAvaliacao;
        this.tipoAvaliacao = tipoAvaliacao;
        this.bimestre = bimestre;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return id.equals(avaliacao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
