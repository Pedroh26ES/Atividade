// src/main/java/com/hackathon/main/Main.java
package com.hackathon;

import com.hackathon.model.pessoa.*;
import com.hackathon.model.instituicao.*;
import com.hackathon.model.*;
import com.hackathon.collection.Equipes;
import com.hackathon.collection.Apresentacoes;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Sistema de Gerenciamento de Hackathon Universitário ===\n");

        var instituicoes = inicializarInstituicoes();

        // Obter instâncias Singleton
        Equipes equipesCollection = Equipes.getInstance();
        Apresentacoes apresentacoesCollection = Apresentacoes.getInstance();

        List<Equipe> equipes = criarEquipes(instituicoes.universidade(), equipesCollection);
        List<Projeto> projetos = criarProjetos(instituicoes.universidade(), equipes);
        List<Banca> bancas = criarBancasAvaliadores(instituicoes, projetos);

        criarApresentacoes(projetos, bancas, apresentacoesCollection);

        realizarAvaliacoes(bancas);

        listarProjetosAprovados(apresentacoesCollection);

        exibirEstatisticas(equipesCollection, apresentacoesCollection);
    }

    private static record Instituicoes(Universidade universidade, Empresa empresa) {
    }

    private static Instituicoes inicializarInstituicoes() {
        Universidade puc = new Universidade("PUC-MG", "Av. Dom José Gaspar, 500",
                "(31) 3319-4444", "PUC001",
                "Luís Henrique Eloy e Silva");

        Empresa techCorp = new Empresa("TechCorp", "Rua das Empresas, 100",
                "(31) 2222-3333", "12.345.678/0001-90", "Tecnologia");

        return new Instituicoes(puc, techCorp);
    }

    private static List<Equipe> criarEquipes(Universidade universidade, Equipes equipesCollection) {
        System.out.println("Criando 2 equipes com 5 alunos cada:");

        Equipe equipe1 = new Equipe("Java");
        adicionarMembrosEquipe1(equipe1, universidade);
        equipesCollection.incluir(equipe1);
        System.out.println(equipe1.getNome() + " criada com " + equipe1.getQuantidadeMembros() + " membros");

        Equipe equipe2 = new Equipe("JavaScript");
        adicionarMembrosEquipe2(equipe2, universidade);
        equipesCollection.incluir(equipe2);
        System.out.println(equipe2.getNome() + " criada com " + equipe2.getQuantidadeMembros() + " membros\n");

        return List.of(equipe1, equipe2);
    }

    private static void adicionarMembrosEquipe1(Equipe equipe, Universidade universidade) {
        equipe.adicionarMembro(new Estudante("Ana Silva", "ana@puc.br", "(31) 99999-1111",
                universidade, "2021001", "Ciência da Computação", 6));
        equipe.adicionarMembro(new Estudante("Bruno Santos", "bruno@puc.br", "(31) 99999-2222",
                universidade, "2021002", "Engenharia de Software", 5));
        equipe.adicionarMembro(new Estudante("Carlos Oliveira", "carlos@puc.br", "(31) 99999-3333",
                universidade, "2021003", "Sistemas de Informação", 4));
        equipe.adicionarMembro(new Estudante("Diana Costa", "diana@puc.br", "(31) 99999-4444",
                universidade, "2021004", "Ciência da Computação", 6));
        equipe.adicionarMembro(new Estudante("Eduardo Lima", "eduardo@puc.br", "(31) 99999-5555",
                universidade, "2021005", "Engenharia de Software", 5));
    }

    private static void adicionarMembrosEquipe2(Equipe equipe, Universidade universidade) {
        equipe.adicionarMembro(new Estudante("Fernanda Rocha", "fernanda@puc.br", "(31) 99999-6666",
                universidade, "2021006", "Ciência da Computação", 7));
        equipe.adicionarMembro(new Estudante("Gabriel Mendes", "gabriel@puc.br", "(31) 99999-7777",
                universidade, "2021007", "Sistemas de Informação", 6));
        equipe.adicionarMembro(new Estudante("Helena Cardoso", "helena@puc.br", "(31) 99999-8888",
                universidade, "2021008", "Engenharia de Software", 5));
        equipe.adicionarMembro(new Estudante("Igor Ferreira", "igor@puc.br", "(31) 99999-9999",
                universidade, "2021009", "Ciência da Computação", 4));
        equipe.adicionarMembro(new Estudante("Julia Barbosa", "julia@puc.br", "(31) 99999-1010",
                universidade, "2021010", "Sistemas de Informação", 6));
    }

    private static List<Projeto> criarProjetos(Universidade universidade, List<Equipe> equipes) {
        System.out.println("Criando projetos diferentes para cada equipe:");

        Profissional orientador1 = new Profissional("Prof. João Silva", "joao@puc.br",
                "(31) 3319-1234", universidade, "Professor", "Inteligência Artificial");
        Profissional orientador2 = new Profissional("Prof. Maria Santos", "maria@puc.br",
                "(31) 3319-5678", universidade, "Professora", "Desenvolvimento Web");

        Projeto projeto1 = new Projeto("Sistema de Gestão Inteligente",
                "Sistema para otimização de recursos usando IA",
                orientador1, equipes.get(0));
        Projeto projeto2 = new Projeto("Plataforma de E-learning Adaptativa",
                "Plataforma educacional que se adapta ao perfil do estudante",
                orientador2, equipes.get(1));

        System.out.println(projeto1.getNome() + " - Equipe: " + projeto1.getEquipe().getNome());
        System.out.println(projeto2.getNome() + " - Equipe: " + projeto2.getEquipe().getNome() + "\n");

        return List.of(projeto1, projeto2);
    }

    private static List<Banca> criarBancasAvaliadores(Instituicoes instituicoes, List<Projeto> projetos) {
        System.out.println("Criando bancas avaliadoras (4 jurados cada):");

        List<Jurado> jurados = criarJurados(instituicoes);

        // Banca 1 - Projeto 1 (primeiros 4 jurados)
        Banca banca1 = new Banca(projetos.get(0));
        for (int i = 0; i < 4; i++) {
            banca1.adicionarJurado(jurados.get(i));
        }

        // Banca 2 - Projeto 2 (ultimos 4 jurados)
        Banca banca2 = new Banca(projetos.get(1));
        for (int i = 4; i < 8; i++) {
            banca2.adicionarJurado(jurados.get(i));
        }

        System.out.println(banca1.getJurados().size() + " jurados - " + projetos.get(0).getNome());
        System.out
                .println(banca2.getJurados().size() + " jurados - " + projetos.get(1).getNome() + "\n");

        return List.of(banca1, banca2);
    }

    private static List<Jurado> criarJurados(Instituicoes instituicoes) {
        return List.of(
                new Jurado("Dr. Pedro Alves", "pedro@techcorp.com", "(31) 88888-1111",
                        instituicoes.empresa(), "CTO", "Arquitetura de Software", "Sistemas Distribuídos"),
                new Jurado("Dra. Lucia Ferreira", "lucia@techcorp.com", "(31) 88888-2222",
                        instituicoes.empresa(), "Gerente de Projetos", "Gestão de TI", "Metodologias Ágeis"),
                new Jurado("Prof. Roberto Costa", "roberto@puc.br", "(31) 3319-9999",
                        instituicoes.universidade(), "Professor Doutor", "Banco de Dados", "Big Data"),
                new Jurado("Dra. Amanda Oliveira", "amanda@techcorp.com", "(31) 88888-3333",
                        instituicoes.empresa(), "Diretora de Inovação", "UX/UI Design", "Experiência do Usuário"),
                new Jurado("Prof. Marcos Silva", "marcos@puc.br", "(31) 3319-8888",
                        instituicoes.universidade(), "Professor", "Redes de Computadores", "Segurança da Informação"),
                new Jurado("Dr. Cristina Lima", "cristina@techcorp.com", "(31) 88888-4444",
                        instituicoes.empresa(), "Tech Lead", "Frontend Development", "React/Angular"),
                new Jurado("Prof. Rafael Santos", "rafael@puc.br", "(31) 3319-7777",
                        instituicoes.universidade(), "Professor", "Inteligência Artificial", "Machine Learning"),
                new Jurado("Dra. Patricia Rocha", "patricia@techcorp.com", "(31) 88888-5555",
                        instituicoes.empresa(), "Product Manager", "Gestão de Produtos", "Product Strategy"));
    }

    private static void criarApresentacoes(List<Projeto> projetos, List<Banca> bancas,
            Apresentacoes apresentacoesCollection) {
        System.out.println("Agendando apresentações:");

        Sala sala1 = new Sala("A101", 50, "Bloco A - 1º Andar");
        Sala sala2 = new Sala("B205", 40, "Bloco B - 2º Andar");

        Apresentacao apresentacao1 = new Apresentacao(projetos.get(0), bancas.get(0), sala1,
                LocalDateTime.now().plusDays(1).withHour(14).withMinute(0));

        Apresentacao apresentacao2 = new Apresentacao(projetos.get(1), bancas.get(1), sala2,
                LocalDateTime.now().plusDays(1).withHour(16).withMinute(0));

        apresentacoesCollection.incluir(apresentacao1);
        apresentacoesCollection.incluir(apresentacao2);

        System.out.println("Apresentação 1: " + apresentacao1.getDataHora());
        System.out.println("Apresentação 2: " + apresentacao2.getDataHora() + "\n");
    }

    private static void realizarAvaliacoes(List<Banca> bancas) {
        System.out.println("Realizando avaliações e calculando notas finais:");

        for (Banca banca : bancas) {
            System.out.println("\n--- Avaliação: " + banca.getProjeto().getNome() + " ---");

            for (Jurado jurado : banca.getJurados()) {
                int nota = 5 + random.nextInt(6); // Notas entre 5 e 10 para testes
                banca.atribuirNota(jurado, nota);
                System.out.println("   " + jurado.getNome() + " → Nota: " + nota);
            }

            double notaFinal = banca.calcularNotaFinal();
            System.out.printf("Nota Final: %.2f%n", notaFinal);
        }
        System.out.println();
    }

    private static void listarProjetosAprovados(Apresentacoes apresentacoesCollection) {
        System.out.println("=== PROJETOS APROVADOS (Nota >= 7.0) Usando Stream ===");

        List<Apresentacao> projetosAprovados = apresentacoesCollection.listarTodas()
                .stream()
                .filter(apresentacao -> apresentacao.getProjeto().getNotaFinal() >= 7.0)
                .toList();

        if (projetosAprovados.isEmpty()) {
            System.out.println("Nenhum projeto foi aprovado com nota >= 7.0");
        } else {
            projetosAprovados.forEach(apresentacao -> {
                Projeto projeto = apresentacao.getProjeto();
                System.out.printf("%s - Nota: %.2f - Equipe: %s%n",
                        projeto.getNome(),
                        projeto.getNotaFinal(),
                        projeto.getEquipe().getNome());
            });
        }
        System.out.println();
    }

    private static void exibirEstatisticas(Equipes equipesCollection, Apresentacoes apresentacoesCollection) {
        System.out.println("=== ESTATISTICAS FINAIS ===");
        System.out.println("Total de equipes: " + equipesCollection.getQuantidade());
        System.out.println("Total de apresentações: " + apresentacoesCollection.getQuantidade());

        long projetosAprovados = apresentacoesCollection.listarTodas()
                .stream()
                .filter(apresentacao -> apresentacao.getProjeto().getNotaFinal() >= 7.0)
                .count();

        System.out.println("Projetos aprovados: " + projetosAprovados);

        double mediaGeral = apresentacoesCollection.listarTodas()
                .stream()
                .mapToDouble(apresentacao -> apresentacao.getProjeto().getNotaFinal())
                .average()
                .orElse(0.0);

        System.out.printf("media geral das notas: %.2f%n", mediaGeral);
        System.out.println("\n=== FIM DO SISTEMA ===");
    }
}