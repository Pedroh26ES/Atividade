// src/main/java/com/hackathon/model/pessoa/Estudante.java
package com.hackathon.model.pessoa;
import com.hackathon.model.instituicao.Instituicao;

public class Estudante extends Pessoa {
    private String matricula;
    private String curso;
    private int periodo;

    public Estudante(String nome, String email, String telefone, Instituicao instituicao,
                    String matricula, String curso, int periodo) {
        super(nome, email, telefone, instituicao);
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
    public int getPeriodo() { return periodo; }
    public void setPeriodo(int periodo) { this.periodo = periodo; }
}