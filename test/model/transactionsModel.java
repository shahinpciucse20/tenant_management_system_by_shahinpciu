package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class transactionsModel {
    
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    //~~~SQL QUERY ~~~//
    //private static String INSERT_ALL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, t_nid, apt_id, tr_payment_method ) VALUES (?,?,?,?,?,?,?)";
    private static String INSERT_APT_BILL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, apt_id, tr_payment_method ) VALUES (?,?,NOW(),?,?,?)";
    private static String UPDATE = "UPDATE transactions SET tr_type=?, tr_amount=?, tr_datetime=?, tr_purpose=?, t_nid=?, apt_id=?, tr_payment_method=? WHERE tr_id = ?";
    private static String DELETE = "DELETE FROM transactions WHERE tr_id = ?";
    private static String INSERT_RENT ="INSERT INTO transactions (tr_type, tr_amount, tr_datetime, tr_purpose, t_nid, apt_id, tr_payment_method) VALUES (?,?,NOW(),?,?,?,?)";
    private static String INSERT_NORMAL_BILL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, tr_payment_method ) VALUES (?,?,NOW(),?,?)";
    private static String SELECT_ALL = "SELECT * FROM transactions";    
    private static String SELECT_BY_ID = "SELECT * FROM transactions WHERE tr_id = ?";
    private static String SELECT_BY_TYPE = "SELECT * FROM transactions WHERE type= ?";
    private static String SELECT_BY_PAYMENT_METHOD = "SELECT * FROM transactions WHERE tr_payment_method= ?";
    private static String SELECT_BY_DATE = "SELECT * FROM transactions WHERE tr_datetime LIKE ";
    private static String SELECT_BY_TENANT = "SELECT * FROM transactions WHERE t_nid =?";
    private static String SELECT_BY_APT = "SELECT * FROM transactions WHERE apt_id =?";
    
    private static String SELECT_LAST_ID = "SELECT tr_id FROM transactions ORDER BY tr_id DESC LIMIT 1";
    private static String SELECT_TOTAL_RENT = "SELECT SUM(tr_amount) AS total_rent FROM transactions WHERE tr_purpose='RENT' AND tr_type = 'CREDIT'";
    private static String SELECT_TOTAL_EXPENSES = "SELECT SUM(tr_amount) AS total_expenses FROM transactions WHERE tr_type = 'DEBIT'";
    
    
    public transactionsModel()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void INSERT_NORMAL_BILL(double tr_amount, String tr_purpose,String tr_payment_method)
    {
        try {
            pst = con.prepareStatement(INSERT_NORMAL_BILL);
            pst.setString(1, "DEBIT");
            pst.setDouble(2, tr_amount);
            pst.setString(3, tr_purpose);
            pst.setString(4, tr_payment_method);
            
            pst.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void INSERT_APT_BILL(double tr_amount, String tr_purpose,int apt_id, String tr_payment_method)
    {
        try {
            pst = con.prepareStatement(INSERT_APT_BILL);
            pst.setString(1, "DEBIT");
            pst.setDouble(2, tr_amount);
            pst.setString(3, tr_purpose);
            pst.setInt(4, apt_id);
            pst.setString(5, tr_payment_method);
            
            pst.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    public void DELETE(int tr_id)
    {
        try {
            pst = con.prepareStatement(DELETE);
            pst.setInt(1, tr_id);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet VIEW_ALL()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    
    public void UPDATE(int tr_id, String tr_type, double tr_amount, String tr_datetime, String tr_purpose, long t_nid, int apt_id, String tr_payment_method)
    {
        try {
            pst = con.prepareStatement(UPDATE);
            pst.setString(1, tr_type);
            pst.setDouble(2, tr_amount);
            pst.setString(3, tr_datetime);
            pst.setString(4, tr_purpose);
            pst.setLong(5, t_nid);
            pst.setInt(6, apt_id);
            pst.setString(7, tr_payment_method);
            pst.setInt(8, tr_id);            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet SEARCH_BY_ID(int tr_id)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_ID);
            pst.setInt(1, tr_id);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet SEARCH_BY_TYPE(String tr_type)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_TYPE);
            pst.setString(1, tr_type);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
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
                int id = rs.getInt("tr_id");
                return id;
            }
            else{
                return -1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    
    
    public ResultSet SEARCH_BY_PAYMENT_METHOD(String tr_payment_method)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_PAYMENT_METHOD);
            pst.setString(1, tr_payment_method.toUpperCase());
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public ResultSet SEARCH_BY_DATE(String tr_date)
    {
        try {
            
            pst = con.prepareStatement(SELECT_BY_DATE+"('%"+tr_date+"%')");
            pst.setString(1, tr_date);
            return rs = pst.executeQuery();   
                
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    public String GET_CURRENT_DATETIME()
    {
        String datetime=null;
        try {
            
            pst = con.prepareStatement("SELECT NOW()");
            
            rs = pst.executeQuery();  
            
            if(rs.next())
            {
                datetime = rs.getString("NOW()");
            }
            return datetime;
                
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
    
    public void INSERT_RENT(double tr_amount,long t_nid, int apt_id, String tr_payment_method)
    {
        try {
            pst = con.prepareStatement(INSERT_RENT);
            pst.setString(1, "CREDIT");
            pst.setDouble(2, tr_amount);
            pst.setString(3, "RENT");
            pst.setLong(4, t_nid);
            pst.setInt(5, apt_id);
            pst.setString(6, tr_payment_method);
            
            pst.executeUpdate();            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public double GET_TOTAL_RENT()
    {
        try {
            pst = con.prepareStatement(SELECT_TOTAL_RENT);
            rs = pst.executeQuery();
            if(rs.next()){
                return rs.getDouble("total_rent");
            }
            else{
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    public double GET_TOTAL_EXPENSE()
    {
        try {
            pst = con.prepareStatement(SELECT_TOTAL_EXPENSES);
            rs = pst.executeQuery();
            if(rs.next()){
                return rs.getDouble("total_expenses");
            }
            else{
                return 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    
    
    
    
}
