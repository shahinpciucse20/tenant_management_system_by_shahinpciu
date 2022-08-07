
package ui;
import java.awt.Dimension;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.apartmentModel;
import model.tenantModel;
import model.transactionsModel;


public class TenantSelect extends javax.swing.JFrame {
    private ResultSet rs = null;
    private tenantModel tM ;
    private apartmentModel aM = null;
    private transactionsModel trM = null;
    
    ResultSet aptRS = null;
    ResultSet aptRentRS = null;

    
    public TenantSelect() {
        initComponents();
        underline.setVisible(false);
        this.setSize(600, 430);
        tM = new tenantModel();
        aM = new apartmentModel();
        trM = new transactionsModel();
    }
    
    
    private void loadData(){
        
        Dimension picSize = new Dimension(250,250);
        
        long nid  = Long.parseLong(txt_Search.getText());
        
        ImageIcon icon = new ImageIcon(new ImageIcon(tM.GET_PIC_BY_ID(nid)).getImage().getScaledInstance(250,250, Image.SCALE_SMOOTH));
        
        rs = tM.VIEW_DATA_BY_NID(nid);
        
        HashMap<String,String> data  = new HashMap<String,String>();
        try {
            if(rs.next()){
                
                data.put("nid", String.valueOf(rs.getLong("nid")));
                data.put("name", String.valueOf(rs.getString("full_name")));
                data.put("age", String.valueOf(rs.getInt("age")));
                data.put("gender", String.valueOf(rs.getString("gender")));
                data.put("religion", String.valueOf(rs.getString("religion")));
                data.put("nationality", String.valueOf(rs.getString("nationality")));
                data.put("profession", String.valueOf(rs.getString("profession")));
                data.put("mobile", String.valueOf(rs.getLong("mobile")));
                data.put("email", String.valueOf(rs.getString("email")));
                data.put("permanant_address", String.valueOf(rs.getString("permanant_address")));
                data.put("total_member", String.valueOf(rs.getInt("total_member")));
                data.put("apt_id", String.valueOf(rs.getInt("apt_id")));
                data.put("t_status", String.valueOf(rs.getString("t_status")));
                data.put("starting_month", String.valueOf(rs.getString("starting_month")));
                data.put("ending_month", String.valueOf(rs.getString("ending_month")));
                
                
                double total_income = trM.GET_PAID_RENT_BY_NID(Long.parseLong(data.get("nid")));
                data.put("total_income", String.valueOf(total_income));
                
                aptRS = aM.VIEW_APTNAME_BUILDINGNAME_LOCATION_BY_APTID(rs.getInt("apt_id"));
                
                aptRentRS = aM.getAptNameRentByAptId(rs.getInt("apt_id"));
                
                if(aptRentRS.next()){
                    
                    data.put("apt_rent", String.valueOf(aptRentRS.getDouble("rent")));

                }
                
                if(aptRS.next()){
                    data.put("apt_name", String.valueOf(aptRS.getString("apt_name")));
                    data.put("b_name", String.valueOf(aptRS.getString("b_name")));
                    data.put("b_loc", String.valueOf(aptRS.getString("location")));
                }
                
                
                
                
                this.dispose();
                TenantProfile tP = new TenantProfile(data, icon);
                tP.setVisible(true);                
            }
            else{
                JOptionPane.showMessageDialog(this, "Tenant Not Found!");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TenantSelect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Tenant Not Found!");
        }
        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_Search = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        lbl_viewlist = new javax.swing.JLabel();
        underline = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setName("Select Tenant"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Select Tenant");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_Search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Tenant NID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        txt_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SearchKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 560, 70));

        btn_Search.setBackground(new java.awt.Color(255, 51, 51));
        btn_Search.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Search.setForeground(new java.awt.Color(255, 255, 255));
        btn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/search-24x.png"))); // NOI18N
        btn_Search.setText("View Profile");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 280, 70));

        lbl_viewlist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_viewlist.setForeground(new java.awt.Color(0, 51, 255));
        lbl_viewlist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_viewlist.setText("View Tenant List");
        lbl_viewlist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_viewlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_viewlistMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_viewlistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_viewlistMouseExited(evt);
            }
        });
        jPanel2.add(lbl_viewlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 170, 30));

        underline.setForeground(new java.awt.Color(0, 0, 255));
        jPanel2.add(underline, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 130, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 600, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyReleased

    }//GEN-LAST:event_txt_SearchKeyReleased

    private void txt_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txt_SearchKeyTyped

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        if(txt_Search.getText().length()>0)
        {
            loadData();           

        }
        else{
           
            JOptionPane.showMessageDialog(this, "Please Enter an NID!");
        }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void lbl_viewlistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewlistMouseEntered
        underline.setVisible(true);     
        
        
    }//GEN-LAST:event_lbl_viewlistMouseEntered

    private void lbl_viewlistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewlistMouseExited
        underline.setVisible(false);
    }//GEN-LAST:event_lbl_viewlistMouseExited

    private void lbl_viewlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_viewlistMouseClicked
        this.dispose();
        new ViewAllTenant().setVisible(true);
    }//GEN-LAST:event_lbl_viewlistMouseClicked

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TenantSelect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_viewlist;
    public static javax.swing.JTextField txt_Search;
    private javax.swing.JSeparator underline;
    // End of variables declaration//GEN-END:variables
}
