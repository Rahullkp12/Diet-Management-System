package cgi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Yong
 */
public class GetNu extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*int User_Id = Integer.parseInt(request.getParameter("User_Id")); */
            /*String User_Id =request.getParameter("User_Id");*/
            String EMAIL =request.getParameter("EMAIL");
            String PASSWORD =request.getParameter("PASSWORD");
            String FIRST_NAME = "N/A", LAST_NAME = "N/A",Gender ="N/A";
            /*float User_BMI = 0;
            String NuFirst_Name = "N/A";
            String Nuemail = "N/A";*/
            boolean returned = false;
            try{
                // load driver
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create connections
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123");  
                // create statement object
                Statement stmt = con.createStatement();  
                // use statement to execute query
                ResultSet rs=stmt.executeQuery("select First_Name, Last_Name from Nutritionist where email = "+EMAIL +" and PASSWORD ="+PASSWORD); 
                // if you have multiple rows returned, you can use while(rs.next()) to iterate different rows
                if(rs.next() !=false){
                    // column index starts from 1
                    FIRST_NAME = rs.getString(1);
                    LAST_NAME = rs.getString(2);
                    Gender = rs.getString(3);
                    returned = true;
                }
                // close connections
                con.close();       
            }catch(Exception ex){out.println(ex.toString());}
            
            System.out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetNu</title>");            
            out.println("<head><h1><b>Hi ! Welcome To Nutritionist Portal</b><br/></h1></head><hr>");
            out.println("<body>");
            out.println("<b>Email: </b>"+EMAIL+"<br/><br/>");
            
            if(returned)
                out.println("<b>First Name: </b>"+FIRST_NAME+" <br/><br/> <b>Last Name: </b>"+LAST_NAME+"<br/> <br/> "
                        + "<b>Gender: </b>"+Gender+"<br/> <br/>");
               /* out.println("<table><tr><th>"+FIRST_NAME+"</th><th>"+LAST_NAME+"</th></tr>");*/
            else
                out.println("Sorry, we cannot locate your ID in the database.");                
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
