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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.apartmentModel;
import model.buildingModel;
import model.tenantModel;
import model.transactionsModel;

public class RcvRentPage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;    
    
  
    public RcvRentPage() {
        initComponents();              
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        clear();
        setTenantNID();   
        cb_tnid.setSelectedIndex(-1);
        cb_tnid.removeItemAt(0);
        setLastId();
        
    }

    private void clear()
    {
        txt_trid.setText("");      
        txt_aptrent.setText("");  
        txt_tramount.setText("");                                       
        cb_paymentmethod.setSelectedIndex(-1);        
        cb_tnid.removeAllItems();         
        setTenantNID();  
        //cb_tnid.setSelectedIndex(-1);
        txt_tname.setText("");   
        txt_aptrent.setText("");        
        txt_aptname.setText("");   
        
        
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
    
    
    private void addRent()
    {
        tenantModel Ten = new tenantModel();
        int  tr_id = Integer.parseInt(txt_trid.getText());        
        double amount = Double.parseDouble(txt_tramount.getText());
        long t_nid = Long.parseLong(cb_tnid.getSelectedItem().toString());
        int apt_id = Ten.GET_APTID_BY_NID(t_nid);
        String payment_method = cb_paymentmethod.getSelectedItem().toString();
        double apt_rent = Double.parseDouble(txt_aptrent.getText());
        
        System.out.println(apt_rent);
        System.out.println(amount);
        
        if(apt_rent == amount)
        {
            System.out.println("No due");
        }
        else{
            
            double due = apt_rent - amount;
            System.out.println("Due is: "+due);
        }
        
        //transactionsModel TR = new transactionsModel();
        //TR.INSERT_RENT(amount,t_nid,apt_id,payment_method);

        clear();
        
        
        
    }
    
    private boolean validInput()
    {
        if(txt_trid.getText().length()>0 && txt_aptrent.getText().length()>0 && txt_tramount.getText().length()>0
                && cb_paymentmethod.getSelectedIndex()!=-1 && txt_tname.getText().length()>0 && txt_aptrent.getText().length()>0)
            return true;
        else{
            return false;
        }
    }
    
    private void setTenantNID()
    {
        tenantModel Ten = new tenantModel();        
        rs = Ten.GET_ALL_NID();       
        int i =0;
        try {    
            //cb_tnid.removeAllItems();
            while (rs.next()) {
                i++;
                cb_tnid.addItem(String.valueOf(rs.getLong("nid")));                           
            } 
            System.out.println(i);
            //cb_tnid.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(RcvRentPage.class.getName()).log(Level.SEVERE, null, ex);
        }    
         
    }
    
    private void setAllInfoByNID()
    {
        tenantModel Ten = new tenantModel();  
        if(cb_tnid.getSelectedIndex()!=-1)
        {
            long nid = Long.parseLong(cb_tnid.getSelectedItem().toString());
            rs = Ten.GET_RCV_RENT_INFO_BY_ID(nid);
            try {
                if(rs.next())
                {
                    txt_tname.setText(rs.getString("full_name"));
                    txt_aptname.setText(rs.getString("apt_name")+"-"+rs.getString("b_name"));
                    txt_aptrent.setText(String.valueOf(rs.getDouble("rent")));

                }
        } catch (SQLException ex) {
            Logger.getLogger(RcvRentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        txt_aptrent = new javax.swing.JTextField();
        txt_trid = new javax.swing.JTextField();
        txt_tname = new javax.swing.JTextField();
        txt_aptname = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        cb_tnid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 640));
        setMinimumSize(new java.awt.Dimension(800, 640));
        setName("Home - TMS"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setPreferredSize(new java.awt.Dimension(1280, 60));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recieve Rent");

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
        cb_paymentmethod.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Payment Method", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        body.add(cb_paymentmethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 260, 70));

        txt_tramount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tramount.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Recieve Amount", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
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
        body.add(txt_tramount, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 400, 80));

        txt_aptrent.setEditable(false);
        txt_aptrent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptrent.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Rent", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_aptrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptrentActionPerformed(evt);
            }
        });
        body.add(txt_aptrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 280, 80));

        txt_trid.setEditable(false);
        txt_trid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_trid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Txn ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_trid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tridActionPerformed(evt);
            }
        });
        body.add(txt_trid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 700, 70));

        txt_tname.setEditable(false);
        txt_tname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_tname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tenant Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_tname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tnameActionPerformed(evt);
            }
        });
        body.add(txt_tname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 410, 80));

        txt_aptname.setEditable(false);
        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_aptname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Apartment", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        txt_aptname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aptnameActionPerformed(evt);
            }
        });
        body.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 400, 80));

        btn_add.setBackground(new java.awt.Color(0, 0, 0));
        btn_add.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btn_add.setForeground(new java.awt.Color(204, 204, 204));
        btn_add.setText("ADD");
        btn_add.setBorderPainted(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        body.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 170, 50));

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
        body.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 170, 50));

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
        body.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 170, 50));

        cb_tnid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_tnid.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Tenant NID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        cb_tnid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_tnidMouseClicked(evt);
            }
        });
        cb_tnid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tnidActionPerformed(evt);
            }
        });
        body.add(cb_tnid, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 280, 80));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        this.dispose();
        new RcvRentPage().setVisible(true);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();        
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
       if(validInput()==true)
       {
           addRent();         
           
           JOptionPane.showMessageDialog(this, "Rent Recieved Successfully"); 
       }       
       else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_tramountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tramountActionPerformed
        
    }//GEN-LAST:event_txt_tramountActionPerformed

    private void txt_aptrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptrentActionPerformed
        
    }//GEN-LAST:event_txt_aptrentActionPerformed

    private void txt_tridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tridActionPerformed
        
    }//GEN-LAST:event_txt_tridActionPerformed

    private void txt_tnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tnameActionPerformed
        
    }//GEN-LAST:event_txt_tnameActionPerformed

    private void txt_aptnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aptnameActionPerformed
        
    }//GEN-LAST:event_txt_aptnameActionPerformed

    private void cb_tnidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tnidActionPerformed
        if(cb_tnid.getSelectedIndex()!=-1)
        {
            setAllInfoByNID();
        }
    }//GEN-LAST:event_cb_tnidActionPerformed

    private void cb_tnidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_tnidMouseClicked
        
    }//GEN-LAST:event_cb_tnidMouseClicked

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

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new RcvRentPage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JComboBox<String> cb_paymentmethod;
    private javax.swing.JComboBox<String> cb_tnid;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_aptrent;
    private javax.swing.JTextField txt_tname;
    private javax.swing.JTextField txt_tramount;
    private javax.swing.JTextField txt_trid;
    // End of variables declaration//GEN-END:variables
}
