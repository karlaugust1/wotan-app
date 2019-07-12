package unifacear.edu.br.wotan.model;

public class HistoricoPergunta {

    private Boolean acertou;
    private String resposta;
    private Long estudante;
    private Long pergunta;
    private Long alternativa;

    public HistoricoPergunta() {
    }

    public Boolean getAcertou() {
        return acertou;
    }

    public void setAcertou(Boolean acertou) {
        this.acertou = acertou;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Long getEstudante() {
        return estudante;
    }

    public void setEstudante(Long estudante) {
        this.estudante = estudante;
    }

    public Long getPergunta() {
        return pergunta;
    }

    public void setPergunta(Long pergunta) {
        this.pergunta = pergunta;
    }

    public Long getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Long alternativa) {
        this.alternativa = alternativa;
    }
}
