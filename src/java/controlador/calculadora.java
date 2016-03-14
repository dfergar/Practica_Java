/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2DAW
 */
@WebServlet(name = "calculadora", urlPatterns = {"/calculadora"})
public class calculadora extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
           
            

            float op1 = Float.parseFloat(request.getParameter("op1"));
            float op2 = Float.parseFloat(request.getParameter("op2"));
            String oper = (String) request.getParameter("oper"); 
            
            String error1;
            float result;
            if(divCero(oper, op2)) {
                error1="Error, división por 0";
                request.setAttribute("error1", error1);
            } 
            else {
                result = operar(oper, op1, op2);               
                request.setAttribute("resultado", result);
            }

             request.getRequestDispatcher("index.jsp").forward(request, response);
            
           
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculadora</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet calculadora at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected float operar(String oper, float op1, float op2)
    {
        float resultado=0;
        switch (oper)
        {
            case("+"): resultado=op1+op2;
            break;
            case("-"): resultado=op1-op2;
            break;
            case("*"): resultado=op1*op2;
            break;
            case("/"): resultado=op1/op2;
            break;
        }
        return resultado;
    }
    
    private static boolean divCero(String oper, float op2)
    {
        if(oper.equals("/") && op2==0){
            return true;
        }
        else {
            return false;
        }
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
