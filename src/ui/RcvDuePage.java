package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.DBConnector;
import model.DueModel;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import model.transactionsModel;
import system.Time;
import values.Values;

public class RcvDuePage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;    
    private static DueModel dueModel = null;    
    private static transactionsModel TR = null;    
    private static tenantModel Ten = null;    
    private static apartmentModel Apt = null;    
    
  
    public RcvDuePage() {
        initComponents();     
        
        dueModel = new DueModel();
        TR = new transactionsModel();
        Ten= new tenantModel();
        Apt = new apartmentModel();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        displayAllUnpaidDue(dueModel.viewAllUnpaidDue());
        setIcon();
    }
    
    private void setIcon()
    {            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));        
    }

    private void clear()
    {
        txt_dueid.setText("");      
        txt_dueamount.setText("");  
        txt_payamount.setText("");                                       
        txt_tnid.setText("");
        txt_duemonth.setText("");
        txt_tname.setText("");   
        txt_dueamount.setText("");      
          
    }
    
     private void displayAllUnpaidDue(ResultSet rs)
    {
        try {                        
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tbl_due.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("due_id"));
                    columData.add(rs.getLong("t_nid"));  
                    columData.add(rs.getString("due_status"));
                    columData.add(rs.getDouble("due_amount"));
                    columData.add(rs.getString("due_month"));
                       
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(RcvDuePage.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    

    
    private void setLastId()
    {       
        
        int oldID = dueModel.getLastId();
        int newID = oldID+1;
        txt_dueid.setText(String.valueOf(newID));        
                
    }
    
    
    String getCurrentDate()
    {    
                
        return Time.getCurMonthYear();
    }

    private void addDue(long nid, double due_amount,String due_month){
        dueModel.insert(nid, due_amount,due_month);
    }
    
    
    private void addRent()
    {
        tenantModel Ten = new tenantModel();
        int  tr_id = Integer.parseInt(txt_dueid.getText());        
        double amount = Double.parseDouble(txt_payamount.getText());
        long t_nid = Long.parseLong(txt_tnid.getText());
        int apt_id = Ten.GET_APTID_BY_NID(t_nid);
        double apt_rent = Double.parseDouble(txt_dueamount.getText());        
        
        
        if(apt_rent != amount && apt_rent > amount)
        {
            double due = apt_rent - amount;
            System.out.println("Due is: "+due);
            
            JOptionPane.showMessageDialog(this, "Due "+due+" Has been Created"); 
        }         

        this.dispose();
        new RcvDuePage().setVisible(true);
        
        
        
    }
    
    private void insertTransaction(){
        
        double tr_amount = Double.parseDouble(txt_payamount.getText());
        int apt_id = Ten.GET_APTID_BY_NID(Long.parseLong(txt_tnid.getText()));
        String tr_payment_method = "CASH";
        String rent_month = txt_duemonth.getText();
        long nid = Long.parseLong(txt_tnid.getText());
        
        TR.INSERT_DUE_PAID(tr_amount, nid,apt_id, tr_payment_method, rent_month);
    }
    
    private boolean validInput()
    {
        if(txt_duemonth.getText().length()>0 && txt_dueid.getText().length()>0 && txt_dueamount.getText().length()>0 && txt_payamount.getText().length()>0
                && txt_tname.getText().length()>0 && txt_dueamount.getText().length()>0)
            return true;
        else{
            return false;
        }
    }
    
   
    
    
    private void displaySelectRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tbl_due.getModel();   
        int selectedRow = tbl_due.getSelectedRow();     
        if(selectedRow>=0)
        {
            txt_dueid.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txt_tnid.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txt_dueamount.setText(recordTable.getValueAt(selectedRow,3).toString()); 
            txt_duemonth.setText(recordTable.getValueAt(selectedRow,4).toString());
            
            txt_tname.setText(getTenNameByNid(Long.parseLong(txt_tnid.getText())));
            
                     
        }
          
    }
    
    private String getTenNameByNid(long nid)
    {       
        
            rs = Ten.GET_RCV_RENT_INFO_BY_ID(nid);
            try {
                if(rs.next())
                {
                    return (rs.getString("full_name"));                  

                }
        } catch (SQLException ex) {
            Logger.getLogger(RcvDuePage.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
 
    }
    
    
    private void updateDueStatus(int due_id){
        dueModel.updateDueStatus(due_id, "PAID");
    }
    
    private void updateDueAmount(int due_id, double due_amount){
        dueModel.updateDueAmount(due_id, due_amount);
    }
    
    
    private void recieveAction(){
        int due_id = Integer.parseInt(txt_dueid.getText());
        double due_amount = Double.parseDouble(txt_dueamount.getText());
        double pay_amount = Double.parseDouble(txt_payamount.getText());
        
        if(due_amount <= pay_amount && pay_amount>0){
            updateDueStatus(due_id);
            JOptionPane.showMessageDialog(this, "Due Recieved Successfully"); 
            
            insertTransaction();
            HomePage.setDashboardLabel();
        }
        else if(due_amount > pay_amount){
            double remaining_amount = due_amount-pay_amount;            
            updateDueAmount(due_id, remaining_amount);
            JOptionPane.showMessageDialog(this, "Due "+remaining_amount+" has been added"); 
            JOptionPane.showMessageDialog(this, "Due Recieved Successfully"); 
            insertTransaction();
            HomePage.setDashboardLabel();
        }
        else{
            JOptionPane.showMessageDialog(this, "Invalid Recieve Amount!"); 
        }
        
    }
    
    private void searchByDId(String query){
        
        int due_id = Integer.parseInt(query);
        
        displayAllUnpaidDue(dueModel.searchByDueId(due_id));
        
    }
            
    private void searchByTNid(String query){
        long t_nid = Long.parseLong(query);        
        displayAllUnpaidDue(dueModel.searchByNid(t_nid));
        
        
    }
    
  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        btn_rcv = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_dueid = new javax.swing.JTextField();
        txt_dueamount = new javax.swing.JTextField();
        txt_tname = new javax.swing.JTextField();
        txt_payamount = new javax.swing.JTextField();
        txt_duemonth = new javax.swing.JTextField();
        txt_tnid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_due = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        cb_SearchFilter = new javax.swing.JComboBox<>();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(836, 815));
        setMinimumSize(new java.awt.Dimension(836, 825));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(836, 815));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recieve Due");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerLayout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 446, Short.MAX_VALUE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_rcv.setBackground(new java.awt.Color(0, 0, 0));
        btn_rcv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_rcv.setForeground(new java.awt.Color(255, 255, 255));
        btn_rcv.setText("RECEIVE");
        btn_rcv.setBorderPainted(false);
        btn_rcv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rcvActionPerformed(evt);
            }
        });
        body.add(btn_rcv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, 50));

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
        body.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 130, 50));

        btn_reset.setBackground(new java.awt.Color(0, 0, 0));
        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/resetWhite-24x.png"))); // NOI18N
        btn_reset.setText("RESET");
        btn_reset.setBorderPainted(false);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        body.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 130, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_dueid.setEditable(false);
        txt_dueid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_dueid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Due ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_dueid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dueidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 70));

        txt_dueamount.setEditable(false);
        txt_dueamount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_dueamount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Due Amount", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_dueamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dueamountActionPerformed(evt);
            }
        });
        jPanel1.add(txt_dueamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 380, 70));

        txt_tname.setEditable(false);
        txt_tname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tenant Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_tname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 380, 70));

        txt_payamount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_payamount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recieve Amount", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_payamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_payamountActionPerformed(evt);
            }
        });
        txt_payamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_payamountKeyTyped(evt);
            }
        });
        jPanel1.add(txt_payamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 360, 80));

        txt_duemonth.setEditable(false);
        txt_duemonth.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_duemonth.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Due Month", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_duemonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_duemonthActionPerformed(evt);
            }
        });
        txt_duemonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_duemonthKeyTyped(evt);
            }
        });
        jPanel1.add(txt_duemonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 380, 70));

        txt_tnid.setEditable(false);
        txt_tnid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tnid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "T NID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_tnid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tnidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_tnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 360, 70));

        body.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 4, 810, 300));

        tbl_due.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_due.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Due ID", "Tenant NID", "Status", "Due Amount", "Due Month"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_due.setRowHeight(40);
        tbl_due.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tbl_due.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_due.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_due);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 800, 210));

        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));
        body.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 810, 10));

        cb_SearchFilter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_SearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Due Id", "Tenant NID" }));
        cb_SearchFilter.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Search By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 51))); // NOI18N
        body.add(cb_SearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 150, 50));

        txt_Search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        body.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 440, 50));

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
        body.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 180, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Unpaid Dues");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 820, 40));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 840, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new RcvDuePage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_rcvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rcvActionPerformed

       if(txt_dueid.getText().length()!=0)
       {        

           
           if(txt_payamount.getText().length()!=0 ){
               
               
               double pAmount = Double.parseDouble(txt_payamount.getText());
               double dAmount = Double.parseDouble(txt_dueamount.getText());
               
               if( pAmount <= dAmount && pAmount > 0 ){
                    recieveAction(); 
                    HomePage.setDashboardLabel();
                    this.dispose();
                    new RcvDuePage().setVisible(true);
               }
               else{
                   JOptionPane.showMessageDialog(this, "Invalid Recieve Amount!!"); 
               }    
           }
           else{
               JOptionPane.showMessageDialog(this, "Recieve Amount Can not be Empty!!"); 
           }
               
  
       }       
       else{
           JOptionPane.showMessageDialog(this, "Select Atleast One Record!!"); 
       }
    }//GEN-LAST:event_btn_rcvActionPerformed

    private void txt_payamountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_payamountKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {
                evt.consume();
            }
            evt.consume();
        }
    }//GEN-LAST:event_txt_payamountKeyTyped

    private void txt_payamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_payamountActionPerformed

    }//GEN-LAST:event_txt_payamountActionPerformed

    private void txt_tnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tnameActionPerformed

    }//GEN-LAST:event_txt_tnameActionPerformed

    private void txt_dueamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dueamountActionPerformed

    }//GEN-LAST:event_txt_dueamountActionPerformed

    private void txt_dueidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dueidActionPerformed

    }//GEN-LAST:event_txt_dueidActionPerformed

    private void txt_duemonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_duemonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duemonthActionPerformed

    private void txt_duemonthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_duemonthKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_duemonthKeyTyped

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
                    case "Due Id":
                    searchByDId(query);
                    break;

                    case "Tenant NID":
                    searchByTNid(query);
                    break;

                }

            } catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "Invalid Search Query!");
            }

        }
        else{
            displayAllUnpaidDue(dueModel.viewAllUnpaidDue());
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void txt_tnidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tnidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tnidActionPerformed

    private void tbl_dueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dueMouseClicked
       displaySelectRow();
    }//GEN-LAST:event_tbl_dueMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new RcvDuePage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_rcv;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_SearchFilter;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbl_due;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_dueamount;
    private javax.swing.JTextField txt_dueid;
    private javax.swing.JTextField txt_duemonth;
    private javax.swing.JTextField txt_payamount;
    private javax.swing.JTextField txt_tname;
    private javax.swing.JTextField txt_tnid;
    // End of variables declaration//GEN-END:variables
}
