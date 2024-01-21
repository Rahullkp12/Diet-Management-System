/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cgi;

import jakarta.servlet.RequestDispatcher;

import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author antar
 */
@WebServlet(name = "UserSignup", urlPatterns = {"/UserSignup"})
public class UserSignup extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            int random_int = (int)Math.floor(Math.random()*(5-1+1)+1);
            String N_Id=Integer.toString(random_int);
            
            String First_Name =request.getParameter("First_Name");
            String Last_Name =request.getParameter("Last_Name");
            String EMAIL =request.getParameter("email");
            String Gender =request.getParameter("gender");
            String PASSWORD =request.getParameter("password");
            String uid =request.getParameter("uid");
            
            String hght =request.getParameter("hght");
            String wght =request.getParameter("wght");
            
            
            
            Connection con = null;
             try{
                // load driver
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create connections
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123");  
                // create statement object
                Statement stmt = (Statement)con.createStatement();
                String  sql= "INSERT INTO Users (User_Id,First_Name,Last_Name,email,password,gender,User_Height,User_Weight,N_Id) values('"+uid+"','"+First_Name+"','"+Last_Name+"','"+EMAIL+"','"+PASSWORD+"','"+Gender+"','"+hght+"','"+wght+"','"+N_Id+"')";
                stmt.executeUpdate(sql);
                System.out.println("<b>Hi ! Welcome! You are Registered<br/></br><br/>");
                // use statement to execute query
                //ResultSet rs=stmt.executeQuery("select First_Name, Last_Name, Gender from Nutritionist where email = "+EMAIL +" and PASSWORD ="+PASSWORD); 
                // if you have multiple rows returned, you can use while(rs.next()) to iterate different rows

                // close connections
                con.close();       
            }catch(Exception ex){out.println(ex.toString());}
            
            
            
            
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You are registered");
            out.println("</body>");
            out.println("</html>");
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
