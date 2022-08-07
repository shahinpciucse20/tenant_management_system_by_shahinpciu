
package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBConnector;
import model.DueModel;
import model.apartmentModel;
import model.transactionsModel;
import model.tenantModel;
import system.MailSender;
import system.Time;
import static ui.HomePage.getCurrentMonthYear;


public class SendRemMail extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;
    
   
    private static tenantModel tenModel = null;
    
    private static apartmentModel aModel = null;
  
    public SendRemMail() {
        initComponents();
        tenModel = new tenantModel();
        aModel = new apartmentModel();
        
        
        displayActiveTenants(tenModel.VIEW_ALL_ACTIVE());
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(900, 700));
        this.setMinimumSize(new Dimension(900, 700));
        this.setPreferredSize(new Dimension(900, 700));
   
    }
    
   
    public void sendMailOnlyAction(){
        DefaultTableModel recordTable = (DefaultTableModel)tbl_activeTenant.getModel();
        int row_count = recordTable.getRowCount();
        ArrayList<String> toMailList = new ArrayList<String>();
        
        for(int i=0 ;i<row_count; i++){
            toMailList.add(i,recordTable.getValueAt(i, 2).toString());
        }
        
        //dlg_mailProgress.setVisible(true);
        //dlg_mailProgress.setSize(570, 300);
        
        
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MailSender.sendEmailOnlyMultiple(toMailList);        
            }
        });  
        t1.start();
            
            
        
        //dlg_mailProgress.setVisible(false);
        
        JOptionPane.showMessageDialog(this, "Message Send to("+toMailList.size()+") Tenant Successfully!");
        
    }
    
    
    
    
    
    
    public static void displayActiveTenants(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_activeTenant.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getLong("nid"));
                    columData.add(rs.getString("full_name"));
   
                    columData.add(rs.getString("email"));
                    
                    rs_apt = aModel.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(rs.getInt("apt_id"));
                    if(rs_apt.next()){
                        columData.add(rs_apt.getString("apt_name"));
                        columData.add(rs_apt.getDouble("rent"));
                    }
                        
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(SendRemMail.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_mailProgress = new javax.swing.JDialog();
        body4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_activeTenant = new javax.swing.JTable();
        btn_close = new javax.swing.JButton();
        btn_sendMail = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        dlg_mailProgress.setAlwaysOnTop(true);
        dlg_mailProgress.setBackground(new java.awt.Color(255, 255, 255));
        dlg_mailProgress.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_mailProgress.setResizable(false);
        dlg_mailProgress.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body4.setBackground(new java.awt.Color(255, 255, 255));
        body4.setMaximumSize(new java.awt.Dimension(570, 300));
        body4.setMinimumSize(new java.awt.Dimension(570, 300));
        body4.setPreferredSize(new java.awt.Dimension(570, 300));
        body4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please Wait");
        body4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 290, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Sending Emails....");
        body4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        dlg_mailProgress.getContentPane().add(body4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1279, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Active Tenants");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 630));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_activeTenant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_activeTenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Full Name", "Email", "Apt Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_activeTenant.setRowHeight(30);
        tbl_activeTenant.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_activeTenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_activeTenantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_activeTenant);
        if (tbl_activeTenant.getColumnModel().getColumnCount() > 0) {
            tbl_activeTenant.getColumnModel().getColumn(3).setMinWidth(70);
            tbl_activeTenant.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 860, 520));

        btn_close.setBackground(new java.awt.Color(51, 51, 51));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 100, 40));

        btn_sendMail.setBackground(new java.awt.Color(255, 0, 0));
        btn_sendMail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sendMail.setForeground(new java.awt.Color(255, 255, 255));
        btn_sendMail.setText("SEND MAIL");
        btn_sendMail.setBorder(null);
        btn_sendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendMailActionPerformed(evt);
            }
        });
        jPanel2.add(btn_sendMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 160, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Configure Reminder Message");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 574, 210, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_activeTenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_activeTenantMouseClicked
        
    }//GEN-LAST:event_tbl_activeTenantMouseClicked

    private void btn_sendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendMailActionPerformed
        
        try {
            
                int choiche = JOptionPane.showConfirmDialog(null,"Do You Want Send Reminder Email?", "CONFIRMATION!",JOptionPane.YES_NO_OPTION );
                if(choiche == JOptionPane.YES_OPTION)
                {                              
                    sendMailOnlyAction();
                }
                else{
                    tbl_activeTenant.clearSelection();
                }
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to Sent Email! Please Check your Internet Connection!");
        }
        
        
        
        
    }//GEN-LAST:event_btn_sendMailActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        new SettingsPage().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendRemMail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body4;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_sendMail;
    private static javax.swing.JDialog dlg_mailProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tbl_activeTenant;
    // End of variables declaration//GEN-END:variables
}
