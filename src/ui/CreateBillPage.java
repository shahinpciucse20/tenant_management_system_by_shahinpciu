package ui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DBConnector;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import model.transactionsModel;
import values.Values;

public class CreateBillPage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;    
    
  
    public CreateBillPage() {
        initComponents();              
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        cb_aptid.removeAllItems();
        setAptID();   
        txt_aptname.setText("");
        cb_aptid.setSelectedIndex(-1);
        
        setLastId();
        cb_aptid.setVisible(false);
        txt_aptname.setVisible(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));  
        
    }

    private void clear()
    {
        this.dispose();
        new CreateBillPage().setVisible(true);
        
        
    } 
    
    
    private void setLastId()
    {
        transactionsModel Ten = new transactionsModel();
        
        int oldID = Ten.LAST_ID();
        int newID = oldID+1;
        txt_trid.setText(String.valueOf(newID));
    }
    
    
    
    
    
    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-600,screensize.height-300);        
        this.setMinimumSize(minSize);
        this.setMaximumSize(minSize);
        this.setSize(minSize);
    }
    
    
    private void addBill()
    {
        if(!tgl_aptbill.isSelected())
        {
            transactionsModel Tr = new transactionsModel();
            double tr_amount = Double.parseDouble(txt_tramount.getText());
            String tr_purpose = txt_trpurpose.getText();
            String tr_payment_method = cb_paymentmethod.getSelectedItem().toString();
            
            Tr.INSERT_NORMAL_BILL(tr_amount, tr_purpose, tr_payment_method);
        }
        else if(tgl_aptbill.isSelected())
        {
            transactionsModel Tr = new transactionsModel();
            double tr_amount = Double.parseDouble(txt_tramount.getText());
            String tr_purpose = txt_trpurpose.getText();
            String tr_payment_method = cb_paymentmethod.getSelectedItem().toString();
            int apt_id = Integer.parseInt(cb_aptid.getSelectedItem().toString());
            
            Tr.INSERT_APT_BILL(tr_amount, tr_purpose, apt_id, tr_payment_method);
        }
        
    }
    
    private boolean validInput()
    {
        if(tgl_aptbill.isSelected())
        {
            if(txt_tramount.getText().length()>0 && cb_paymentmethod.getSelectedIndex()!=-1 && cb_aptid.getSelectedIndex()!=-1 && txt_trpurpose.getText().length()>0)
            {
                return true;
            }
            else{
                return false;
            }
        }
        
        else
        {
            if(txt_tramount.getText().length()>0 && cb_paymentmethod.getSelectedIndex()!=-1 && txt_trpurpose.getText().length()>0)
            {
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    private void setAptID()
    {
        apartmentModel A = new apartmentModel();        
        ResultSet rs = A.VIEW_ALL_ID();
        int i = 0;
        try {
                      
            while (rs.next()) 
            {
                cb_aptid.addItem(String.valueOf(rs.getInt("apt_id")));    
                
            }   
           
        } catch (SQLException ex) {
            Logger.getLogger(CreateBillPage.class.getName()).log(Level.SEVERE, null, ex);
        }    
         
    }   
    
    private void setAptNameByID(int apt_id)
    {
        apartmentModel A = new apartmentModel();
        rs = A.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(apt_id);
        try {
            if(rs.next())
            {
                txt_aptname.setText(rs.getString("apt_name")+"-"+rs.getString("b_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTenantPage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
        

  
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        cb_paymentmethod = new javax.swing.JComboBox<>();
        txt_tramount = new javax.swing.JTextField();
        txt_trid = new javax.swing.JTextField();
        txt_aptname = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        cb_aptid = new javax.swing.JComboBox<>();
        txt_trpurpose = new javax.swing.JTextField();
        tgl_aptbill = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 640));
        setMinimumSize(new java.awt.Dimension(800, 640));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 640));
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
        jLabel2.setText("Create Bill");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerLayout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 472, Short.MAX_VALUE)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerLayout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_paymentmethod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_paymentmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "BKASH", "BANK CHECK", "NAGAD", "ROCKET", "INTERNET BANKING" }));
        cb_paymentmethod.setSelectedIndex(-1);
        cb_paymentmethod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Payment Method", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        body.add(cb_paymentmethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 260, 70));

        txt_tramount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tramount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Amount", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_tramount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tramountActionPerformed(evt);
            }
        });
        txt_tramount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tramountKeyTyped(evt);
            }
        });
        body.add(txt_tramount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 420, 80));

        txt_trid.setEditable(false);
        txt_trid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_trid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Txn ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_trid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tridActionPerformed(evt);
            }
        });
        body.add(txt_trid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 700, 70));

        txt_aptname.setEditable(false);
        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apartment", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_aptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptnameActionPerformed(evt);
            }
        });
        body.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 520, 80));

        btn_add.setBackground(new java.awt.Color(0, 0, 0));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(204, 204, 204));
        btn_add.setText("CREATE");
        btn_add.setBorderPainted(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        body.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 170, 50));

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
        body.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 170, 50));

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
        body.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 170, 50));

        cb_aptid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_aptid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apartment ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        cb_aptid.setMaximumSize(new java.awt.Dimension(800, 640));
        cb_aptid.setMinimumSize(new java.awt.Dimension(800, 640));
        cb_aptid.setPreferredSize(new java.awt.Dimension(800, 640));
        cb_aptid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_aptidMouseClicked(evt);
            }
        });
        cb_aptid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_aptidActionPerformed(evt);
            }
        });
        body.add(cb_aptid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 160, 80));

        txt_trpurpose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_trpurpose.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Purpose", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_trpurpose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_trpurposeActionPerformed(evt);
            }
        });
        body.add(txt_trpurpose, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 700, 80));

        tgl_aptbill.setBackground(new java.awt.Color(0, 0, 0));
        tgl_aptbill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tgl_aptbill.setForeground(new java.awt.Color(255, 255, 255));
        tgl_aptbill.setText("Bill For Apartment");
        tgl_aptbill.setBorderPainted(false);
        tgl_aptbill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_aptbillActionPerformed(evt);
            }
        });
        body.add(tgl_aptbill, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, 40));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new CreateBillPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
       if(validInput()==true)
       {
           addBill();
           
           JOptionPane.showMessageDialog(this, "Bill Created Successfully");
           HomePage.setDashboardLabel();
           clear();
       }       
       else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_tramountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tramountActionPerformed
        
    }//GEN-LAST:event_txt_tramountActionPerformed

    private void txt_tridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tridActionPerformed
        
    }//GEN-LAST:event_txt_tridActionPerformed

    private void txt_aptnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptnameActionPerformed
        
    }//GEN-LAST:event_txt_aptnameActionPerformed

    private void cb_aptidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_aptidActionPerformed
        if(cb_aptid.getSelectedIndex()!=-1)
        {
            int id = Integer.parseInt(cb_aptid.getSelectedItem().toString());
            setAptNameByID(id);
        }
    }//GEN-LAST:event_cb_aptidActionPerformed

    private void cb_aptidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_aptidMouseClicked
        
    }//GEN-LAST:event_cb_aptidMouseClicked

    private void txt_trpurposeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_trpurposeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_trpurposeActionPerformed

    private void tgl_aptbillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_aptbillActionPerformed
        if(tgl_aptbill.isSelected())
        {
            cb_aptid.setVisible(true);
            txt_aptname.setVisible(true);
        }
        else if(!tgl_aptbill.isSelected())
        {
            cb_aptid.setVisible(false);
            txt_aptname.setVisible(false);
        }
    }//GEN-LAST:event_tgl_aptbillActionPerformed

    private void txt_tramountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tramountKeyTyped
       char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_tramountKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new CreateBillPage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_aptid;
    private javax.swing.JComboBox<String> cb_paymentmethod;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton tgl_aptbill;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_tramount;
    private javax.swing.JTextField txt_trid;
    private javax.swing.JTextField txt_trpurpose;
    // End of variables declaration//GEN-END:variables
}
