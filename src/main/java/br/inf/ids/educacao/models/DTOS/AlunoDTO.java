package br.inf.ids.educacao.models.DTOS;

public class AlunoDTO {

    private Long matricula;
    private String nome;
    private Double mediaFinal;

    public AlunoDTO(){
    }

    public AlunoDTO(Long matricula, String nome, Double mediaFinal) {
        this.matricula = matricula;
        this.nome = nome;
        this.mediaFinal = mediaFinal;
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
