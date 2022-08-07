package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.SettingsPage;
import ui.loginPage;


public class UserInfo {
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;   
    
    
    
    //~~~SQL QUERY~~~//
    String SELECT_PASS = "SELECT user_pass FROM userinfo WHERE user_id=1";   
    String UPDATE_PASS = "UPDATE userinfo SET user_pass = ? WHERE user_id=1";
    
    String SELECT_MSG = "SELECT rem_msg FROM userinfo WHERE user_id=1";  
    String UPDATE_MSG = "UPDATE userinfo SET rem_msg = ? WHERE user_id=1";
    
     public UserInfo()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getPassword(){
        try {          
            con = DBConnector.getConnection();
            pst = con.prepareStatement(SELECT_PASS);
            rs = pst.executeQuery(); 
            if(rs.next()){
                return rs.getString("user_pass");                
            }
            else{
                return null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }  
     
     
     
    public void updatePassword(String newPass){
         
         try{
            con = DBConnector.getConnection();
            pst = con.prepareStatement(UPDATE_PASS);
            pst.setString(1, newPass);
            pst.executeUpdate();             
   
        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            
        }   
    }
    
    
    public String getRemMsg(){
        try {          
            con = DBConnector.getConnection();
            pst = con.prepareStatement(SELECT_MSG);
            rs = pst.executeQuery(); 
            if(rs.next()){
                return rs.getString("rem_msg");                
            }
            else{
                return null;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }  
    
    public void updateRemMsg(String newMsg){
         
         try{
            con = DBConnector.getConnection();
            pst = con.prepareStatement(UPDATE_MSG);
            pst.setString(1, newMsg);
            pst.executeUpdate();             
   
        } catch (SQLException ex) {
            Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
            
        }   
    }
     
     
     
    
    
    
}
