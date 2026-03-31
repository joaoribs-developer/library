package br.com.poojava.app;

import br.com.poojava.model.Aluno;
import br.com.poojava.model.Livro;
import br.com.poojava.model.Pessoa;
import br.com.poojava.model.Professor;
import br.com.poojava.service.Biblioteca;

public class BibliotecaApp {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Livro livro1 = new Livro("Aprendendo Java", "Cláudio Silva", "978-85-11111-11-1");
        Livro livro2 = new Livro("Programação Orientada a Objetos", "Ana Oliveira", "978-85-22222-22-2");
        Livro livro3 = new Livro("Estruturas de Dados", "Rita Souza", "978-85-33333-33-3");

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        Pessoa aluno = new Aluno("Mariana Ramos", "A001", "mariana@escola.com", "Ciência da Computação");
        Pessoa professor = new Professor("Lorena Piza Arndt do Nascimento", "P001", "lorena@escola.com", "Computação Aplicada");

        System.out.println("=== Sistema de Biblioteca Escolar ===\n");
        System.out.println(aluno.apresentar());
        System.out.println(professor.apresentar("Olá"));
        System.out.println();

        System.out.println("Livros cadastrados:");
        biblioteca.listarTodosOsLivros().forEach(System.out::println);
        System.out.println();

        System.out.println("Primeiros empréstimos:");
        biblioteca.emprestarLivro("978-85-11111-11-1", aluno);
        biblioteca.emprestarLivro(livro2, professor);
        System.out.println();

        System.out.println("Livros disponíveis após os primeiros empréstimos:");
        biblioteca.listarLivrosDisponiveis().forEach(System.out::println);
        System.out.println();

        System.out.println("Relatório de empréstimos atual:");
        biblioteca.mostrarRelatorioEmprestimos();
        System.out.println();

        System.out.println("Tentativa de empréstimo repetido (livro já emprestado):");
        biblioteca.emprestarLivro("978-85-11111-11-1", professor);
        System.out.println();

        System.out.println("Devolução de um livro e novo empréstimo:");
        biblioteca.devolverLivro("978-85-11111-11-1");
        biblioteca.emprestarLivro("978-85-11111-11-1", professor);
        System.out.println();

        System.out.println("Relatório de empréstimos após devolução e novo empréstimo:");
        biblioteca.mostrarRelatorioEmprestimos();
        System.out.println();

        System.out.println("Tentando devolver livro já disponível:");
        biblioteca.devolverLivro("978-85-33333-33-3");
        System.out.println();

        System.out.println("Lista final de livros disponíveis:");
        biblioteca.listarLivrosDisponiveis().forEach(System.out::println);
        System.out.println();

        System.out.println("Relatório final de empréstimos:");
        biblioteca.mostrarRelatorioEmprestimos();
    }
}
