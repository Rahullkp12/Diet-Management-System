<%-- 
    Document   : newNU
    Created on : Dec 2, 2022, 3:57:52 AM
    Author     : antar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="reg_nu" style="border:1px solid #ccc">
  <div class="container">
        <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="N_Id"><b>User id</b></label>
    <input type="text" placeholder="Generate a N id" name="N_Id" required><br><br><!-- comment -->
    
    <label for="First_Name"><b>First Name</b></label>
    <input type="text" name=First_Name" required><br><br>

    <label for="Last_Nname"><b>Last Name</b></label>
    <input type="text" name="Lase_Name" required><br><br>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required><br><br>

    
    <label for="gender"><b>Gender</b></label>
    <input type="text" placeholder="Enter Gender" name="gender" required><br><br>
    
     <label for="password"><b>Password</b></label>
    <input type="text" placeholder="Enter Password" name="password" required><br><br>

        <% String N_Id=request.getParameter("N_Id"); %>
        <% String First_Name=request.getParameter("First_Name"); %>
        <% String Last_Name=request.getParameter("Last_Name"); %>
        <% String email=request.getParameter("email"); %>
        <% String gender=request.getParameter("gender"); %>
        <% String password=request.getParameter("password"); %>
        <form action="reg_nu.jsp?id=<%=N_Id%>" method="post">
            
    <div class="clearfix">
      <button type="button" class="cancelbtn" onclick="location.href='student.html'">Cancel</button>
      <button type="button" class="registerbtn" onclick="location.href='login.html'">Register</button>
    
    </div>
        
        <!--Student ID: <br>
        Password: <input type="password" name="pwd1" />
        Password Again: <input type="password" name="pwd2" />
        <input type="submit" /-->
        </form>
    </body>
</html>

