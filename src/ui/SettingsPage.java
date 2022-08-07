
package ui;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DBConnector;
import model.UserInfo;
import values.Values;


public class SettingsPage extends javax.swing.JFrame {
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    String password;
    
    private UserInfo userInfo = null;

    
    public SettingsPage() {
        initComponents();
        
        userInfo = new UserInfo();
        
        password = getPassFromDB();
        jpass_old.setText(password);
        jpass_new.requestFocus();
        txt_remmsg.setText(getRemMsg());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    private String getPassFromDB(){
        
        return userInfo.getPassword();
 
    }

    
    private void changeAction(String newPass){
          userInfo = new UserInfo();
          userInfo.updatePassword(newPass);
                  
    }
    
    private String getRemMsg(){
        userInfo = new UserInfo();
        return userInfo.getRemMsg();
    }
    
    private void saveRemMsg(String newMsg){
        
        userInfo = new UserInfo();
        userInfo.updateRemMsg(newMsg);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TOP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        middle = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        MESSAGE = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remmsg = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        CREDINTIAL = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpass_old = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jpass_new = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jpass_confirm = new javax.swing.JPasswordField();
        btn_change = new javax.swing.JButton();
        rb_unhideconf = new javax.swing.JRadioButton();
        rb_unhideold = new javax.swing.JRadioButton();
        rb_unhidenew = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(779, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        TOP.setBackground(new java.awt.Color(0, 0, 0));
        TOP.setPreferredSize(new java.awt.Dimension(779, 80));
        TOP.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SETTINGS");
        TOP.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(TOP, java.awt.BorderLayout.PAGE_START);

        middle.setBackground(new java.awt.Color(255, 255, 255));
        middle.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        MESSAGE.setBackground(new java.awt.Color(255, 255, 255));
        MESSAGE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_remmsg.setColumns(20);
        txt_remmsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_remmsg.setRows(5);
        jScrollPane1.setViewportView(txt_remmsg);

        MESSAGE.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 750, 220));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REMINDER MESSAGE TEMPLATE");
        MESSAGE.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 4, 740, 40));

        btn_save.setBackground(new java.awt.Color(255, 0, 0));
        btn_save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("SAVE");
        btn_save.setBorder(null);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        MESSAGE.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 180, 50));

        jTabbedPane1.addTab("Reminder Message", MESSAGE);

        CREDINTIAL.setBackground(new java.awt.Color(255, 255, 255));
        CREDINTIAL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CREDINTIAL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("OLD PASSWORD");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 22));
        CREDINTIAL.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 190, 50));

        jpass_old.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpass_old.setMargin(new java.awt.Insets(2, 2, 2, 25));
        CREDINTIAL.add(jpass_old, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 460, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("NEW PASSWORD");
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 22));
        CREDINTIAL.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, 50));

        jpass_new.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpass_new.setMargin(new java.awt.Insets(2, 2, 2, 25));
        CREDINTIAL.add(jpass_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 460, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("CONFIRM PASSWORD");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 22));
        CREDINTIAL.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 230, 50));

        jpass_confirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpass_confirm.setMargin(new java.awt.Insets(2, 2, 2, 25));
        CREDINTIAL.add(jpass_confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 460, 50));

        btn_change.setBackground(new java.awt.Color(255, 0, 0));
        btn_change.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_change.setForeground(new java.awt.Color(255, 255, 255));
        btn_change.setText("CHANGE");
        btn_change.setBorder(null);
        btn_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeActionPerformed(evt);
            }
        });
        CREDINTIAL.add(btn_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 200, 50));

        rb_unhideconf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/hidden_icon.png"))); // NOI18N
        rb_unhideconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_unhideconfActionPerformed(evt);
            }
        });
        CREDINTIAL.add(rb_unhideconf, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, -1, 30));

        rb_unhideold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/hidden_icon.png"))); // NOI18N
        rb_unhideold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_unhideoldActionPerformed(evt);
            }
        });
        CREDINTIAL.add(rb_unhideold, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, 30));

        rb_unhidenew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/hidden_icon.png"))); // NOI18N
        rb_unhidenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_unhidenewActionPerformed(evt);
            }
        });
        CREDINTIAL.add(rb_unhidenew, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CHANGE PASSWORD");
        CREDINTIAL.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 4, 750, 40));

        jTabbedPane1.addTab("Credential", CREDINTIAL);

        middle.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(middle, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeActionPerformed
        if(jpass_new.getText().length()>=4 && jpass_confirm.getText().length()>=4 ){
            if(jpass_new.getText().equals(jpass_confirm.getText())){
                changeAction(jpass_new.getText());
                JOptionPane.showMessageDialog(this, "Password Successfully Changed!");
                this.dispose();
                new SettingsPage().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Password Does not Matched!"); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Password Must be 4 Character Length!"); 
        }
    }//GEN-LAST:event_btn_changeActionPerformed

    private void rb_unhideconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_unhideconfActionPerformed
        if(rb_unhideconf.isSelected())
        {
            jpass_confirm.setEchoChar((char)0);
        }
        else if(!rb_unhideconf.isSelected())
        {
            jpass_confirm.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_rb_unhideconfActionPerformed

    private void rb_unhideoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_unhideoldActionPerformed
        if(rb_unhideold.isSelected())
        {
            jpass_old.setEchoChar((char)0);
        }
        else if(!rb_unhideold.isSelected())
        {
            jpass_old.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_rb_unhideoldActionPerformed

    private void rb_unhidenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_unhidenewActionPerformed
       if(rb_unhidenew.isSelected())
        {
            jpass_new.setEchoChar((char)0);
        }
        else if(!rb_unhidenew.isSelected())
        {
            jpass_new.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_rb_unhidenewActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(txt_remmsg.getText().length()!=0){
            saveRemMsg(txt_remmsg.getText());
            JOptionPane.showMessageDialog(this, "Reminder Message Successfully Changed!");
            txt_remmsg.setText(getRemMsg());
        }
        else{
            JOptionPane.showMessageDialog(this, "Message Can not Be Empty!"); 
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SettingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CREDINTIAL;
    private javax.swing.JPanel MESSAGE;
    private javax.swing.JPanel TOP;
    private javax.swing.JButton btn_change;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField jpass_confirm;
    private javax.swing.JPasswordField jpass_new;
    private javax.swing.JPasswordField jpass_old;
    private javax.swing.JPanel middle;
    private javax.swing.JRadioButton rb_unhideconf;
    private javax.swing.JRadioButton rb_unhidenew;
    private javax.swing.JRadioButton rb_unhideold;
    private javax.swing.JTextArea txt_remmsg;
    // End of variables declaration//GEN-END:variables
}
