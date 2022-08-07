package system;

import java.util.ArrayList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Address;
import model.UserInfo;
import values.Values;
import java.io.File;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import javax.mail.Multipart;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;

public class MailSender {
    private static UserInfo userInfo = new UserInfo();
    
    private static String MAIL_HOST = "smtp.gmail.com";
    private static String MAIL_PORT = "465";
    private static String FROM = Values.FROM_MAIL;  
    
    
    
    public static void sendEmailOnlyMultiple(ArrayList<String> recipientList){
        
        //String to = recpient;        
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.port", MAIL_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Values.MY_USER_MAIL, Values.MY_USER_PASS);

            }

        });

       
        
            
                try {
                
                MimeMessage message = new MimeMessage(session);
               
                message.setFrom(new InternetAddress(FROM));

                InternetAddress[] recipientAddress = new InternetAddress[recipientList.size()];
                int counter = 0;
                
                for (String reci : recipientList) {
                    recipientAddress[counter] = new InternetAddress(reci);
                    counter++;
                }
                message.setRecipients(Message.RecipientType.BCC, recipientAddress);
                
                               
                
                // Set Subject: header field
                message.setSubject(Values.REM_MSG_HEADER);

                // Now set the actual message
                message.setText(userInfo.getRemMsg());

                Transport.send(message);
                
                
                    } catch (MessagingException mex) {
                mex.printStackTrace();
                }
                

    }
    
    
    
   public static void sendEmailOnlyOnce(String recipient){
        
        
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.port", MAIL_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Values.MY_USER_MAIL, Values.MY_USER_PASS);

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        
            
                try {
                
                MimeMessage message = new MimeMessage(session);

                
                message.setFrom(new InternetAddress(FROM));
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                
                
                message.setSubject(Values.REM_MSG_HEADER);
                
                message.setText(userInfo.getRemMsg());

                Transport.send(message);
                
                
                } 
                catch (MessagingException mex) {
                mex.printStackTrace();
                }
                
  
        

    }
     
    
   public static void sendEmailWithAttachmentOnce(String recipient,String filePath,String rentMonth,String bodyText){
        
        
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.port", MAIL_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Values.MY_USER_MAIL, Values.MY_USER_PASS);

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        
            
                try {
                
                MimeMessage message = new MimeMessage(session);

                
                message.setFrom(new InternetAddress(FROM));
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                
                
                message.setSubject(Values.PAY_MSG_HEADER+rentMonth);
                
                
                //~~Attachment
                
                    Multipart multipart = new MimeMultipart();

                    MimeBodyPart attachmentPart = new MimeBodyPart();

                    MimeBodyPart textPart = new MimeBodyPart();

                    try {

                        File f =new File(filePath);

                        attachmentPart.attachFile(f);
                        textPart.setText(bodyText);
                        multipart.addBodyPart(textPart);
                        multipart.addBodyPart(attachmentPart);

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                
                    
                message.setContent(multipart);
                
                Transport.send(message);
                
                
                } 
                catch (MessagingException mex) {
                mex.printStackTrace();
                }

    }
   
    
   public static void sendCustomeMail(String recipient, String subject , String body) throws AddressException, MessagingException{
        
        
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", MAIL_HOST);
        properties.put("mail.smtp.port", MAIL_PORT);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Values.MY_USER_MAIL, Values.MY_USER_PASS);

                        }  });   
        
        MimeMessage message = new MimeMessage(session);                
        message.setFrom(new InternetAddress(FROM));                
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));              
        message.setSubject(subject);                
        message.setText(body);
        Transport.send(message);

    }
   
   
   
   
   
   
   
    
}
