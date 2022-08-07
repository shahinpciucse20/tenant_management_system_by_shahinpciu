package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import values.Values;

public class ViewAllTenant extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    private String imagePath = null;
    private tenantModel Ten = null;
    
    
  
    public ViewAllTenant() {
        initComponents();        
        Ten = new tenantModel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        clear();        
        setResponsiveSize();  
       
       
        displayAllTenant(Ten.VIEW_ALL());
        txt_Search.requestFocus();
        
        
        
    }
    
    private void deleteTenant(long id)
    {
        Ten.DELETE(id);
    }
    
    

    private void clear()
    {
        
        tbl_tenant.clearSelection();      
        
    } 
    

    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-400,screensize.height-200);        
        
        this.setSize(maxSize);
    }
    

    
    
    private void searchByName(String text)
    {
        ResultSet rs = Ten.SEARCH_BY_ACTIVE_NAME(text);
        displayAllTenant(rs);
    }
    
    private void searchByNID(String nid)
    {
        long id = Long.parseLong(nid);
        ResultSet rs = Ten.SEARCH_BY_ACTIVE_ID(id);
        displayAllTenant(rs);
    }
    
    private void searchByMobile(String text)
    {
        int id = Integer.parseInt(text);
        ResultSet rs = Ten.SEARCH_BY_ACT_MOBILE(text);
        displayAllTenant(rs);
    }
    
    private void searchByAptId(String text)
    {
        int id = Integer.parseInt(text);
        ResultSet rs = Ten.SEARCH_BY_APTID(id);
        displayAllTenant(rs);
    }
    
    

    private void displayAllTenant(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_tenant.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getLong("nid"));
                    columData.add(rs.getString("full_name"));                       
                    columData.add(rs.getInt("age"));
                    columData.add(rs.getString("gender"));
                    columData.add(rs.getString("religion"));
                    columData.add(rs.getString("nationality"));
                    columData.add(rs.getString("profession"));
                    columData.add(rs.getLong("mobile"));
                    columData.add(rs.getString("email"));
                    columData.add(rs.getString("permanant_address"));
                    columData.add(rs.getInt("total_member"));
                    columData.add(rs.getInt("apt_id"));
                    columData.add(rs.getDouble("security_deposit"));
                    columData.add(rs.getString("starting_month"));
                           
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllTenant.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        table = new javax.swing.JPanel();
        search_bar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        table_main = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tenant = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Home - TMS"); // NOI18N
        setResizable(false);

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("All Tenant");

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2118, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                    .addContainerGap(431, Short.MAX_VALUE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        table.setBackground(new java.awt.Color(255, 102, 102));
        table.setMaximumSize(new java.awt.Dimension(3110, 450));
        table.setPreferredSize(new java.awt.Dimension(3110, 450));
        table.setLayout(new javax.swing.BoxLayout(table, javax.swing.BoxLayout.Y_AXIS));

        search_bar.setBackground(new java.awt.Color(255, 255, 255));
        search_bar.setPreferredSize(new java.awt.Dimension(2118, 80));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/icons_profile.png"))); // NOI18N
        jLabel10.setText("View Profile");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "MOBILE" }));

        txt_Search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout search_barLayout = new javax.swing.GroupLayout(search_bar);
        search_bar.setLayout(search_barLayout);
        search_barLayout.setHorizontalGroup(
            search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_barLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(cb_SearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        search_barLayout.setVerticalGroup(
            search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_barLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_SearchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        table.add(search_bar);

        table_main.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tenant.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbl_tenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Full Name", "Age", "Gender", "Religion", "Nationality", "Profession", "Mobile", "Email", "Permanant Address", "Member", "Apt ID", "Security Deposit", "Starting Month"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tenant.setRowHeight(50);
        tbl_tenant.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_tenant.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_tenant.getTableHeader().setReorderingAllowed(false);
        tbl_tenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tenantMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_tenant);
        if (tbl_tenant.getColumnModel().getColumnCount() > 0) {
            tbl_tenant.getColumnModel().getColumn(0).setMinWidth(150);
            tbl_tenant.getColumnModel().getColumn(0).setMaxWidth(170);
            tbl_tenant.getColumnModel().getColumn(1).setMinWidth(180);
            tbl_tenant.getColumnModel().getColumn(2).setMinWidth(50);
            tbl_tenant.getColumnModel().getColumn(2).setMaxWidth(50);
            tbl_tenant.getColumnModel().getColumn(3).setMaxWidth(60);
            tbl_tenant.getColumnModel().getColumn(4).setMinWidth(100);
            tbl_tenant.getColumnModel().getColumn(4).setMaxWidth(140);
            tbl_tenant.getColumnModel().getColumn(5).setMinWidth(120);
            tbl_tenant.getColumnModel().getColumn(5).setMaxWidth(150);
            tbl_tenant.getColumnModel().getColumn(6).setMinWidth(120);
            tbl_tenant.getColumnModel().getColumn(6).setMaxWidth(150);
            tbl_tenant.getColumnModel().getColumn(7).setMinWidth(150);
            tbl_tenant.getColumnModel().getColumn(7).setMaxWidth(170);
            tbl_tenant.getColumnModel().getColumn(8).setMinWidth(140);
            tbl_tenant.getColumnModel().getColumn(9).setMinWidth(120);
            tbl_tenant.getColumnModel().getColumn(10).setMinWidth(50);
            tbl_tenant.getColumnModel().getColumn(10).setMaxWidth(60);
            tbl_tenant.getColumnModel().getColumn(11).setMinWidth(50);
            tbl_tenant.getColumnModel().getColumn(11).setMaxWidth(50);
            tbl_tenant.getColumnModel().getColumn(12).setMinWidth(100);
            tbl_tenant.getColumnModel().getColumn(12).setMaxWidth(130);
            tbl_tenant.getColumnModel().getColumn(13).setMinWidth(120);
            tbl_tenant.getColumnModel().getColumn(13).setMaxWidth(120);
        }

        javax.swing.GroupLayout table_mainLayout = new javax.swing.GroupLayout(table_main);
        table_main.setLayout(table_mainLayout);
        table_mainLayout.setHorizontalGroup(
            table_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 2098, Short.MAX_VALUE)
                .addContainerGap())
        );
        table_mainLayout.setVerticalGroup(
            table_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(table_mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                .addContainerGap())
        );

        table.add(table_main);

        body.add(table, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        if(txt_Search.getText().length()>0)
        {
            
            clear();
            
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

                        case "APT ID":
                            searchByAptId(query);
                            break;      
                    }
            
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }
            
            
        }
        else{
            displayAllTenant(Ten.VIEW_ALL_ACTIVE());
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void tbl_tenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tenantMouseClicked
        
        if(tbl_tenant.getSelectedRow()>=0){
            
            int col = tbl_tenant.getSelectedColumn();
            int row = tbl_tenant.getSelectedRow();         
            
            
            String myString = tbl_tenant.getValueAt(row, 0).toString();
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            
        }
        
        
        
    }//GEN-LAST:event_tbl_tenantMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       if(tbl_tenant.getSelectedRow()>=0){
           int row = tbl_tenant.getSelectedRow();
           String nid = tbl_tenant.getValueAt(row, 0).toString();
           TenantSelect tS = new TenantSelect();
           tS.txt_Search.setText(nid);
           this.dispose();
           tS.setVisible(true);
       }
       else{
           JOptionPane.showMessageDialog(this, "Please Select At least 1 Tenant!");
       }
    }//GEN-LAST:event_jLabel10MouseClicked

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ViewAllTenant().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_Search;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel search_bar;
    private javax.swing.JPanel table;
    private javax.swing.JPanel table_main;
    private javax.swing.JTable tbl_tenant;
    private javax.swing.JTextField txt_Search;
    // End of variables declaration//GEN-END:variables
}
