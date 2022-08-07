
package system;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import ui.UpdateBuildingPage;
import values.Values;


public class Print{ 
    
    
    
    
    public static void printJTable(JTable table, String title){
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat(Values.APP_NAME+" - "+Time.getCurDayMonthYear()+"-"+Time.getCurHourMinSec());
        
        try {
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (PrinterException ex) {
            Logger.getLogger(Print.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
