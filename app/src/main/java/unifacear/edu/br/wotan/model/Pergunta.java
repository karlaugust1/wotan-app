package unifacear.edu.br.wotan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pergunta {

    private Long id;
    private String descricao;
    private String dataCriacao;
    private String dataLimite;
    private Double valor;
    private Boolean ativa;
    private Boolean visivel;
    private Long idConteudo;
    private String titulo;
    private List<Alternativa> alternativas;

    public Pergunta() {
    }

    public Pergunta(Long id, String descricao, String dataCriacao, String dataLimite, Double valor, Boolean ativa, Boolean visivel, Long idConteudo, String titulo, List<Alternativa> alternativas) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataLimite = dataLimite;
        this.valor = valor;
        this.ativa = ativa;
        this.visivel = visivel;
        this.idConteudo = idConteudo;
        this.titulo = titulo;
        this.alternativas = alternativas;
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

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public Long getIdConteudo() {
        return idConteudo;
    }

    public void setIdConteudo(Long idConteudo) {
        this.idConteudo = idConteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
}

