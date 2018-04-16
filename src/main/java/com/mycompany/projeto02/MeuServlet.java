/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Minha classe HTTP com doGet e doPost que mostra como usar o ServletContext e o GetDispacher utilizando os seguintes html:
 * O meuFormulario.html,Erro.html,Login.html,Logout.html
 * 
 * @author Doug
 * 
 * @version: 1
 * 
 * 
 */
@WebServlet("/MeuServlet")
public class MeuServlet extends HttpServlet{
    
    /**
    *@author Doug
    *@version: 1
    * Construtor padrão.
    */
    public MeuServlet(){
        System.out.println("construtor");
    }
     /**
     * Metodo que mostra no console uma palavra "init"
     * 
     * @author Doug
     * 
     *@throws javax.servlet.ServletException
     * 
     *@version: 1
     * 
     * 
     */
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

    /**
     * Metodo que utiliza o ServertContext para contar quantas vezes esse servlet foi acessado.
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     * 
     *
     */
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
        
      
       //Trabalhando com servlet context criando variavel contador global(funciona em varios servlets)
        ServletContext ex = req.getServletContext();
        if(ex.getAttribute("contador")==null) {
                ex.setAttribute("contador", 1);
        }
        else {
                Integer contador = (Integer)ex.getAttribute("contador");
                contador++;
                ex.setAttribute("contador", contador);
        }

        resp.getWriter().println((Integer)req.getServletContext().getAttribute("contador"));
        
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
       
       
    }
    /**
     * Metodo que recebe informação do formulario(MeuFormulario.html) e retorna a pagina em resposta(erro.html ou login.html ou logout.html) atraves do uso do RequestDispacher
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
             RequestDispatcher dis;
             String str = req.getParameter("acao");
            switch (str) {
                case "login":
                    dis=req.getRequestDispatcher("/login.html");
                    dis.forward(req, resp);
                    break;
                case "logout":
                    dis=req.getRequestDispatcher("/logout.html");
                    dis.forward(req, resp);
                    break;
                default:
                    dis=req.getRequestDispatcher("/erro.html");
                    dis.forward(req, resp);
                    break;
            }
    }


}

