// src/main/java/com/hackathon/model/Sala.java
package com.hackathon.model;

public class Sala {
    private String numero;
    private int capacidade;
    private String localizacao;

    public Sala(String numero, int capacidade, String localizacao) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.localizacao = localizacao;
    }


    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public int getCapacidade() { return capacidade; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}