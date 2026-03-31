package br.com.poojava.model;

public abstract class Pessoa {
    private String nome;
    private String id;
    private String email;

    public Pessoa(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String apresentar() {
        return "Pessoa: " + nome + " (" + id + ") - " + email;
    }

    public String apresentar(String saudacao) {
        return saudacao + ", " + nome + "! Você está cadastrado como " + obterTipo() + ".";
    }

    public abstract String obterTipo();
}
