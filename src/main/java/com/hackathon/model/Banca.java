// src/main/java/com/hackathon/model/Banca.java
package com.hackathon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hackathon.model.pessoa.Jurado;
import java.util.HashMap;

public class Banca implements Avaliavel {
    private static final int MAX_JURADOS = 4;
    private static final int NOTA_MINIMA = 0;
    private static final int NOTA_MAXIMA = 10;
    
    private final List<Jurado> jurados;
    private final Projeto projeto;
    private final Map<Jurado, Integer> notas;

    public Banca(Projeto projeto) {
        if (projeto == null) {
            throw new IllegalArgumentException("Projeto não pode ser nulo");
        }
        this.projeto = projeto;
        this.jurados = new ArrayList<>();
        this.notas = new HashMap<>();
    }

    public void adicionarJurado(Jurado jurado) {
        if (jurado == null) {
            throw new IllegalArgumentException("Jurado não pode ser nulo");
        }
        if (jurados.size() >= MAX_JURADOS) {
            throw new IllegalStateException("Banca já possui o máximo de " + MAX_JURADOS + " jurados");
        }
        if (jurados.contains(jurado)) {
            throw new IllegalStateException("Jurado já está na banca");
        }
        jurados.add(jurado);
    }

    public void atribuirNota(Jurado jurado, int nota) {
        if (!jurados.contains(jurado)) {
            throw new IllegalArgumentException("Jurado não pertence a esta banca");
        }
        if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA) {
            throw new IllegalArgumentException("Nota deve estar entre " + NOTA_MINIMA + " e " + NOTA_MAXIMA);
        }
        notas.put(jurado, nota);
    }

    public double calcularNotaFinal() {
        if (notas.size() != jurados.size()) {
            throw new IllegalStateException("Nem todos os jurados atribuíram notas");
        }

        double soma = notas.values().stream().mapToInt(Integer::intValue).sum();
        double media = soma / notas.size();
        projeto.setNotaFinal(media);
        return media;
    }

    @Override
    public void avaliar() {
        System.out.println("Banca está avaliando o projeto: " + projeto.getNome());
    }

    public List<Jurado> getJurados() {
        return new ArrayList<>(jurados);
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Map<Jurado, Integer> getNotas() {
        return new HashMap<>(notas);
    }
    
    public boolean todasNotasAtribuidas() {
        return notas.size() == jurados.size();
    }
}