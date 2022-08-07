package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class buildingModel {
    
    //~~~COLUMN NAME~~~//
    private int b_id,num_of_apt;
    private String b_name,location;
    
    
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    
    //~~~SQL QUERY ~~~//
    private static final String INSERT = "INSERT INTO building ( b_name, num_of_apt, location ) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE building SET b_name = ?, location = ? WHERE b_id = ?";
    private static final String DELETE = "DELETE FROM building WHERE b_id = ?";
    private static final String SELECT_ALL = "SELECT * FROM building";  
    private static final String SELECT_ALL_ID = "SELECT b_id FROM building"; 
    private static final String SELECT_NAME_BY_ID = "SELECT b_name FROM building WHERE b_id= ?";
    private static final String SELECT_LAST_ID = "SELECT b_id FROM building ORDER BY b_id DESC LIMIT 1";
    
    private static final String SELECT_NUM_OF_BUILDING = "SELECT COUNT(*) AS num_of_building FROM building";
    private static final String SELECT_BY_ID = "SELECT * FROM building WHERE b_id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM building WHERE b_name LIKE ";
    private static final String SELECT_BY_LOCATION = "SELECT * FROM building WHERE location LIKE ";
    
    private static final String SELECT_NUM_OF_APT_BY_ID = "SELECT num_of_apt FROM building WHERE b_id =?";
    private static final String UPDATE_NUM_OF_APT_BY_ID = "UPDATE building SET num_of_apt = ? WHERE b_id =?";
    
    private static final String SELECT_NUM_OF_TEN_BY_BID = "SELECT COUNT(*) AS num_of_tenant FROM apartment NATURAL JOIN tenant WHERE b_id=? AND t_status='ACTIVE'";
    private static final String SELECT_TEN_BY_BID = "SELECT *  FROM apartment NATURAL JOIN tenant WHERE b_id=? AND t_status='ACTIVE'";
    
    
    private static final String SELECT_BUILDING_TOTAL_TRANS = "SELECT SUM(tr_amount) AS total_income FROM apartment NATURAL JOIN transactions WHERE tr_type=? AND b_id= ?";
    
    public buildingModel()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void INSERT(String b_name,int num_of_apt, String location)
    {
        try {
            pst = con.prepareStatement(INSERT);            
            pst.setString(1, b_name);
            pst.setInt(2, num_of_apt);
            pst.setString(3, location);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    public void UPDATE(int b_id, String b_name,String location)
    {
        try {
            pst = con.prepareStatement(UPDATE);
            pst.setString(1, b_name);
            pst.setString(2, location);
            pst.setInt(3, b_id);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public int LAST_ID()
    {
        
        try {
            pst = con.prepareStatement(SELECT_LAST_ID);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("b_id");
                return id;
            }
            else{
                return 100;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    
    public void UPDATE_NUMOFAPT_BY_ID(int b_id)
    {
        int oldNum = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_APT_BY_ID);
            pst.setInt(1, b_id);
            rs = pst.executeQuery();
            if(rs.next()){
                oldNum = rs.getInt("num_of_apt");
            }
            int newNum = oldNum +1;
            
            pst = con.prepareStatement(UPDATE_NUM_OF_APT_BY_ID);
            pst.setInt(1, newNum);
            pst.setInt(2, b_id);
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void DELETE(int b_id)
    {
        try {
            pst = con.prepareStatement(DELETE);
            pst.setInt(1, b_id);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet VIEW_ALL_ID()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_ID);
            return rs = pst.executeQuery();    
            
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;               
        }
        
    }
    
    
    public ResultSet SEARCH_NAME_BY_ID(int b_id)
    {
        try {
            pst = con.prepareStatement(SELECT_NAME_BY_ID);
            pst.setInt(1, b_id);
            return rs = pst.executeQuery();    
            
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;               
        }
        
    }
    
    public ResultSet VIEW_ALL()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;               
        }
        
    }
    
    public ResultSet GET_TEN_BY_BID(int b_id)
    {
        try {
            pst = con.prepareStatement(SELECT_TEN_BY_BID);
            pst.setInt(1, b_id);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;               
        }
        
    }
    
    
    public ResultSet SEARCH_BY_ID(int b_id)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_ID);
            pst.setInt(1, b_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    public ResultSet SEARCH_BY_NAME(String search_text)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_NAME+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet SEARCH_BY_LOCATION(String search_text)
    {
        try {
            pst = con.prepareStatement(SELECT_BY_LOCATION+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }        
    }
    
    public int GET_NUM_OF_BUILDING()
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_BUILDING);            
            rs = pst.executeQuery();
            if(rs.next())
            {
                return count = rs.getInt("num_of_building");
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    public int GET_NUM_OF_APT(int b_id)
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_APT_BY_ID);  
            pst.setInt(1, b_id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                return count = rs.getInt("num_of_apt");
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    
    public int GET_NUM_OF_TENANT(int b_id)
    {
        int count = 0;
        try {
            pst = con.prepareStatement(SELECT_NUM_OF_TEN_BY_BID);  
            pst.setInt(1, b_id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                return count = rs.getInt("num_of_tenant");
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
public double getTotalIncomeByBuilding(int b_id)
    {
        double total = 0;
        try {
            pst = con.prepareStatement(SELECT_BUILDING_TOTAL_TRANS);  
            pst.setString(1, "CREDIT");
            pst.setInt(2, b_id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                total = rs.getDouble("total_income");
                return total;
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }

public double getTotalExpenseByBuilding(int b_id)
    {
        double total = 0;
        try {
            pst = con.prepareStatement(SELECT_BUILDING_TOTAL_TRANS);  
            pst.setString(1, "DEBIT");
            pst.setInt(2, b_id);
            rs = pst.executeQuery();
            if(rs.next())
            {
                total = rs.getDouble("total_income");
                return total;
            }
            else{
                return 0;
            }           
                
                
        } catch (SQLException ex) {
            Logger.getLogger(buildingModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }  
        
    }
    
    
    
    
    
    
}
