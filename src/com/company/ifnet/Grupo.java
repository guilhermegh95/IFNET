package com.company.ifnet;

import java.util.ArrayList;

public class Grupo {
    private String nome, tipoGrupo;
    private ArrayList<Aluno> alunoLista = new ArrayList<>();
    private ArrayList<Disciplina> disciplinaLista = new ArrayList<>();

    public Grupo(String nome, String tipoGrupo){
        this.nome = nome;
        this.tipoGrupo = tipoGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public void getAlunoLista() {
        for (Aluno alunoItem: alunoLista) {
            System.out.println(alunoItem.toString());
        }
    }

    public void addAluno (Aluno aluno) {
        alunoLista.add(aluno);
    }

    public void getDisciplinaLista() {
        for (Disciplina disciplinaItem: disciplinaLista) {
            System.out.println(disciplinaItem.toString());
        };
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinaLista.add(disciplina);
    }
}
