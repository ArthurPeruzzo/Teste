package br.inf.ids.educacao.models;

import java.util.Objects;

public class PresencaBimestre {

    private Bimestre bimestre;
    private Integer presenca;

    public PresencaBimestre() {
    }

    public PresencaBimestre(Bimestre bimestre, Integer presenca) {
        this.bimestre = bimestre;
        this.presenca = presenca;
    }

    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Integer getPresenca() {
        return presenca;
    }

    public void setPresenca(Integer presenca) {
        this.presenca = presenca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresencaBimestre that = (PresencaBimestre) o;
        return bimestre.equals(that.bimestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bimestre);
    }
}