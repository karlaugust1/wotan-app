package unifacear.edu.br.wotan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Disciplina {

    private Long id;
    private String descricao;
    private Long idCurso;
    private String curso;

    public Disciplina() {
    }

    public Disciplina(Long id, String descricao, Long idCurso, String curso) {
        this.id = id;
        this.descricao = descricao;
        this.idCurso = idCurso;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}

