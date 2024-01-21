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
import java.util.HashMap;

/**
 *
 * @author Yong
 */
public class GetScores extends HttpServlet {

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
            String ids = request.getParameter("ID").trim();
            HashMap<Integer, Double> scores = new HashMap<Integer, Double>();
            boolean returned = false;
            try{
                // load driver
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create connections
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Ranjan");  
                // create statement object
                Statement stmt = con.createStatement();  
                // use statement to execute query
                ResultSet rs=stmt.executeQuery("select student_id, avg(score) from grade group by student_id having student_id in ("+ids+")");  
                // if you have multiple rows returned, you can use while(rs.next()) to iterate different rows
                while(rs.next()){
                    // column index starts from 1
                    int id = rs.getInt(1);
                    double score = rs.getDouble(2);
                    scores.put(id, score);
                    returned = true;
                }
                // close connections
                con.close();       
            }catch(Exception ex){out.println(ex.toString());}
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetNames</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Student ID: "+ids+"<br/>");
             out.println("<table><tr><th>ID</th><th>Average Score</th></tr>");
            if(returned){
                for(int id : scores.keySet()){
                    out.println("<tr><td>"+id+"</td><td>"+scores.get(id)+"</td></tr>");
                }
                out.println("</table>");
            }
            else
                out.println("Sorry, we cannot locate records.");                
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
