
package system;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class AutoMailJob {
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        
        Calendar today = Calendar.getInstance();
        
        today.add(Calendar.YEAR, 2022);
        today.add(Calendar.MONTH, Calendar.JULY);
        today.add(Calendar.DAY_OF_MONTH, 15);
        today.add(Calendar.HOUR_OF_DAY, 19);
        today.add(Calendar.MINUTE, 15);
        today.add(Calendar.SECOND, 0);
        today.add(Calendar.MILLISECOND, 0);
        
        
        timer.scheduleAtFixedRate(task, today.getTime(), 5000);
        
        
        
    }
    
    
    
    
    
    
}
