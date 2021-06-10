package br.inf.ids.educacao.models;

import java.util.Objects;

public class NotaBimestre {

    private Bimestre bimestre;
    private Double nota;

    public NotaBimestre() {
    }

    public NotaBimestre(Bimestre bimestre, Double nota) {
        this.bimestre = bimestre;
        this.nota = nota;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaBimestre that = (NotaBimestre) o;
        return bimestre.equals(that.bimestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bimestre);
    }
}
