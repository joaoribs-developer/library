# Projeto de POO em Java - Biblioteca Escolar

## Tema do algoritmo
Sistema de Biblioteca Escolar com empréstimo de livros para alunos e professores.

## Descrição do problema
O algoritmo resolve o problema de controle de empréstimos de livros em uma biblioteca escolar, permitindo cadastrar livros, realizar empréstimos, devolver livros e gerar um relatório de empréstimos ativos.

## Organização do projeto
O projeto foi organizado em pacotes por responsabilidade:

- `br.com.poojava.app` - classe principal de execução
- `br.com.poojava.service` - lógica de negócio e gerenciamento de empréstimos
- `br.com.poojava.model` - entidades de domínio (Livro, Pessoa, Aluno, Professor, Emprestimo)
- `br.com.poojava.contract` - interfaces e contratos de serviço

## Classes criadas

### Livro
- Atributos: `titulo`, `autor`, `isbn`, `disponivel`
- Métodos: `emprestar()`, `devolver()`, `getTitulo()`, `getAutor()`, `getIsbn()`, `isDisponivel()`, `obterRegistro()`
- Relação: `Livro` implementa a interface `Registravel`

### Pessoa (abstract)
- Atributos: `nome`, `id`, `email`
- Métodos: `apresentar()`, `apresentar(String saudacao)`, `obterTipo()`
- Relação: base para `Aluno` e `Professor`

### Aluno
- Atributos: `curso`
- Métodos: `obterRegistro()`, `apresentar(String saudacao)` (sobrescrito)
- Relação: estende `Pessoa` e implementa `Registravel`

### Professor
- Atributos: `departamento`
- Métodos: `obterRegistro()`
- Relação: estende `Pessoa` e implementa `Registravel`

### Biblioteca
- Atributos: `livros`, `emprestimos`
- Métodos: `adicionarLivro()`, `listarTodosOsLivros()`, `listarLivrosDisponiveis()`, `emprestarLivro(Livro, Pessoa)`, `emprestarLivro(String, Pessoa)`, `devolverLivro(String)`, `buscarLivroPorIsbn()`, `mostrarRelatorioEmprestimos()`
- Relação: gerencia objetos `Livro`, `Pessoa` e `Emprestimo`

### Emprestimo
- Atributos: `livro`, `pessoa`, `dataEmprestimo`
- Métodos: `toString()`
- Relação: registra a associação entre `Livro` e `Pessoa`

### Registravel
- Método: `obterRegistro()`
- Relação: contrato para gerar texto descritivo de registro em `Livro`, `Aluno` e `Professor`

## Conceitos de POO aplicados
- Classes e objetos: `Livro`, `Pessoa`, `Aluno`, `Professor`, `Biblioteca`, `Emprestimo`
- Encapsulamento: campos privados com getters e setters
- Herança: `Aluno` e `Professor` estendem `Pessoa`
- Interface: `Registravel` implementada por `Livro`, `Aluno` e `Professor`
- Sobrescrita: `toString()` em `Livro` e `apresentar(String saudacao)` em `Aluno`
- Sobrecarga: `emprestarLivro(Livro, Pessoa)` e `emprestarLivro(String, Pessoa)` em `Biblioteca`

## Execução
Execute o projeto com Maven:

```bash
cd base_path\poo-java
mvn compile exec:java
```

O `pom.xml` já aponta para a classe principal:
`br.com.poojava.app.BibliotecaApp`

## Integrantes
- João Vitor Ribeiro da Silva
