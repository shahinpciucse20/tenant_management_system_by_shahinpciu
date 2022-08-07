package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.UserInfo;
import model.apartmentModel;
import model.buildingModel;
import values.Values;

public class UpdateBuildingPage extends javax.swing.JFrame {
    
    private buildingModel B = null;
    private UserInfo userInfo = null;
    String user_input = null;
    String login_key ;
    static boolean confirm = false;    
  
    public UpdateBuildingPage() {
        initComponents();       
        B = new buildingModel();
        userInfo = new UserInfo();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayAllBuilding(B.VIEW_ALL());  
        login_key = getPassFromDB();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
        
    }
    
     private String getPassFromDB(){
        
        return userInfo.getPassword();
 
    }
    
    
    private void displaySelectRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tbl_building.getModel();   
        int selectedRow = tbl_building.getSelectedRow();     
        if(selectedRow>=0)
        {
            txt_bid.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txt_bname.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txt_location.setText(recordTable.getValueAt(selectedRow,2).toString()); 
                     
        }
          
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
                    columData.add(rs.getInt("num_of_apt"));
                                            
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBuildingPage.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void deleteBuilding(int id)
    {
        B.DELETE(id);
    }
    
    private void updateBuilding()
    {
        buildingModel B = new buildingModel();
        int b_id =Integer.parseInt(txt_bid.getText());
        String b_name = txt_bname.getText();
        String location = txt_location.getText();
        B.UPDATE(b_id, b_name, location);
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
    
    
    private void clear()
    {
        
        txt_bid.setText("");
        txt_bname.setText("");
        txt_location.setText("");
        tbl_building.clearSelection();
        
    }
     String getCurrentDate()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("E, MMM dd - yyyy  hh:mm:ss");

        String formattedDate = date.format(formatedDate);
                
        return formattedDate;
    }
    
      
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_KeyConfirmation = new javax.swing.JDialog();
        body = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_confirm = new javax.swing.JButton();
        borderbg = new javax.swing.JPanel();
        addbuilding = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        container1 = new javax.swing.JPanel();
        form = new javax.swing.JPanel();
        labels = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        input = new javax.swing.JPanel();
        txt_location = new javax.swing.JTextField();
        txt_bid = new javax.swing.JTextField();
        txt_bname = new javax.swing.JTextField();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_building = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txt_Search = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btn_removebuilding = new javax.swing.JButton();
        cb_SearchFilter = new javax.swing.JComboBox<>();

        dlg_KeyConfirmation.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_KeyConfirmation.setMinimumSize(new java.awt.Dimension(570, 310));
        dlg_KeyConfirmation.setResizable(false);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please Confirm Your Identity");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 31, 560, 60));

        txt_pass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "ENTER PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_pass.setName(""); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        body.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 490, 70));

