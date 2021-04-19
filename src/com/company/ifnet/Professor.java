package com.company.ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario{

    private String area;
    private ArrayList<Disciplina> disciplinaMinistrada = new ArrayList<>();



    public Professor(String nome, String prontuario, String area) {
        super(nome, prontuario);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void addDisciplinaMinistrada(Disciplina disciplina) {
        disciplinaMinistrada.add(disciplina);
    }
    public void listarDisciplinaMinistrada() {
        for (Disciplina discplinas: this.disciplinaMinistrada) {
            System.out.println(discplinas.getNome());
        }
    }

    public static Professor cadastrarProfessor() throws CadastroException {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Nome do Professor: ");
        String nomeProfessor = leitura.nextLine();
        if (nomeProfessor.equals("")) {
            throw new CadastroException("Você deve digitar um Nome!");
        } else {
            System.out.print("Prontuário: ");
            String prontuarioProfessor = leitura.nextLine();
            if (prontuarioProfessor.equals("")) {
                throw new CadastroException("Você deve digitar um Prontuário!");
            } else {
                System.out.print("Área: ");
                String areaProfessor = leitura.nextLine();
                if (areaProfessor.equals("")) {
                    throw new CadastroException("Você deve digitar uma Área!");
                } else {
                    Professor p = new Professor(nomeProfessor, prontuarioProfessor, areaProfessor);
                    System.out.println("Professor cadastrado com sucesso!");
                    return p;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "  |  " + "Prontuário: " + this.getProntuario() + "  |  " +
                "Area: " + this.getArea();
    }
}
