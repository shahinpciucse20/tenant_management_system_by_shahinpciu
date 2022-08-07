package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import model.DBConnector;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import system.Time;
import values.Values;

public class TenantLeavePage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    private String imagePath = null;
    tenantModel Ten = null;
    apartmentModel Apt = null;
    int apartment_id;
    
    
  
    public TenantLeavePage() {
        initComponents();              
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        clear();             
        
        Ten = new tenantModel();
        Apt = new apartmentModel();
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
         
        displayAllTenant(Ten.VIEW_ALL_ACTIVE());
        txt_Search.requestFocus();
        txt_endingmonth.setText(getCurrentDate());
        
        
    }
    
    private void deleteTenant(long id)
    {
        Ten.DELETE(id);
    }
    
    private void updateLeaveStatus(int aptid,long nid,String date){
        Apt.UPDATE_AVAILABLE(aptid, "YES");
        Ten.UPDATE_TENANT_STATUS(nid, "INACTIVE",date);
        Ten.updateSecurityDepByNid(nid, 0);
    }
    
    

    private void clear()
    {
        txt_nid.setText("");   
        txt_fullname.setText("");   
        txt_email.setText("");   
        txt_mobile.setText("");
        txt_endingmonth.setText("");
        
        txt_securitydeposit.setText("");   
        
        lbl_photo.setIcon(null);
        
        txt_aptname.setText("");            
                
        
        tbl_tenant.clearSelection();
        txt_endingmonth.setText(getCurrentDate());
        
    } 
    
    
    private void setAptNameByID(int apt_id)
    {
        apartmentModel A = new apartmentModel();
        rs = A.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(apt_id);
        try {
            if(rs.next())
            {
                txt_aptname.setText(rs.getString("apt_name")+"-"+rs.getString("b_name")+"-"+rs.getString("location"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TenantLeavePage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    
    
    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-400,screensize.height-200);        
        //this.setMinimumSize(minSize);
        //this.setMaximumSize(minSize);
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
    
    
    
    
    
    
    
    
    private void displaySelectRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tbl_tenant.getModel();   
        int selectedRow = tbl_tenant.getSelectedRow();     
        if(selectedRow>=0)
        {
            txt_nid.setText(recordTable.getValueAt(selectedRow,0).toString());
            long nid =Long.parseLong(txt_nid.getText());     
            
            ImageIcon icon = new ImageIcon(new ImageIcon(Ten.GET_PIC_BY_ID(nid)).getImage().getScaledInstance(lbl_photo.getWidth(),lbl_photo.getHeight(), Image.SCALE_SMOOTH));
            lbl_photo.setIcon(icon);
            txt_fullname.setText(recordTable.getValueAt(selectedRow,1).toString());
   
            txt_mobile.setText("0"+recordTable.getValueAt(selectedRow,2).toString()); 
            txt_email.setText(recordTable.getValueAt(selectedRow,3).toString()); 
            
            //cb_aptid.addItem(recordTable.getValueAt(selectedRow,5).toString()); 
            setAptNameByID(Integer.parseInt(recordTable.getValueAt(selectedRow,5).toString()));
            txt_securitydeposit.setText(recordTable.getValueAt(selectedRow,4).toString()); 
            apartment_id = Integer.parseInt(recordTable.getValueAt(selectedRow,5).toString());
            
                     
        }
          
    }
    
    String getCurrentDate()
    {                 
        return Time.getCurMonthYear();
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
                    columData.add(rs.getLong("mobile"));
                    columData.add(rs.getString("email"));
                    columData.add(rs.getDouble("security_deposit"));
                    columData.add(rs.getInt("apt_id"));  
      
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(TenantLeavePage.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        topbox = new javax.swing.JPanel();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        TableHolder1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tenant = new javax.swing.JTable();
        bottombox = new javax.swing.JPanel();
        txt_nid = new javax.swing.JTextField();
        txt_fullname = new javax.swing.JTextField();
        txt_endingmonth = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_securitydeposit = new javax.swing.JTextField();
        lbl_photo = new javax.swing.JLabel();
        txt_aptname = new javax.swing.JTextField();
        btn_leave = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        txt_mobile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1276, 1048));
        setMinimumSize(new java.awt.Dimension(1276, 1048));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1276, 1048));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tenant Leave");

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
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(header, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new javax.swing.BoxLayout(body, javax.swing.BoxLayout.Y_AXIS));

        forms.setBackground(new java.awt.Color(255, 255, 255));
        forms.setPreferredSize(new java.awt.Dimension(790, 300));
        forms.setLayout(new javax.swing.BoxLayout(forms, javax.swing.BoxLayout.Y_AXIS));

        topbox.setBackground(new java.awt.Color(255, 255, 255));
        topbox.setPreferredSize(new java.awt.Dimension(500, 100));
        topbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "MOBILE" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        topbox.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 170, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        topbox.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 780, 50));

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
        topbox.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 20, 160, 50));

        TableHolder1.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_tenant.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_tenant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NID", "NAME", "MOBILE", "EMAIL", "DEPOSIT", "APT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tenant.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_tenant.setRowHeight(30);
        tbl_tenant.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_tenant.setShowHorizontalLines(false);
        tbl_tenant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tenantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tenant);

        TableHolder1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 20, 1150, 330));

        topbox.add(TableHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1190, 370));

        forms.add(topbox);

        bottombox.setBackground(new java.awt.Color(255, 255, 255));
        bottombox.setPreferredSize(new java.awt.Dimension(80, 100));
        bottombox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nid.setEditable(false);
        txt_nid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_nid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_nid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nidActionPerformed(evt);
            }
        });
        bottombox.add(txt_nid, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 430, 80));

        txt_fullname.setEditable(false);
        txt_fullname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_fullname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FULL NAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fullnameActionPerformed(evt);
            }
        });
        bottombox.add(txt_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 430, 80));

        txt_endingmonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_endingmonth.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LEAVING MONTH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_endingmonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_endingmonthActionPerformed(evt);
            }
        });
        bottombox.add(txt_endingmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 450, 80));

        txt_email.setEditable(false);
        txt_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        bottombox.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 450, 80));

        txt_securitydeposit.setEditable(false);
        txt_securitydeposit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_securitydeposit.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "SECURITY DEPOSIT AMOUNT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_securitydeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_securitydepositActionPerformed(evt);
            }
        });
        bottombox.add(txt_securitydeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 450, 80));

        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bottombox.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 250, 250));

        txt_aptname.setEditable(false);
        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_aptname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RENTED APARTMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        txt_aptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptnameActionPerformed(evt);
            }
        });
        bottombox.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 910, 70));

        btn_leave.setBackground(new java.awt.Color(255, 51, 51));
        btn_leave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_leave.setForeground(new java.awt.Color(255, 255, 255));
        btn_leave.setText(" LEAVE");
        btn_leave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leaveActionPerformed(evt);
            }
        });
        bottombox.add(btn_leave, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 230, 60));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        bottombox.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 190, 60));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_close.setForeground(new java.awt.Color(255, 255, 255));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        bottombox.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 390, 170, 60));

        txt_mobile.setEditable(false);
        txt_mobile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_mobile.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "MOBILE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mobileActionPerformed(evt);
            }
        });
        bottombox.add(txt_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 430, 80));

        forms.add(bottombox);

        body.add(forms);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new TenantLeavePage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_securitydepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_securitydepositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_securitydepositActionPerformed

    private void txt_endingmonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_endingmonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_endingmonthActionPerformed

    private void txt_nidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nidActionPerformed

    private void txt_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fullnameActionPerformed

    private void txt_aptnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aptnameActionPerformed

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

    private void btn_leaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leaveActionPerformed
        if(txt_nid.getText().length()>0)
        {
            int deleteItem = JOptionPane.showConfirmDialog(null,"Are you confirm to perform this operation?", "WARNING!!",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {
                int apt_id = apartment_id;
                long nid = Long.parseLong(txt_nid.getText());
                
                
                updateLeaveStatus(apt_id, nid,txt_endingmonth.getText().toUpperCase());
                
                JOptionPane.showMessageDialog(this, "Tenant Successfully Leaved!");
                HomePage.setDashboardLabel();
                clear();
                displayAllTenant(Ten.VIEW_ALL_ACTIVE());

            }
            else{
                clear();
            }

        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Atleast One Record!");
        }
    }//GEN-LAST:event_btn_leaveActionPerformed

    private void tbl_tenantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tenantMouseClicked
        displaySelectRow();
    }//GEN-LAST:event_tbl_tenantMouseClicked

    private void txt_mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mobileActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new TenantLeavePage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TableHolder1;
    private javax.swing.JPanel body;
    private javax.swing.JPanel bottombox;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_leave;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel forms;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JTable tbl_tenant;
    private javax.swing.JPanel topbox;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_endingmonth;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_mobile;
    private javax.swing.JTextField txt_nid;
    private javax.swing.JTextField txt_securitydeposit;
    // End of variables declaration//GEN-END:variables
}
