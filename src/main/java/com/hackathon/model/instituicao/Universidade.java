// src/main/java/com/hackathon/model/instituicao/Universidade.java
package com.hackathon.model.instituicao;

public class Universidade extends Instituicao {
    private String codigo;
    private String reitor;

    public Universidade(String nome, String endereco, String telefone, String codigo, String reitor) {
        super(nome, endereco, telefone);
        this.codigo = codigo;
        this.reitor = reitor;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getReitor() { return reitor; }
    public void setReitor(String reitor) { this.reitor = reitor; }
}