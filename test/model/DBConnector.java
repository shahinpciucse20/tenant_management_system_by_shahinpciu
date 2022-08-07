package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnector {
    
    public static Connection getConnection() throws SQLException
    {
        final String URL = "jdbc:mysql://localhost:3306/tms2";
        final String USERNAME = "root";
        final String PASSWORD = "1234";
        
       
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return conn;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

