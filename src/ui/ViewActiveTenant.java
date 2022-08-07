
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
import javax.swing.JOptionPane;
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


public class ViewActiveTenant extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;
    
   
    private static tenantModel tenModel = null;
    
    private static apartmentModel aModel = null;
  
    public ViewActiveTenant() {
        initComponents();
        
        tenModel = new tenantModel();
        aModel = new apartmentModel();
        
        displayActiveTenants(tenModel.VIEW_ALL_ACTIVE());
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(900, 700));
        this.setMinimumSize(new Dimension(900, 700));
        this.setPreferredSize(new Dimension(900, 700));
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
   
    }
    
    
    private void searchByName(String text)
    {
        displayActiveTenants(tenModel.SEARCH_BY_ACTIVE_NAME(text));
    }
    
    private void searchByNID(String nid)
    {
        long id = Long.parseLong(nid);
        displayActiveTenants(tenModel.SEARCH_BY_ACTIVE_ID(id));
    }
    
    private void searchByMobile(String text)
    {
        
        displayActiveTenants(tenModel.SEARCH_BY_ACT_MOBILE(text));
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
                    columData.add("0"+rs.getLong("mobile"));
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
            Logger.getLogger(ViewActiveTenant.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_activeTenant = new javax.swing.JTable();
        btn_close = new javax.swing.JButton();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        btn_close1 = new javax.swing.JButton();
        btn_close2 = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        lbl_viewProfile = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 700));
        setResizable(false);
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
        tbl_activeTenant.setRowHeight(30);
        tbl_activeTenant.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_activeTenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_activeTenantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_activeTenant);
        if (tbl_activeTenant.getColumnModel().getColumnCount() > 0) {
            tbl_activeTenant.getColumnModel().getColumn(0).setMinWidth(150);
            tbl_activeTenant.getColumnModel().getColumn(0).setMaxWidth(160);
            tbl_activeTenant.getColumnModel().getColumn(1).setMinWidth(160);
            tbl_activeTenant.getColumnModel().getColumn(1).setMaxWidth(180);
            tbl_activeTenant.getColumnModel().getColumn(2).setMinWidth(120);
            tbl_activeTenant.getColumnModel().getColumn(2).setMaxWidth(120);
            tbl_activeTenant.getColumnModel().getColumn(4).setMinWidth(60);
            tbl_activeTenant.getColumnModel().getColumn(4).setMaxWidth(60);
            tbl_activeTenant.getColumnModel().getColumn(5).setMinWidth(70);
            tbl_activeTenant.getColumnModel().getColumn(5).setMaxWidth(80);
            tbl_activeTenant.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_activeTenant.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 860, 480));

        btn_close.setBackground(new java.awt.Color(255, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("VIEW INACTIVE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 180, 40));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "MOBILE" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 550, 40));

        btn_Search.setBackground(new java.awt.Color(255, 51, 51));
        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Search.setForeground(new java.awt.Color(255, 255, 255));
        btn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 20, 130, 40));

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
        jPanel2.add(btn_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 130, 40));

        btn_close2.setBackground(new java.awt.Color(51, 51, 51));
        btn_close2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close2.setForeground(new java.awt.Color(255, 255, 255));
        btn_close2.setText("CLOSE");
        btn_close2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_close2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, 110, 40));

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
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, 130, 40));

        lbl_viewProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_viewProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_viewProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons_profile.png"))); // NOI18N
        lbl_viewProfile.setText("View Profile");
        lbl_viewProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_viewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewProfileMouseClicked(evt);
            }
        });
        jPanel2.add(lbl_viewProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 120, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        new ViewInActiveTenant().setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_activeTenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_activeTenantMouseClicked
        
    }//GEN-LAST:event_tbl_activeTenantMouseClicked

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        if(txt_Search.getText().length()>0)
        {

            String selection = cb_SearchFilter.getSelectedItem().toString();
            String query = txt_Search.getText();

            try {

                switch(selection)
                {
                    case "ID":

                    searchByNID(query);
                    break;

                    case "NAME":
                    searchByName(query);
                    break;

                    case "MOBILE":
                    searchByMobile(query);
                    break;

                    
                }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }

        }
        else{
            displayActiveTenants(tenModel.VIEW_ALL_ACTIVE());
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void btn_close1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close1ActionPerformed
        DBConnector.closeCon();
        this.dispose();
        new ViewActiveTenant().setVisible(true);
    }//GEN-LAST:event_btn_close1ActionPerformed

    private void btn_close2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_close2ActionPerformed
       this.dispose();
    }//GEN-LAST:event_btn_close2ActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        Print.printJTable(tbl_activeTenant, "All Active Tenants");
    }//GEN-LAST:event_btn_printActionPerformed

    private void lbl_viewProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewProfileMouseClicked
        if(tbl_activeTenant.getSelectedRow()>=0){
            int row = tbl_activeTenant.getSelectedRow();
            String nid = tbl_activeTenant.getValueAt(row, 0).toString();
            TenantSelect tS = new TenantSelect();
            tS.txt_Search.setText(nid);
            this.dispose();
            tS.setVisible(true);
        }
        else{
           JOptionPane.showMessageDialog(this, "Please Select At least 1 Tenant!");
       }
    }//GEN-LAST:event_lbl_viewProfileMouseClicked

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewActiveTenant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_close1;
    private javax.swing.JButton btn_close2;
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_viewProfile;
    private static javax.swing.JTable tbl_activeTenant;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
