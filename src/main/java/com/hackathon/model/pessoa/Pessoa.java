// src/main/java/com/hackathon/model/pessoa/Pessoa.java
package com.hackathon.model.pessoa;
import com.hackathon.model.instituicao.Instituicao;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String telefone;
    protected Instituicao instituicao;

    public Pessoa(String nome, String email, String telefone, Instituicao instituicao) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.instituicao = instituicao;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public Instituicao getInstituicao() { return instituicao; }
    public void setInstituicao(Instituicao instituicao) { this.instituicao = instituicao; }
}