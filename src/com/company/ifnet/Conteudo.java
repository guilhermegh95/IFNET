package com.company.ifnet;

public class Conteudo {

    private String tipo;
    private String nome;
    private String codigo;
    private Disciplina discplina;
    //private Area area;

    public Conteudo (String nome, String tipo, Disciplina disciplina, String codigo) {
        this.nome = nome;
        this.tipo = tipo;
        this.discplina = disciplina;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDiscplina() {
        return discplina.toString();
    }

    public void setDiscplina(Disciplina discplina) {
        this.discplina = discplina;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "  |  " + "Tipo: " + this.getTipo() + "  |  " +
                "Disciplina: " + this.discplina.getNome() + "  |  " + "Código: " + this.getCodigo();
    }





}
