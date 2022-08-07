
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
import system.Time;
import static ui.HomePage.getCurrentMonthYear;
import values.Values;


public class EmptyApartment extends javax.swing.JFrame {
    
    private static ResultSet rs_apt = null;
    private static ResultSet rs_apt_rent = null;    
    

    private static apartmentModel aModel = null;
  
    public EmptyApartment() {
        initComponents();
        
        aModel = new apartmentModel();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        displayEmptyApt(aModel.VIEW_ALL_AVAILABLE());
        this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
        this.setMaximumSize(new Dimension(900, 700));
        this.setMinimumSize(new Dimension(900, 700));
        this.setPreferredSize(new Dimension(900, 700));
   
    }
    

    
    public static void displayEmptyApt(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_emptyApt.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("apt_id"));
                    columData.add(rs.getString("apt_name"));  
                    columData.add(rs.getInt("b_id"));
                    columData.add(rs.getString("b_name"));
                    columData.add(rs.getString("location"));
                    columData.add(rs.getDouble("rent"));
                    columData.add(rs.getString("available"));
                                           
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(EmptyApartment.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_emptyApt = new javax.swing.JTable();
        btn_close = new javax.swing.JButton();

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
        jLabel2.setText("Empty Apartments");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 630));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 630));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        tbl_emptyApt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_emptyApt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Apt ID", "Apt Name", "B ID", "B Name", "Location", "Rent", "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_emptyApt.setRowHeight(45);
        tbl_emptyApt.setRowMargin(5);
        tbl_emptyApt.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_emptyApt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_emptyApt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_emptyAptMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_emptyApt);
        if (tbl_emptyApt.getColumnModel().getColumnCount() > 0) {
            tbl_emptyApt.getColumnModel().getColumn(0).setMaxWidth(60);
            tbl_emptyApt.getColumnModel().getColumn(1).setMinWidth(80);
            tbl_emptyApt.getColumnModel().getColumn(1).setMaxWidth(80);
            tbl_emptyApt.getColumnModel().getColumn(2).setMinWidth(60);
            tbl_emptyApt.getColumnModel().getColumn(2).setMaxWidth(80);
            tbl_emptyApt.getColumnModel().getColumn(5).setMaxWidth(180);
            tbl_emptyApt.getColumnModel().getColumn(6).setMinWidth(100);
            tbl_emptyApt.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 30, 860, 530));

        btn_close.setBackground(new java.awt.Color(51, 51, 51));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 120, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 900, 630));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_emptyAptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_emptyAptMouseClicked
        
    }//GEN-LAST:event_tbl_emptyAptMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmptyApartment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tbl_emptyApt;
    // End of variables declaration//GEN-END:variables
}
