
package system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Time {
    
    public static ArrayList<String> monthList = new ArrayList<String>();
    
    
    
public static String getCurDayMonthYear()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("E, MMM dd - yyyy");

        String formattedDate = date.format(formatedDate);
                
        return formattedDate.toUpperCase();
    }

public static String getCurHourMinSec()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("hh:mm:ss");

        String formattedDate = date.format(formatedDate);
                
        return formattedDate.toUpperCase();
    }


public static String getCurMonth()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("MMM");

        String formattedDate = date.format(formatedDate);
                
        return formattedDate.toUpperCase();
    }
    

public static String getCurMonthYear()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("MMM-YYYY");

        String formattedDate = date.format(formatedDate);
                
        return formattedDate.toUpperCase();
    }


public static String getMonthYearFromDateTime(String dateTime){
    
    //2022-07-24 00:11:00
    String year = dateTime.substring(0,4);
    String month = dateTime.substring(5,7);
    String monthName=null;
    
    switch(month){
        case "01":
            monthName = "JAN";
            break;
        case "02":
            monthName = "FEB";
            break;
        case "03":
            monthName = "MAR";
            break;
         case "04":
            monthName = "APR";
            break;
         case "05":
            monthName = "MAY";
            break;
         case "06":
            monthName = "JUN";
            break;
         case "07":
            monthName = "JUL";
            break;
         case "08":
            monthName = "AUG";
            break;
         case "09":
            monthName = "SEP";
            break;
         case "10":
            monthName = "OCT";
            break;
         case "11":
            monthName = "NOV";
            break;
            
        case "12":
            monthName = "DEC";
            break;
             
            
    }
    
    return (monthName+"-"+year);
    
    
}


public static String getDateTimeFromMonthYear(String monthyear){
    
    
    //JUL-2022
    String month = monthyear.substring(0,3);
    String year = monthyear.substring(4,8);    
    
    String monthNum=null;
    
    switch(month){
        case "JAN":
            monthNum = "01";
            break;
        case "FEB":
            monthNum = "02";
            break;
        case "MAR":
            monthNum = "03";
            break;
         case "APR":
            monthNum = "04";
            break;
         case "MAY":
            monthNum = "05";
            break;
         case "JUN":
            monthNum = "06";
            break;
         case "JUL":
            monthNum = "07";
            break;
         case "AUG":
            monthNum = "08";
            break;
         case "SEP":
            monthNum = "09";
            break;
         case "OCT":
            monthNum = "10";
            break;
         case "NOV":
            monthNum = "11";
            break;
            
        case "DEC":
            monthNum = "12";
            break;
             
            
    }
    
    //2022-07-24 00:11:00
    return (year+"-"+monthNum);
    
    
}


    
    
}
