package com.company.ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario{

    private String email, curso;
    private ArrayList<Disciplina> disciplinaCursadas = new ArrayList<>();
    private ArrayList<Disciplina> disciplinaCursando = new ArrayList<>();
    private ArrayList<Conteudo> listaConteudo = new ArrayList<>();



    public Aluno(String nome, String prontuario, String email, String curso) {
        super(nome, prontuario);
        this.curso = curso;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void addDisciplinaCursada(Disciplina disciplina) {
        disciplinaCursadas.add(disciplina);
    }
    public void listarDisciplinaCursada() {
        for (Disciplina discplinas: this.disciplinaCursadas) {
            System.out.println(discplinas.getNome());
        }
    }
    public void addDisciplinaCursando(Disciplina disciplina) {
        disciplinaCursando.add(disciplina);
    }
    public void listarDisciplinaCursando() {
        for (Disciplina discplinas: this.disciplinaCursando) {
            System.out.println(discplinas.getNome());
        }
    }

    public void addConteudo(Conteudo conteudo) {
        listaConteudo.add(conteudo);
    }
    public void listarConteudos() {
        for (Conteudo conteudoItem: this.listaConteudo) {
            System.out.println(conteudoItem.toString());
        }
    }

    public static Aluno cadastrarAluno() throws CadastroException{
        Scanner leitura = new Scanner(System.in);

        System.out.print("Nome do Aluno: ");
        String nomeAluno = leitura.nextLine();
        if (nomeAluno.equals(""))
            throw new CadastroException("Você deve digitar um Nome!");
        System.out.print("Prontuário: ");
        String prontuarioAluno = leitura.nextLine();
        if (prontuarioAluno.equals(""))
            throw new CadastroException("Você deve digitar um Prontuário!");
        System.out.print("E-mail: ");
        String emailAluno = leitura.nextLine();
        if (emailAluno.equals(""))
            throw new CadastroException("Você deve digitar um E-mail!");
        System.out.print("Curso: ");
        String cursoAluno = leitura.nextLine();
        if (cursoAluno.equals(""))
            throw new CadastroException("Você deve digitar um Nome!");

        Aluno a = new Aluno(nomeAluno, prontuarioAluno, emailAluno, cursoAluno);

        System.out.println("Aluno cadastrado com sucesso!");

        return a;

    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "  |  " + "Prontuário: " + this.getProntuario() + "  |  " +
                "Email: " + this.getEmail() + "  |  " + "Curso: " + this.getCurso();
    }
}
