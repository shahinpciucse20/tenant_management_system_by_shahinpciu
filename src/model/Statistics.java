
package model;

 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.Time;

public class Statistics {
    
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    private static final String SELECT_TOTAL_EXPENSE_BY_MONTH = "SELECT SUM(tr_amount) AS amount FROM transactions WHERE tr_type='DEBIT' AND tr_datetime  BETWEEN ? AND ?";
    private static final String SELECT_TOTAL_INCOME_BY_MONTH = "SELECT SUM(tr_amount) AS amount FROM transactions WHERE tr_type='CREDIT' AND rent_month = ?";
    
    private static final String SELECT_INCOME_GROUP_BY_MONTH = "SELECT rent_month,SUM(tr_amount) AS amount FROM transactions WHERE tr_type='CREDIT'  GROUP BY rent_month";
    private static final String SELECT_INCOME_GROUP_BY_APT = "SELECT apt_id,SUM(tr_amount) AS amount FROM transactions WHERE tr_type='CREDIT' GROUP BY apt_id";
    private static final String SELECT_RECENT_TXN = "SELECT * FROM transactions ORDER BY tr_datetime DESC";
            
            
            
            
    public Statistics(){
        try {
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public ResultSet getIncomeGroupByMonths(){
        
        try {
            pst = con.prepareStatement(SELECT_INCOME_GROUP_BY_MONTH);
            return rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
      public ResultSet getIncomeGroupByAptId(){
        
        try {
            pst = con.prepareStatement(SELECT_INCOME_GROUP_BY_APT);
            return rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
      
      
      public ResultSet getRecentTXN(){
        
        try {
            pst = con.prepareStatement(SELECT_RECENT_TXN);
            return rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public double getTotalExpenseInMonth(String currMonthYear){
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
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }     

        return amount;
    }
    
    
    public double getTotalIncomeInMonth(String currMonthYear){
        double amount=0;
        
        try {
            
            
            pst = con.prepareStatement(SELECT_TOTAL_INCOME_BY_MONTH);
            pst.setString(1, currMonthYear);
            
            
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
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }     

        return amount;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
