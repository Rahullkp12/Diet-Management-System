/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cgi;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author antar
 */
@WebServlet(name = "DeleteUser", urlPatterns = {"/DeleteUser"})
public class DeleteUser extends HttpServlet {

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
           String U_Id =request.getParameter("U_Id");
            
            String EMAIL =request.getParameter("email");
            
            String PASSWORD =request.getParameter("password");
            
            
            Connection con = null;
            try{
                // load driver
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create connections
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123");  
                // create statement object
                Statement stmt = (Statement)con.createStatement();
                
                String  sql1="Delete from BMI where User_Id= '"+U_Id+"'";
                stmt.executeUpdate(sql1);
                String  sqlVdiet="Delete from VDietPlan where User_Id= '"+U_Id+"'";
                stmt.executeUpdate(sqlVdiet);
                String  sqlNVdiet="Delete from NVDietPlan where User_Id= '"+U_Id+"'";
                stmt.executeUpdate(sqlNVdiet);
                String  sqlApp="Delete from App_schedule where User_Id= '"+U_Id+"'";
                stmt.executeUpdate(sqlApp);
                String  sql= "Delete from Users where email= '"+EMAIL+"' and User_Id= '"+U_Id+"' and password= '"+PASSWORD+"'";
                stmt.executeUpdate(sql);
                
                
                
                
                
                System.out.println("<b>Hi ! Welcome! You are Registered<br/></br><br/>");
                // use statement to execute query
                //ResultSet rs=stmt.executeQuery("select First_Name, Last_Name, Gender from Nutritionist where email = "+EMAIL +" and PASSWORD ="+PASSWORD); 
                // if you have multiple rows returned, you can use while(rs.next()) to iterate different rows

                // close connections
                con.close();       
            }catch(Exception ex){out.println(ex.toString());}
            
            System.out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Final</title>");            
            out.println("<head><h1><b>Hi ! You are Deleted</b><br/></h1></head><hr>");
            out.println("<body>");
            System.out.println("<b>Hi ! Welcome! You are Registered<br/></br><br/>");
                
            
               
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
