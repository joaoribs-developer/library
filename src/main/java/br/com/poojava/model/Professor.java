package br.com.poojava.model;

import br.com.poojava.contract.Registravel;

public class Professor extends Pessoa implements Registravel {
    private String departamento;

    public Professor(String nome, String id, String email, String departamento) {
        super(nome, id, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String obterTipo() {
        return "Professor";
    }

    @Override
    public String obterRegistro() {
        return "Professor: " + getNome() + " | Departamento: " + departamento;
    }
}
