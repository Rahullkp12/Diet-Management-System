<%-- 
    Document   : index
    Created on : Nov 9, 2022, 10:10:53 PM
    Author     : Yong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>      
        Current time is <%= new java.util.Date() %>

        <form action="AgeServlet" method="get">
           Your Birth Year: <input type="text" name="year" />
           <input type="submit" />
         </form>
    </body>
</html>
