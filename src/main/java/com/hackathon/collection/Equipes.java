// src/main/java/com/hackathon/collection/Equipes.java
package com.hackathon.collection;

import com.hackathon.model.Equipe;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Equipes {
    private static Equipes instance;
    private final List<Equipe> equipes;

    private Equipes() {
        this.equipes = new ArrayList<>();
    }

    public static synchronized Equipes getInstance() {
        if (instance == null) {
            instance = new Equipes();
        }
        return instance;
    }

    public void incluir(Equipe equipe) {
        if (equipe == null) {
            throw new IllegalArgumentException("Equipe não pode ser nula");
        }
        if (pesquisar(equipe.getNome()) != null) {
            throw new IllegalStateException("Já existe uma equipe com o nome: " + equipe.getNome());
        }
        equipes.add(equipe);
    }

    public Equipe pesquisar(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }
        return equipes.stream()
                .filter(equipe -> equipe.getNome().equalsIgnoreCase(nome.trim()))
                .findFirst()
                .orElse(null);
    }

    public Optional<Equipe> pesquisarOptional(String nome) {
        return Optional.ofNullable(pesquisar(nome));
    }

    public List<Equipe> listarTodas() {
        return new ArrayList<>(equipes);
    }

    public int getQuantidade() {
        return equipes.size();
    }
    
    public boolean remover(String nome) {
        return equipes.removeIf(equipe -> equipe.getNome().equalsIgnoreCase(nome));
    }
}