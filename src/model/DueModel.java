
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DueModel {
    
     //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    private static final String INSERT = "INSERT INTO due (t_nid,due_status,due_amount,due_month) VALUES (?,?,?,?)";
    private static final String UPDATE_DUE_STATUS = "UPDATE due SET due_status=? WHERE due_id=?";
    private static final String UPDATE_DUE_AMOUNT = "UPDATE due SET due_amount=? WHERE due_id=?";
    private static final String SELECT_TOTAL_DUE_AMOUNT = "SELECT SUM(due_amount) AS total_amount FROM due WHERE due_status = 'UNPAID';";
    private static final String SELECT_LAST_ID = "SELECT due_id FROM due ORDER BY due_id DESC LIMIT 1";
    private static final String SELECT_ALL_UNPAID = "SELECT * FROM due WHERE due_status='UNPAID'";
   
    private static final String SELECT_ALL_PAID = "SELECT due_id,t_nid,full_name,apt_id,due_month,due_amount FROM due LEFT JOIN tenant ON due.t_nid=tenant.nid WHERE due_status='PAID'";
    private static final String SEARCH_PAID_BY_MONTH = "SELECT due_id,t_nid,full_name,apt_id,due_month,due_amount FROM due LEFT JOIN tenant ON due.t_nid=tenant.nid WHERE due_status='PAID' AND due_month LIKE";
    private static final String SEARCH_PAID_BY_NAME = "SELECT due_id,t_nid,full_name,apt_id,due_month,due_amount FROM due LEFT JOIN tenant ON due.t_nid=tenant.nid WHERE due_status='PAID' AND full_name LIKE";

    private static final String SELECT_DUE_RENT_IN_MONTH = "SELECT SUM(rent) AS total_due_rent FROM apartment WHERE available='NO' AND apt_id NOT IN (select  tenant.apt_id from tenant  join transactions ON tenant.nid = transactions.t_nid WHERE rent_month = ? AND t_status = 'ACTIVE')";
    
    
    //~~ Search Query ~~//
    private static final String SELECT_BY_NID = "SELECT * FROM due WHERE t_nid =? AND due_status='UNPAID'";
    private static final String SELECT_BY_DID = "SELECT * FROM due WHERE due_id =? AND due_status='UNPAID'";
    
    
    public DueModel(){
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void insert(long nid, double due_amount,String due_month)
    {
        try {
            pst = con.prepareStatement(INSERT);            
            pst.setLong(1, nid);
            pst.setString(2, "UNPAID");
            pst.setDouble(3, due_amount);
            pst.setString(4, due_month);
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateDueStatus(int due_id,String due_status){
        try {
            pst = con.prepareStatement(UPDATE_DUE_STATUS);
            pst.setString(1, due_status);
            pst.setInt(2, due_id);
            
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateDueAmount(int due_id, double due_amount){
        try {
            pst = con.prepareStatement(UPDATE_DUE_AMOUNT);
            pst.setDouble(1, due_amount);
            pst.setInt(2, due_id);
            
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
public ResultSet viewAllUnpaidDue()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_UNPAID);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }


public ResultSet viewAllPaidDue()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_PAID);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }

public double getTotalDueByMonth(String month){
        try {
            pst = con.prepareStatement(SELECT_DUE_RENT_IN_MONTH);
            pst.setString(1, month);
            rs = pst.executeQuery();
            
            if(rs.next()){                
                return rs.getDouble("total_due_rent");
            }
            else{
                return 0;
            }
        
         } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    
    
    public double getTotalDueAmount(){
        try {
            pst = con.prepareStatement(SELECT_TOTAL_DUE_AMOUNT);
            rs = pst.executeQuery();
            if(rs.next()){                
                return rs.getDouble("total_amount");
            }
            else{
                return 0;
            }
        
         } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    public int getLastId()
    {
        
        try {
            pst = con.prepareStatement(SELECT_LAST_ID);
            rs = pst.executeQuery();
            if(rs.next())
            {
                int id = rs.getInt("due_id");
                return id;
            }
            else{
                return 2000;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    
    public ResultSet searchByNid(long nid)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_NID);
            pst.setLong(1, nid);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet searchByDueId(int due_id)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_DID);
            pst.setLong(1, due_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    
    public ResultSet SEARCH_BY_MONTH(String search_text)
    {
        try {
            pst = con.prepareStatement(SEARCH_PAID_BY_MONTH+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public ResultSet SEARCH_BY_NAME(String search_text)
    {
        try {
            pst = con.prepareStatement(SEARCH_PAID_BY_NAME+"('%"+search_text+"%')");            
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(DueModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
