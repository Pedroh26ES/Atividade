// src/main/java/com/hackathon/model/pessoa/Jurado.java
package com.hackathon.model.pessoa;

import com.hackathon.model.Avaliavel;
import com.hackathon.model.pessoa.Profissional;
import com.hackathon.model.instituicao.Instituicao;

public class Jurado extends Profissional implements Avaliavel {
    private String areaExpertise;

    public Jurado(String nome, String email, String telefone, Instituicao instituicao,
            String cargo, String especialidade, String areaExpertise) {
        super(nome, email, telefone, instituicao, cargo, especialidade);
        this.areaExpertise = areaExpertise;
    }

    @Override
    public void avaliar() {
        System.out.println("Jurado " + nome + " (" + areaExpertise + ") está avaliando o projeto");
    }

    public String getAreaExpertise() {
        return areaExpertise;
    }

    public void setAreaExpertise(String areaExpertise) {
        this.areaExpertise = areaExpertise;
    }
}