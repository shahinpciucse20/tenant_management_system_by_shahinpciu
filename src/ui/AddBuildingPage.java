package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.DBConnector;
import model.apartmentModel;
import model.buildingModel;
import values.Values;

public class AddBuildingPage extends javax.swing.JFrame {
  
    public AddBuildingPage() {
        initComponents();        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLastId();
        setIcon();
    }
    
    private void setIcon()
    {            
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Values.ICON_PATH)));        
    }

    private void clear()
    {
        txt_bid.setText("");
        txt_bname.setText("");
        txt_location.setText("");
        setLastId();
    }
    
    private void setLastId()
    {
        buildingModel B = new buildingModel();
        
        int oldID = B.LAST_ID();
        int newID = oldID+1;
        txt_bid.setText(String.valueOf(newID));
    }
    
    private void addBuilding(String b_name, String location)
    {
        buildingModel B = new buildingModel();
        B.INSERT(b_name, 0, location);
        clear();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        mainbody = new javax.swing.JPanel();
        borderbg = new javax.swing.JPanel();
        addbuilding = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        container1 = new javax.swing.JPanel();
        form = new javax.swing.JPanel();
        lables = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        input = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_location = new javax.swing.JTextField();
        txt_bid = new javax.swing.JTextField();
        txt_bname = new javax.swing.JTextField();
        buttons = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Home - TMS"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        mainbody.setLayout(new java.awt.BorderLayout());

        borderbg.setBackground(new java.awt.Color(255, 255, 255));
        borderbg.setForeground(new java.awt.Color(255, 255, 255));

        addbuilding.setBackground(new java.awt.Color(255, 255, 255));
        addbuilding.setLayout(new java.awt.BorderLayout());

        heading.setBackground(new java.awt.Color(0, 0, 0));
        heading.setPreferredSize(new java.awt.Dimension(963, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Building");

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        addbuilding.add(heading, java.awt.BorderLayout.PAGE_START);

        container1.setLayout(new javax.swing.BoxLayout(container1, javax.swing.BoxLayout.Y_AXIS));

        form.setBackground(new java.awt.Color(255, 255, 255));
        form.setPreferredSize(new java.awt.Dimension(1241, 300));
        form.setLayout(new javax.swing.BoxLayout(form, javax.swing.BoxLayout.LINE_AXIS));

        lables.setPreferredSize(new java.awt.Dimension(300, 574));
        lables.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Building Location: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 230, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Building ID: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 230, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Building Name: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 230, 60));

        lables.add(jPanel1, java.awt.BorderLayout.CENTER);

        form.add(lables);

        input.setPreferredSize(new java.awt.Dimension(600, 400));
        input.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 596));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_location.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txt_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 710, 50));

        txt_bid.setEditable(false);
        txt_bid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txt_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 710, 50));

        txt_bname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(txt_bname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 710, 50));

        input.add(jPanel2, java.awt.BorderLayout.CENTER);

        form.add(input);

        container1.add(form);

        buttons.setBackground(new java.awt.Color(255, 255, 255));
        buttons.setForeground(new java.awt.Color(255, 255, 255));
        buttons.setPreferredSize(new java.awt.Dimension(1241, 200));
        buttons.setLayout(new javax.swing.BoxLayout(buttons, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 200));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        buttons.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(600, 200));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_close, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        buttons.add(jPanel6);

        container1.add(buttons);

        addbuilding.add(container1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout borderbgLayout = new javax.swing.GroupLayout(borderbg);
        borderbg.setLayout(borderbgLayout);
        borderbgLayout.setHorizontalGroup(
            borderbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderbgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addbuilding, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
                .addContainerGap())
        );
        borderbgLayout.setVerticalGroup(
            borderbgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderbgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addbuilding, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainbody.add(borderbg, java.awt.BorderLayout.CENTER);

        body.add(mainbody, java.awt.BorderLayout.CENTER);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
       this.dispose();
    }//GEN-LAST:event_btn_closeActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        clear();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if(txt_bname.getText().length()>0 && txt_location.getText().length()>0)
        {
            addBuilding(txt_bname.getText(), txt_location.getText());
            JOptionPane.showMessageDialog(this, "Building Successfully Added"); 
            HomePage.setDashboardLabel();
        }
        else{
           JOptionPane.showMessageDialog(this, "Incorrect Data!!"); 
       }
    }//GEN-LAST:event_btn_addActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBConnector.closeCon();
    }//GEN-LAST:event_formWindowClosed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 new AddBuildingPage().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addbuilding;
    private javax.swing.JPanel body;
    private javax.swing.JPanel borderbg;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel buttons;
    private javax.swing.JPanel container1;
    private javax.swing.JPanel form;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel input;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel lables;
    private javax.swing.JPanel mainbody;
    private javax.swing.JTextField txt_bid;
    private javax.swing.JTextField txt_bname;
    private javax.swing.JTextField txt_location;
    // End of variables declaration//GEN-END:variables
}
