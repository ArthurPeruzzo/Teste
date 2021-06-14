package br.inf.ids.educacao.models;

import br.inf.ids.educacao.enums.BimestreEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_bimestre")
public class Bimestre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private BimestreEnum bimestre;
    private LocalDate inicioBimestre;
    private LocalDate fimBimestre;

    @JsonIgnore
    @OneToMany(mappedBy = "bimestre")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "bimestre")
    private List<Presenca> presencas = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "bimestres")
    private List<Aluno> alunos = new ArrayList<>();


    public Bimestre(){
    }

    public Bimestre(BimestreEnum bimestre, LocalDate inicioBimestre, LocalDate fimBimestre) {
        this.bimestre = bimestre;
        this.inicioBimestre = inicioBimestre;
        this.fimBimestre = fimBimestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BimestreEnum getBimestre() {
        return bimestre;
    }

    public void setBimestre(BimestreEnum bimestre) {
        this.bimestre = bimestre;
    }

    public LocalDate getInicioBimestre() {
        return inicioBimestre;
    }

    public void setInicioBimestre(LocalDate inicioBimestre) {
        this.inicioBimestre = inicioBimestre;
    }

    public LocalDate getFimBimestre() {
        return fimBimestre;
    }

    public void setFimBimestre(LocalDate fimBimestre) {
        this.fimBimestre = fimBimestre;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public List<Presenca> getPresencas() {
        return presencas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Long getdiasLetivosBimestre(){

        return ChronoUnit.DAYS.between(inicioBimestre, fimBimestre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bimestre bimestre = (Bimestre) o;
        return id.equals(bimestre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
