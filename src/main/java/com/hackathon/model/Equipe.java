// src/main/java/com/hackathon/model/Equipe.java
package com.hackathon.model;

import com.hackathon.model.pessoa.Estudante;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Estudante> membros;

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(Estudante estudante) {
        if (membros.size() < 5) {
            membros.add(estudante);
        } else {
            throw new IllegalStateException("Equipe já possui o máximo de 5 membros");
        }
    }

    public void removerMembro(Estudante estudante) {
        membros.remove(estudante);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Estudante> getMembros() { return new ArrayList<>(membros); }
    public int getQuantidadeMembros() { return membros.size(); }
}