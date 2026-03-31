package br.com.poojava.model;

import java.time.LocalDate;

public class Emprestimo {
    private final Livro livro;
    private final Pessoa pessoa;
    private final LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, Pessoa pessoa, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "livro=" + livro.obterRegistro() +
                ", pessoa=" + pessoa.apresentar() +
                ", dataEmprestimo=" + dataEmprestimo +
                '}';
    }
}
