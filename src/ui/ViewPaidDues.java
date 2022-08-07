package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTable;
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


public class ViewPaidDues extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;    
   
    private static tenantModel tenModel = new tenantModel(); 
    private static apartmentModel aModel = new apartmentModel();   
    private static transactionsModel trModel = new transactionsModel();
    private static DueModel dueModel = new DueModel();
    
  
    public ViewPaidDues() {
        initComponents();       
        
        
        displayPaidDues(dueModel.viewAllPaidDue());
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(1082, 730));
        this.setMinimumSize(new Dimension(1082, 730));
        this.setPreferredSize(new Dimension(1082, 730));
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
   
    }
    
    
    private void setTableStyle(JTable table){
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));        
        
    }
    
    
    private void searchByName(String text)
    {
        displayPaidDues(dueModel.SEARCH_BY_NAME(text));
    }
    
    private void searchByNID(String nid)
    {
        long id = Long.parseLong(nid);
        displayPaidDues(trModel.VIEW_ALL_COLLECTED_RENT_BY_NID(id));
    }
    
    private void searchByMobile(String text)
    {
        
        displayPaidDues(tenModel.SEARCH_BY_ACT_MOBILE(text));
    }   
    
    private void searchByMonth(String text)
    {
        
        displayPaidDues(dueModel.SEARCH_BY_MONTH(text));
    } 
   
    
    
    
    
    
    
    public static void displayPaidDues(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_paidDues.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("due_id"));
                    columData.add(rs.getLong("t_nid"));                    
                    columData.add(rs.getString("full_name"));
                    columData.add(rs.getInt("apt_id"));  
                    columData.add(rs.getString("due_month"));
                    columData.add(rs.getDouble("due_amount"));                    
      
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(ViewPaidDues.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_paidDues = new javax.swing.JTable();
        btn_reset = new javax.swing.JButton();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel2.setText("All Paid Dues");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 630));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_paidDues.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_paidDues.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Due Id", "Tenant NID", "Tenant Name", "Apt ID", "Due Month", "Due Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_paidDues.setRowHeight(30);
        tbl_paidDues.setRowMargin(5);
        tbl_paidDues.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_paidDues.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_paidDues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_paidDuesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_paidDues);
        if (tbl_paidDues.getColumnModel().getColumnCount() > 0) {
            tbl_paidDues.getColumnModel().getColumn(0).setMinWidth(80);
            tbl_paidDues.getColumnModel().getColumn(0).setMaxWidth(80);
            tbl_paidDues.getColumnModel().getColumn(1).setMinWidth(170);
            tbl_paidDues.getColumnModel().getColumn(1).setMaxWidth(200);
            tbl_paidDues.getColumnModel().getColumn(2).setMinWidth(200);
            tbl_paidDues.getColumnModel().getColumn(2).setMaxWidth(250);
            tbl_paidDues.getColumnModel().getColumn(3).setMinWidth(80);
            tbl_paidDues.getColumnModel().getColumn(3).setMaxWidth(90);
            tbl_paidDues.getColumnModel().getColumn(4).setMinWidth(200);
            tbl_paidDues.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 80, 1040, 480));

        btn_reset.setBackground(new java.awt.Color(51, 51, 51));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        jPanel2.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 570, 110, 40));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "Tenant Name" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 610, 40));

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
        jPanel2.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 20, 150, 40));

        btn_close.setBackground(new java.awt.Color(51, 51, 51));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 100, 40));

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
        jPanel2.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 570, 130, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1080, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new ViewPaidDues().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tbl_paidDuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_paidDuesMouseClicked
        
    }//GEN-LAST:event_tbl_paidDuesMouseClicked

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        if(txt_Search.getText().length()>0)
        {

            String selection = cb_SearchFilter.getSelectedItem().toString();
            String query = txt_Search.getText();

            try {

                switch(selection)
                {                   
                    
                    case "Month":
                    searchByMonth(query);
                    break;

                    case "Tenant Name":
                    searchByName(query);
                    break;

                   

                    
                }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }

        }
        else{
            
            displayPaidDues(dueModel.viewAllPaidDue());
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();        
    }//GEN-LAST:event_btn_closeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     // DBConnector.closeCon();

    }//GEN-LAST:event_formWindowClosed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        Print.printJTable(tbl_paidDues, "All Paid Dues");
    }//GEN-LAST:event_btn_printActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPaidDues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tbl_paidDues;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
