package br.inf.ids.educacao.models.DTOS;

public class NotaAlunoPorBimestreDTO {

    private Long bimestre;
    private Long matricula;
    private String nome;
    private Double mediaFinal;

    public NotaAlunoPorBimestreDTO() {
    }

    public NotaAlunoPorBimestreDTO(Long bimestre, Long matricula, String nome, Double mediaFinal) {
        this.bimestre = bimestre;
        this.matricula = matricula;
        this.nome = nome;
        this.mediaFinal = mediaFinal;
    }

    public Long getBimestre() {
        return bimestre;
    }

    public void setBimestre(Long bimestre) {
        this.bimestre = bimestre;
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
}
