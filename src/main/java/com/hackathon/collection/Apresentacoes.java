// src/main/java/com/hackathon/collection/Apresentacoes.java
package com.hackathon.collection;

import com.hackathon.model.Apresentacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Apresentacoes {
    private static Apresentacoes instance;
    private final List<Apresentacao> apresentacoes;

    private Apresentacoes() {
        this.apresentacoes = new ArrayList<>();
    }

    public static synchronized Apresentacoes getInstance() {
        if (instance == null) {
            instance = new Apresentacoes();
        }
        return instance;
    }

    public void incluir(Apresentacao apresentacao) {
        if (apresentacao == null) {
            throw new IllegalArgumentException("Apresentação não pode ser nula");
        }
        if (pesquisar(apresentacao.getProjeto().getNome()) != null) {
            throw new IllegalStateException("Já existe uma apresentação para o projeto: " + 
                                          apresentacao.getProjeto().getNome());
        }
        apresentacoes.add(apresentacao);
    }

    public Apresentacao pesquisar(String nomeProjeto) {
        if (nomeProjeto == null || nomeProjeto.trim().isEmpty()) {
            return null;
        }
        return apresentacoes.stream()
                .filter(apresentacao -> apresentacao.getProjeto().getNome().equalsIgnoreCase(nomeProjeto.trim()))
                .findFirst()
                .orElse(null);
    }

    public Optional<Apresentacao> pesquisarOptional(String nomeProjeto) {
        return Optional.ofNullable(pesquisar(nomeProjeto));
    }

    public List<Apresentacao> listarTodas() {
        return new ArrayList<>(apresentacoes);
    }

    public int getQuantidade() {
        return apresentacoes.size();
    }
    
    public List<Apresentacao> listarAprovadas(double notaMinima) {
        return apresentacoes.stream()
                .filter(apresentacao -> apresentacao.getProjeto().getNotaFinal() >= notaMinima)
                .toList();
    }
}