// src/main/java/com/hackathon/model/instituicao/Empresa.java
package com.hackathon.model.instituicao;

public class Empresa extends Instituicao {
    private String cnpj;
    private String setor;

    public Empresa(String nome, String endereco, String telefone, String cnpj, String setor) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.setor = setor;
    }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
}