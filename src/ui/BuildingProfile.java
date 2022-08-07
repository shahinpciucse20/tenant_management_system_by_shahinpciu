
package ui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.DBConnector;
import model.apartmentModel;
import model.buildingModel;


public class BuildingProfile extends javax.swing.JFrame {
    
    private static buildingModel B = null;
    private static apartmentModel Apt = null;
    
     
    //~~~SQL Connection~~~//
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    public BuildingProfile() {
        initComponents();
        
        B = new buildingModel();
        Apt = new apartmentModel();
        
        displayAllBuilding(B.VIEW_ALL());       
        
        this.setPreferredSize(new Dimension(1180, 820));
        this.setMinimumSize(new Dimension(1180, 820));
        
        
    }
    
    
    private void displayAllBuilding(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_building.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("b_id"));
                    columData.add(rs.getString("b_name"));  
                    columData.add(rs.getString("location"));
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(BuildingProfile.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    private void setNumOfApt(int b_id){
        int c = B.GET_NUM_OF_APT(b_id);        
        lbl_totalapt.setText(String.valueOf(c));
    }
    
    
    private void setNumOfTenant(int b_id){
        int c = B.GET_NUM_OF_TENANT(b_id);
        lbl_totalten.setText(String.valueOf(c));
    }
    
    private void setAptDataByBid(int b_id){
        rs = Apt.GET_ALL_APT_BY_BID(b_id);
        try {
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_apartment.getModel();
            recordTable.setRowCount(0);  
            
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("apt_id"));
                    columData.add(rs.getString("apt_name"));                       
                    columData.add(rs.getDouble("rent"));                   
                          
                }
                recordTable.addRow(columData);
            }          
            
            
                
            } catch (SQLException ex) {
            Logger.getLogger(BuildingProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setTenDataByBid(int b_id){
        rs = B.GET_TEN_BY_BID(b_id);
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
                    columData.add(rs.getString("mobile")); 
                    columData.add(rs.getString("email"));                     
        
                }
                recordTable.addRow(columData);
            }          
            
            
                
            } catch (SQLException ex) {
            Logger.getLogger(BuildingProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
  
    
    private void searchByName(String text)
    {
        displayAllBuilding(B.SEARCH_BY_NAME(text));
    }
    
    private void searchByID(String id)
    {
        int b_id = Integer.parseInt(id);
        displayAllBuilding(B.SEARCH_BY_ID(b_id));
    }
    
    private void searchByLocation(String loc)
    {
        displayAllBuilding(B.SEARCH_BY_LOCATION(loc));
    }
    
    private void displaySelectRow()
    {
        DefaultTableModel rT = (DefaultTableModel)tbl_building.getModel();   
        int sRow = tbl_building.getSelectedRow();     
        if(sRow >= 0)
        {
            int b_id = Integer.parseInt(rT.getValueAt(sRow,0).toString());
            
            lbl_bname.setText(rT.getValueAt(sRow, 1).toString());
            lbl_bloc.setText(rT.getValueAt(sRow, 2).toString());
            setNumOfApt(b_id);  
            setAptDataByBid(b_id);
            setNumOfTenant(b_id);
            setTenDataByBid(b_id);
            lbl_totalIncome.setText(String.valueOf(B.getTotalIncomeByBuilding(b_id)));
            lbl_totalExpenses.setText(String.valueOf(B.getTotalExpenseByBuilding(b_id)));
                     
        }
          
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        top = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        table = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_building = new javax.swing.JTable();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        form = new javax.swing.JPanel();
        lbl_bname = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_bloc = new javax.swing.JLabel();
        transaction = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        INCOME = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_totalIncome = new javax.swing.JLabel();
        INCOME1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbl_totalExpenses = new javax.swing.JLabel();
        tenant = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_tenant = new javax.swing.JTable();
        lbl_totalten = new javax.swing.JLabel();
        txt_blocation5 = new javax.swing.JLabel();
        apt = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_apartment = new javax.swing.JTable();
        lbl_totalapt = new javax.swing.JLabel();
        txt_blocation6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Building Profile");
        setMaximumSize(new java.awt.Dimension(1100, 800));
        setMinimumSize(new java.awt.Dimension(1100, 800));
        setPreferredSize(new java.awt.Dimension(1100, 800));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        top.setBackground(new java.awt.Color(51, 51, 51));
        top.setPreferredSize(new java.awt.Dimension(100, 70));
        top.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Building Profile");
        top.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        table.setBackground(new java.awt.Color(234, 234, 234));
        table.setMinimumSize(new java.awt.Dimension(50, 100));
        table.setPreferredSize(new java.awt.Dimension(450, 730));
        table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        table.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 18, 50, 50));

        TableHolder.setBackground(new java.awt.Color(234, 234, 234));
        TableHolder.setMaximumSize(new java.awt.Dimension(100, 550));
        TableHolder.setMinimumSize(new java.awt.Dimension(100, 550));
        TableHolder.setPreferredSize(new java.awt.Dimension(50, 0));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 402));

        tbl_building.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        tbl_building.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "LOCATION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_building.setFocusable(false);
        tbl_building.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbl_building.setOpaque(false);
        tbl_building.setRowHeight(30);
        tbl_building.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_building.getTableHeader().setReorderingAllowed(false);
        tbl_building.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_buildingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_building);
        if (tbl_building.getColumnModel().getColumnCount() > 0) {
            tbl_building.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl_building.getColumnModel().getColumn(1).setMinWidth(180);
            tbl_building.getColumnModel().getColumn(1).setMaxWidth(200);
            tbl_building.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 430, 500));

        table.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 470, 535));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "LOCATION" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        table.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 22, -1, 45));

        txt_Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        table.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 18, 230, 50));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(204, 204, 204));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        table.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 110, 38));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_close.setForeground(new java.awt.Color(204, 204, 204));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        table.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, 40));

        body.add(table, java.awt.BorderLayout.LINE_END);

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setMinimumSize(new java.awt.Dimension(500, 100));
        form.setPreferredSize(new java.awt.Dimension(550, 730));
        form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bname.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        form.add(lbl_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 420, 60));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        form.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 420, 10));

        lbl_bloc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_bloc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        form.add(lbl_bloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 240, 60));

        transaction.setBackground(new java.awt.Color(255, 255, 255));
        transaction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(244, 244, 244));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        INCOME.setBackground(new java.awt.Color(0, 153, 102));
        INCOME.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL INCOME");
        INCOME.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 320, 60));

        jPanel2.setBackground(new java.awt.Color(222, 222, 222));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalIncome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_totalIncome.setForeground(new java.awt.Color(0, 153, 102));
        lbl_totalIncome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(lbl_totalIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 320, 50));

        INCOME.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 320, 70));

        jPanel3.add(INCOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 140));

        INCOME1.setBackground(new java.awt.Color(255, 0, 0));
        INCOME1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TOTAL EXPENSES");
        INCOME1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 1, 300, 60));

        jPanel6.setBackground(new java.awt.Color(222, 222, 222));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalExpenses.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_totalExpenses.setForeground(new java.awt.Color(255, 0, 0));
        lbl_totalExpenses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel6.add(lbl_totalExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, 300, 50));

        INCOME1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 320, 70));

        jPanel3.add(INCOME1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 300, 140));

        transaction.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 670, 180));

        form.add(transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 700, 200));

        tenant.setBackground(new java.awt.Color(255, 255, 255));
        tenant.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(244, 244, 244));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_tenant.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_tenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "Full Name", "Mobile", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tenant.setRowHeight(25);
        tbl_tenant.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_tenant.getTableHeader().setReorderingAllowed(false);
        tbl_tenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tenantMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_tenant);
        if (tbl_tenant.getColumnModel().getColumnCount() > 0) {
            tbl_tenant.getColumnModel().getColumn(0).setMinWidth(120);
            tbl_tenant.getColumnModel().getColumn(0).setMaxWidth(200);
            tbl_tenant.getColumnModel().getColumn(3).setMinWidth(200);
            tbl_tenant.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 120));

        tenant.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 140));

        lbl_totalten.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_totalten.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_totalten.setText("0");
        tenant.add(lbl_totalten, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 50, 30));

        txt_blocation5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_blocation5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_blocation5.setText("Total Tenant:");
        tenant.add(txt_blocation5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 30));

        form.add(tenant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 700, 210));

        apt.setBackground(new java.awt.Color(255, 255, 255));
        apt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(244, 244, 244));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_apartment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_apartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "RENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_apartment.setRowHeight(25);
        tbl_apartment.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_apartment.getTableHeader().setReorderingAllowed(false);
        tbl_apartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_apartmentMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_apartment);
        if (tbl_apartment.getColumnModel().getColumnCount() > 0) {
            tbl_apartment.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 120));

        apt.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 140));

        lbl_totalapt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_totalapt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_totalapt.setText("0");
        apt.add(lbl_totalapt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 60, 30));

        txt_blocation6.setBackground(new java.awt.Color(255, 255, 255));
        txt_blocation6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_blocation6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_blocation6.setText("Total Apartment:");
        apt.add(txt_blocation6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 30));

        form.add(apt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 700, 210));

        body.add(form, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void tbl_apartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_apartmentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_apartmentMouseClicked

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new BuildingProfile().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tbl_tenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tenantMouseClicked

        
    }//GEN-LAST:event_tbl_tenantMouseClicked

    private void tbl_buildingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_buildingMouseClicked
        displaySelectRow();
    }//GEN-LAST:event_tbl_buildingMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txt_Search.getText().length()>0)
        {
            String query = txt_Search.getText();
            String userChoice = cb_SearchFilter.getSelectedItem().toString();
            try {
                
                    switch(userChoice)
                    {
                        case "ID":
                           
                            searchByID(query);
                            break;
                        case "NAME":
                            
                            searchByName(query);
                            break;
                        case "LOCATION":
                            
                            searchByLocation(query);
                            break;    
                    }
            
            }             
                
             catch (Exception e) 
                    {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }
        }
        else{
            displayAllBuilding(B.VIEW_ALL());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosing

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuildingProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel INCOME;
    private javax.swing.JPanel INCOME1;
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel apt;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_bloc;
    private javax.swing.JLabel lbl_bname;
    private javax.swing.JLabel lbl_totalExpenses;
    private javax.swing.JLabel lbl_totalIncome;
    private javax.swing.JLabel lbl_totalapt;
    private javax.swing.JLabel lbl_totalten;
    private javax.swing.JPanel table;
    private javax.swing.JTable tbl_apartment;
    private javax.swing.JTable tbl_building;
    private javax.swing.JTable tbl_tenant;
    private javax.swing.JPanel tenant;
    private javax.swing.JPanel top;
    private javax.swing.JPanel transaction;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JLabel txt_blocation5;
    private javax.swing.JLabel txt_blocation6;
    // End of variables declaration//GEN-END:variables
}
