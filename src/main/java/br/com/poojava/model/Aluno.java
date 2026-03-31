package br.com.poojava.model;

import br.com.poojava.contract.Registravel;

public class Aluno extends Pessoa implements Registravel {
    private String curso;

    public Aluno(String nome, String id, String email, String curso) {
        super(nome, id, email);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String obterTipo() {
        return "Aluno";
    }

    @Override
    public String obterRegistro() {
        return "Aluno: " + getNome() + " | Curso: " + curso;
    }

    @Override
    public String apresentar(String saudacao) {
        return saudacao + ", " + getNome() + "! Curso: " + curso + ".";
    }
}
