
package ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import model.transactionsModel;


public class test {
    
    
    static Scanner sc = new Scanner(System.in);
    static ResultSet rs = null;
    static buildingModel building = new buildingModel();
    static apartmentModel APT = new apartmentModel();
    static transactionsModel TR = new transactionsModel();
    
    public static void main(String[] args) {
        
        
        
        tenantModel T = new tenantModel();
        long mobile = 012620L;
        
        T.INSERT(19995464345564L, "Md Shahin Shah",22 , "MALE", "ISLAM", "BANGLADESHI", "OTHERS", mobile,"shahins121@gmail.com", "Khulshi,Chittagong,Bangladesh", "src/res/male01.png", 6, 204, 15000, "APR 2022");
        
        
        
        System.out.println("Success");
        
        
        /*try {
            while(rs.next())
            {                
                System.out.println("ID:"+rs.getInt("apt_id"));
                System.out.println("NAME:"+rs.getString("apt_name"));
                System.out.println("AVAILABLE:"+rs.getString("available"));
                System.out.println("B_ID:"+rs.getInt("b_id"));
                System.out.println("BUILDING:"+rs.getString("b_name"));
                System.out.println("LOCATION:"+rs.getString("location"));
                
                System.out.println("\n\n");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        
                
        
        
        
        
        
        //building.UPDATE(id,name, num_of_apt, location);
        
        //rs = building.VIEW_ALL();
        
        /*
        try {
            ResultSet rs = building.SEARCH_BY_LOCATION(location);
            if(rs.next())
            {
                System.out.println("Success");
                System.out.println(rs.getInt("b_id") + rs.getString("b_name")+ rs.getInt("num_of_apt")+ rs.getString("location"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        
        
    }
    
}
