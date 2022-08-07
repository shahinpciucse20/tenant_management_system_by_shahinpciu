package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
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
import system.MailSender;
import system.Time;
import values.Values;


public class DueRentTenant extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;
    
    private static transactionsModel tModel = null;
    private static DueModel dueModel = null;
    private static apartmentModel aModel = null;
  
    public DueRentTenant() {
        initComponents();
        
        tModel = new transactionsModel();
        dueModel = new DueModel();
        aModel = new apartmentModel();
        
        displayAllDueTenant(tModel.getDueTenantByMonth(Time.getCurMonthYear()));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(900, 700));
        this.setMinimumSize(new Dimension(900, 700));
        this.setPreferredSize(new Dimension(900, 700));
        lbl_totalduerent.setText(String.valueOf(dueModel.getTotalDueByMonth(Time.getCurMonthYear())));
        lbl_curmonth.setText(Time.getCurMonthYear());
        lbl_total.setText("Total Due in "+Time.getCurMonth()+":");
        btn_rcvRent.setVisible(false);
    }
    
    public static void setTotalDueAmount(){
        lbl_totalduerent.setText(String.valueOf(dueModel.getTotalDueByMonth(Time.getCurMonthYear())));
    }
    
    
    public void sendMailOnlyAction(){
        DefaultTableModel recordTable = (DefaultTableModel)tbl_dueRentTenant.getModel();
        int row_count = recordTable.getRowCount();
        ArrayList<String> toMailList = new ArrayList<String>();
        
        for(int i=0 ;i<row_count; i++){
            toMailList.add(i,recordTable.getValueAt(i, 3).toString());
        }

        
        
        
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MailSender.sendEmailOnlyMultiple(toMailList);        
            }
        });  
        t1.start();
            
        
        JOptionPane.showMessageDialog(this, "Message Send to("+toMailList.size()+") Tenant Successfully!");
        
    }
    
    
    public static void displayAllDueTenant(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_dueRentTenant.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getLong("nid"));
                    columData.add(rs.getString("full_name"));  
                    columData.add("0"+rs.getString("mobile"));
                    columData.add(rs.getString("email"));
                    columData.add(rs.getInt("apt_id"));
                    rs_apt = aModel.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(rs.getInt("apt_id"));
                    if(rs_apt.next()){
                        columData.add(rs_apt.getString("apt_name"));
                        columData.add(rs_apt.getDouble("rent"));
                    }
                        
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(DueRentTenant.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dueRentTenant = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_totalduerent = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_rcvRent = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        lbl_curmonth = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_sendreminder = new javax.swing.JButton();
        btn_close1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 700));
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
        jLabel2.setText("Current Month Due");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 630));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_dueRentTenant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_dueRentTenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Full Name", "Mobile", "Email", "Apt ID", "Apt Name", "Rent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dueRentTenant.setRowHeight(30);
        tbl_dueRentTenant.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_dueRentTenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dueRentTenantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dueRentTenant);
        if (tbl_dueRentTenant.getColumnModel().getColumnCount() > 0) {
            tbl_dueRentTenant.getColumnModel().getColumn(2).setMinWidth(120);
            tbl_dueRentTenant.getColumnModel().getColumn(2).setMaxWidth(120);
            tbl_dueRentTenant.getColumnModel().getColumn(4).setMinWidth(60);
            tbl_dueRentTenant.getColumnModel().getColumn(4).setMaxWidth(60);
            tbl_dueRentTenant.getColumnModel().getColumn(5).setMinWidth(70);
            tbl_dueRentTenant.getColumnModel().getColumn(5).setMaxWidth(80);
            tbl_dueRentTenant.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_dueRentTenant.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 860, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Tenant who did not pay Rent for Current Month");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 400, 40));

        lbl_totalduerent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_totalduerent.setText("00");
        jPanel2.add(lbl_totalduerent, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 180, 40));

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_total.setText("Total Due in JUL:");
        jPanel2.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 570, 170, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 610, 340, 10));

        btn_rcvRent.setBackground(new java.awt.Color(255, 0, 0));
        btn_rcvRent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_rcvRent.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcvRent.setText("Recieve Rent");
        btn_rcvRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvRentActionPerformed(evt);
            }
        });
        jPanel2.add(btn_rcvRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 150, 40));

        btn_close.setBackground(new java.awt.Color(51, 51, 51));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, 100, 40));

        lbl_curmonth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel2.add(lbl_curmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 150, 10));

        btn_sendreminder.setBackground(new java.awt.Color(255, 0, 0));
        btn_sendreminder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sendreminder.setForeground(new java.awt.Color(255, 255, 255));
        btn_sendreminder.setText("SEND REMINDER MAIL");
        btn_sendreminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendreminderActionPerformed(evt);
            }
        });
        jPanel2.add(btn_sendreminder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 200, 40));

        btn_close1.setBackground(new java.awt.Color(51, 51, 51));
        btn_close1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close1.setForeground(new java.awt.Color(255, 255, 255));
        btn_close1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_close1.setText("RESET");
        btn_close1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 120, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_rcvRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvRentActionPerformed
        DefaultTableModel recordTable = (DefaultTableModel)tbl_dueRentTenant.getModel();   
        int selectedRow = tbl_dueRentTenant.getSelectedRow();     
        if(selectedRow >= 0)
        {
            long nid = Long.parseLong(recordTable.getValueAt(selectedRow,0).toString());
            String full_name = recordTable.getValueAt(selectedRow, 1).toString();
            
            this.dispose();
            
            RcvRentPage rentPage = new RcvRentPage();  
            rentPage.setVisible(true);
            rentPage.cb_tnid.removeAllItems();
            rentPage.cb_tnid.addItem(String.valueOf(nid));
            rentPage.cb_tnid.setSelectedIndex(0);
            rentPage.setAllInfoByNID();
                    
            
                     
        }
    }//GEN-LAST:event_btn_rcvRentActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_sendreminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendreminderActionPerformed
        try {
            
                if(tbl_dueRentTenant.getRowCount()!=0){
                        int choiche = JOptionPane.showConfirmDialog(null,"Do You Want Send Reminder Email?", "CONFIRMATION!",JOptionPane.YES_NO_OPTION );
                        if(choiche == JOptionPane.YES_OPTION)
                        {                              
                            sendMailOnlyAction();
                        }
                        else
                        {
                            tbl_dueRentTenant.clearSelection();
                        }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "There is No Recipient!");
                }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to Sent Email! Please Check your Internet Connection!");
        }
        
        
    }//GEN-LAST:event_btn_sendreminderActionPerformed

    private void tbl_dueRentTenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dueRentTenantMouseClicked
        btn_rcvRent.setVisible(true);
    }//GEN-LAST:event_tbl_dueRentTenantMouseClicked

    private void btn_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close1ActionPerformed
       DBConnector.closeCon();
       this.dispose();
       new DueRentTenant().setVisible(true);
    }//GEN-LAST:event_btn_close1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DueRentTenant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_close1;
    private javax.swing.JButton btn_rcvRent;
    private javax.swing.JButton btn_sendreminder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_curmonth;
    private javax.swing.JLabel lbl_total;
    public static javax.swing.JLabel lbl_totalduerent;
    private static javax.swing.JTable tbl_dueRentTenant;
    // End of variables declaration//GEN-END:variables
}
