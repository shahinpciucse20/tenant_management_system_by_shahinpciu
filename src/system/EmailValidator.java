  
package system;

import java.util.regex.*; 


public class EmailValidator {   
    
    
    
    public static boolean isEmailValid(String email){
        
        //Regular Expression   
        String regex = "^(.+)@(.+)$"; 
        
        //Compile regular expression to get the pattern  
        Pattern pattern = Pattern.compile(regex);         
         
        Matcher matcher = pattern.matcher(email); 
        
        return matcher.matches();
        
    }
    
}
