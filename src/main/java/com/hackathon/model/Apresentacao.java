// src/main/java/com/hackathon/model/Apresentacao.java
package com.hackathon.model;

import java.time.LocalDateTime;

public class Apresentacao {
    private Projeto projeto;
    private Banca banca;
    private Sala local;
    private LocalDateTime dataHora;

    public Apresentacao(Projeto projeto, Banca banca, Sala local, LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now())) {
        throw new IllegalArgumentException("Data da apresentação não pode ser no passado");
    }
        this.projeto = projeto;
        this.banca = banca;
        this.local = local;
        this.dataHora = dataHora;
    }

    public void avaliar() {
        banca.avaliar();
        double notaFinal = banca.calcularNotaFinal();
        System.out.println("Apresentação do projeto " + projeto.getNome() + 
                         " avaliada com nota: " + notaFinal);
    }

    public Projeto getProjeto() { return projeto; }
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }
    public Banca getBanca() { return banca; }
    public void setBanca(Banca banca) { this.banca = banca; }
    public Sala getLocal() { return local; }
    public void setLocal(Sala local) { this.local = local; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}