/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto02;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *É um HttpServlet focado em mostrar como adicionar linha em uma tabela do html de forma dinamica utilizando um formulario(FormAluno.html) e o ServletContext.
 * 
 * @author Doug
 * @version 1
 * 
 * 
 */
@WebServlet("/Exercicio")
public class Exercicio extends HttpServlet{
    /**
     * N será utilizado por isso n tem implementação
     * 
     * @author Doug
     * @version 1
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * 
     * 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    /**
     * Esse metodo reescrito do doPOst retira as informações de um formulario de aluno e adiciona numa tabela de forma dinamicamente
     * 
     * @author Doug
     * @version 1
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * 
     * 
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("<link rel= " +"stylesheet"+ " href= " +" tabela.css "+">");
        try{
            
            FormularioAluno A = new FormularioAluno();
            A.setNome(req.getParameter("nome"));
            A.setP1(Double.parseDouble(req.getParameter("prova1")));
            A.setTr(Double.parseDouble(req.getParameter("trabalho")));
            A.setPj(Double.parseDouble(req.getParameter("projetoaula")));
            A.setFr(Double.parseDouble(req.getParameter("freq")));
            A.setPf(Double.parseDouble(req.getParameter("pf")));
            String s = situacao(A.getP1(), A.getTr(), A.getPj(),A.getFr(),A.getPf());
            
            A.setSituacao(s);
            
           
            
            
            ServletContext sc = req.getServletContext();
            
            if(sc.getAttribute("ListaAlunos")==null)
            {
                ArrayList<FormularioAluno> tabelaAlunos = new <FormularioAluno>ArrayList();
                tabelaAlunos.add(A);
                sc.setAttribute("ListaAlunos", tabelaAlunos);
            }else{
                ArrayList<FormularioAluno> tabelaAlunos = (ArrayList<FormularioAluno>) sc.getAttribute("ListaAlunos");
                tabelaAlunos.add(A);
                sc.setAttribute("ListaAlunos", tabelaAlunos);
            }
            
      
            
            
             
               
            out.print("<table>");
            
            out.print("<tr>");
                out.print("<th>Aluno</th>");
                out.print("<th>Nota 1</th>");
                out.print("<th>Trabalho</th>");
                out.print("<th>Projetos Sala</th>");
                out.print("<th>Prova Final</th>");
                out.print("<th>Situação</th>");
            out.print("</tr>");
            
            
            
            for(FormularioAluno aluno:(ArrayList<FormularioAluno>) sc.getAttribute("ListaAlunos")){
                
                out.print("<tr>");
                out.print("<td>"+aluno.getNome()+"</td>");
                out.print("<td>"+aluno.getP1()+"</td>");
                out.print("<td>"+aluno.getTr()+"</td>");
                out.print("<td>"+aluno.getPj()+"</td>");
                out.print("<td>"+aluno.getPf()+"</td>");
                out.print("<td>"+aluno.getSituacao()+"</td>");
                out.print("</tr>");
                
            }   
           
           
        }
        catch(NumberFormatException e){
            System.out.println("Erro :" + e);
                    
        }
        
        out.print("</table>");
        out.print("</body>"); 
        out.print("<html>");
        
        
    }
    /**
     * 
     * Metodo que serve para retornar a situação do aluno no final da materia ou seja se foi:
     * aprovado direto ou reprovado direto,aprovado pela prova final,reprovado pela prova final,reprovado por frequencia
     * 
     * @author Doug
     * @version 1
     * 
     * @param p1 Essa é a variavel correspondente a nota da primeira prova
     * @param tr Essa é a variavel correspondente a nota do trabalho em grupo
     * @param pj Essa é a variavel correspondente a nota dos projetos feitos em sala 
     * @param fr Essa é a variavel correspondente a porcentagem da frequencia do aluno
     * @param pf Essa é a variavel correspondente a nota da prova final
     * @return Uma das possiveis strings a seguir:Aprovado Direto,Reprovado Direto,Aprovado Final,Reprovado Final,Reprovado por falta
     */
    
    public String situacao(double p1,double tr,double pj,double fr,double pf){
        double m1 = 0.7*((p1+tr)/2)+pj* 0.3;
       
        if(fr >= 0.75){
           if(m1>= 7) 
               return "Aprovado direto";
           else if (m1 < 3) 
               return "Reprovado direto";
           else{
               //Prova final
               if( ((pf + m1) / 2) >= 5)
                   return "Aprovado final";
               else
                   return "Reprovado final";
               
           }
       }else{
           return "Reprovado por falta";
       }
        
       
    }

}

