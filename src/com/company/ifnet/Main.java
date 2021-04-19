package com.company.ifnet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<Aluno> aluno = new ArrayList<>();
        ArrayList<Professor> professor = new ArrayList<>();
        ArrayList<Disciplina> disciplina = new ArrayList<>();
        ArrayList<Conteudo> conteudo = new ArrayList<>();

        Aluno aluno1 = new Aluno("João", "123456", "joao@email.com", "ADS");
        Aluno aluno2 = new Aluno("Ana", "123457", "ana@email.com", "Matemática");
        Aluno aluno3 = new Aluno("Maria", "123458", "maria@email.com", "Engenharia");
        Aluno aluno4 = new Aluno("Carlos", "123459", "carlos@email.com", "ADS");
        Aluno aluno5 = new Aluno("Pedro", "123460", "pedro@email.com", "Matemática");
        aluno.add(aluno1);
        aluno.add(aluno2);
        aluno.add(aluno3);
        aluno.add(aluno4);
        aluno.add(aluno5);

        Professor professor1 = new Professor("Rosalvo", "654321", "Tecnologia");
        Professor professor2 = new Professor("Flávio", "654320", "Tecnologia");
        Professor professor3 = new Professor("Emílio", "654319", "Tecnologia");
        Professor professor4 = new Professor("Eliane", "654318", "Humanas");
        Professor professor5 = new Professor("Guemael", "654317", "Exatas");
        professor.add(professor1);
        professor.add(professor2);
        professor.add(professor3);
        professor.add(professor4);
        professor.add(professor5);

        Disciplina Calculo1 = new Disciplina("Calculo1", "Exatas", "CA1");
        Disciplina BancoDeDados = new Disciplina("Banco de dados", "Tecnologia", "BD1");
        Disciplina LP = new Disciplina("Linguagem de programação 3", "Tecnologia", "LP3");
        Disciplina InglesTecnico = new Disciplina("inglesTecnico", "Humanas", "ING");
        Disciplina CA2 = new Disciplina("Calculo2", "Exatas", "CA2");
        disciplina.add(Calculo1);
        disciplina.add(BancoDeDados);
        disciplina.add(LP);
        disciplina.add(InglesTecnico);
        disciplina.add(CA2);

        Conteudo Livro1 = new Conteudo("Introducao a Calculo","Livro", Calculo1, "INTCA01");
        Conteudo Livro2 = new Conteudo("JAVA POO","Livro", LP, "JAVA1");
        Conteudo Artigo1 = new Conteudo("VERBO TO BE","Artigo", InglesTecnico, "TOBE01");
        Conteudo Artigo2 = new Conteudo("Algoritimos","Artigo", LP, "ALG01");
        Conteudo Apostila = new Conteudo("Calculo Varias Variaveis","Apostila", CA2, "CVV1");
        conteudo.add(Livro1);
        conteudo.add(Livro2);
        conteudo.add(Artigo1);
        conteudo.add(Artigo2);
        conteudo.add(Apostila);



        Scanner leitura = new Scanner(System.in);

        int opcaoPrincipal;
        boolean opcao = true;
        String prontuario;

        while (opcao){
            try {
                opcao = true;
                menuPrincipal();
                opcaoPrincipal = Integer.parseInt((leitura.nextLine()));

                do {

                    switch (opcaoPrincipal) {

                        case 1:
                            limpaTela();
                            menuAdmin();
                            int opcaoAdmin = Integer.parseInt(leitura.nextLine());

                            switch (opcaoAdmin) {
                                case 0:
                                    limpaTela();
                                    break;
                                //MENU DE CADASTRO DO ADMIN
                                case 1:
                                    limpaTela();
                                    menuCadastro();
                                    int opcaoCadastro = Integer.parseInt(leitura.nextLine());
                                    switch (opcaoCadastro) {
                                        case 0:
                                            limpaTela();
                                            break;
                                        //CADASTRO DE ALUNOS
                                        case 1:
                                            limpaTela();
                                            try{
                                                aluno.add(Aluno.cadastrarAluno());
                                            }catch (CadastroException e){
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        //CADASTRO DE PROFESSORES
                                        case 2:
                                            limpaTela();
                                            try{
                                                professor.add(Professor.cadastrarProfessor());
                                            }catch (CadastroException e){
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        //CADASTRO DE DISCIPLINAS
                                        case 3:
                                            limpaTela();
                                            try {
                                                disciplina.add(Disciplina.cadastrarDisciplina());
                                            }catch (CadastroException e){
                                                System.out.println(e.getMessage());
                                            }
                                            break;
                                        default:
                                            limpaTela();
                                            System.err.println("Opção inválida!");
                                            break;
                                    }
                                    break;

                                //MENU DE EXCLUSÃO DO ADMIN
                                case 2:
                                    limpaTela();
                                    menuExcluir();
                                    int opcaoExcluir = Integer.parseInt(leitura.nextLine());
                                    switch (opcaoExcluir) {
                                        case 0:
                                            limpaTela();
                                            break;
                                        //EXCLUSÃO DE ALUNO
                                        case 1:
                                            limpaTela();
                                            int numEscolhidoAluno;
                                            System.out.print("Informe o número do Aluno a ser excluído: \n\n");
                                            listarAluno(aluno);
                                            System.out.print("Número: ");
                                            numEscolhidoAluno = Integer.parseInt(leitura.nextLine());
                                            aluno.remove(numEscolhidoAluno);
                                            System.out.println("Aluno excluído com sucesso!");
                                            break;
                                        //EXCLUSÃO DE PROFESSOR
                                        case 2:
                                            limpaTela();
                                            int indexP = 0, numEscolhidoProf;
                                            System.out.print("Informe o número do Professor a ser excluído: \n\n");
                                            listarProfessor(professor);
                                            System.out.print("Número: ");
                                            numEscolhidoProf = Integer.parseInt(leitura.nextLine());
                                            professor.remove(numEscolhidoProf);
                                            System.out.println("Professor excluído com sucesso!");
                                            break;
                                        //EXCLUSÃO DE DISCIPLINA
                                        case 3:
                                            limpaTela();
                                            int indexD = 0, numEscolhidoDisc;
                                            System.out.print("Informe o número da Disciplina a ser excluída: \n\n");
                                            listarDisciplina(disciplina);
                                            System.out.print("Número: ");
                                            numEscolhidoDisc = Integer.parseInt(leitura.nextLine());
                                            disciplina.remove(numEscolhidoDisc);
                                            System.out.println("Disciplina excluída com sucesso!");
                                            break;
                                        default:
                                            limpaTela();
                                            System.err.println("Opção inválida!");
                                            break;
                                    }
                                    break;

                                //MENU DE EXIBIÇÃO DO ADMIN
                                case 3:
                                    limpaTela();
                                    menuListar();
                                    int opcaoListar = Integer.parseInt(leitura.nextLine());
                                    switch (opcaoListar) {
                                        case 0:
                                            limpaTela();
                                            break;
                                        //EXIBIÇÃO DA LISTA DE ALUNOS
                                        case 1:
                                            limpaTela();
                                            System.out.println("Alunos cadastrados\n");
                                            listarAluno(aluno);
                                            break;
                                        //EXIBIÇÃO DA LISTA DE PROFESSORES
                                        case 2:
                                            limpaTela();
                                            System.out.println("Professores cadastrados\n");
                                            listarProfessor(professor);
                                            break;
                                        //EXIBIÇÃO DA LISTA DE DISCIPLINAS
                                        case 3:
                                            limpaTela();
                                            System.out.println("Disciplinas cadastradas\n");
                                            listarDisciplina(disciplina);
                                            break;
                                        default:
                                            limpaTela();
                                            System.err.println("Opção inválida!");
                                            break;
                                    }
                                    break;
                                default:
                                    limpaTela();
                                    System.err.println("Opção inválida!");
                                    break;
                            }
                            break;

                        case 2:
                            System.out.println("Escreva seu prontuário");
                            prontuario = leitura.nextLine();
                            int indexAluno = 0;
                            for (Aluno alunoCadastrado: aluno) {
                                if (prontuario.equals(alunoCadastrado.getProntuario())) {
                                    System.out.println(alunoCadastrado.toString());
                                    indexAluno = aluno.indexOf(alunoCadastrado);
                                }
                            }
                            aluno.get(indexAluno).toString();
                            limpaTela();
                            menuAluno();
                            int opcaoAluno = Integer.parseInt(leitura.nextLine());
                            switch (opcaoAluno) {
                                case 0:
                                    //Sair
                                    System.out.println("Caso 0");
                                    break;
                                case 1:
                                    listarDisciplina(disciplina);
                                    System.out.println("Digite o código da disciplina que deseja adionar a lista de Disciplinas cursadas: ");
                                    String codigo = leitura.nextLine();
                                    int indexDisciplinaCursada = 0;
                                    for (Disciplina disciplinaItem: disciplina) {
                                        if (codigo.equals(disciplinaItem.getCodigo())) {
                                            System.out.println(disciplinaItem.getNome());
                                            indexDisciplinaCursada = disciplina.indexOf(disciplinaItem);
                                        }
                                    }
                                    aluno.get(indexAluno).addDisciplinaCursada(disciplina.get(indexDisciplinaCursada));
                                    break;
                                case 2:
                                    listarDisciplina(disciplina);
                                    System.out.println("Digite o código da disciplina que deseja adionar a lista de Disciplinas cursadas: ");
                                    String codigoCursada = leitura.nextLine();
                                    int indexDisciplinaCursando = 0;
                                    for (Disciplina disciplinaItem: disciplina) {
                                        if (codigoCursada.equals(disciplinaItem.getCodigo())) {
                                            System.out.println(disciplinaItem.getNome());
                                            indexDisciplinaCursando = disciplina.indexOf(disciplinaItem);
                                        }
                                    }
                                    aluno.get(indexAluno).addDisciplinaCursando(disciplina.get(indexDisciplinaCursando));
                                    break;
                                case 3:
                                    aluno.get(indexAluno).listarDisciplinaCursada();
                                    System.out.println("Caso 3");
                                    break;
                                case 4:
                                    //Listar disciplina que está sendo cursada
                                    aluno.get(indexAluno).listarDisciplinaCursando();
                                    break;
                                case 5:
                                    //Adicionar conteúdo
                                    listarConteudo(conteudo);
                                    System.out.println("Digite o código do conteúdo que deseja adionar: ");
                                    String codigoConteudo = leitura.nextLine();
                                    int indexConteudo = 0;
                                    for (Conteudo conteudoItem : conteudo) {
                                        if (codigoConteudo.equals(conteudoItem.getCodigo())) {
                                            System.out.println(conteudoItem.getNome());
                                            indexConteudo = conteudo.indexOf(conteudoItem);
                                        }
                                    }
                                    aluno.get(indexAluno).addConteudo(conteudo.get(indexConteudo));
                                    break;
                                case 6:
                                    aluno.get(indexAluno).listarConteudos();
                                    //System.out.println("Caso 6");
                                    break;

                            }
                            break;

                        case 3:
                            System.out.println("Escreva seu prontuário");
                            prontuario = leitura.nextLine();
                            int indexProfessor = 0;
                            // Inserir Logica para saber qual aluno será usado
                            for (Professor professorCadastrado: professor) {
                                if (prontuario.equals(professorCadastrado.getProntuario())) {
                                    System.out.println(professorCadastrado.toString());
                                    indexProfessor = professor.indexOf(professorCadastrado);
                                }
                            }
                            professor.get(indexProfessor).toString();
                            limpaTela();
                            menuProfessor();
                            int opcaoProfessor = Integer.parseInt(leitura.nextLine());
                            switch (opcaoProfessor) {
                                case 0:
                                    // sair
                                    System.out.println("Caso 0");
                                    break;
                                case 1:
                                    //Criar grupo
                                    System.out.println("Caso 1");
                                    break;
                                case 2:
                                    listarDisciplina(disciplina);
                                    System.out.println("Digite o código da disciplina que deseja adionar a lista de Disciplinas ministradas: ");
                                    String codigo = leitura.nextLine();
                                    int indexDisciplinaMinistrada = 0;
                                    for (Disciplina disciplinaItem: disciplina) {
                                        if (codigo.equals(disciplinaItem.getCodigo())) {
                                            System.out.println(disciplinaItem.getNome());
                                            indexDisciplinaMinistrada = disciplina.indexOf(disciplinaItem);
                                        }
                                    }
                                    professor.get(indexProfessor).addDisciplinaMinistrada(disciplina.get(indexDisciplinaMinistrada));
                                    break;
                                case 3:
                                    limpaTela();
                                    System.out.println("Alunos cadastrados\n");
                                    listarAluno(aluno);
                                    break;
                                case 4:
                                    limpaTela();
                                    //Listar disciplina(s) ministrada(s)
                                    professor.get(indexProfessor).listarDisciplinaMinistrada();
                                    break;
                                case 5:
                                    // criar conteúdo
                                    System.out.println("Caso 5");
                                    break;
                                case 6:
                                    // excluir disciplina ministrada
                                    System.out.println("Caso 6");
                                    break;

                            }
                            break;
                    }
                    break;
                } while (opcaoPrincipal != 0);

            }catch (NumberFormatException e){
                System.out.println("Você deve informar um número! Reinicie o programa e informe um número.");
                opcao = false;
            }
        }




        leitura.close();
    }

    public static boolean numberOrNot(int input){
        try {
            Integer.parseInt(String.valueOf(input));
        }catch (NumberFormatException e){
            System.out.println("Você precisa informar um número!");
            return false;
        }
        return true;
    }

    public static void menuPrincipal() {
        //limpaTela();
        System.out.println( "---------- Informe um número do Menu ----------\n\n" +
                "1) Admin\n" +
                "2) Aluno\n" +
                "3) Professor\n" );
        System.out.print("Informe um número: ");
    }

    public static void menuAdmin() {
        limpaTela();
        System.out.println( "        ---------- Menu Admin ----------\n\n"+
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Cadastro\n" +
                "2) Deletar\n" +
                "3) Lista de Cadastro\n" +
                "0) Sair\n");

        System.out.print("Informe um número: ");
    }

    public static void menuCadastro() {
        limpaTela();
        //MENU PARA CADASTRAR OBJETOS NAS RESPECTIVAS ARRAYLIST'S
        System.out.println("    ---------- Menu de Cadastro ----------\n\n" +
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Cadastro de Aluno\n" +
                "2) Cadastro de Professor\n" +
                "3) Cadastro de Disciplina\n" +
                "0) Retornar ao Menu Anterior\n");
            System.out.print("Informe um número: ");
    }

    public static void menuExcluir() {
        limpaTela();
        //MENU PARA EXCLUIR OBJETOS DAS RESPECTIVAS ARRAYLIST'S
        System.out.println("   ---------- Menu de Exclusão ----------\n\n" +
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Deletar Aluno\n" +
                "2) Deletar Professor\n" +
                "3) Deletar Disciplina\n" +
                "0) Retornar ao Menu Anterior\n");
        System.out.print("Informe um número: ");
    }

    public static void menuListar() {
        limpaTela();
        //MENU PARA EXIBIR OBJETOS DAS RESPECTIVAS ARRAYLIST'S
        System.out.println("   ---------- Menu de Exibição ----------\n\n" +
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Listar Aluno(s)\n" +
                "2) Listar Professor(es)\n" +
                "3) Listar Disciplina(s)\n" +
                "0) Retornar ao Menu Anterior\n");
        System.out.print("Informe um número: ");
    }

    public static void menuAluno() {
        limpaTela();
        System.out.println("    ---------- Menu do Aluno ----------\n\n" +
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Adicionar disciplina cursada\n" +
                "2) Adicionar disciplina que está sendo cursada atualmente\n" +
                "3) Listar Disciplinas Cursadas\n" +
                "4) Listar Disciplinas Cursando\n" +
                "5) Adicionar conteúdo\n" +
                "6) Listar conteúdo\n" +
                "0) Sair\n");
        System.out.print("Informe um número: ");
    }
    public static void menuProfessor() {
        limpaTela();
        System.out.println("   ---------- Menu de Professor ----------\n\n" +
                "---------- Informe um número do Menu ----------\n\n" +
                "1) Criar grupo\n" +
                "2) Adicionar disciplinas ministradas\n" +
                "3) Listar Aluno(s)\n" +
                "4) Listar Disciplina(s) Ministradas(is)\n" +
                "5) Criar conteúdo(s)\n" +
                "6) Excluir Disciplina(s) Ministrada(s)\n" +
                "0) Sair\n");
        System.out.print("Informe um número: ");
    }
    public static void limpaTela(){
        System.out.println("\n\n\n");
    }

    public static void listarDisciplina(ArrayList<Disciplina> disciplina) {
        int CountDisciplinaCursada = 0;
        for(Disciplina disciplinaCursada : disciplina) {
            System.out.println((CountDisciplinaCursada++) + " - " + disciplinaCursada.toString());
        }
        System.out.println("\n\n");
    }
    public static void listarAluno(ArrayList<Aluno> alunos) {
        int Count = 0;
        for(Aluno alunoItem : alunos) {
            System.out.println((Count++) + " - " + alunoItem.toString());
        }
        System.out.println("\n\n");
    }

    public static void listarProfessor(ArrayList<Professor> professores) {
        int Count = 0;
        for(Professor professorItem : professores) {
            System.out.println((Count++) + " - " + professorItem.toString());
        }
        System.out.println("\n\n");
    }

    public static void listarConteudo(ArrayList<Conteudo> conteudos){
        int Count = 0;
        for (Conteudo conteudoItem : conteudos){
            System.out.println((Count++) + " - " + conteudoItem.toString());
        }
        System.out.println("\n\n");
    }

}
