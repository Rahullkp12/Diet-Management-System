<%-- 
    Document   : reg_nu
    Created on : Dec 2, 2022, 3:55:38 AM
    Author     : antar
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            <% String N_Id=request.getParameter("N_Id"); %>
        <% String First_Name=request.getParameter("First_Name"); %>
        <% String Last_Name=request.getParameter("Last_Name"); %>
        <% String email=request.getParameter("email"); %>
        <% String email=request.getParameter("gender"); %>
        <% String password=request.getParameter("password"); %>
        
         <jsp:useBean id="MyConn"  scope="request" class="mybeans.MyConnections" />
         <%
            Connection con = MyConn.getConnection();
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO Nutritionist(N_Id,First_Name,Last_Name,email,gender,password) values("+N_Id+", "+First_Name+","+Last_Name+", "+email+", "+gender+", "+password+")";
            stmt.executeQuery(sql);
            //if(rs.next()){
                //sql = "update PWD set password="+pw1+" where student_id="+id;
                //stmt.executeUpdate(sql);
             //}else
             //{
                //sql = "INSERT INTO PWD values("+id+", "+pw1+")";
                //stmt.executeUpdate(sql);
             //}
            MyConn.closeConnection();
         %>
         <script type = "text/javascript">  
            alert('You have successfully registered');
            window.location.href = "NUlogin.html";
        </script>
         <%               
            }else{
            
        %>
        <script type = "text/javascript">  
            alert('Your inputs do not match.\n Try Again!');
            window.location.href = "NUlogin.html?id=<%=id%>";
        </script>
        
        <%
            }
        %>
    </body>
</html>