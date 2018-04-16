/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto02;

/**
 * Classe Aluno que armazena o seu nome,primeira prova,nota do trabalho em grupo,nota do projeto individual em sala,a frequencia do aluno,nota da prova final
 * 
 * @author Andre
 * 
 * @version 1
 * 
 */
public class FormularioAluno {
    
    private String nome;
    private double p1;
    private double tr;
    private double pj;
    private double fr;
    private double pf;
    private String situacao;

    public String getNome() {
        return nome;
    }

    public String getSituacao() {
        return situacao;
    }
    
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getTr() {
        return tr;
    }

    public void setTr(double tr) {
        this.tr = tr;
    }

    public double getPj() {
        return pj;
    }

    public void setPj(double pj) {
        this.pj = pj;
    }

    public double getFr() {
        return fr;
    }

    public void setFr(double fr) {
        this.fr = fr;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }
    /**
     * Metodo que mostra pelo terminal as informações do aluno
     * 
     * @author Doug
     * @version 1
     * 
     * 
     */
    
    public void mostra(){
        System.out.println("Nome do aluno: "+this.nome);
        System.out.println("Prova 1: "+this.p1);
        System.out.println("Trabalho: "+this.tr);
        System.out.println("Projeto: "+this.pj);
        System.out.println("Frequencia: "+this.fr);
        System.out.println("Prova final: "+this.pf);
        System.out.println("Situação:"+this.situacao);
        
        
        
    }
    
}
