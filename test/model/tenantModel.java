
package model;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class tenantModel {
    
     
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    //~~~SQL QUERY ~~~//
    private static String INSERT = "INSERT INTO tenant ( nid, full_name, age,gender,religion,nationality,profession,mobile,email,permanant_address,photo,total_member,apt_id,security_deposit,starting_month ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static String UPDATE = "UPDATE tenant SET nid = ?, full_name = ?, age=?, gender=?, religion=?,nationality=?,mobile=?, email=?,permanant_address=?,total_member=?,security_deposit=?,starting_month=? WHERE nid = ?";
    private static String DELETE = "DELETE FROM tenant WHERE nid = ?";
    private static String SELECT_ALL = "SELECT * FROM tenant";  
    private static String SELECT_BLOB_BY_ID = "SELECT photo FROM tenant WHERE nid= ?";
    private static String SELECT_SUM_SECURITY_DEPOSIT = "SELECT SUM(security_deposit) as total_security_deposit FROM tenant";  
    private static String SELECT_ALL_ID = "SELECT nid FROM tenant"; 
    private static String SELECT_NAME_BY_ID = "SELECT full_name FROM tenant WHERE nid= ?";
    private static String SELECT_LAST_ID = "SELECT nid FROM tenant ORDER BY nid DESC LIMIT 1";
    private static String SELECT_APTID_BY_NID = "SELECT apt_id FROM tenant WHERE nid= ?";
    
    
    private static String SELECT_INFO_BY_ID ="SELECT nid,full_name,apt_id,apt_name,rent,b_name FROM tenant NATURAL JOIN apartment NATURAL JOIN building WHERE nid = ?";
    
    private static String SELECT_NUM_OF_TENANT = "SELECT COUNT(*) AS num_of_tenant FROM tenant";
    private static String SELECT_BY_ID = "SELECT * FROM tenant WHERE nid = ?";
    private static String SELECT_BY_APTID = "SELECT * FROM tenant WHERE apt_id = ?";
    private static String SELECT_BY_NAME = "SELECT * FROM tenant WHERE full_name LIKE ";
    private static String SELECT_BY_MOBILE = "SELECT * FROM tenant WHERE mobile LIKE ";
    
    
    
    public tenantModel()
    {
         try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet VIEW_ALL()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL);
            return rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void DELETE(long nid)
    {
        try {
            pst = con.prepareStatement(DELETE);
            pst.setLong(1, nid);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    

    
    
    public BufferedImage GET_PIC_BY_ID(long nid)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BLOB_BY_ID);
            pst.setLong(1, nid);
            rs = pst.executeQuery();
            if(rs.next())
            {
                return ImageIO.read(rs.getBinaryStream("photo"));
            }
            else{
                return null;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void UPDATE(long nid, String full_name, int age, String gender, String religion,String nationality,int mobile, String email,String permanant_address,int total_member,double security_deposit,String starting_month)
    {
        try {
            pst = con.prepareStatement(UPDATE);
            pst.setLong(1, nid);
            pst.setString(2, full_name);
            pst.setInt(3, age);
            pst.setString(4, gender);
            pst.setString(5, religion);
            pst.setString(6, nationality);
            pst.setInt(7, mobile);
            pst.setString(8, email);
            pst.setString(9, permanant_address);
            pst.setInt(10, total_member);
            pst.setDouble(11, security_deposit);
            pst.setString(12, starting_month);
            pst.setLong(13, nid);
            
            
            
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public void INSERT(long  nid, String full_name, int age, String gender,String religion,String nationality,String profession,long mobile,String email,String permanant_address,String photopath,int total_member,int apt_id,double security_deposit,String starting_month)
    {
        try {
            File imageFile = new File(photopath);
            FileInputStream pic = new FileInputStream(imageFile);
            
            pst = con.prepareStatement(INSERT);
            pst.setLong(1, nid);
            pst.setString(2, full_name);
            pst.setInt(3, age);
            pst.setString(4, gender);
            pst.setString(5, religion);
            pst.setString(6, nationality);
            pst.setString(7, profession);
            pst.setLong(8, mobile);
            pst.setString(9, email);
            pst.setString(10, permanant_address);
            pst.setBinaryStream(11, pic);
            pst.setInt(12, total_member);
            pst.setInt(13, apt_id);
            pst.setDouble(14, security_deposit);
            pst.setString(15, starting_month);    
            
            pst.executeUpdate();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
        }      
        
        
    }
    
    public int GET_APTID_BY_NID(long nid)
    {
        int apt_id=0;
        try {    
            pst = con.prepareStatement(SELECT_APTID_BY_NID);
            pst.setLong(1, nid);
            rs = pst.executeQuery();
            if(rs.next())
            {
                apt_id = rs.getInt("apt_id");
                return apt_id;
            }
            else{
                return 0;
            }            
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public int GET_NUM_OF_TENANT()
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_TENANT);            
            rs = pst.executeQuery();
            if(rs.next())
            {
                return count = rs.getInt("num_of_tenant");
            }
            else{
                return 0;
            }        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    public double GET_SUM_OF_SECURITY_DEPOSIT()
    {
        double sum = 0;
        try {
            pst = con.prepareStatement(SELECT_SUM_SECURITY_DEPOSIT);            
            rs = pst.executeQuery();
            if(rs.next())
            {
                return sum = rs.getDouble("total_security_deposit");
            }
            else{
                return 0;
            }        
                
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    
    
    public ResultSet GET_ALL_NID()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_ID);
            return rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public ResultSet GET_RCV_RENT_INFO_BY_ID(long nid)
    {
        try {
            pst = con.prepareStatement(SELECT_INFO_BY_ID);
            pst.setLong(1, nid);
            return rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
    
    
    public ResultSet SEARCH_BY_ID(long nid)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_ID);
            pst.setLong(1, nid);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet SEARCH_BY_NAME(String search_text)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_NAME+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet SEARCH_BY_MOBILE(String search_text)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_MOBILE+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
      public ResultSet SEARCH_BY_APTID(int apt_id)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_APTID);
            pst.setInt(1, apt_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(tenantModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    
    
    

}
