package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class apartmentModel {
    
     //~~~COLUMN NAME~~~//
    private int apt_id,b_id;
    private String apt_name,available;
    
    
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    //~~~SQL QUERY ~~~//
    private static String INSERT = "INSERT INTO apartment ( apt_name, b_id,rent, available ) VALUES (?, ?, ?, ?)";
    private static String UPDATE = "UPDATE apartment SET apt_name = ?,rent = ? WHERE apt_id = ?";
    private static String UPDATE_AVAILABLE = "UPDATE apartment SET available = ? WHERE apt_id = ? ";
    private static String DELETE = "DELETE FROM apartment WHERE apt_id = ?";
    private static String SELECT_NUM_OF_APARTMENT = "SELECT COUNT(*) AS num_of_apartment FROM apartment";
    private static String SELECT_LAST_ID = "SELECT apt_id FROM apartment ORDER BY apt_id DESC LIMIT 1";
    private static String SELECT_ALL_ID = "SELECT apt_id FROM apartment";
    private static String SELECT_ALL_ID_BY_AVAILABLE = "SELECT apt_id FROM apartment WHERE available = 'YES'";
    private static String SELECT_APTNAME_BUILDINGNAME_LOCATION_BY_APTID = "SELECT apt_name,b_name,location FROM apartment NATURAL JOIN building WHERE apt_id = ?";
    
    
    private static String SELECT_ALL = "SELECT * FROM apartment NATURAL JOIN building";    
    private static String SELECT_BY_ID = "SELECT * FROM apartment NATURAL JOIN building WHERE apt_id = ?";
    private static String SELECT_BY_NAME = "SELECT * FROM apartment NATURAL JOIN building WHERE apt_name LIKE ";
    private static String SELECT_BY_AVAILABLE = "SELECT * FROM apartment NATURAL JOIN building WHERE available = ?";
    private static String SELECT_BY_BUILDING_NAME = "SELECT * FROM apartment NATURAL JOIN building WHERE b_name LIKE ";
    private static String SELECT_BY_BUILDING_LOCATION = "SELECT * FROM apartment NATURAL JOIN building WHERE location LIKE ";
    private static String SELECT_AVAILABLE_COUNT_BY_BUILDING_ID = "SELECT COUNT(available) AS num_of_available_apt FROM apartment WHERE b_id = (SELECT b_id FROM building WHERE b_id = ? )";
    private static String SELECT_AVAILABLE_COUNT = "SELECT COUNT(*) AS num_of_available_apt FROM apartment WHERE available = 'YES'";
    
    public apartmentModel()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    
    public void INSERT(String apt_name,int b_id,double rent, String available)
    {
        try {
            pst = con.prepareStatement(INSERT);            
            pst.setString(1, apt_name);
            pst.setInt(2, b_id);
            pst.setDouble(3, rent);
            pst.setString(4, available);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    
    public void DELETE(int apt_id)
    {
        try {
            pst = con.prepareStatement(DELETE);
            pst.setInt(1, apt_id);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet VIEW_ALL()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL);
            return rs = pst.executeQuery();      
            
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet VIEW_ALL_ID_BY_AVAILABLE()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_ID_BY_AVAILABLE);
            return rs = pst.executeQuery();      
            
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet VIEW_ALL_ID()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_ID);
            return rs = pst.executeQuery();      
            
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    
    public int LAST_ID()
    {
        
        try {
            pst = con.prepareStatement(SELECT_LAST_ID);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("apt_id");
                return id;
            }
            else{
                return -1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    public void UPDATE(int apt_id,String apt_name,double rent)
    {
        try {
            pst = con.prepareStatement(UPDATE);
            pst.setString(1, apt_name);
            pst.setDouble(2, rent);
            pst.setInt(3, apt_id);            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE_AVAILABLE(int apt_id,String available)
    {
        try {
            pst = con.prepareStatement(UPDATE_AVAILABLE);
            pst.setString(1, available.toUpperCase());            
            pst.setInt(2, apt_id);            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    public ResultSet SEARCH_BY_ID(int apt_id)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_ID);
            pst.setInt(1, apt_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet SEARCH_BY_NAME(String search_text)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_NAME+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet SEARCH_BY_AVAILABLE(String available)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_AVAILABLE);
            pst.setString(1, available);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    
    public ResultSet SEARCH_BY_BUILDING_NAME(String b_name)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_BUILDING_NAME+"('%"+b_name+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }
        
    }
    
    public ResultSet SEARCH_BY_BUILDING_LOCATION(String loc)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_BUILDING_LOCATION+"('%"+loc+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }
        
    }
    
    
    public int GET_NUM_OF_AVAILABLE_APT_BY_BUILDING_ID(int b_id)
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_AVAILABLE_COUNT_BY_BUILDING_ID);
            pst.setInt(1, b_id);
            rs = pst.executeQuery();  
            if(rs.next())
                return count = rs.getInt("num_of_available_apt");
            else    
                return 0;
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);  
            return 0;
        }
    }
    
    
    public int GET_NUM_OF_AVAILABLE_APT()
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_AVAILABLE_COUNT);            
            rs = pst.executeQuery();  
            if(rs.next())
                return count = rs.getInt("num_of_available_apt");
            else    
                return 0;
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);  
            return 0;
        }
    }
        
        
    public int GET_NUM_OF_APARTMENT()
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_APARTMENT);            
            rs = pst.executeQuery();
            if(rs.next())
            {
                return count = rs.getInt("num_of_apartment");
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    public ResultSet VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(int apt_id )
    {
        try {
            pst = con.prepareStatement(SELECT_APTNAME_BUILDINGNAME_LOCATION_BY_APTID); 
            pst.setInt(1, apt_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(apartmentModel.class.getName()).log(Level.SEVERE, null, ex);  
            return null;
        }
        
    }
        
        
    }
       
    
    

