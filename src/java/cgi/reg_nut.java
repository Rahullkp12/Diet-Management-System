/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cgi;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author antar
 */
@WebServlet(name = "reg_nut", urlPatterns = {"/reg_nut"})
public class reg_nut extends HttpServlet {

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
            
            String N_Id = request.getParameter("N_Id");
            String First_Name = request.getParameter("First_Name");
            String Last_Name = request.getParameter("Last_Name");
            String email= request.getParameter("email");
            String gender =request.getParameter("gender");
            String password = request.getParameter("password");
            
            RequestDispatcher dispatcher;
            
           // boolean returned = false;
            
            try{
                // load driver
                //Connection con = null;
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create statement object
                //Statement stmt = con.createStatement();  
                // use statement to execute query
                //ResultSet rs=stmt.executeQuery("select Users.First_name, Users.Last_Name,Users.Gender,Users.User_Height, Users.User_Weight, Users.User_BMI , Nutritionist.First_Name, Nutritionist.email \n" +
//"from Users, Nutritionist \n" +
//"where Users.EMAIL = "+EMAIL +" and Users.PASSWORD ="+PASSWORD+" and Nutritionist.N_Id=Users.N_Id");// 
                //String sql= "INSERT INTO Nutritionist values("+N_Id+", "+First_Name+","+Last_Name+", "+email+", "+gender+", "+password+")";
                //String sql= "INSERT INTO Nutritionist(N_Id, First_Name, Last_Name, email,gender,password) values(?,?,?,?,?,?)";
                try ( // create connections
                        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123")) {
                     System.out.println("connected");
                        PreparedStatement pst = con.prepareStatement ("INSERT INTO Nutritionist(N_Id, First_Name, Last_Name, email,gender,password) values(?,?,?,?,?,?)");
//stmt.executeUpdate(sql);
                        System.out.println("in");

// if you have multiple rows returned, you can use while(rs.next()) to iterate different rows
                        pst.setString(1, N_Id);
                        pst.setString(1, First_Name);
                        pst.setString(1, Last_Name);
                        pst.setString(1, email);
                        pst.setString(1, gender);
                        pst.setString(1, password);


                    int rowCount = pst.executeUpdate ( );
                    dispatcher = request.getRequestDispatcher ("NUsignup.html");
                    if (rowCount > 0) {
                        request.setAttribute("status","success");
                    } else {
                        request. setAttribute ("status","failed");
                    }
                    dispatcher.forward(request, response);
                }
                //stmt.executeUpdate(sql);
            } catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
                }finally {
                    
                // close connections
                              
            
            
            System.out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetNames</title>");            
            out.println("<head><h1><b>Hi ! Welcome To Your Journey Towards Weight Loss / Weight Gain</b><br/></h1></head><hr>");
            out.println("<body>");
         
            
            //if(returned)
               // out.println("<b>Nutritionist ID: </b>"+N_Id+" <br/><br/><b>First Name: </b>"+First_Name+" <br/><br/> <b>Last Name: </b>"+Last_Name+"<br/> <br/> "
                     //   + "<b>Email: </b>"+email+"<br/> <br/>"
                       // + "<b>Gender: </b>"+gender+"<br/> <br/>"
                        //+ "<b>Password: </b>"+password+"<br/> <br/>");        
                        
               /* out.println("<table><tr><th>"+FIRST_NAME+"</th><th>"+LAST_NAME+"</th></tr>");*/
                
           // else
               // out.println("Sorry, we cannot locate your ID in the database.");                
            //out.println("</body>");
            //out.println("</html>");
        }
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

