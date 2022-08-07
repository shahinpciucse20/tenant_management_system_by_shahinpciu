package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.Time;


public class transactionsModel {
    
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    //~~~SQL QUERY ~~~//
    //private static String INSERT_ALL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, t_nid, apt_id, tr_payment_method ) VALUES (?,?,?,?,?,?,?)";
    private static final String INSERT_APT_BILL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, apt_id, tr_payment_method ) VALUES (?,?,NOW(),?,?,?)";
    private static final String INSERT_DUE_PAID = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose,t_nid, apt_id, tr_payment_method, rent_month ) VALUES (?,?,NOW(),?,?,?,?,?)";
    private static final String UPDATE = "UPDATE transactions SET tr_type=?, tr_amount=?, tr_datetime=?, tr_purpose=?, t_nid=?, apt_id=?, tr_payment_method=? WHERE tr_id = ?";
    private static final String DELETE = "DELETE FROM transactions WHERE tr_id = ?";
    private static final String INSERT_RENT ="INSERT INTO transactions (tr_type, tr_amount, tr_datetime, tr_purpose, t_nid, apt_id, tr_payment_method,rent_month) VALUES (?,?,NOW(),?,?,?,?,?)";
    private static final String INSERT_NORMAL_BILL = "INSERT INTO transactions ( tr_type, tr_amount, tr_datetime, tr_purpose, tr_payment_method ) VALUES (?,?,NOW(),?,?)";
    private static final String SELECT_ALL = "SELECT * FROM transactions";    
    private static final String SELECT_BY_ID = "SELECT * FROM transactions WHERE tr_id = ?";
    private static final String SELECT_BY_TYPE = "SELECT * FROM transactions WHERE type= ?";
    private static final String SELECT_BY_PAYMENT_METHOD = "SELECT * FROM transactions WHERE tr_payment_method= ?";
    private static final String SELECT_BY_DATE = "SELECT * FROM transactions WHERE tr_datetime LIKE ";
    private static final String SELECT_BY_TENANT = "SELECT * FROM transactions WHERE t_nid =?";
    private static final String SELECT_BY_APT = "SELECT * FROM transactions WHERE apt_id =?";
    
    private static final String SELECT_LAST_ID = "SELECT tr_id FROM transactions ORDER BY tr_id DESC LIMIT 1";
    private static final String SELECT_TOTAL_RENT = "SELECT SUM(tr_amount) AS total_rent FROM transactions WHERE tr_purpose='RENT' AND tr_type = 'CREDIT'";
    private static final String SELECT_TOTAL_EXPENSES = "SELECT SUM(tr_amount) AS total_expenses FROM transactions WHERE tr_type = 'DEBIT'";
    private static final String SELECT_TOTAL_INCOME_BY_MONTH = "SELECT SUM(tr_amount) AS total_income FROM transactions WHERE (tr_purpose='RENT' OR tr_purpose='DUE') AND rent_month=?";
    
    private static final String SELECT_IS_RENT_PAID = "SELECT COUNT(*) AS paid_rent from transactions WHERE rent_month = ? AND t_nid = ?";
    private static final String SELECT_DUE_TENANT_BY_MONTH = "SELECT nid,full_name,mobile,email,apt_id FROM tenant WHERE t_status='ACTIVE' AND nid NOT IN (select DISTINCT tenant.nid from tenant  join transactions ON tenant.nid = transactions.t_nid WHERE rent_month = ? AND t_status = 'ACTIVE')";
    private static final String SELECT_PAID_TENANT_BY_MONTH = "SELECT nid,full_name,mobile,email,apt_id FROM tenant WHERE t_status='ACTIVE' AND nid IN (select DISTINCT tenant.nid from tenant  join transactions ON tenant.nid = transactions.t_nid WHERE rent_month = ? AND t_status = 'ACTIVE')";
    private static final String SELECT_PAID_RENT_AMOUNT_ONLY_BY_MONTH = "select  nid,full_name,mobile,email,tenant.apt_id,tr_amount from tenant  join transactions ON tenant.nid = transactions.t_nid WHERE rent_month = ? AND tr_purpose ='RENT'";
    private static final String SELECT_ALL_INCOME_BY_MONTH = "SELECT tr_id,t_nid,full_name,mobile,tenant.apt_id,tr_amount,tr_purpose FROM transactions LEFT JOIN tenant ON tenant.nid=transactions.t_nid WHERE (tr_purpose='RENT' OR tr_purpose='DUE') AND rent_month=?";
    private static final String SELECT_TOTAL_EXPENSE_BY_MONTH = "SELECT SUM(tr_amount) AS amount FROM transactions WHERE tr_type='DEBIT' AND tr_datetime  BETWEEN ? AND ?";
    private static final String SELECT_EXPENSE_BY_MONTH = "SELECT * FROM transactions WHERE tr_type='DEBIT' AND tr_datetime  BETWEEN ? AND ?";
    
    
    // All Collected Rent Queries //
    private static final String SELECT_ALL_RENT = "SELECT tr_id,tr_amount,rent_month,tenant.nid,full_name,t_status,apt_name,b_name FROM (TRANSACTIONS LEFT JOIN TENANT On tenant.nid = transactions.t_nid) LEFT JOIN apartment ON apartment.apt_id = tenant.apt_id LEFT JOIN building ON building.b_id = apartment.b_id WHERE tr_type = 'CREDIT' AND tr_purpose='RENT'";
    private static final String SELECT_ALL_RENT_BY_MONTH = "SELECT tr_id,tr_amount,rent_month,tenant.nid,full_name,t_status,apt_name,b_name FROM (TRANSACTIONS LEFT JOIN TENANT On tenant.nid = transactions.t_nid) LEFT JOIN apartment ON apartment.apt_id = tenant.apt_id LEFT JOIN building ON building.b_id = apartment.b_id WHERE tr_type = 'CREDIT' AND tr_purpose='RENT' AND rent_month LIKE ";
    private static final String SELECT_ALL_RENT_BY_NID = "SELECT tr_id,tr_amount,rent_month,tenant.nid,full_name,t_status,apt_name,b_name FROM (TRANSACTIONS LEFT JOIN TENANT On tenant.nid = transactions.t_nid) LEFT JOIN apartment ON apartment.apt_id = tenant.apt_id LEFT JOIN building ON building.b_id = apartment.b_id WHERE tr_type = 'CREDIT' AND tr_purpose='RENT' AND t_nid=?";
    private static final String SELECT_ALL_RENT_BY_NAME = "SELECT tr_id,tr_amount,rent_month,tenant.nid,full_name,t_status,apt_name,b_name FROM (TRANSACTIONS LEFT JOIN TENANT On tenant.nid = transactions.t_nid) LEFT JOIN apartment ON apartment.apt_id = tenant.apt_id LEFT JOIN building ON building.b_id = apartment.b_id WHERE tr_type = 'CREDIT' AND tr_purpose='RENT' AND full_name LIKE ";

    private static final String SELECT_TXN_BY_NID = "SELECT * FROM transactions WHERE tr_type='CREDIT' AND t_nid=?";
    private static final String SELECT_TOTAL_PAID_RENT_BY_NID = "SELECT SUM(tr_amount) AS total FROM transactions WHERE tr_type='CREDIT' AND t_nid=?";
    
    
    
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
    
    public void INSERT_DUE_PAID(double tr_amount,long nid,int apt_id, String tr_payment_method,String rent_month)
    {
        try {
            pst = con.prepareStatement(INSERT_DUE_PAID);
            pst.setString(1, "CREDIT");
            pst.setDouble(2, tr_amount);
            pst.setString(3, "DUE");
            pst.setLong(4, nid);
            pst.setInt(5, apt_id);
            pst.setString(6, tr_payment_method);
            pst.setString(7, rent_month);
            
            pst.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet VIEW_TXN_BY_NID(long nid)
    {
        try {
            pst = con.prepareStatement(SELECT_TXN_BY_NID);
            pst.setLong(1, nid);
            return rs = pst.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   
    
    
    public ResultSet getDueTenantByMonth(String month){
         try {
            pst = con.prepareStatement(SELECT_DUE_TENANT_BY_MONTH);
            pst.setString(1, month);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }
    
    public ResultSet getTotalEarningByMonth(String month){
         try {
            pst = con.prepareStatement(SELECT_ALL_INCOME_BY_MONTH);
            pst.setString(1, month);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }
    
    public ResultSet getExpenseByMonth(String currMonthYear){
         try {
            String dateFrom = Time.getDateTimeFromMonthYear(currMonthYear)+"-01 00:00:00";
            String dateTo = Time.getDateTimeFromMonthYear(currMonthYear)+"-30 00:00:00";            
            pst = con.prepareStatement(SELECT_EXPENSE_BY_MONTH);
            pst.setString(1, dateFrom);
            pst.setString(2, dateTo);             
           
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }
    
    
    
    public double getTotalExpenseByMonth(String currMonthYear){
        double amount=0;
        
        try {
            
            String dateFrom = Time.getDateTimeFromMonthYear(currMonthYear)+"-01 00:00:00";
            String dateTo = Time.getDateTimeFromMonthYear(currMonthYear)+"-30 00:00:00";            
            pst = con.prepareStatement(SELECT_TOTAL_EXPENSE_BY_MONTH);
            pst.setString(1, dateFrom);
            pst.setString(2, dateTo);
            
            rs = pst.executeQuery();
            if (rs.next()) {
                amount = rs.getDouble("amount");
                return amount;
                
            }
            else{
                amount=0;
                return amount;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
        }     

        return amount;
    }
    
    
    
    
    
    public boolean isRentAlreadyPaid(long nid,String month){
        try {
            pst = con.prepareStatement(SELECT_IS_RENT_PAID);
            pst.setString(1, month);
            pst.setLong(2, nid);
            rs = pst.executeQuery();
            if(rs.next()){
                if(rs.getInt("paid_rent")>0)
                    return true;
                else{
                    return false;
                }
            }
            else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
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
    
public ResultSet VIEW_ALL_COLLECTED_RENT()
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_RENT);
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }
    
public ResultSet VIEW_ALL_COLLECTED_RENT_BY_MONTH(String month)
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_RENT_BY_MONTH+"('%"+month+"%')");
            
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }

public ResultSet VIEW_ALL_COLLECTED_RENT_BY_NAME(String name)
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_RENT_BY_NAME+"('%"+name+"%')");
            
            return rs = pst.executeQuery();       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(transactionsModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
        
    }


public ResultSet VIEW_ALL_COLLECTED_RENT_BY_NID(long nid)
    {
        try {
            pst = con.prepareStatement(SELECT_ALL_RENT_BY_NID);
            pst.setLong(1, nid);
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
                return 1000;
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
    
    
    public void INSERT_RENT(double tr_amount,long t_nid, int apt_id, String tr_payment_method,String rent_month)
    {
        try {
            pst = con.prepareStatement(INSERT_RENT);
            pst.setString(1, "CREDIT");
            pst.setDouble(2, tr_amount);
            pst.setString(3, "RENT");
            pst.setLong(4, t_nid);
            pst.setInt(5, apt_id);
            pst.setString(6, tr_payment_method);
            pst.setString(7, rent_month);
            
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
    
    public double GET_PAID_RENT_BY_NID(long nid)
    {
        try {
            pst = con.prepareStatement(SELECT_TOTAL_PAID_RENT_BY_NID);
            pst.setLong(1, nid);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return rs.getDouble("total");
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
    
    
    public double getTotalIncomeAmountByMonth(String month)
    {
        try {
            pst = con.prepareStatement(SELECT_TOTAL_INCOME_BY_MONTH);
            pst.setString(1, month);
            rs = pst.executeQuery();
            
            if(rs.next()){
                return rs.getDouble("total_income");
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
