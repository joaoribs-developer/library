package br.com.poojava.model;

import br.com.poojava.contract.Registravel;

public class Livro implements Registravel {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel = true;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (!disponivel) {
            System.out.println("O livro já está emprestado: " + titulo);
            return;
        }
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }

    @Override
    public String obterRegistro() {
        return "ISBN: " + isbn + " | Título: " + titulo;
    }
}
