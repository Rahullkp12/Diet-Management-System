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
public class GetNames extends HttpServlet {

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
            String FIRST_NAME = "N/A", LAST_NAME = "N/A",Gender ="N/A",User_Height="N/A",User_Weight="N/A";
            float User_BMI = 0;
            String NuFirst_Name = "N/A";
            String Nuemail = "N/A";
            String BMI_Status = "N/A";
            String Breakfast = "N/A";
            String Lunch = "N/A";
            String Dinner = "N/A";
            
            boolean returned = false;
            try{
                // load driver
                Class.forName("oracle.jdbc.driver.OracleDriver");                
                // create connections
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123");  
                // create statement object
                Statement stmt = con.createStatement();  
                // use statement to execute query
                //ResultSet rs=stmt.executeQuery("select Users.First_name, Users.Last_Name,Users.Gender,Users.User_Height, Users.User_Weight, Users.User_BMI , Nutritionist.First_Name, Nutritionist.email \n" +
//"from Users, Nutritionist \n" +
//"where Users.EMAIL = "+EMAIL +" and Users.PASSWORD ="+PASSWORD+" and Nutritionist.N_Id=Users.N_Id");// 
                ResultSet rs=stmt.executeQuery("Select breakfasttable.First_Name, breakfasttable.Last_Name, breakfasttable.Gender, breakfasttable.User_Height, breakfasttable.User_Weight, breakfasttable.User_BMI,Nutritionist.First_Name, Nutritionist.email, breakfasttable.Status, breakfasttable.breakfast, breakfasttable.lunch, breakfasttable.dinner from\n" +
"((Select Users.N_Id, Users.First_Name, Users.Last_Name, Users.Gender, Users.User_Height, Users.User_Weight, Users.User_BMI, BMI.Status,Users.User_Id,Users.password, Users.email, nvdietplan.breakfast,nvdietplan.lunch,nvdietplan.dinner \n" +
"from BMI,Users,nvdietplan where Users.User_Id=nvdietplan.User_Id and BMI.User_Id = Users.User_Id )\n" +
"Union (Select Users.N_Id,Users.First_Name, Users.Last_Name, Users.Gender, Users.User_Height, Users.User_Weight, Users.User_BMI, BMI.Status, Users.User_Id, Users.password, Users.email, vdietplan.breakfast, vdietplan.lunch, vdietplan.dinner \n" +
"from BMI, Users, vdietplan where Users.User_Id=vdietplan.User_Id and BMI.User_Id = Users.User_Id )) breakfasttable \n" +
"left Join Nutritionist on Nutritionist.N_Id = breakfasttable.N_Id Where breakfasttable.email = '"+EMAIL +"' and breakfasttable.password='"+PASSWORD+"'");
                // if you have multiple rows returned, you can use while(rs.next()) to iterate different rows
                if(rs.next() !=false){
                    // column index starts from 1
                    FIRST_NAME = rs.getString(1);
                    LAST_NAME = rs.getString(2);
                    Gender = rs.getString(3);
                    User_Height = rs.getString(4);
                    User_Weight = rs.getString(5);
                    User_BMI = rs.getFloat(6);
                    NuFirst_Name = rs.getString(7);
                    Nuemail = rs.getString(8);
                    BMI_Status = rs.getString(9);
                    Breakfast = rs.getString(10);
                    Lunch = rs.getString(11);
                    Dinner = rs.getString(12);
                    
                    returned = true;
             
                }
                // close connections
                con.close();       
            }catch(Exception ex){out.println(ex.toString());}
            
            System.out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GetNames</title>");            
            out.println("<head><h1><b>Hi ! Welcome To Your Journey Towards Weight Loss / Weight Gain</b><br/></h1></head><hr>");
            out.println("<body>");
            System.out.println("<b>Hi ! Welcome To Your Journey Towards Weight Loss / Weight Gain<br/></br><br/>");
            out.println("<b>Email: </b>"+EMAIL+"<br/><br/>");
            
            if(returned)
                out.println("<b>First Name: </b>" +FIRST_NAME+ " <br/><br/> <b>Last Name: </b>"+LAST_NAME+"<br/> <br/> "
                        + "<b>Gender: </b>"+Gender+"<br/> <br/> <b>User_Height: "
                        + "</b>"+User_Height+" meters <br/> <br/> <b>User_Weight: </b>"+User_Weight+" kg"
                        + "<br/></br> <b>Your BMI: </b>"+User_BMI+"  kg/meter square<br/> <br/><br/><b>Nutritionsit's First Name: </b>" 
                        +NuFirst_Name+" <br/><br/><b>Nutritionsit's email: </b>" +Nuemail+" <br/><br/><b>Your BMI Status is: </b>"+BMI_Status+"<br/><br/><b>Lunch Suggested: </b>"+Lunch+" <br/><br/> <b>Dinner Suggested: </b>"+Dinner+" <br/><br/><b>Breakfast suggested: </b>"+Breakfast+" <br/><br/>");
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
