// src/main/java/com/hackathon/model/Projeto.java
package com.hackathon.model;
import com.hackathon.model.pessoa.Profissional;

public class Projeto {
    private String nome;
    private String descricao;
    private Profissional orientador;
    private Equipe equipe;
    private double notaFinal;

    public Projeto(String nome, String descricao, Profissional orientador, Equipe equipe) {
        this.nome = nome;
        this.descricao = descricao;
        this.orientador = orientador;
        this.equipe = equipe;
        this.notaFinal = 0.0;
    }

    public void calcularNotaFinal() {
        // Nota calculada atraves da apresentação
        System.out.println("Calculando nota final do projeto: " + nome);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Profissional getOrientador() { return orientador; }
    public void setOrientador(Profissional orientador) { this.orientador = orientador; }
    public Equipe getEquipe() { return equipe; }
    public void setEquipe(Equipe equipe) { this.equipe = equipe; }
    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }
}