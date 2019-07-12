package unifacear.edu.br.wotan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alternativa {

    private Long id;
    private String descricao;
    private Boolean correta;
    private Long idPergunta;

    public Alternativa() {
    }

    public Alternativa(Long id, String descricao, Boolean correta, Long idPergunta) {
        this.id = id;
        this.descricao = descricao;
        this.correta = correta;
        this.idPergunta = idPergunta;
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

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }

    public Long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }
}
