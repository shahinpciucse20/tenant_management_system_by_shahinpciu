
package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.DBConnector;
import model.DueModel;
import model.apartmentModel;
import model.transactionsModel;
import model.tenantModel;
import system.Print;
import system.Time;
import static ui.HomePage.getCurrentMonthYear;
import values.Values;


public class IncomeInMonth extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;
    
    private static transactionsModel tModel = null;
    private static tenantModel tenModel = null;
    private static DueModel dueModel = null;
    private static apartmentModel aModel = null;
  
    public IncomeInMonth() {      

        initComponents();
        
        tModel= new transactionsModel();
        tenModel = new tenantModel();
        dueModel = new DueModel();
        aModel = new apartmentModel();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
        displayAllIncomeData(tModel.getTotalEarningByMonth(Time.getCurMonthYear()));
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(1082, 730));
        this.setMinimumSize(new Dimension(1082, 730));
        this.setPreferredSize(new Dimension(1082, 730));
        setTotalEarningAmount();
        lbl_curmonth.setText(Time.getCurMonthYear());
        lbl_total.setText("Total Earning in "+Time.getCurMonth()+":");
        
        
    }
    
    
    
    public static void setTotalEarningAmount(){
        lbl_totalincome.setText(String.valueOf(tModel.getTotalIncomeAmountByMonth(Time.getCurMonthYear())));
    }
    
    
    public static void displayAllIncomeData(ResultSet rs)
    {
        tModel= new transactionsModel();
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_totalEarningMonth.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("tr_id"));
                    columData.add(rs.getLong("t_nid"));
                    columData.add(rs.getString("full_name"));  
                    columData.add("0"+rs.getLong("mobile"));                    
                    columData.add(rs.getInt("apt_id"));
                    rs_apt = aModel.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(rs.getInt("apt_id"));
                    if(rs_apt.next()){
                        columData.add(rs_apt.getString("apt_name"));   
                    }
                    columData.add(rs.getDouble("tr_amount"));
                    columData.add(rs.getString("tr_purpose"));
                        
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(IncomeInMonth.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_totalEarningMonth = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_totalincome = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_print = new javax.swing.JButton();
        lbl_curmonth = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_close1 = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 700));
        setMinimumSize(new java.awt.Dimension(1080, 700));
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
        jLabel2.setText("Current Month Income");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 630));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_totalEarningMonth.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tbl_totalEarningMonth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TXN Id", "NID", "Full Name", "Mobile", "Apt ID", "Apt Name", "Amount", "Purpose"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_totalEarningMonth.setRowHeight(50);
        tbl_totalEarningMonth.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_totalEarningMonth.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_totalEarningMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_totalEarningMonthMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_totalEarningMonth);
        if (tbl_totalEarningMonth.getColumnModel().getColumnCount() > 0) {
            tbl_totalEarningMonth.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_totalEarningMonth.getColumnModel().getColumn(1).setMinWidth(170);
            tbl_totalEarningMonth.getColumnModel().getColumn(1).setMaxWidth(180);
            tbl_totalEarningMonth.getColumnModel().getColumn(2).setMinWidth(180);
            tbl_totalEarningMonth.getColumnModel().getColumn(2).setMaxWidth(220);
            tbl_totalEarningMonth.getColumnModel().getColumn(3).setMinWidth(160);
            tbl_totalEarningMonth.getColumnModel().getColumn(3).setMaxWidth(200);
            tbl_totalEarningMonth.getColumnModel().getColumn(4).setMinWidth(60);
            tbl_totalEarningMonth.getColumnModel().getColumn(4).setMaxWidth(60);
            tbl_totalEarningMonth.getColumnModel().getColumn(5).setMinWidth(70);
            tbl_totalEarningMonth.getColumnModel().getColumn(5).setMaxWidth(80);
            tbl_totalEarningMonth.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_totalEarningMonth.getColumnModel().getColumn(6).setMaxWidth(120);
            tbl_totalEarningMonth.getColumnModel().getColumn(7).setMinWidth(100);
            tbl_totalEarningMonth.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 1040, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tenant who paid Rent and Dues for Current Month");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 510, 40));

        lbl_totalincome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_totalincome.setText("00");
        jPanel2.add(lbl_totalincome, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 570, 190, 40));

        lbl_total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_total.setText("Total Earning in JUL:");
        jPanel2.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 570, 200, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 610, 390, 10));

        btn_print.setBackground(new java.awt.Color(255, 0, 0));
        btn_print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/-printWhite-24x.png"))); // NOI18N
        btn_print.setText("PRINT");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 570, 130, 40));

        lbl_curmonth.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel2.add(lbl_curmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 150, 10));

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
        jPanel2.add(btn_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 120, 40));

        btn_close.setBackground(new java.awt.Color(51, 51, 51));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 110, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1080, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        Print.printJTable(tbl_totalEarningMonth, "Total Income in "+lbl_curmonth.getText());
    }//GEN-LAST:event_btn_printActionPerformed

    private void tbl_totalEarningMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_totalEarningMonthMouseClicked
        
    }//GEN-LAST:event_tbl_totalEarningMonthMouseClicked

    private void btn_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close1ActionPerformed
       DBConnector.closeCon();
       this.dispose();
       new IncomeInMonth().setVisible(true);
    }//GEN-LAST:event_btn_close1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

   
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
            java.util.logging.Logger.getLogger(IncomeInMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncomeInMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncomeInMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncomeInMonth.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncomeInMonth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_close1;
    private javax.swing.JButton btn_print;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_curmonth;
    private javax.swing.JLabel lbl_total;
    public static javax.swing.JLabel lbl_totalincome;
    private static javax.swing.JTable tbl_totalEarningMonth;
    // End of variables declaration//GEN-END:variables
}
