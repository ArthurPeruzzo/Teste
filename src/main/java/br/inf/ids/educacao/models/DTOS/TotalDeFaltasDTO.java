package br.inf.ids.educacao.models.DTOS;

public class TotalDeFaltasDTO {

    private Long matricula;
    private Integer totalDeFaltas;

    public TotalDeFaltasDTO() {
    }

    public TotalDeFaltasDTO(Long matricula, Integer totalDeFaltas) {
        this.matricula = matricula;
        this.totalDeFaltas = totalDeFaltas;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Integer getTotalDeFaltas() {
        return totalDeFaltas;
    }

    public void setTotalDeFaltas(Integer totalDeFaltas) {
        this.totalDeFaltas = totalDeFaltas;
    }
}
