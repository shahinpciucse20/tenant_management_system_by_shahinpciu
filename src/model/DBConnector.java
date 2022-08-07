package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import org.apache.ibatis.jdbc.ScriptRunner;


public class DBConnector {
    
    public static Connection con2 = null;
    static String username="root";
    static String pass="";
    static File myObj;
    static Scanner myReader;
    
    
    static void getIdPassFromFile(){
     
        try {
            String myDocDir = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            myObj = new File(myDocDir+"/tms_setup_db/mysql_local_id_pass.txt");
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line.charAt(0)!='#'){  
                    if(line.charAt(0)=='u')
                    {
                        username = line.substring(2,line.length());
                    }
                    if(line.charAt(0)=='p'){
                        pass = line.substring(2,line.length());
                    }   
                }                

               }
            System.out.println(username);
            System.out.println(pass);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
               
               
    }
    
    
    public static Connection getConnection() throws SQLException
    {
        getIdPassFromFile();
        
        final String DATABASE_NAME = "tms";
        final String SERVER_URL = "jdbc:mysql://localhost:3306/";
        final String URL = SERVER_URL+DATABASE_NAME;
        final String USERNAME = username;
        final String PASSWORD = pass;
        
        
        /*
        final String DATABASE_NAME = "sql6506714";
        final String SERVER_URL = "jdbc:mysql://sql6.freesqldatabase.com/";
        final String URL = SERVER_URL+DATABASE_NAME;
        final String USERNAME = "sql6506714";
        final String PASSWORD = "YtBbkfTSBj";
        */
       
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con2 = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return con2;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public static void closeCon(){
        
        try {
            con2.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void createDBOnce(){
        if(!isDBExist()){
            
        final String DATABASE_NAME = "tms";
        final String SERVER_URL = "jdbc:mysql://localhost:3306/";        
        final String USERNAME = "root";
        final String PASSWORD = "1234";
        
        Connection con =null;
        
       
           
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                con = DriverManager.getConnection(SERVER_URL,USERNAME,PASSWORD);
                
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            String path = "src/sql/tms_sql.sql";
            
            try {
                ScriptRunner sr;
                sr = new ScriptRunner(con);
                Reader reader = new BufferedReader(new FileReader(path));
      
                sr.runScript(reader);
                
                
                FileWriter myWriter;
        
                myWriter = new FileWriter("src/local_db/isDBCreated.txt");
                myWriter.write("yes");
                myWriter.close();
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            
        }
    }
    
    
    
    public static boolean isDBExist(){
        
        try {
            File myObj = new File("src/local_db/isDBCreated.txt");
            if(!myObj.exists()){
                myObj.createNewFile();
            }
            
            Scanner myReader = new Scanner(myObj);
            
            
            
            if(myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                if(data.toLowerCase().equals("no")){
                    return false;
                }
                else if(data.toLowerCase().equals("yes")){
                    return true;
                }
                else{
                    return false;
                }                
            }
            else{
                return false;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}