        btn_confirm.setBackground(new java.awt.Color(255, 0, 0));
        btn_confirm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_confirm.setForeground(new java.awt.Color(255, 255, 255));
        btn_confirm.setText("CONFIRM");
        btn_confirm.setBorder(null);
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });
        body.add(btn_confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, 60));

        javax.swing.GroupLayout dlg_KeyConfirmationLayout = new javax.swing.GroupLayout(dlg_KeyConfirmation.getContentPane());
        dlg_KeyConfirmation.getContentPane().setLayout(dlg_KeyConfirmationLayout);
        dlg_KeyConfirmationLayout.setHorizontalGroup(
            dlg_KeyConfirmationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(dlg_KeyConfirmationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_KeyConfirmationLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        dlg_KeyConfirmationLayout.setVerticalGroup(
            dlg_KeyConfirmationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGroup(dlg_KeyConfirmationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlg_KeyConfirmationLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1480, 666));
        setMinimumSize(new java.awt.Dimension(1480, 666));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1480, 666));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borderbg.setBackground(new java.awt.Color(255, 255, 255));
        borderbg.setForeground(new java.awt.Color(255, 255, 255));
        borderbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addbuilding.setBackground(new java.awt.Color(255, 255, 255));
        addbuilding.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Update Building");

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1460, Short.MAX_VALUE)
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        addbuilding.add(heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1460, -1));

        container1.setBackground(new java.awt.Color(255, 255, 255));
        container1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setPreferredSize(new java.awt.Dimension(1241, 300));
        form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labels.setBackground(new java.awt.Color(255, 255, 255));
        labels.setPreferredSize(new java.awt.Dimension(200, 300));
        labels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Building Location: ");
        labels.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 230, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Building ID: ");
        labels.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 230, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Building Name: ");
        labels.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, 60));

        form.add(labels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        input.setBackground(new java.awt.Color(255, 255, 255));
        input.setPreferredSize(new java.awt.Dimension(400, 596));
        input.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_location.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        input.add(txt_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 410, 50));

        txt_bid.setEditable(false);
        txt_bid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        input.add(txt_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 50));

        txt_bname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        input.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 410, 50));

        form.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 440, 330));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_building.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_building.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "LOCATION", "NUM of APT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_building.setFocusable(false);
        tbl_building.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tbl_building.setRowHeight(30);
        tbl_building.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_building.setShowVerticalLines(false);
        tbl_building.getTableHeader().setReorderingAllowed(false);
        tbl_building.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_buildingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_building);
        if (tbl_building.getColumnModel().getColumnCount() > 0) {
            tbl_building.getColumnModel().getColumn(0).setMinWidth(60);
            tbl_building.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbl_building.getColumnModel().getColumn(0).setMaxWidth(70);
            tbl_building.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbl_building.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_building.getColumnModel().getColumn(3).setMinWidth(90);
            tbl_building.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 340));

        form.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 730, 360));

        btn_update.setBackground(new java.awt.Color(0, 0, 0));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_update.setForeground(new java.awt.Color(204, 204, 204));
        btn_update.setText("UPDATE");
        btn_update.setBorderPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        form.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, 50));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_close.setForeground(new java.awt.Color(204, 204, 204));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        form.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 130, 50));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(204, 204, 204));
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        form.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 130, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        form.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, 400, 50));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        form.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 50, 140, 50));

        btn_removebuilding.setBackground(new java.awt.Color(255, 51, 51));
        btn_removebuilding.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_removebuilding.setForeground(new java.awt.Color(255, 255, 255));
        btn_removebuilding.setText("X   REMOVE BUILDING");
        btn_removebuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removebuildingActionPerformed(evt);
            }
        });
        form.add(btn_removebuilding, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 410, 50));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "LOCATION" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        form.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 150, 50));

        container1.add(form, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 580));

        addbuilding.add(container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1450, 580));

        borderbg.add(addbuilding, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 1450, 640));

        getContentPane().add(borderbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1480, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
       this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
    this.dispose();
    new UpdateBuildingPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(txt_bname.getText().length()>0 && txt_location.getText().length()>0 && txt_bid.getText().length()>0)
        {
            updateBuilding();
            JOptionPane.showMessageDialog(this, "Building Successfully Updated"); 
            
            clear();
            displayAllBuilding(B.VIEW_ALL());
        }
        else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_buildingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_buildingMouseClicked
        displaySelectRow();
    }//GEN-LAST:event_tbl_buildingMouseClicked

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased
        
    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped
        

    }//GEN-LAST:event_txt_SearchKeyTyped

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txt_Search.getText().length()>0)
        {
            String query = txt_Search.getText();
            String userChoice = cb_SearchFilter.getSelectedItem().toString();
            try {
                
                    switch(userChoice)
                    {
                        case "ID":
                            clear();
                            searchByID(query);
                            break;
                        case "NAME":
                            clear();
                            searchByName(query);
                            break;
                        case "LOCATION":
                            clear();
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

    private void btn_removebuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removebuildingActionPerformed
        if(txt_bname.getText().length()>0 && txt_location.getText().length()>0 && txt_bid.getText().length()>0)
        {
            int deleteItem = JOptionPane.showConfirmDialog(null,Values.DeleteWarningMessage, "Do You Want to Remove?",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {
                dlg_KeyConfirmation.setSize(550,310);
                
                dlg_KeyConfirmation.setVisible(true);              
  
            }
            else{
                txt_pass.setText("");
                clear();
            }
            

        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Atleast One Record to Remove!");
        }
    }//GEN-LAST:event_btn_removebuildingActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        user_input = txt_pass.getText().toString();
        if(user_input.equals(login_key))
        {
            
            txt_pass.setText("");
            dlg_KeyConfirmation.dispose();           
            int b_id = Integer.parseInt(txt_bid.getText());
            deleteBuilding(b_id);
            JOptionPane.showMessageDialog(this, "Building Removed");
            clear();
            displayAllBuilding(B.VIEW_ALL());

        }
        else{
            txt_pass.setText("");
            dlg_KeyConfirmation.dispose();  
            JOptionPane.showMessageDialog(this, "Wrong Password !!");
            
        }
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        user_input = txt_pass.getText().toString();
        if(user_input.equals(login_key))
        {
            txt_pass.setText("");
            dlg_KeyConfirmation.dispose();        
            int b_id = Integer.parseInt(txt_bid.getText());
            deleteBuilding(b_id);
            JOptionPane.showMessageDialog(this, "Building Removed");
            clear();
            displayAllBuilding(B.VIEW_ALL());

        }
        else{
            txt_pass.setText("");
            dlg_KeyConfirmation.dispose();  
            JOptionPane.showMessageDialog(this, "Wrong Login Key!!");
      
        }
    }//GEN-LAST:event_btn_confirmActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 new UpdateBuildingPage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel addbuilding;
    private javax.swing.JPanel body;
    private javax.swing.JPanel borderbg;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton btn_removebuilding;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel container1;
    private javax.swing.JDialog dlg_KeyConfirmation;
    private javax.swing.JPanel form;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel labels;
    private javax.swing.JTable tbl_building;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_bid;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JTextField txt_location;
    private javax.swing.JPasswordField txt_pass;
    // End of variables declaration//GEN-END:variables
}
