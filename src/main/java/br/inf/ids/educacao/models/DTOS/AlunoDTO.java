package br.inf.ids.educacao.models.DTOS;

import javax.persistence.NamedNativeQuery;
import java.io.Serializable;


public class AlunoDTO implements Serializable {

    private Long matricula;
    private Double mediaFinal;

    public AlunoDTO(){
    }

    public AlunoDTO(Long matricula, Double mediaFinal) {
        this.matricula = matricula;
        this.mediaFinal = mediaFinal;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
