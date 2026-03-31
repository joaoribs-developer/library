package br.com.poojava.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.poojava.model.Emprestimo;
import br.com.poojava.model.Livro;
import br.com.poojava.model.Pessoa;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        if (livro != null) {
            livros.add(livro);
            System.out.println("Livro adicionado: " + livro.getTitulo());
        }
    }

    public List<Livro> listarTodosOsLivros() {
        return Collections.unmodifiableList(livros);
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public boolean emprestarLivro(Livro livro, Pessoa pessoa) {
        if (livro == null || pessoa == null) {
            System.out.println("Empréstimo inválido: livro ou pessoa inexistente.");
            return false;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo: " + livro.getTitulo());
            return false;
        }
        livro.emprestar();
        Emprestimo emprestimo = new Emprestimo(livro, pessoa, LocalDate.now());
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado: " + livro.getTitulo() + " para " + pessoa.getNome());
        return true;
    }

    public boolean emprestarLivro(String isbn, Pessoa pessoa) {
        Optional<Livro> livro = buscarLivroPorIsbn(isbn);
        if (livro.isPresent()) {
            return emprestarLivro(livro.get(), pessoa);
        }
        System.out.println("Livro não encontrado para ISBN: " + isbn);
        return false;
    }

    public boolean devolverLivro(String isbn) {
        Optional<Livro> livro = buscarLivroPorIsbn(isbn);
        if (livro.isPresent()) {
            Livro retorno = livro.get();
            if (!retorno.isDisponivel()) {
                retorno.devolver();
                removerEmprestimo(retorno);
                System.out.println("Livro devolvido: " + retorno.getTitulo());
                return true;
            }
            System.out.println("O livro já estava disponível: " + retorno.getTitulo());
            return false;
        }
        System.out.println("Livro não encontrado para devolução: " + isbn);
        return false;
    }

    private void removerEmprestimo(Livro livro) {
        emprestimos.removeIf(emprestimo -> emprestimo.getLivro().equals(livro));
    }

    public Optional<Livro> buscarLivroPorIsbn(String isbn) {
        return livros.stream()
                .filter(l -> l.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();
    }

    public void mostrarRelatorioEmprestimos() {
        System.out.println("=== Relatório de Empréstimos ===");
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }
}
