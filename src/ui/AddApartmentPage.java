package ui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.DBConnector;
import model.apartmentModel;
import model.buildingModel;
import values.Values;

public class AddApartmentPage extends javax.swing.JFrame { 
    
    private ResultSet rs = null;
    
  
    public AddApartmentPage() {
        initComponents();        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResponsiveSize();
        setLastId();
        setBID();
        setIcon();
        
    }

    public AddApartmentPage(JPanel body, JButton btn_add, JButton btn_close, JButton btn_reset, JPanel buttons, JComboBox<String> cb_available, JComboBox<String> cb_bid, JPanel forms, JPanel header, JPanel heading, JLabel jLabel2, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JPanel jPanel1, JPanel labels, JPanel textbox, JTextField txt_aptid, JTextField txt_aptname, JTextField txt_bname, JTextField txt_rent) throws HeadlessException {
        this.body = body;
        this.btn_add = btn_add;
        this.btn_close = btn_close;
        this.btn_reset = btn_reset;
        this.buttons = buttons;
        this.cb_available = cb_available;
        this.cb_bid = cb_bid;
        this.forms = forms;
        this.header = header;
        this.heading = heading;
        this.jLabel2 = jLabel2;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jLabel8 = jLabel8;
        this.jLabel9 = jLabel9;
        this.jPanel1 = jPanel1;
        this.labels = labels;
        this.textbox = textbox;
        this.txt_aptid = txt_aptid;
        this.txt_aptname = txt_aptname;
        this.txt_bname = txt_bname;
        this.txt_rent = txt_rent;
    }
    
    

   
    
    private void setIcon()
    {            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));        
    }

    private void clear()
    {
        txt_aptid.setText("");
        txt_rent.setText("");
        txt_bname.setText("");
        cb_available.setSelectedIndex(-1);
        cb_bid.setSelectedIndex(-1);
        txt_rent.setText("");
        txt_aptname.setText("");
        setLastId();
    }
    
    private void setLastId()
    {
        apartmentModel APT = new apartmentModel();
        
        int oldID = APT.LAST_ID();
        int newID = oldID+1;
        txt_aptid.setText(String.valueOf(newID));
    }
    
    
    private void setNameByID(int id)
    {
        buildingModel B = new buildingModel();
        
        rs =  B.SEARCH_NAME_BY_ID(id);
        try {
            if(rs.next())
            {
                txt_bname.setText(rs.getString("b_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddApartmentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setBID()
    {
        try {
            buildingModel B = new buildingModel();
            ResultSet rs = B.VIEW_ALL_ID();
            
            while(rs.next())
            {
                try {
                    cb_bid.addItem(String.valueOf(rs.getInt("b_id")));
                } catch (SQLException ex) {
                    Logger.getLogger(AddApartmentPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddApartmentPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setResponsiveSize()
    {
        Dimension screensize = Toolkit. getDefaultToolkit(). getScreenSize();
        Dimension maxSize = new Dimension(screensize.width,screensize.height-50);
        Dimension minSize = new Dimension(screensize.width-500,screensize.height-300);        
        this.setMinimumSize(minSize);
        this.setMaximumSize(minSize);
        this.setSize(minSize);
    }
    
    
    private void addApartment(String apt_name, int b_id, double rent,String available)
    {
        apartmentModel A = new apartmentModel();
        A.INSERT(apt_name, b_id, rent,available);
        clear();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        labels = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textbox = new javax.swing.JPanel();
        txt_aptid = new javax.swing.JTextField();
        txt_rent = new javax.swing.JTextField();
        txt_bname = new javax.swing.JTextField();
        cb_bid = new javax.swing.JComboBox<>();
        cb_available = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_aptname = new javax.swing.JTextField();
        buttons = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Home - TMS"); // NOI18N
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
        jLabel2.setText("Add Apartment");

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
        forms.setLayout(new java.awt.BorderLayout());

        labels.setBackground(new java.awt.Color(255, 255, 255));
        labels.setPreferredSize(new java.awt.Dimension(400, 300));
        labels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Apartment ID: ");
        labels.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 230, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Apartment Name: ");
        labels.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 230, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Availability : ");
        labels.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 230, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Building : ");
        labels.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 230, 60));

        forms.add(labels, java.awt.BorderLayout.LINE_START);

        textbox.setBackground(new java.awt.Color(255, 255, 255));
        textbox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_aptid.setEditable(false);
        txt_aptid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textbox.add(txt_aptid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 780, 50));

        txt_rent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textbox.add(txt_rent, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 440, 50));

        txt_bname.setEditable(false);
        txt_bname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textbox.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 520, 50));

        cb_bid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_bid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_bidActionPerformed(evt);
            }
        });
        textbox.add(cb_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 240, 50));

        cb_available.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cb_available.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES" }));
        textbox.add(cb_available, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 240, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Rent : ");
        textbox.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 80, 60));

        txt_aptname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        textbox.add(txt_aptname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 780, 50));

        forms.add(textbox, java.awt.BorderLayout.CENTER);

        body.add(forms);

        buttons.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 220, 70));

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
        jPanel1.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 190, 70));

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
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 190, 70));

        buttons.add(jPanel1, java.awt.BorderLayout.CENTER);

        body.add(buttons);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        clear();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        
       if(txt_aptid.getText().length()>0 && txt_rent.getText().length()>0 && cb_bid.getSelectedIndex()!=-1 && cb_available.getSelectedIndex()!=-1)
       {
           int bid = Integer.parseInt(cb_bid.getSelectedItem().toString()); 
           double rent = Double.parseDouble(txt_rent.getText());
           addApartment(txt_aptname.getText(),bid ,rent, cb_available.getSelectedItem().toString());
           buildingModel B = new buildingModel();           
           B.UPDATE_NUMOFAPT_BY_ID(bid);
           JOptionPane.showMessageDialog(this, "Apartment Successfully Added"); 
           HomePage.setDashboardLabel();
       }
       else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void cb_bidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_bidActionPerformed
        if(cb_bid.getSelectedIndex()!=-1)
        {
            int id = Integer.parseInt(cb_bid.getSelectedItem().toString());        
            setNameByID(id);
        }
        
    }//GEN-LAST:event_cb_bidActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddApartmentPage().setVisible(true);                                       
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel buttons;
    private javax.swing.JComboBox<String> cb_available;
    private javax.swing.JComboBox<String> cb_bid;
    private javax.swing.JPanel forms;
    private javax.swing.JPanel header;
    private javax.swing.JPanel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel labels;
    private javax.swing.JPanel textbox;
    private javax.swing.JTextField txt_aptid;
    private javax.swing.JTextField txt_aptname;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JTextField txt_rent;
    // End of variables declaration//GEN-END:variables
}
