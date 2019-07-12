package unifacear.edu.br.wotan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Estudante {

    private Long id;
    private String matricula;
    private Long idUsuario;
    private String nome;
    private String senha;

    public Estudante() {
    }

    public Estudante(Long id, String matricula, Long idUsuario, String nome, String senha) {
        this.id = id;
        this.matricula = matricula;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
    }

    public Estudante(String matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
