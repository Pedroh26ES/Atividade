// src/main/java/com/hackathon/model/pessoa/Profissional.java
package com.hackathon.model.pessoa;
import com.hackathon.model.instituicao.Instituicao;

public class Profissional extends Pessoa {
    private String cargo;
    private String especialidade;

    public Profissional(String nome, String email, String telefone, Instituicao instituicao, 
                       String cargo, String especialidade) {
        super(nome, email, telefone, instituicao);
        this.cargo = cargo;
        this.especialidade = especialidade;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}