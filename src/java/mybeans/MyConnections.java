/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package mybeans;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Yong
 */
public class MyConnections implements Serializable {
   private Connection conn;
    
    public MyConnections() {
    }
    
    public Connection getConnection() throws Exception{
        if (conn!=null)
            conn.close();
        // load driver
        Class.forName("oracle.jdbc.driver.OracleDriver");                
        // create connections
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Antara","system","Ranjan@123");  
        return conn;
    }
    
    public void closeConnection() throws Exception{        
        if (conn!=null)
            conn.close();
    }
    
    
}
