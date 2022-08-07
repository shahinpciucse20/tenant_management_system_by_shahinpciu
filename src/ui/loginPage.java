
package ui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileWriter;   
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.DBConnector;
import model.UserInfo;
import values.Values;



public class loginPage extends javax.swing.JFrame {
    
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    private static UserInfo userInfo = null;
    
    
    String user_input = null;    
    
    String password;
    
    
    boolean remembered;
    final String local_db_path = "src/local_db/db.txt";

   
    public loginPage() {         
        
        
        initComponents();        

        txt_pass.setEchoChar('*');              
        
        
        setIcon();
        
        
        
        
        
        
    }
    
    private static String getPassFromDB(){ return userInfo.getPassword();}
 
    
    
    
    
    
    private void setIcon()
    {            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));        
    }
    
    
    
    

    void readFromFile()
    {
       if(remembered){
           
           
           try {
               File myObj = new File(local_db_path);
               Scanner myReader = new Scanner(myObj);
               
               if (myReader.hasNextLine()) {
                   String savedKey = myReader.nextLine(); 
                   txt_pass.setText(savedKey);
                   
               }
               
           } catch (FileNotFoundException ex) {
               Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    }
    
    void saveKeyToFile(String key)
    {       
        
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(local_db_path);
            myWriter.write(key);
            myWriter.close();
            
        } catch (IOException ex) {
            Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    void LoginAction(){
        try {
            userInfo = new UserInfo();         
            password = getPassFromDB();

            user_input = txt_pass.getText().toString();

            if(user_input.equals(password))
            {

                    this.dispose();
                    new SplashScreen().setVisible(true);

                }
            else{
                JOptionPane.showMessageDialog(this, "Wrong Password!!"); 
            }
        }       
            
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, e); 
        }
    }
        
            
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_close = new javax.swing.JButton();
        rb_unhide = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("LOG IN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        txt_pass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "ENTER LOGIN PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_pass.setName(""); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        jPanel2.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 199, 270, -1));

        btn_login.setBackground(new java.awt.Color(255, 0, 0));
        btn_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("LOG IN");
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 180, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 237, 16));

        btn_close.setBackground(new java.awt.Color(255, 0, 0));
        btn_close.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 138, 35));

        rb_unhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/hidden_icon.png"))); // NOI18N
        rb_unhide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_unhideActionPerformed(evt);
            }
        });
        jPanel2.add(rb_unhide, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 330, 528));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tenant Management System");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 356, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/tms.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(64, 64));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 220, 235));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        if(txt_pass.getText().length()!=0)
            LoginAction();
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        if(txt_pass.getText().length()!=0)
            LoginAction();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void rb_unhideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_unhideActionPerformed
        if(rb_unhide.isSelected())
        {
            txt_pass.setEchoChar((char)0);
        }
        else if(!rb_unhide.isSelected())
        {
            txt_pass.setEchoChar('*');
        }
    }//GEN-LAST:event_rb_unhideActionPerformed

    public static void main(String args[]) {       
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rb_unhide;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
