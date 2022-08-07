package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DBConnector;
import model.UserInfo;
import model.apartmentModel;
import model.buildingModel;
import values.Values;

public class UpdateApartmentPage extends javax.swing.JFrame {
    
    private apartmentModel A = null;
    String user_input = null;
    String security_key = null;
    
    private static UserInfo userInfo = null;
    
  
    public UpdateApartmentPage() {
        initComponents();        
        A = new apartmentModel();    
        userInfo = new UserInfo();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayAllApartment(A.VIEW_ALL());
        security_key = userInfo.getPassword();
        
    }
    
    private void searchByID(String id)
    {
        int apt_id = Integer.parseInt(id);
        displayAllApartment(A.SEARCH_BY_ID(apt_id));
    }
    
     private void searchByName(String name)
    {
        displayAllApartment(A.SEARCH_BY_NAME(name));
    }
      private void searchByBuildingName(String bname)
    {
        
        displayAllApartment(A.SEARCH_BY_BUILDING_NAME(bname));
    }
       private void searchByLocation(String loc)
    {
        
        displayAllApartment(A.SEARCH_BY_BUILDING_LOCATION(loc));
    }
    
    
    private void displaySelectRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tbl_apartment.getModel();   
        int selectedRow = tbl_apartment.getSelectedRow();     
        if(selectedRow>=0)
        {
            txt_aptid.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txt_aptname.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txt_bname.setText(recordTable.getValueAt(selectedRow,2).toString()); 
            txt_rent.setText(recordTable.getValueAt(selectedRow,3).toString()); 
                     
        }
          
    }
    

    
    
    
    private void displayAllApartment(ResultSet rs)
    {
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
                    columData.add(rs.getString("b_name"));
                    columData.add(rs.getInt("rent"));
                                            
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(UpdateApartmentPage.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void deleteApartment(int id)
    {
        A.DELETE(id);
    }
    
    private void updateApartment()
    {
        int apt_id =Integer.parseInt(txt_aptid.getText());
        String apt_name = txt_aptname.getText();
        double rent = Double.parseDouble(txt_rent.getText());
        A.UPDATE(apt_id,apt_name,rent);
    }
    
    
    
    private void clear()
    {
        
        txt_aptid.setText("");
        txt_aptname.setText("");
        txt_bname.setText("");
        tbl_apartment.clearSelection();
        txt_rent.setText("");
        
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg_KeyConfirmation = new javax.swing.JDialog();
        body = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
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
        jLabel9 = new javax.swing.JLabel();
        input = new javax.swing.JPanel();
        txt_bname = new javax.swing.JTextField();
        txt_aptid = new javax.swing.JTextField();
        txt_aptname = new javax.swing.JTextField();
        txt_rent = new javax.swing.JTextField();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_apartment = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        txt_Search = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btn_removebuilding = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        dlg_KeyConfirmation.setBounds(new java.awt.Rectangle(700, 350, 0, 0));
        dlg_KeyConfirmation.setMinimumSize(new java.awt.Dimension(570, 310));
        dlg_KeyConfirmation.setResizable(false);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please Confirm Your Identity");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 560, 60));

        txt_pass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "ENTER SECURITY CODE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_pass.setName(""); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });
        body.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 490, 70));

        btn_login.setBackground(new java.awt.Color(255, 0, 0));
        btn_login.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("CONFIRM");
        btn_login.setBorder(null);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        body.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, 60));

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
        setMinimumSize(new java.awt.Dimension(1480, 666));
        setName("Home - TMS"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
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
        jLabel2.setText("Update Apartment");

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
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Rent : ");
        labels.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Apartment ID: ");
        labels.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Apartment Name: ");
        labels.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Building : ");
        labels.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 50));

        form.add(labels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 410));

        input.setBackground(new java.awt.Color(255, 255, 255));
        input.setPreferredSize(new java.awt.Dimension(400, 596));
        input.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_bname.setEditable(false);
        txt_bname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        input.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 410, 50));

        txt_aptid.setEditable(false);
        txt_aptid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptid.setBorder(null);
        txt_aptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptidActionPerformed(evt);
            }
        });
        input.add(txt_aptid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 410, 50));

        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        input.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 410, 50));

        txt_rent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rentActionPerformed(evt);
            }
        });
        input.add(txt_rent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 410, 50));

        form.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 440, 380));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_apartment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tbl_apartment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "BUILDING", "RENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_apartment.setRowHeight(50);
        tbl_apartment.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_apartment.getTableHeader().setReorderingAllowed(false);
        tbl_apartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_apartmentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_apartment);
        if (tbl_apartment.getColumnModel().getColumnCount() > 0) {
            tbl_apartment.getColumnModel().getColumn(0).setMinWidth(70);
            tbl_apartment.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbl_apartment.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_apartment.getColumnModel().getColumn(1).setMinWidth(70);
            tbl_apartment.getColumnModel().getColumn(1).setPreferredWidth(70);
            tbl_apartment.getColumnModel().getColumn(1).setMaxWidth(100);
            tbl_apartment.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_apartment.getColumnModel().getColumn(3).setMinWidth(150);
            tbl_apartment.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 400));

        form.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 750, 420));

        btn_update.setBackground(new java.awt.Color(0, 0, 0));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(204, 204, 204));
        btn_update.setText("UPDATE");
        btn_update.setBorderPainted(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        form.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 130, 50));

        btn_close.setBackground(new java.awt.Color(0, 0, 0));
        btn_close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_close.setForeground(new java.awt.Color(204, 204, 204));
        btn_close.setText("CLOSE");
        btn_close.setBorderPainted(false);
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        form.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 110, 50));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(204, 204, 204));
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        form.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 120, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        form.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 360, 50));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        form.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 50, 100, 50));

        btn_removebuilding.setBackground(new java.awt.Color(255, 51, 51));
        btn_removebuilding.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_removebuilding.setForeground(new java.awt.Color(255, 255, 255));
        btn_removebuilding.setText("X   REMOVE APARTMENT");
        btn_removebuilding.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removebuildingActionPerformed(evt);
            }
        });
        form.add(btn_removebuilding, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 410, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("SEARCH BY:");
        form.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 100, 50));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "LOCATION", "BUILDING NAME" }));
        cb_SearchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchFilterActionPerformed(evt);
            }
        });
        form.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 170, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Building : ");
        form.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 220, 60));

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
    new UpdateApartmentPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(txt_aptname.getText().length()>0 && txt_rent.getText().length()>0 && txt_aptid.getText().length()>0)
        {
            updateApartment();
            JOptionPane.showMessageDialog(this, "Apartment Successfully Updated"); 
            displayAllApartment(A.VIEW_ALL());
        }
        else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_apartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_apartmentMouseClicked
        displaySelectRow();
    }//GEN-LAST:event_tbl_apartmentMouseClicked

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
                        case "BUILDING NAME":
                            clear();
                            searchByBuildingName(query);
                            break;     

                    }
                
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }
                        
        }
        else{
            displayAllApartment(A.VIEW_ALL());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btn_removebuildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removebuildingActionPerformed
        if(txt_aptname.getText().length()>0 && txt_bname.getText().length()>0 && txt_aptid.getText().length()>0)
        {
            int deleteItem = JOptionPane.showConfirmDialog(null,Values.DeleteWarningMessage, "Do You Want to Remove?",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {
                dlg_KeyConfirmation.setSize(550,310);
                
                dlg_KeyConfirmation.setVisible(true);                
  
            }
            else{
                clear();
            }          

        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Atleast One Record to Remove!");
        }
    }//GEN-LAST:event_btn_removebuildingActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        user_input = txt_pass.getText().toString();
        if(user_input.equals(security_key))
        {
            
            dlg_KeyConfirmation.setVisible(false);
            System.err.println("Matched");
            int b_id = Integer.parseInt(txt_aptid.getText());
            deleteApartment(b_id);
            JOptionPane.showMessageDialog(this, "Apartment Removed");
            clear();
            displayAllApartment(A.VIEW_ALL());

        }
        else{
            dlg_KeyConfirmation.setVisible(false);
            JOptionPane.showMessageDialog(this, "Wrong Password!!");
            
        }
    }//GEN-LAST:event_txt_passActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        user_input = txt_pass.getText().toString();
        if(user_input.equals(security_key))
        {
            
            dlg_KeyConfirmation.setVisible(false);
            System.err.println("Matched");
            int b_id = Integer.parseInt(txt_aptid.getText());
            deleteApartment(b_id);
            JOptionPane.showMessageDialog(this, "Apartment Removed");
            clear();
            displayAllApartment(A.VIEW_ALL());

        }
        else{
            dlg_KeyConfirmation.setVisible(false);
            JOptionPane.showMessageDialog(this, "Wrong Security Key!!");
      
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rentActionPerformed

    private void txt_aptidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_aptidActionPerformed

    private void cb_SearchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchFilterActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 new UpdateApartmentPage().setVisible(true);
                
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
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_removebuilding;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel container1;
    private javax.swing.JDialog dlg_KeyConfirmation;
    private javax.swing.JPanel form;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel labels;
    private javax.swing.JTable tbl_apartment;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_aptid;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_rent;
    // End of variables declaration//GEN-END:variables
}
