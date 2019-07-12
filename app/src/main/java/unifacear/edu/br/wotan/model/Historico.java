package unifacear.edu.br.wotan.model;

public class Historico {

    private String pergunta;
    private String dataCriacao;
    private String resposta;
    private String dataResposta;
    private Boolean correta;

    public Historico() {
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(String dataResposta) {
        this.dataResposta = dataResposta;
    }

    public Boolean getCorreta() {
        return correta;
    }

    public void setCorreta(Boolean correta) {
        this.correta = correta;
    }

}
